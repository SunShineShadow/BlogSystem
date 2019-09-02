package com.xuan.blog.servlet;

import com.mysql.jdbc.PacketTooBigException;
import com.xuan.blog.Util.DBUtil;
import com.xuan.blog.Util.JsonUtil;
import com.xuan.blog.entity.Article;
import com.xuan.blog.exception.ParameterException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hx on 2019/8/23
 */
public class ArticleListServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String sid = req.getParameter("id");
        try{
            Integer id = Integer.parseInt(sid);
        }catch (Exception e){
            throw new ParameterException("id错误："+sid);
        }
        Connection connection = DBUtil.getConnection();
        List<Article> articleList = new ArrayList<>();
        String sql = "select a.id,a.title,a.content,a.create_time " +
                "from article a join user u on a.user_id = u.id where u.id = ?;";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setInt(1, Integer.parseInt(req.getParameter("id")));
        ResultSet rs = pre.executeQuery();
        try{
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setCreateTime(rs.getTime("create_time"));
                articleList.add(article);
            }
            System.out.println(articleList);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,pre,rs);
        }
        return articleList;
    }
}
