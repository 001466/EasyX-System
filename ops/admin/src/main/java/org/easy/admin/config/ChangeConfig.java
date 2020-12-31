package org.easy.admin.config;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import lombok.extern.slf4j.Slf4j;
import org.easy.admin.entity.Health;
import org.easy.admin.entity.HttpTrace;
import org.easy.admin.entity.Metrics;
import org.easy.admin.entity.httptrace.Trace;
import org.easy.admin.entity.metrics.AvailableTag;
import org.easy.admin.entity.metrics.Measurement;
import org.easy.quartz.service.IJobService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Configuration
@Slf4j
public class ChangeConfig extends AbstractStatusChangeNotifier implements InitializingBean {

    @Value("#{'${notify.phones}'.split(',')}")
    private List<String> phones;

    @Value("#{'${notify.errors}'.split(',')}")
    private List<String> errors;

    @Value("${notify.consumed:8}")
    private Integer consumed;

    @Value("${notify.cron}")
    String cron;

    @Autowired
    IJobService iJobService;


    @Bean
    public RestTemplate restTemplateCustom(){
        return new RestTemplate();
    }


    @Autowired
    @Qualifier("restTemplateCustom")
    private RestTemplate restTemplateCustom;

    @Autowired
    InstanceRepository repository;

    @Autowired
    @Qualifier("taskExecutor")
    private ThreadPoolTaskExecutor executor;

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
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {

//        System.err.println(instance.getRegistration().getName());
//        System.err.println(instance.getStatusInfo().getStatus());
//        System.err.println(instance.getStatusInfo());
//        if(instance.getEndpoints()!=null){
//            System.err.println(instance.getEndpoints().get("metrics"));
//            System.err.println(instance.getEndpoints().get("httptrace").get().getUrl());
//            System.err.println(instance.getEndpoints().get("health").toString());
//        }

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

    @Override
    public void afterPropertiesSet() throws Exception {
        JobDataMap jobDataMap=new JobDataMap();
        iJobService.removeJob(JOB_NAME,JOB_NAME);
        iJobService.saveJob(JOB_NAME, JOB_NAME, "Springboot Admin Service Status Check", new Job(){
            @Override
            public void execute(JobExecutionContext context) throws JobExecutionException {
                doNotify();
            }
        }, cron, JOB_NAME,jobDataMap);
    }





    private void doNotify(){
        List<Instance> instances= repository.findAll().collectList().block(Duration.ofSeconds(2));
        instances.forEach(instance -> {
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
        Future<Health> healthFuture = executor.submit(new Callable<Health>() {
            @Override
            public Health call() throws Exception {
                return checkHealth(name,svrUrl,instance);
            }
        });

        if(!healthFuture.isCancelled()) {
            Health health = null;
            try{
                health = healthFuture.get(consumed,TimeUnit.SECONDS);
                if (health != null) {
                    Metrics metrics=checkMetrics(name,svrUrl,instance);
                    if(metrics!=null){
                        checkErr(name,svrUrl,metrics.getAvailableTags());
                        checkHttpTrace(name,svrUrl,instance,metrics.getMeasurements());
                    }
                }
            } catch (TimeoutException e) {
                notice(name,svrUrl,new StringBuilder("Check health timeout,consumed more than ").append(consumed).append(" seconds").toString());
                throw e;
            }finally {
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

    private Metrics checkMetrics(String name,String svrUrl,Instance instance) throws Exception {
        if(!instance.getEndpoints().isPresent(ENDPOINT_METRICS)){
            notice(name,svrUrl,new StringBuilder("Endpoint metrics is not exist").toString());
            return null;
        }
        String url = instance.getEndpoints().get(ENDPOINT_METRICS).get().getUrl()+ENDPOINT_METRICS_HTTP_SERVER_REQUESTS;
        ResponseEntity<Metrics> responseEntity = restTemplateCustom.getForEntity(url,Metrics.class);
        if(responseEntity == null){
            notice(name,url,"Check metrics get null");
            return null;
        }
        Metrics metrics=responseEntity.getBody();
        if(metrics==null){
            notice(name,url,new StringBuilder("Check metrics get null").toString());
            return null;
        }
        if(responseEntity.getStatusCodeValue()!=200){
            notice(name,url,new StringBuilder(responseEntity.getStatusCodeValue()).toString());
            return metrics;
        }
        return metrics;
    }

    private boolean checkErr(String name,String svrUrl,List<AvailableTag> availableTags) throws Exception {
        if(StringUtils.isEmpty(availableTags) || CollectionUtils.isEmpty(errors)){
            return true;
        }
        for(AvailableTag availableTag:availableTags){
            if(availableTag.getTag().toLowerCase().equals(METRICS_AVAILABLETAG_TAG_EXCEPTION)){
                List<String> exceptions=availableTag.getValues();
                if(CollectionUtils.isEmpty(exceptions)){
                    return true;
                }
                for(String ex:exceptions){
                    for (String er:errors){
                        if(ex.toLowerCase().indexOf(er.toLowerCase())>0){
                            notice(name,svrUrl,ex);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }



    private HttpTrace checkHttpTrace(String name, String svrUrl, Instance instance, List<Measurement> measurements) throws Exception {
        if(StringUtils.isEmpty(measurements)){
            return null;
        }
        for(Measurement measurement:measurements){
            if(measurement.getStatistic().toUpperCase().equals(METRICS_MEASUREMENT_STATISTIC_MAX)){
                Double maxVal=measurement.getValue();
                if(maxVal>consumed){
                    return checkHttpTrace(name,svrUrl,instance);
                }
            }
        }
        return null;
    }

    private HttpTrace checkHttpTrace(String name,String svrUrl,Instance instance) throws Exception {
        if(!instance.getEndpoints().isPresent(ENDPOINT_HTTPTRACE)){
            notice(name,svrUrl,new StringBuilder("Endpoint httptrace is not exist").toString());
            return null;
        }
        String url = instance.getEndpoints().get(ENDPOINT_HTTPTRACE).get().getUrl();
        ResponseEntity<HttpTrace> responseEntity = restTemplateCustom.getForEntity(url,HttpTrace.class);
        if(responseEntity == null){
            notice(name,url,"Check httptrace get null");
            return null;
        }
        HttpTrace httpTrace=responseEntity.getBody();
        if(responseEntity.getStatusCodeValue()!=200){
            notice(name,url,new StringBuilder(responseEntity.getStatusCodeValue()).toString());
            return httpTrace;
        }

        if(httpTrace==null || CollectionUtils.isEmpty(httpTrace.getTraces())){
            return httpTrace;
        }

        List<Trace>  traces=httpTrace.getTraces();
        for(Trace trace:traces){
            if(trace.getTimeTaken()>(consumed*1000)){
                notice(name,trace.getRequest().getUri(),new StringBuilder("Consumed more than ").append(consumed).append(" seconds").toString());
                return httpTrace;
            }
        }
        return httpTrace;
    }





    private void notice(String title,String svrUrl,String content) throws Exception {
//        String name=new StringBuilder(title).append(" ").append(svrUrl).toString();
//        try{
//            Map<String,String> map=new HashMap<>();
//            map.put("name",name);
//            map.put("content",content);
//
//            Msg msg=new Msg();
//            msg.setTitle("Springboot admin do notify");
//            msg.setContent(map);
//            msg.setDestinations(phones.toArray(new String[phones.size()]));
//            msg.setTemplates(new MsgTemplate[]{MsgTemplate.SPRINGBOOT_ADMIN_SMS});
//            iSystemNotictFeign.notice(msg);
//        }finally {
//            throw new Exception(new StringBuilder(name).append("   ").append(content).toString());
//        }
    }


}
