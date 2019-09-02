package com.xuan.blog.servlet;

import com.xuan.blog.Util.DBUtil;
import com.xuan.blog.Util.JsonUtil;
import com.xuan.blog.entity.Article;
import com.xuan.blog.exception.BusinessException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by hx on 2019/8/29
 */

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends BaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        // 处理前端请求数据{"id":"2","title":"","content":""}
        // application/json数据，需要使用request.getInputStream来获取
        // 获取JSON类型的请求数据
        Article article = JsonUtil.get(req, Article.class);
        // 处理业务及数据库操作
        try {
            conn = DBUtil.getConnection();
            String sql = "update article set title=?,content=? where id=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId());
            int r = ps.executeUpdate();
            if(r > 0){
//                return null;
                return r;
            }else{
                throw new BusinessException("没有该文章"+article.getId());
            }
        }finally {
            DBUtil.close(conn,ps,null);
        }
    }
}
