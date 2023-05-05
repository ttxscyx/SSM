package com.cyx.mybatis.test;

import com.cyx.mybatis.mapper.UserMapper;
import com.cyx.mybatis.pojo.User;
import com.cyx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {

    @Test
    public  void  testGetUserByUsername(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("add");
        System.out.println(user);
    }
    @Test
    public  void  testCheckLogin(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);
    }

    @Test
    public  void  testCheckLoginByMap(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map =new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public  void  testInsertUser(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        User user= new  User(null,"root","12345",33,"女","1241@qq.com");
        mapper.insertUser(user);

    }
    @Test
    public  void  testCheckLoginByParam(){

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByparam("admin", "123456");
        System.out.println(user);
    }
}
