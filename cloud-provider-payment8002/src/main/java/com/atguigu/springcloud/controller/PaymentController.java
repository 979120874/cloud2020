package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @className: PaymentController
 * @author: weishihuan
 * @date: 2022-02-13 22:21
 **/
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult addPayment(@RequestBody Payment payment){
        int i = paymentService.addParameter(payment);
        if (i<0){
            return new CommonResult(404,"插入失败",null);
        }
        return new CommonResult(200,"插入成功,serverPort: "+serverPort,i);
    }
    @RequestMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPaymentById(id.longValue());
        if (payment!=null){
            return new CommonResult(200,"查询成功,serverPort: "+serverPort,payment);
        }
        return new CommonResult(404,"对不起，查询失败",null);
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
