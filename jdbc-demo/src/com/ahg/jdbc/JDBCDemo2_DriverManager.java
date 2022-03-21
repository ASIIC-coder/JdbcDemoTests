package com.ahg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo2_DriverManager {

    /*
    注册驱动，获取数据库连接
     */
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取驱动
        String url = "jdbc:mysql://127.0.0.1:3306/sql_store?useSSL=false";
        String username = "root";
        String password = "<3.1415926Pai>";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.定义sql语句 set
        String sql1 = "update customers set points = 2734 where customer_id =1";
        //4.获取执行sql的对象
        Statement stmt = connection.createStatement();
        //5.执行sql
        int count = stmt.executeUpdate(sql1);

        //6.处理结果
        System.out.println(count);
        //7.释放资源
        stmt.close();
        connection.close();
    }

}
