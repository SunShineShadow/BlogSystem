package com.xuan.blog.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuan.blog.entity.Article;
import com.xuan.blog.exception.SystemException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hx on 2019/8/23
 */
public class JsonUtil {
    public static String analysis(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SystemException("JSON解析错误"+obj);
        }
    }

    public static <T> T get(HttpServletRequest req, Class<T> cls){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            return objectMapper.readValue(req.getInputStream(),cls);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SystemException("JSON反序列化失败！");
        }
    }
}
