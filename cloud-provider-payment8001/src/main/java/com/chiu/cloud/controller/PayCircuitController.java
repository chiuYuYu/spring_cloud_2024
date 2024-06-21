package com.chiu.cloud.Controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:PayCircuitController
 * Package:com.chiu.cloud.Controller
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/14 下午 01:47
 * @Version 1.0
 */

@RestController
public class PayCircuitController {

    @GetMapping("/pay/circuit/{id}")
    public  String myCircuit(@PathVariable("id")Integer id){
        if (id==-4)throw new RuntimeException("id 不可為負數");
        if ( id==9999){
            try {TimeUnit.SECONDS.sleep(5);}catch (InterruptedException e){e.printStackTrace();};
        }
        return  "hello Circuit id:"+id+"\t"+ IdUtil.simpleUUID();
    }


    @GetMapping("/pay/bulkhead/{id}")
    public  String myBulkhead(@PathVariable("id")Integer id){
        if (id==-4)throw new RuntimeException("myBulkhead ID 不可為負數");
        if ( id==9999){
            try {TimeUnit.SECONDS.sleep(5);}catch (InterruptedException e){e.printStackTrace();};
        }
        return  "hello myBulkhead id:"+id+"\t"+ IdUtil.simpleUUID();
    }
    @GetMapping("/pay/ratelimit/{id}")
    public  String myRatelimit(@PathVariable("id")Integer id) {
        return "歡迎來到myRatelimit"+id+"\t"+IdUtil.simpleUUID();
    }
}
