package org.easy.order;



import org.easy.order.entity.LandingOrder;
import org.easy.order.service.ILandingOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.spring.web.json.Json;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTests {

    @Autowired
    ILandingOrderService landingOrderService;

    @Test
    public void contextLoads()  {
        LandingOrder order=new LandingOrder();
        order.setBrowserName("Chrome");
        order.setBrowserOs("Windows");
        order.setBrowserType("Mobile");
        order.setCreateIp("182.168.9.5");
        order.setCustomContent("Test");
        order.setCustomEmail("240018840@qq.com");
        order.setCustomFrom("Baidu");
        order.setCustomMobile("13049682462");
        order.setCustomName("xxx");
        order.setCustomQq("240018840");
        order.setCustomVisitUrl("http://23232/232l2k32/23/23");
        order.setCustomWechat("24002330");
        order.setDeliverAdderss("架夺回国虽加盟加国国圆明园");
        order.setDeliverCity("成都");
        order.setDeliverProvince("广东");
        order.setProductBranch("苏宁");
        order.setProductId("BS-SDFLSK2222323");
        order.setProductPrice(new BigDecimal(23232.343));
        landingOrderService.save(order);
    }
}
