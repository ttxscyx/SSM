package com.cyx.mybatis.test;

import com.cyx.mybatis.mapper.SelectMapper;
import com.cyx.mybatis.pojo.User;
import com.cyx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    /*
    * 若sql语句查询的结果为多条时，一定不能以实体类类型作为方法的返回值，
    * 否则会抛出异常TooManyResultsException
    * 若sql语句查询的结果为一条时，此时可以用实体类类型或list集合类型作为方法的返回值
    * */
    @Test
    public void  testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(4);
        System.out.println(user);

    }
    @Test
    public void  testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);

    }
    @Test
    public void  testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);

    }
    @Test
    public void  testGetUserByIdtoMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdtoMap(4);
        //{password=123456, gender=男, id=4, age=18, email=12345@qq.com, username=admin}
        System.out.println(map);
    }
    @Test
    public void  testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
      /*  List<Map<String,Object>> list = mapper.getAllUserToMap();
        System.out.println(list);*/
      Map<String,Object> map =mapper.getAllUserToMap();
      System.out.println(map);
    }
}
