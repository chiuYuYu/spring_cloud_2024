package com.chiu.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ClassName:ResultData
 * Package:com.chiu.cloud.resp
 * Description:
 *
 * @Author chiu
 * @Create 2024/4/30 下午 03:05
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class ResultData <T> {

    private String code;
    private String message;
    private T data;
    private Long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }
    public static <T> ResultData<T> success(T data) {
        ResultData resultData = new ResultData();
        resultData.setData(data);
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        return resultData;
    }
    public static <T> ResultData<T> fail(String code,String message) {
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMessage(message);
        resultData.setData(null);
        return resultData;
    }
}