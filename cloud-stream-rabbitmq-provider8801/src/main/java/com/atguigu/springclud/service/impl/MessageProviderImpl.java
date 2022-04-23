package com.atguigu.springclud.service.impl;

import com.atguigu.springclud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * TODO
 *
 * @className: MessageProviderImpl
 * @author: weishihuan
 * @date: 2022-04-06 10:43
 **/
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    @Qualifier(Source.OUTPUT)
    //需要指定名称为output，不然会找不到，yml配置也有一个output作为管道的名字
    private MessageChannel channel;

    @Override
    public String sendMessage() {
        String msg= UUID.randomUUID().toString();
        channel.send(MessageBuilder.withPayload(msg).build());
        System.out.println("****"+msg);
        return msg;
    }
}
