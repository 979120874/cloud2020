package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.naming.Name;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @className: PaymentService
 * @author: weishihuan
 * @date: 2022-03-05 16:50
 **/
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O";
    }

    @HystrixCommand(fallbackMethod="paymentInfo_TimeOutHandele",commandProperties={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000" )
    })
    public String paymentInfo_TimeOut(Integer id){
        //int a=10/0;
        //int time=2.5;
        //try {
        //    TimeUnit.SECONDS.sleep(1);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"┭┮﹏┭┮"+"\t"+"秒"+"终于进来了";
    }
    public String paymentInfo_TimeOutHandele(@PathVariable("id") Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"系统繁忙，请稍后重新访问"+"/(ㄒoㄒ)/~~";
    }

    //=========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
