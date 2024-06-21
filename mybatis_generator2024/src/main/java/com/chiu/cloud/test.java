package com.chiu.cloud;

import com.chiu.cloud.entities.Startus;
import com.chiu.cloud.entities.User;

/**
 * ClassName:test
 * Package:com.chiu.cloud
 * Description:
 *
 * @Author chiu
 * @Create 2024/6/19 下午 12:00
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        User user = new User();
        String s = user.getStartus().toString();
        System.out.println(s);
    }
}
