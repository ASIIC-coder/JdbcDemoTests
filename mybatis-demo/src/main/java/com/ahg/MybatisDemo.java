package com.ahg;

import com.ahg.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

/*
Mybatis快速入门
 */
public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession的对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行SQL
        List<User> users = sqlSession.selectList("test.selectAll");

        System.out.println(users);

        //4.释放资源
        sqlSession.close();
    }
}
