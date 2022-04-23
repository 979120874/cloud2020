package com.atguigu.springcloud.LB;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @className: MyLB
 * @author: weishihuan
 * @date: 2022-03-02 23:34
 **/
@Component
public class MyLB implements LoadBalancer{
    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);


    private final int getAndIncrement(){
        int upCount;
        int next;
        do {
            upCount=nextServerCyclicCounter.get();
            next = upCount>=2000 ? 0 : upCount+1;
        }while (!nextServerCyclicCounter.compareAndSet(upCount, next));
        System.out.println("******第几次访问*******="+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> ServiceInstances) {
        int index=getAndIncrement() % ServiceInstances.size();
        ServiceInstance serviceInstance = ServiceInstances.get(index);
        return serviceInstance;
    }
}
