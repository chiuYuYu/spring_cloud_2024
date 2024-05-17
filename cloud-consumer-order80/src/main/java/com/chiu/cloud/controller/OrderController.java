package com.chiu.cloud.controller;


import com.chiu.cloud.entities.PayDTO;
import com.chiu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

/**
 * ClassName:OrderController
 * Package:com.chiu.cloud.controller
 * Description:
 *
 * @Author chiu
 * @Create 2024/4/30 下午 04:07
 * @Version 1.0
 */
@RestController
public class OrderController {

//    public static final String PaymentSrv_URL="http://localhost:8001";
    public static final String PaymentSrv_URL="http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){

        return   restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }
    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData addOrder(@PathVariable("id") Integer id){
        return   restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    public String getInfo(){
        return   restTemplate.getForObject(PaymentSrv_URL+"/pay/get/info",String.class);
    }

}
