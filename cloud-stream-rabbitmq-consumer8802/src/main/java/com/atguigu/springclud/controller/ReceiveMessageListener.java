package com.atguigu.springclud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @className: ReceiveMessageListener
 * @author: weishihuan
 * @date: 2022-04-06 12:11
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {

    @Value("${server.port}")
    public String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> msg){
        String payload = msg.getPayload();
        System.out.println("1号 \t"+"本机是："+port+"\t 接收到的消息为："+payload);
    }
}
