package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.service.FeignPaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @className: OrderNacosController
 * @author: weishihuan
 * @date: 2022-04-07 22:04
 **/
@RestController
public class OrderNacosController {
    //@Resource
    //private RestTemplate restTemplate;

    @Resource
    private FeignPaymentService feignPaymentService;

    //@Value("${service-url.nacos-user-service}")
    //private String targetUrl;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        return feignPaymentService.getPaymentById(id);
    }
}
