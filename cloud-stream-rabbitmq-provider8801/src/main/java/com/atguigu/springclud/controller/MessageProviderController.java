package com.atguigu.springclud.controller;

import com.atguigu.springclud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * TODO
 *
 * @className: MessageProvidercontroller
 * @author: weishihuan
 * @date: 2022-04-06 10:55
 **/
@RestController
public class MessageProviderController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return iMessageProvider.sendMessage();
    }
}
