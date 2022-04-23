package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @className: FeignPaymentService
 * @author: weishihuan
 * @date: 2022-03-04 23:15
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignPaymentService {
    @RequestMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout")
    public String paymentFeignTimeOut();
}
