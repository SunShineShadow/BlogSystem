package com.xuan.blog.servlet;

import com.xuan.blog.Util.JsonUtil;
import com.xuan.blog.entity.JSON;
import com.xuan.blog.exception.ParameterException;
import com.xuan.blog.exception.SystemException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hx on 2019/8/23
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        JSON result = new JSON();
        try {
            Object data = process(req,resp);
            result.setSuccess(true);
            result.setCode("200");
            result.setMessage("操作成功");
            result.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof ParameterException) {
                result.setCode(((ParameterException) e).getCode());
                result.setMessage(e.getMessage());
            } else if (e instanceof SystemException) {
                result.setCode(((SystemException) e).getCode());
                result.setMessage(e.getMessage());
            } else {
                result.setCode("500");
                result.setMessage("服务器错误");
            }
        }
        resp.getWriter().write(JsonUtil.analysis(result));
    }

    public abstract Object process(HttpServletRequest req,
                                   HttpServletResponse resp)throws Exception;
}
