package com.xuan.blog.entity;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

/**
 * Created by hx on 2019/8/23
 */
public class JSON {
    private boolean success;//操作是否成功

    private String code;//错误码

    private String message;//错误信息

    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

