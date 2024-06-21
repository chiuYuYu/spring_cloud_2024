package com.chiu.cloud;

import com.nimbusds.jose.crypto.impl.PRFParams;

/**
 * ClassName:model
 * Package:com.chiu.cloud
 * Description:
 *
 * @Author chiu
 * @Create 2024/6/5 上午 08:38
 * @Version 1.0
 */
public class model {
    private String ciphertext;

    public static void main(String[] args) {
        String a="03";
        if(!a.equals("00")&&!a.equals("01")&&!a.equals("02")) System.out.println("a:資料錯誤");


    }
}

