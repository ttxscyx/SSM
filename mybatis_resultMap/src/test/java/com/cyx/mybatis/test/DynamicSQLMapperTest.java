package com.cyx.mybatis.test;

import com.cyx.mybatis.mapper.DynamicSQLMapper;
import com.cyx.mybatis.pojo.Emp;
import com.cyx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {
    /*
    * 动态SQL：
    * 1、if:根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
    * 2、where：
    * 当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
    * 当where标签中没有内容时，此时where标签没有任何效果
    * 注意：where标签不能将其中内容后面多余的and或or去掉
    * 3、trim：
    * 若标签中有内容时：
    * prefix/suffix：将trim标签中内容前面或后面添加指定内容
    *suffixOverrides/prefixOverrides：将trim标签中内容前面或后面去掉指定内容
    * 若标签中没有内容时，trim标签也没有任何效果
    * 4、choose、when、otherwise，相当于if...else if...else
    * when至少要有一个，otherwise最多只能有一个
    * 5、foreach
    * collection:设置要循环的数组或集合
    * item：用一个字符串表示数组或集合中的每一个数据
    * separator：设置每次循环的数据之间的分隔符
    * open：循环的所有内容以什么开始
    * close：循环的所有内容以什么结束
    * 6、sql片段
    * 可以记录一段sql，在需要用的地方使用include标签进行引用
    *设置：<sql id="empColumns">
        emp_id,emp_name,age,gender,dept_id,email
    </sql>
    * 引用：<include refid="empColumns"></include>
    * */
    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emp = mapper.getEmpByChoose(new Emp(null, "", null, "", ""));
        System.out.println(emp);
    }

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emp = mapper.getEmpBycondition(new Emp(null, "", 20, null,""));
        emp.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp =new Emp(null, "小马1", 23, "女","165516@qq.com");
        Emp emp1 =new Emp(null, "小马2", 23, "女","165516@qq.com");
        Emp emp2 =new Emp(null, "小马3", 23, "女","165516@qq.com");
        List<Emp> list = Arrays.asList(emp, emp1, emp2);
        mapper.insertMoreEmp(list);
    }
    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{16,17};
        mapper.deletMoreEmp(empIds);
    }
}
