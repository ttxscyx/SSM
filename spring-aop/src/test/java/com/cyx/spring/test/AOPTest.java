package com.cyx.spring.test;

import com.cyx.spring.aop.annotation.Calculator;
import com.cyx.spring.aop.annotation.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc =new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(1,1);
    }
}
