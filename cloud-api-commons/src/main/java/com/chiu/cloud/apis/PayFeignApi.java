package com.chiu.cloud.apis;

import cn.hutool.core.util.IdUtil;
import com.chiu.cloud.entities.PayDTO;
import com.chiu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:PayFeignApi
 * Package:com.chiu.cloud.apis
 * Description:
 *
 * @Author chiu
 * @Create 2024/5/5 下午 10:33
 * @Version 1.0
 */
//@FeignClient("cloud-payment-service")
@FeignClient("cloud-gateway")
public interface PayFeignApi {

    @PostMapping(value = "/pay/add")
    ResultData addPay(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/get/{id}")
    ResultData getById(@PathVariable("id")Integer id);

    @GetMapping(value = "/pay/get/info")
    String mylb();

    @GetMapping("/pay/circuit/{id}")
    String myCircuit(@PathVariable("id")Integer id);

    @GetMapping("/pay/bulkhead/{id}")
    String myBulkhead(@PathVariable("id")Integer id);

    @GetMapping("/pay/ratelimit/{id}")
    String myRatelimit(@PathVariable("id")Integer id);

    @GetMapping("/pay/micrometer/{id}")
    String myMicrometer(@PathVariable("id") Integer id);


    @GetMapping(value = "/pay/gateway/get/{id}")
    ResultData gatewayGetById(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/info")
    ResultData<String> getGatewayInfo();
}
