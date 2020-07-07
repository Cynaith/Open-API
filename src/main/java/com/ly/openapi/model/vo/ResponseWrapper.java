package com.ly.openapi.model.vo;

/**
 * @author: Cynaith
 **/
public class ResponseWrapper {
    private String code;
    private String msg;
    private Object data;

    public ResponseWrapper() {
    }

    public ResponseWrapper(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseWrapper success(Object data){
        ResponseWrapper responseWrapper = new ResponseWrapper();

        responseWrapper.setCode(ResultCode.SUCCESS.getCode());

        responseWrapper.setMsg(ResultCode.SUCCESS.getMessage());

        responseWrapper.setData(data);

        return responseWrapper;
    }

    public static ResponseWrapper error(){
        ResponseWrapper responseWrapper = new ResponseWrapper();

        responseWrapper.setCode(ResultCode.ERROR.getCode());

        responseWrapper.setMsg(ResultCode.ERROR.getMessage());

        responseWrapper.setData(null);

        return responseWrapper;
    }

    public static ResponseWrapper failed(){
        ResponseWrapper responseWrapper = new ResponseWrapper();

        responseWrapper.setCode(ResultCode.FAILED.getCode());

        responseWrapper.setMsg(ResultCode.FAILED.getMessage());

        responseWrapper.setData(null);

        return responseWrapper;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
