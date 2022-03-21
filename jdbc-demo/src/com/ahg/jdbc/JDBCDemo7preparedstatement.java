package com.ahg.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * SQL注入
 */
public class JDBCDemo7preparedstatement {

    @Test
    public void testResultSet() throws Exception {

        String url = "jdbc:mysql:///sql_hr?useSSL=false";
        String username = "root";
        String password = "<3.1415926Pai>";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.定义sql语句 ：接受用户输入 用户名 和密码
        String name = "zhangsan";
        String pwd = "123";

        String sql1 = "select * from tb_user where username = ? and password = ?";
//        String sql2 = "select * from ";
        //4.获取pstmt的对象
        PreparedStatement pstmt = connection.prepareStatement(sql1);
        //设置?的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //执行,需要使用无参的executeQuery
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        //7.释放资源
        rs.close();
        pstmt.close();
        connection.close();
    }

}


