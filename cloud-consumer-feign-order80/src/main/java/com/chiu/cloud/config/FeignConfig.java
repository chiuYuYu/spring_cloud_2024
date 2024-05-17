package com.chiu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * ClassName:FeignConfig
 * Package:com.chiu.cloud.config
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/6 上午 08:43
 * @Version 1.0
 */
@Component
public class FeignConfig {

    @Bean
    public Retryer myRetryer(){
         return Retryer.NEVER_RETRY;
        //初始間隔時間,重試最大間格時間,最大請求次數為3(2+1)
//        return new Retryer.Default(100,2,4);
    }

    @Bean
    Logger.Level log(){
        return Logger.Level.FULL;
    }
}
