package com.chiu.cloud.controller;

import com.chiu.cloud.apis.PayFeignApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:OrderMicrometerController
 * Package:com.chiu.cloud.controller
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/17 上午 09:04
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderMicrometerController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/fegin/micrometer/{id}")
    public String myMicrometer(@PathVariable("id")Integer id){

        return payFeignApi.myMicrometer(id);

    }


}
