package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @className: ConfigClientController
 * @author: weishihuan
 * @date: 2022-04-08 10:48
 **/
@RestController
@RefreshScope
public class ConfigClientController {

    //@Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        //return configInfo;
        return "configInfo";
    }
}
