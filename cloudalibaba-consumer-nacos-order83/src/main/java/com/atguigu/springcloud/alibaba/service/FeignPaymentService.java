package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value="nacos-payment-provider")
public interface FeignPaymentService {
    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id")Integer id);
}
