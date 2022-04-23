package com.atgugu.cloudalibaba.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    Payment getPaymentById(@Param("id") Long id);
}
