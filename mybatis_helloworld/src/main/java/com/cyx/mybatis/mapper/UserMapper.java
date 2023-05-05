package com.cyx.mybatis.mapper;

import com.cyx.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    //添加功能
    int insertUser();
    //修改功能
    void updateUser();
    //删除功能
    int deleteUser();
    //根据id查询用户信息
    User getUserById();
    //查询所有的用户信息
    List<User> getAllUser();
}
