package com.chiu.cloud.exp;


import com.chiu.cloud.resp.ResultData;
import com.chiu.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName:GlobalExceptionHandler
 * Package:com.chiu.cloud.exp
 * Description:
 *
 * @Author chiu
 * @Create 2024/4/30 下午 03:30
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e){
        System.out.println("COME IN GlobalExceptionHandler");
        log.error("全局異常訊息:{}",e.getMessage(),e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
    }


}
