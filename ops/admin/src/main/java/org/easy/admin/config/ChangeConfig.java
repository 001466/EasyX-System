package org.easy.admin.config;

import de.codecentric.boot.admin.server.config.AdminServerHazelcastAutoConfiguration;
import de.codecentric.boot.admin.server.config.AdminServerNotifierAutoConfiguration;
import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceDeregisteredEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import lombok.extern.slf4j.Slf4j;
import org.easy.admin.entity.Health;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Configuration
@AutoConfigureBefore({AdminServerNotifierAutoConfiguration.NotifierTriggerConfiguration.class, AdminServerNotifierAutoConfiguration.CompositeNotifierConfiguration.class})
@Slf4j
public class ChangeConfig extends AbstractStatusChangeNotifier{

    @Value("#{'${notify.phones}'.split(',')}")
    private List<String> phones;


    @Value("${notify.consumed:8}")
    private Integer consumed;


    @Bean
    public RestTemplate restTemplateCustom(){
        return new RestTemplate();
    }

    @Autowired
    @Qualifier("restTemplateCustom")
    private RestTemplate restTemplateCustom;

    @Autowired
    @Qualifier("taskExecutor")
    private Executor executor;



    private static final String ENDPOINT_METRICS="metrics";
    private static final String ENDPOINT_METRICS_HTTP_SERVER_REQUESTS="/http.server.requests";
    private static final String ENDPOINT_HTTPTRACE="httptrace";
    private static final String ENDPOINT_HEALTH="health";
    private static final String HEALTH="UP";
    private static final String METRICS_MEASUREMENT_STATISTIC_MAX="MAX";
    private static final String METRICS_AVAILABLETAG_TAG_EXCEPTION="exception";
    private static final String METRICS_AVAILABLETAG_TAG_URI="uri";
    private static final String JOB_NAME="Springboot_Admin_Service_Status_Check";

    public ChangeConfig(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected boolean shouldNotify(InstanceEvent event, Instance instance) {
        log.info("{},{},{},{},{}",instance.getRegistration().getName(),instance.getRegistration().getServiceUrl(), event.getClass().getSimpleName(),event.getType(),instance.getStatusInfo().getStatus());
        if (event instanceof InstanceStatusChangedEvent) {
            return true;
        }
        return false;
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {

        return Mono
                .fromRunnable(() -> {
                    String name=instance.getRegistration().getName();
                    String svrUrl=instance.getRegistration().getServiceUrl();

                    try {
                        doNotify(name,svrUrl,instance);
                    }catch (Exception e){
                        log.error(name, e.getMessage(),e);
                    }
                });

    }

    private void doNotify(String name,String svrUrl,Instance instance) throws Exception {
        Future<Health> healthFuture = ((ThreadPoolTaskExecutor)executor).submit(new Callable<Health>() {
            @Override
            public Health call() throws Exception {
                return checkHealth(name,svrUrl,instance);
            }
        });

        if(!healthFuture.isCancelled()) {
            Health health = null;
            try{
                health = healthFuture.get(consumed,TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                notice(name,svrUrl,new StringBuilder("Check health timeout,consumed more than ").append(consumed).append(" seconds").toString());
                throw e;
            }
            finally {
                log.info("Check health {} {} {}",name,svrUrl,health);
                healthFuture.cancel(true);
            }
        }



    }

    private Health checkHealth(String name,String svrUrl,Instance instance) throws Exception {
        if(!instance.getEndpoints().isPresent(ENDPOINT_HEALTH)){
            notice(name,svrUrl,new StringBuilder("Endpoint health is not exist").toString());
            return null;
        }
        String url = instance.getEndpoints().get(ENDPOINT_HEALTH).get().getUrl();
        ResponseEntity<Health> responseEntity = null;
        try {
            responseEntity = restTemplateCustom.getForEntity(url, Health.class);
        }catch (Exception e){
            notice(name,url,e.getMessage());
            return null;
        }

        if(responseEntity == null){
            notice(name,url,"Check health get null");
            return null;
        }

        Health health=responseEntity.getBody();
        if(responseEntity.getStatusCodeValue()!=200){
            notice(name,url,new StringBuilder(responseEntity.getStatusCodeValue()).append(" and health status is ").append(health) .toString());
            return health;
        }

        if(health==null || StringUtils.isEmpty(health.getStatus()) || ! health.getStatus().toUpperCase().equals( HEALTH)){
            notice(name,url,health.getStatus());
            return health;
        }
        return health;
    }


    private void notice(String title,String svrUrl,String content) throws Exception {
        log.info("通知 :{} {} {}",title,svrUrl,content);
        if(CollectionUtils.isEmpty(phones)){
            return;
        }


    }
}
