package com.chiu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.chiu.cloud.entities.Pay;
import com.chiu.cloud.resp.ResultData;
import com.chiu.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

/**
 * ClassName:PayGatewayController
 * Package:com.chiu.cloud.Controller
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/17 上午 11:59
 * @Version 1.0
 */
@RestController
public class PayGatewayController {
    @Resource
    PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return ResultData.success("gateway info test：" + IdUtil.simpleUUID());
    }

    @GetMapping(value = "/pay/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request) {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("請求頭名稱: " + headName + "\t\t\t" + "请求頭值: " + headValue);
            if (headName.equalsIgnoreCase("X-Request-chiu1")
                    || headName.equalsIgnoreCase("X-Request-chiu2")) {
                result = result + headName + "\t " + headValue + " ";
            }
        }
        System.out.println("====================================");
        System.out.println("customerId:"+request.getParameter("customerId"));
        System.out.println("customerName:"+request.getParameter("customerName"));
        System.out.println("====================================");

        return ResultData.success("getGatewayFilter 過濾器 test： " + result + " \t " + DateUtil.now());
    }
}