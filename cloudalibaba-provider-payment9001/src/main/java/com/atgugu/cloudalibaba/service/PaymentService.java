package com.atgugu.cloudalibaba.service;

import com.atgugu.cloudalibaba.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @className: PaymentService
 * @author: weishihuan
 * @date: 2022-04-07 22:36
 **/
@Service
public class PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
