package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.alibaba.OutMethod.CircleBreajer;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @className: CircleBreakerController
 * @author: weishihuan
 * @date: 2022-04-21 23:25
 **/
@RestController
public class RibbonCircleBreakerController {
    private static String paymentUrl = "http://nacos-payment-provider/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/commons/paymentSQL/{id}")
    //@SentinelResource(value = "paymentSQL") //什么都没有配置
    @SentinelResource(value = "paymentSQL", blockHandlerClass = CircleBreajer.class, blockHandler = "blocPaymentSQL", fallbackClass = CircleBreajer.class, fallback = "fallbackPaymentSQL")
    //什么都没有配置
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(paymentUrl + "paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException异常，非法参数");
        } else if (result == null) {
            throw new NullPointerException("NullPointerException异常，空指针");
        }
        return result;
    }


    //=========================Feign
}
