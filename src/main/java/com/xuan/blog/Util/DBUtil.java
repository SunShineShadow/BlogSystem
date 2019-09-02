package com.xuan.blog.Util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.xuan.blog.exception.SystemException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hx on 2019/8/23
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/blogsystem";

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static volatile DataSource DATASOURCE;

    private DBUtil(){
    }

    public static DataSource getDataSource() {
        if (DATASOURCE == null) {
            synchronized (DBUtil.class) {
                if (DATASOURCE == null) {
                    DATASOURCE = new MysqlDataSource();
                    String username = "root";
                    String password = "root";
                    ((MysqlDataSource) DATASOURCE).setUrl(URL);
                    ((MysqlDataSource) DATASOURCE).setUser(USER_NAME);
                    ((MysqlDataSource) DATASOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATASOURCE;
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection connection, PreparedStatement
            preparedStatement, ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new SystemException("数据库错误");
        }
    }
}
