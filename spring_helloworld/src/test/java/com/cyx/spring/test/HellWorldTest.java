package com.cyx.spring.test;

import com.cyx.spring.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HellWorldTest {
    @Test
    public void test(){
        //获取IOC容器
        ApplicationContext ioc =new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean
        HelloWorld hellworld =(HelloWorld) ioc.getBean("hellworld");
        hellworld.sayHello();
    }
}
