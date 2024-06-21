package com.chiu.cloud;

/**
 * ClassName:TestExcepton
 * Package:com.chiu.cloud
 * Description:
 *
 * @Author chiu
 * @Create 2024/6/6 上午 07:42
 * @Version 1.0
 */
public class TestException extends  RuntimeException{

    private static final long serialVersionUID = 1l;

    private final String code;


    public TestException(String code) {
        this(code,null);
    }
    public TestException(String code,String message) {
        this(code,message,null);
    }

    public TestException(String code,String message,Throwable caues) {
        super(message,caues);
        this.code=code;
    }

    public String getCode(){
        return this.code;
    }
}
