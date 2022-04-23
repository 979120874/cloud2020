package com.atguigu.springcloud.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @className: FlowlimitService
 * @author: weishihuan
 * @date: 2022-04-21 11:10
 **/
@Service
public class FlowlimitService {

    @SentinelResource(value = "getName")
    public void getName(){
        System.out.println("韦世欢");
    }
}
