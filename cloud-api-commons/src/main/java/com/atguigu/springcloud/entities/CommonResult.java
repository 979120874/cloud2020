package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @className: CommonResult
 * @author: weishihuan
 * @date: 2022-02-13 22:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    private Integer code;
    private String msg;
    private T data;
    public CommonResult(Integer code,String msg){
        this(code,msg,null);
    }
}
