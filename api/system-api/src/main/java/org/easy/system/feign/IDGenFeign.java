package org.easy.system.feign;

import org.easy.system.AutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = AutoConfiguration.SERVICE_NAME,path = IDGenFeign.PATH,fallback =IDGenFeignFallback.class )
public interface IDGenFeign {

    String PATH = "/id";

    @RequestMapping(value = "/long", method = RequestMethod.GET)
    public  long next();

    @RequestMapping(value = "/uuid", method = RequestMethod.GET)
    public  String uuid();

}
