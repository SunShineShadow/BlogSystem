package com.xuan.blog.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hx on 2019/8/29
 */
@Getter
@Setter
public class ParameterException extends RuntimeException{
    private String code;

    public ParameterException(String message) {
        super("客户端错误："+message);
    }

    public ParameterException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }
}
