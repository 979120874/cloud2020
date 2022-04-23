package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @className: GateWayConfig
 * @author: weishihuan
 * @date: 2022-03-12 13:28
 **/
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes().route("path_route_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com")).build();
    }
}
