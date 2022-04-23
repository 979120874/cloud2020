package com.atgugu.cloudalibaba.controller;

import com.atgugu.cloudalibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
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
 * @date: 2022-04-07 21:23
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    public String port;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPaymentById(id.longValue());
        return new CommonResult<Payment>(100,port,payment);
    }
}
