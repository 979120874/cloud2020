package com.atguigu.springcloud.alibaba;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * TODO
 *
 * @className: MainApp8401
 * @author: weishihuan
 * @date: 2022-04-20 15:03
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8401 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp8401.class, args);
    }


}

