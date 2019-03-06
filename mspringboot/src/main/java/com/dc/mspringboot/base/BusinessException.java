package com.dc.mspringboot.base;


import com.dc.mspringboot.em.EnumError;

/**
 * @Description: 统一异常处理信息实体类
 * @auther: dcf
 * @date: 2019/2/21
 */
public class BusinessException extends Exception {

    private int code;//异常编码
    private String message;//异常消息
    private Exception exception;//异常错误具体信息

    public BusinessException() {
    }

    public BusinessException(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public BusinessException(String message, Exception e) {
        this.message = message;
        this.exception = e;
    }

    public BusinessException(EnumError emErr) {
        this.message = emErr.getMsg();
        this.code = emErr.getCode();
    }


    public void setMessage(EnumError emErr) {
        this.message = emErr.getMsg();
        this.code = emErr.getCode();
    }

    public BusinessException(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}