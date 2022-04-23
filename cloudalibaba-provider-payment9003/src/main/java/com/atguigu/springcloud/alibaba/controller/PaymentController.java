package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * TODO
 *
 * @className: PaymentController
 * @author: weishihuan
 * @date: 2022-04-21 22:30
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String servicePort;

    public static HashMap<Long,Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"111111111fb42181"));
        hashMap.put(2L,new Payment(2L,"2222222211fb4218"));
        hashMap.put(3L,new Payment(3L,"3333333311fb4218"));
    }
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        return new CommonResult<Payment>(200,"okok...."+servicePort,payment);
    }
}
