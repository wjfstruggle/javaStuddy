package com.cdc.ecommerce.common.utils;

import org.aspectj.weaver.loadtime.Aj;

/**
 * @Author wujf
 * @ClassName AjaxResponse
 * @Description
 * @Date $ $
 * @Param $
 * @return $
 **/
public class AjaxResponse {
    private boolean isOk; // 是否请求成功
    private int code; // 请求相应的状态码
    private String message; // 请求结果描述信息
    private Object data; // 请求结果数据
    private AjaxResponse() {

    }
    public static AjaxResponse success() {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setOk(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("success");
        return ajaxResponse;
    }
    public static AjaxResponse success(Object data) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setOk(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("success");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
