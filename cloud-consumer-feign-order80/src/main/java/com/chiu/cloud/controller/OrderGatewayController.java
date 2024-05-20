package com.chiu.cloud.controller;

import com.chiu.cloud.apis.PayFeignApi;
import com.chiu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:OrderGatewayController
 * Package:com.chiu.cloud.controller
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/17 下午 12:14
 * @Version 1.0
 */
@RestController
public class OrderGatewayController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id)
    {
        return payFeignApi.gatewayGetById(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo()
    {
        return payFeignApi.getGatewayInfo();
    }

}
