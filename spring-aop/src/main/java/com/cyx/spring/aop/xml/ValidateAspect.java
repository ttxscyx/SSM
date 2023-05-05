package com.cyx.spring.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ValidateAspect {

    /*@Before("execution(* com.cyx.spring.aop.annotation.CalculatorImpl.*(..))")*/

    public void beforeMethod(){
        System.out.println("ValidateAspect- ->前置通知");
    }

}
