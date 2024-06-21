package com.chiu.cloud.Controller;

import ch.qos.logback.core.util.TimeUtil;
import com.chiu.cloud.entities.Pay;
import com.chiu.cloud.entities.PayDTO;
import com.chiu.cloud.resp.ResultData;
import com.chiu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:PayController
 * Package:com.chiu.cloud.Controller
 * Description:
 *
 * @Author chiu
 * @Create 2024/4/30 下午 12:21
 * @Version 1.0
 */
@RestController
@Slf4j
@Tag(name = "支付微服務",description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;


    @PostMapping("/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json參數")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        log.info("新增", pay);
        int add = payService.add(pay);

        return    ResultData.success("新增成功:" + add);
    }


    @DeleteMapping("/pay/delete/{id}")
    public ResultData<String>  deletePay(@PathVariable("id") Integer id) {

        log.info("要刪除", id);
        int add = payService.delete(id);
        return ResultData.success("新增成功:" + add);
    }

    @PutMapping("/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int update = payService.update(pay);
        return ResultData.success("以修改:" + update);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        System.out.println(id);
        if(id==-4) throw new RuntimeException();
        Pay byId = payService.getById(id);
        try {
            System.out.println("開始等待");
            TimeUnit.SECONDS.sleep(62);
        }catch (Exception e){
            System.out.println(e);
        }
        return ResultData.success(byId);
    }


    @GetMapping("/pay/getALL")
    public ResultData<List<Pay>> getALL() {
        return ResultData.success(payService.getAll());
    }


    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/get/info")
    public String getInFoByConsul(@Value("${chiu.info}")String s){
        return "chiu_Info:"+s+"\t port:"+port;
    }
}
