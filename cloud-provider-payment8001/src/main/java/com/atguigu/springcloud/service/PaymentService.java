package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;


/**
 * @author ik
 */
public interface PaymentService {
    int addParameter(Payment payment);
    Payment getPaymentById (Long id);
}
