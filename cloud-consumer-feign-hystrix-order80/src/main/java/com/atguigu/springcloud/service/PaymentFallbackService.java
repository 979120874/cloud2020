package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @className: PaymentFallbackService
 * @author: weishihuan
 * @date: 2022-03-06 23:33
 **/
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80--paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80--paymentInfo_TimeOut";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "呜呜呜呜呜id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id:"+id;
    }
}
