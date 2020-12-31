package org.easy.system.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
@EnableScheduling
public class IDGenFeignFallback implements IDGenFeign {

    private static final long SUFFIX=1000;
    private static final int PREFIX=100;
    private static final AtomicLong RANDOM=new AtomicLong(new Random().nextInt(PREFIX));


    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyMMdd");
    private static final AtomicLong ID = new AtomicLong (((Long.parseLong(FORMAT.format(new Date()))*PREFIX+ RANDOM.incrementAndGet()) * SUFFIX));

    @Override
    public long next() {
        return ID.incrementAndGet();
    }

    @Override
    public String uuid() {
        return DigestUtils.md5DigestAsHex(String.valueOf(next()).getBytes());
    }

    @Scheduled(cron = "${id.reset.cron:0 1 0 * * ?}")
    public static long reset() {
        log.info("Reset ID ...");
        if(RANDOM.get()>PREFIX) {
            RANDOM.set(0);
        }
        ID.set(((Long.parseLong(FORMAT.format(new Date()))*PREFIX+ RANDOM.incrementAndGet()) * SUFFIX)) ;
        return ID.get();
    }

}
