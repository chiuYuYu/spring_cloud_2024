package com.chiu.cloud.controller;

import com.chiu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:FlowLimitController
 * Package:com.chiu.cloud.controller
 * Description:
 *
 * @Author chiu
 * @Create 2024/6/20 下午 03:38
 * @Version 1.0
 */
@RestController
public class FlowLimitController {

    private static int a=0;

    @GetMapping("testA")
    public String testA(){
        System.out.println("進入A\t\t"+a++);
        return "==========testA";
    }

    @GetMapping("testB")
    public String testB(){
        System.out.println("進入B\t\t"+a++);
        return "==========testB";
    }

    @GetMapping("testClean")
    public String testClean(){
        a=0;
        return "==========testClean";
    }

    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("testC1")
    public String testC(){
        flowLimitService.common();
        return "==========testC1";
    }
    @GetMapping("testC2")
    public String testC2(){
        flowLimitService.common();
        return "==========testC2";
    }
    //流控效果的排隊等待
    @GetMapping("testE")
    public String testE(){
        System.out.println("==========testE\t\t"+System.currentTimeMillis());
        return "==========testE\t\t"+System.currentTimeMillis()+"\t\t流控排隊等待";
    }
    //溶斷測試
    @GetMapping("testF")
    public String testF(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){e.printStackTrace();}
        System.out.println("==========testF\t\t"+System.currentTimeMillis());
        return "==========testF\t\t"+System.currentTimeMillis();
    }



}
