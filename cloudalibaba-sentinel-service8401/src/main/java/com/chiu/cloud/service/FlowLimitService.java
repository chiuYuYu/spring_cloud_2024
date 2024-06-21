package com.chiu.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * ClassName:FlowLimitService
 * Package:com.chiu.cloud.service
 * Description:
 *
 * @Author chiu
 * @Create 2024/6/20 下午 04:48
 * @Version 1.0
 */
@Service
public class FlowLimitService {

    @SentinelResource(value = "common")
    public void common(){
        System.out.println("FlowLimitService.common====================");
    }

}
