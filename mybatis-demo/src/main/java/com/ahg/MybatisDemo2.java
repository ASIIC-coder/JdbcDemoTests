package com.ahg;

import com.ahg.mapper.UserMapper;
import com.ahg.pojo.User;
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
public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlSession的对象
        SqlSession sqlSession = sqlSessionFactory.openSession();


        //3.执行SQL
//        List<User> users = sqlSession.selectList("test.selectAll");
//        System.out.println(users);

        //3.1 获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.selectAll();
        System.out.println(users);
        //关闭资源
        sqlSession.close();
    }
}
