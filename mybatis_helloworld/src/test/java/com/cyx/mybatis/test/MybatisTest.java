package com.cyx.mybatis.test;

import com.cyx.mybatis.mapper.UserMapper;

import com.cyx.mybatis.pojo.User;
import com.cyx.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        //获取sql的会话对象SqlSession(不会自动提交事务)，是MyBatis提供的操作数据库对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取sql的会话对象SqlSession(会自动提交事务)，是MyBatis提供的操作数据库对象
        //获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();
        System.out.println("结果：" + result);
//        //提交事务
//       sqlSession.commit();
        //关闭SqlSession
        //sqlSession.close();
    }
    @Test
    public void testGetAllUser() throws  IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
         mapper.updateUser();
        // mapper.deleteUser();
        //User user=  mapper.getUserById();
        //System.out.println(user);
        //List<User> list =mapper.getAllUser();
        //list.forEach(user -> System.out.println(user));
        //list.forEach(System.out::println);

    }
    @Test
    public void testGetUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //int user = mapper.insertUser();
        //mapper.updateUser();
        //mapper.deleteUser();
        // User user = mapper.getUserById();
        // System.out.println(user);
        List<User> user = mapper.getAllUser();
        user.forEach(System.out::println);
    }
}
