package com.chiu.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * ClassName:RestTemplateConfig
 * Package:com.chiu.cloud.config
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/23 上午 11:59
 * @Version 1.0
 */
@Component
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {

        String a="TSP98467812342";
        String b="000000300000";
        String c="000000050000";

        System.out.println(String.format("%013d",Long.parseLong(b) - Long.parseLong(c)));
        System.out.println(a.charAt(8));
        String aaa= String.format("%013d", Long.parseLong("000000010000"))+"00000000";
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        String vv="000000029990000002819201905160908491938160000004868";
        System.out.println(vv.substring(vv.length() - 16));
        System.out.println("=================================");
        System.out.println(IssuerResponseCode.SUCCESS.getCode());
        System.out.println("=================================");
    }

    public enum IssuerResponseCode {
        SUCCESS("0000"),
        REQUESTED("0001"),
        TIMEOUT("1001");

        private String code;

        private IssuerResponseCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

}
