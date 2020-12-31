package org.easy.order.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.easy.cloud.controller.BaseController;
import org.easy.order.entity.Order;
import org.easy.order.service.IOrderService;
import org.easy.system.feign.IDGenFeign;
import org.easy.tool.web.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.reactive.Response;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;



/**
 * @author winall
 */
@RestController
@EnableScheduling
@RequestMapping(path = {"/order"})
@Api(tags = "订单管理", position = 0)
public class OrderController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    IOrderService ordersService;

    @Autowired
    IDGenFeign idGenFeign;

    @ApiOperation(value = "订单添加", notes = "订单添加")
    @PostMapping(path = {"/add"}, produces = {"application/json"}, consumes = {"application/json"})
    public R<String> addRequestBody(@RequestBody @ApiParam(name = "orders对像", value = "orders") @Valid Order order, HttpServletRequest request) {

        if (order.getCustomMobile() == null || order.getCustomMobile().equals("")) {
            throw new RuntimeException("Receive Error Custome Order：" + order.toString());
        }

        LOGGER.info("Get order:" + order.toString());

        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        OperatingSystem os = userAgent.getOperatingSystem();

        order.setBrowserName(browser.getName());
        order.setBrowserType(browser.getBrowserType().toString());
        order.setBrowserOs(os.getName());
        order.setCreateIp(getRemoteAddr(request));
        order.setId(idGenFeign.next());
        order.setCreateDate(LocalDate.now());
        order.setCreateTime(LocalDateTime.now());

        ordersService.save(order);
        return R.success();
    }


    @PostMapping(path = {"/add"})
    @ApiOperation(value = "订单添加", notes = "订单添加")
    public R<String> addModelAttribute(@ModelAttribute @ApiParam(name = "orders对像", value = "orders") @Valid Order order, HttpServletRequest request) {
        return addRequestBody(order, request);
    }





}
