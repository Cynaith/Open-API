package com.ly.openapi.model.vo;

/**
 * @author: Cynaith
 **/
public enum ResultCode {

    SUCCESS("200","查询成功"),
    ERROR("500","服务器异常"),
    FAILED("300","账户无效");


    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
