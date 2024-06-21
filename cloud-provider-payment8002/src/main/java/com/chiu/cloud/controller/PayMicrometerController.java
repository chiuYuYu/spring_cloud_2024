package com.chiu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:PayMicrometerController
 * Package:com.chiu.cloud.Controller
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/17 上午 08:58
 * @Version 1.0
 */
@RestController
public class PayMicrometerController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id){
        return "歡迎來到myMicrometer 端口"+port+" 輸入的ID為:"+id+"\t"+ IdUtil.simpleUUID();
    }

}
