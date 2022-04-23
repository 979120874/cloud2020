package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.LB.LoadBalancer;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * TODO
 *
 * @className: OrderController
 * @author: weishihuan
 * @date: 2022-02-14 23:38
 **/
@RestController
public class OrderController {
    //public static final String Payment_URL="http://localhost:8001";
    // 通过在eureka上注册过的微服务名称调用
    public static final String Payment_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @RequestMapping("/consumer/payment/create")
    public CommonResult addPayment(Payment payment){
        return restTemplate.postForObject(Payment_URL+"/payment/create",payment,CommonResult.class);
    }
    @RequestMapping("/consumer/payment/create2")
    public CommonResult addPayment2(Payment payment){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(Payment_URL + "/payment/create", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }
        return new CommonResult(404,"操作失败");
    }



    @RequestMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(Payment_URL+"/payment/get/"+id,CommonResult.class);
    }
    @RequestMapping("/consumer/payment/get2/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") Integer id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(Payment_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }
        return new CommonResult(404,"查询失败");
    }

    @RequestMapping("/consumer/discoveryClient/get")
    public Object getDisplayInfo(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("服务名称为="+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-ORDER-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println("说明："+"\t"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri()+"\t"+instance.getPort());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri.toString() + "/payment/lb", String.class);
    }
}
