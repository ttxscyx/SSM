package com.cyx.mybatis.test;

import com.cyx.mybatis.mapper.EmpMapper;
import com.cyx.mybatis.pojo.Emp;
import com.cyx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MBGTest {
    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
            SqlSessionFactory sqlSessionFactory = new
                    SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
        /*List<Emp> list = mapper.selectByExample(null);
        list.forEach(emp -> System.out.println(emp));*/
            //根据条件查询
        /*EmpExample example = new EmpExample();
        example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
        example.or().andDidIsNotNull();
		List<Emp> list = mapper.selectByExample(example);
        list.forEach(emp -> System.out.println(emp));*/
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"456@qq.com"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
