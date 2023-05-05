package com.cyx.spring.test;

import com.cyx.spring.aop.xml.Calculator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPXmlTest {

    @Test
    public void testAOPByXML(){

        ApplicationContext ioc=new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1,1);
    }

}
