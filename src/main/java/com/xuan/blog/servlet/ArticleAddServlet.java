package com.xuan.blog.servlet;

import com.xuan.blog.Util.DBUtil;
import com.xuan.blog.Util.JsonUtil;
import com.xuan.blog.entity.Article;
import com.xuan.blog.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * Created by hx on 2019/8/29
 */
public class ArticleAddServlet extends BaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        //处理前端请求数据
        Article article = JsonUtil.get(req,Article.class);
        try{
            conn = DBUtil.getConnection();
            String sql = "insert into article(title, content, user_id, create_time) " +
                    "select ?, ?, user.id, now() from user " +
                    "where user.name=?;";
            pre = conn.prepareStatement(sql);
            pre.setString(1, article.getTitle());
            pre.setString(2, article.getContent());
            pre.setString(3, article.getUserAccout());
            int r = pre.executeUpdate();
            if (r > 0)return r;
            else throw new BusinessException("没有该用户"+article.getUserAccout());
        }
        finally {
            DBUtil.close(conn,pre,null);
        }
    }
}
