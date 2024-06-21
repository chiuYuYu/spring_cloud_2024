package com.chiu.cloud.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:startus
 * Package:com.chiu.cloud.entities
 * Description:
 *
 * @Author chiu
 * @Create 2024/6/19 上午 11:56
 * @Version 1.0
 */
public enum Startus {
    a("00"),b("01"),c("02");

    private static final Map<String,Startus> map= new HashMap<>();

    private  String value;

     Startus(String value){
        this.value=value;
    }

    public String getValue(){
        return  value;
    }

    public static Startus fromValue(String value) {
        for (Startus startus : Startus.values()) {
            map.put(startus.getValue(), startus);
        }
        if ( map.containsKey(value)){
            System.out.println(123);
        }
        return map.get(value);
    }
}
