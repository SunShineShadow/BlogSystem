package com.xuan.blog.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hx on 2019/8/29
 */
@Getter
@Setter
public class SystemException extends RuntimeException {
    private String code;

    public SystemException(String message) {
        super("系统异常" + message);
        code = "501";
    }

    public SystemException(String message, Throwable cause, String code) {
        super("系统异常" + message, cause);
        code = "501";
    }
}
