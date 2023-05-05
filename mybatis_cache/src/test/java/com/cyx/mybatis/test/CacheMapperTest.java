package com.cyx.mybatis.test;

import com.cyx.mybatis.mapper.CacheMapper;
import com.cyx.mybatis.pojo.Emp;
import com.cyx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    /*
    * mybatis的一级缓存：
    * MyBatis的一级缓存是SqlSession级别的，即通过同一个SqlSession查询的数据会被缓存
    * 再次使用同一个SqlSession查询同一条数据，会从缓存中获取
    * 使一级缓存失效的四种情况：
    * 1. 不同SqlSession对应不同一级缓存。（即不同SqlSession，即使是相同查询条件也无用）。
    * 2. 同一个SqlSession但是查询条件不同。
    * 3. 同一个SqlSession 两次查询期间执行了任何一次针对此表增删改操作。
    * 4. 同一个SqlSession两次查询期间手动清空了缓存。sqlSession1.clearCache();
    *
    * MyBatis的二级缓存：
    * MyBatis的二级缓存是SqlSessionFactory级别的，即通过同一个SqlSessionFactory所获取的SqlSession对象
    * 查询的数据会被缓存，在通过同一个SqlSessionFactory所获取的SqlSession查询相同的数据会从缓存中获取
    * MyBatis二级缓存开启的条件：
    * a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
    * b>在映射文件中设置标签<cache/>
    * c>二级缓存必须在SqlSession关闭或提交之后有效
    * d>查询的数据所转换的实体类类型必须实现序列化的接口
    * 使二级缓存失效的情况：
    * 两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
    * 在mapper配置文件中添加的cache标签可以设置一些属性
    * 1、eviction属性：缓存回收策略，默认的是LRU
    * LRU:(Least Recently Used) -最近最少使用的：移除最长时间不被使用的对象。
    * FIFO(First in First out) -先进先出：按对象进入缓存的顺序来移除他们。
    * SOFT-软引用：移除基于垃圾回收器状态和软引用规则的对象。
    * WEAK-弱引用：更积极地移除移除基于垃圾回收器状态和软引用规则的对象。
    * 2、flushInterval属性：刷新间隔，单位毫秒
    * 默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新
    * 3、size属性：引用数目，正整数
    * 代表缓存最多可以储存多少个对象，太大容易导致内存溢出
    * 4、readOnly属性：只读：true/false
    * true：只读缓存;会给所有调用者返回缓存对象的相同实例。因此这些对象不能被修改。这提供了很重要的性能优势。
    * false：读写缓存；会返回缓存对象的拷贝(通过序列化)。这会慢一些，但是安全，因此默认是false。
    * MyBatis缓存查询的顺序：
    * 1、先查询二级缓存，因为二级缓存当中可能会有其他线程已经查询出来的数据。
    * 2、二级缓存没有命中，则再查询一级缓存。
    * 3、一级缓存也没有命中，则执行查询数据库。
    * 4、SQLSession关闭之后，一级缓存当中的数据会写入到二级缓存。
    */
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpId(1);
        System.out.println(emp1);
        sqlSession1.clearCache();
        //mapper1.insertEmp(new Emp(null,"小红",25,"女","1331515@qq.com"));
        Emp emp2 = mapper1.getEmpId(1);
        System.out.println(emp2);
        /*SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpId(1);
        System.out.println(emp3);*/
    }
    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpId(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpId(1);
        System.out.println(emp2);
        sqlSession2.close();
    }
}
