package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.FeignPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @className: FeignOrderController
 * @author: weishihuan
 * @date: 2022-03-04 23:17
 **/
@RestController
public class FeignOrderController {
    @Resource
    private FeignPaymentService feignPaymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        return feignPaymentService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String consumerPaymentFeignTimeOut(){
        return feignPaymentService.paymentFeignTimeOut();
    }
}
