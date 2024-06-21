package com.chiu.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName:MyFilter
 * Package:com.chiu.cloud.filter
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/22 上午 10:35
 * @Version 1.0
 */
@Component
@Slf4j
public class MyFilter implements GlobalFilter, Ordered {

    public static final  String BEGIN_VISIT_TIME="begin_visit_time";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(BEGIN_VISIT_TIME,System.currentTimeMillis());

        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            Long beginTime = exchange.getAttribute(BEGIN_VISIT_TIME);
            if(beginTime!=null){
                log.info("訪問主機:"+exchange.getRequest().getURI().getHost());
                log.info("訪問端口:"+exchange.getRequest().getURI().getPort());
                log.info("訪問url:"+exchange.getRequest().getURI().getPath());
                log.info("訪問url參數:"+exchange.getRequest().getURI().getRawQuery());
                log.info("總耗時:"+(System.currentTimeMillis()-beginTime)+"毫秒");
                log.info("===================================================");
                System.out.println();
            }
        }));
    }

    //數字越小，優先級越高
    @Override
    public int getOrder() {
        return 0;
    }

    public static void main(String[] args) {
        String a="00";
        switch (a){
            case "00":
                a="00000";
                break;
            case "01":
                a="11111111111";
                break;
            case "02":
                a="2222222222";
                break;

        }
        System.out.println(a);
    }

}

