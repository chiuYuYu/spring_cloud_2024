package com.chiu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:${NAME}
 * Package:com.chiu.cloud
 * Description:
 *
 * @Author chiu
 * @Create ${DATE} ${TIME}
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient //此註解為使用consul為註冊中心時註冊服務
@EnableFeignClients    //啟用Feign客戶端，定義服務+綁定接口，以聲明式的方式實現服務調用
public class MainOpenFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenFeign80.class,args);

    }
}