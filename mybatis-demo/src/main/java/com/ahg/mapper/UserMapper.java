package com.ahg.mapper;

import com.ahg.pojo.User;

import java.util.List;

public interface UserMapper {

    //3 第三步在Mapper接口中定义一个方法，方法名SQL映射文件中sql语句的id-->  <select id="selectAll"
    //定义一个list对象是为了返回多个User对象
    List<User> selectAll();

    User selectById(int id);

    
}
