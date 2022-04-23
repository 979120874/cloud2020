package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.alibaba.OutMethod.CircleBreajer;
import com.atguigu.springcloud.alibaba.service.CircleBreakerService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @className: FeignCircleBreakerController
 * @author: weishihuan
 * @date: 2022-04-22 13:56
 **/
@RestController
public class FeignCircleBreakerController {
    @Resource
    private CircleBreakerService circleBreakerService;

    @GetMapping(value = "/feign/commons/paymentSQL/{id}")
    @SentinelResource(value = "paymentSQL", blockHandlerClass = CircleBreajer.class, blockHandler = "blocPaymentSQL", fallbackClass = CircleBreajer.class, fallback = "fallbackPaymentSQL")
    //什么都没有配置
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        CommonResult<Payment> result = circleBreakerService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException异常，非法参数");
        } else if (result == null) {
            throw new NullPointerException("NullPointerException异常，空指针");
        }
        return result;
    }
}
