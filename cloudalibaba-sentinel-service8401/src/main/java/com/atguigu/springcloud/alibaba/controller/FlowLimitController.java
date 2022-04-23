package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.MyHandler.CustomerBlockHandler;
import com.atguigu.springcloud.alibaba.service.FlowlimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * TODO
 *
 * @className: FlowLimitController
 * @author: weishihuan
 * @date: 2022-04-20 15:06
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @Resource
    private FlowlimitService flowlimitService;

    @GetMapping("/testA")
    public String testA() {
        flowlimitService.getName();
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread() + "...testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 10 / 0;
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandlerClass = CustomerBlockHandler.class,blockHandler = "testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        return "testHotKey,哈哈哈";
    }

    public String blockHotKey(String p1, String p2, BlockException exception) {
        return "blockHotKey,┭┮﹏┭┮";
    }
}
