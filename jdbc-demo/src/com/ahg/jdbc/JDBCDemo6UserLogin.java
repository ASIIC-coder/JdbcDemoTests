package com.ahg.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * SQL注入
 */
public class JDBCDemo6UserLogin {

    @Test
    public void testResultSet() throws Exception {

        String url = "jdbc:mysql:///sql_hr?useSSL=false";
        String username = "root";
        String password = "<3.1415926Pai>";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.定义sql语句 ：接受用户输入 用户名 和密码
        String name = "zhangsan";
        String pwd = "123";

        String sql1 = "select * from tb_user where username = '" + name + "' and password = '" + pwd + "'";
//        String sql2 = "select * from ";
        //4.获取执行sql的对象
        Statement stmt = connection.createStatement();
        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql1);

        //6.判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }


        //7.释放资源
        rs.close();
        stmt.close();
        connection.close();
    }

}


