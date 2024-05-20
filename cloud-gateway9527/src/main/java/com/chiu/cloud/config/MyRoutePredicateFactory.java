package com.chiu.cloud.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.AfterRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * ClassName:MyRoutePredicateFactory
 * Package:com.chiu.cloud.config
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/17 下午 03:28
 * @Version 1.0
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    public MyRoutePredicateFactory(){
        super(MyRoutePredicateFactory.Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //檢查request的參數裡面，user Type是否為指定的值，符合配置就通過
                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");

                if(userType==null) return false;
                //如果說參數存在，就和config的數據進行比較
                if(userType.equalsIgnoreCase(config.getUserType()))return true;

                return false;
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }

    @Validated
    public static class Config{
        @Setter@Getter@NotEmpty
        private  String userType;
    }
}
