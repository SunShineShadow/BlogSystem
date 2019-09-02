package com.xuan.blog.servlet;

import com.xuan.blog.Util.MyActionEnter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hx on 2019/8/31
 */

@WebServlet("/ueditor")
public class UEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = UEditorServlet.class.getClassLoader().
                getResource("config.json").getPath();
        MyActionEnter myActionEnter = new MyActionEnter(req, path);
        String exec = myActionEnter.exec();
        resp.getWriter().write(exec);
    }
}
