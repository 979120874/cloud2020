package com.atguigu.springcloud.alibaba.OutMethod;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @className: CircleBreajer
 * @author: weishihuan
 * @date: 2022-04-22 12:07
 **/
public class CircleBreajer {
    public static CommonResult blocPaymentSQL(Long id,BlockException blockException) {
        return new CommonResult<>(444,"blockHandler出错啦",null);
    }
    public static CommonResult fallbackPaymentSQL(@PathVariable("id") Long id) {
        return new CommonResult<>(888,"fallback出错啦",null);
    }
}
