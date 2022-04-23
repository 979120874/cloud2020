package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.util.logging.resources.logging;

/**
 * TODO
 *
 * @className: FeignConfig
 * @author: weishihuan
 * @date: 2022-03-05 00:12
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
