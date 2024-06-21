package com.chiu.cloud.controller;


import com.chiu.cloud.entities.PayDTO;
import com.chiu.cloud.resp.ResultData;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.util.JSONArrayUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.List;

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

    @PostMapping (value = "/consumer/pay/get/info/test333")
    public ResponseEntity<String> addOrder(HttpEntity<String> requestBody) throws ParseException {
        System.out.println("v2");

        ResponseEntity<String> url = restTemplate.postForEntity(PaymentSrv_URL+"/pay/get/info/test333",requestBody, String.class);
        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>(url.getBody(), HttpStatus.OK);
        return  stringResponseEntity;
    }

}
