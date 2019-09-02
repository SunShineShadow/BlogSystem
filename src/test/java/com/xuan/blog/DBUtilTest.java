package com.xuan.blog;

import com.xuan.blog.Util.DBUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by hx on 2019/8/23
 */
public class DBUtilTest {

    @Test
    public void testConnection(){
        Connection connection = DBUtil.getConnection();
//        System.out.println(connection);
        Assert.assertNotNull(connection);
    }
    @Test
    public void test(){
        System.out.println(new Integer[]{});
        System.out.println(new String[]{});
    }
}
