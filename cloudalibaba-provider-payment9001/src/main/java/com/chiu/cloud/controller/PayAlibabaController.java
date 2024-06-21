package com.chiu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:PayAlibabaController
 * Package:com.chiu.cloud.controller
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/23 上午 11:37
 * @Version 1.0
 */
@RestController
public class PayAlibabaController {

    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id")Integer id){
        return "serverPort:"+serverPort+"\tid:"+id;
    }
}
