package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @className: OrderConsulController
 * @author: weishihuan
 * @date: 2022-02-20 17:13
 **/
@RestController
@Slf4j
public class OrderConsulController {
    @Resource
    private RestTemplate restTemplate;

    public static final String  INVOKE_URL = "http://consul-provider-payment";

    @GetMapping("/consul/payment/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
