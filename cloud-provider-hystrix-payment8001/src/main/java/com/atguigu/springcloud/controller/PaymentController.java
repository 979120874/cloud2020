package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @className: PaymentController
 * @author: weishihuan
 * @date: 2022-03-05 16:54
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String ServerPort;
    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String info_ok = paymentService.paymentInfo_OK(id);
        log.info(info_ok);
        return info_ok;
    }

    @GetMapping("/payment/hystrix/TimeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String info_TimeOut = paymentService.paymentInfo_TimeOut(id);
        log.info(info_TimeOut);
        return info_TimeOut;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }

}
