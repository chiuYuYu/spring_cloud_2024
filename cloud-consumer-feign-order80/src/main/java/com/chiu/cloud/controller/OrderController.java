package com.chiu.cloud.controller;


import cn.hutool.core.date.DateUtil;
import com.chiu.cloud.apis.PayFeignApi;
import com.chiu.cloud.entities.PayDTO;
import com.chiu.cloud.resp.ResultData;
import com.chiu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        System.out.println("進入");
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    };

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        System.out.println("進入get");
        ResultData resultData =null;
        try {
            System.out.println("調用開始");
            System.out.println(DateUtil.now());
            resultData = payFeignApi.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }finally {
            System.out.println("調用結束");
            System.out.println(DateUtil.now());
        }
        return resultData;
    };

    @GetMapping("/feign/pay/mylb")
    public String getPayInfo(){
        return payFeignApi.mylb();
    };
}
