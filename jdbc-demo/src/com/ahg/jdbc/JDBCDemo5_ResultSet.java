package com.ahg.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCDemo5_ResultSet {

    /**
     * 执行DQL
     * @throws Exception
     */
    @Test
    public void testResultSet()throws Exception {
        //1.注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取驱动
        String url = "jdbc:mysql:///sql_store?useSSL=false";
        String username = "root";
        String password = "<3.1415926Pai>";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.定义sql语句 set
        String sql1 = "select * from customers";
        //4.获取执行sql的对象
        Statement stmt = connection.createStatement();
        //5.执行sql
        ResultSet resultSet = stmt.executeQuery(sql1);

        //6.处理结果,遍历Set集合中resultSet的所有数据
        while (resultSet.next()){

            int anInt = resultSet.getInt("customer_id");
            String string = resultSet.getString("first_name");
            String string1 = resultSet.getString("last_name");
            Date date = resultSet.getDate("birth_date");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            int points = resultSet.getInt("points");

            System.out.println(anInt);
            System.out.println(string);
            System.out.println(string1);
            System.out.println(date);
            System.out.println(phone);
            System.out.println(address);
            System.out.println(city);
            System.out.println(state);
            System.out.println(points);

        }
        //7.释放资源
        stmt.close();
        connection.close();
    }
}
