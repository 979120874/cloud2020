package com.atguigu.springcloud.alibaba.MyHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @className: CustomerBlockHandler
 * @author: weishihuan
 * @date: 2022-04-21 19:31
 **/
public class CustomerBlockHandler {
    public static CommonResult byResource(BlockException blockException) {
        return new CommonResult(444,"按客戶自定义,global handlerException----1",null);
    }

    public static String testHotKey( String p1, String p2,BlockException blockException) {
        return "blockHotKey,┭┮﹏┭┮";
    }
}
