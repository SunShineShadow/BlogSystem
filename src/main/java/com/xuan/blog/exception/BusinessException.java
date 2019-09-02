package com.xuan.blog.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hx on 2019/8/29
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private String code;

    public BusinessException(String message) {
        super("业务异常" + message);
        this.code = "401";
    }

    public BusinessException(String message, Throwable cause) {
        super("业务异常" + message, cause);
        this.code = "401";
    }
}
