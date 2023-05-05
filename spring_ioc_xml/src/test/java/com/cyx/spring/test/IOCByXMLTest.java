package com.cyx.spring.test;

import com.cyx.spring.Person;
import com.cyx.spring.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    /*
    * 获取bean的三种方式：
    * 1、根据bean的id获取
    * 2、根据bean的类型获取,
    * 注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
    * 若没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
    * 若有多个类型匹配的bean，此时抛出异常：NoUniqueBeanDefinitionException
    * 3、根据bean的id和类型获取
    * */
    @Test
    public void testDI(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student student = ioc.getBean("studentTwo", Student.class);
        System.out.println(student);
    }
    @Test
    public void testDIBySetFour(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student student = ioc.getBean("studentFour", Student.class);
        System.out.println(student);
    }
    @Test
    public void testDIBySetFive(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student student = ioc.getBean("studentFive", Student.class);
        System.out.println(student);
        /*Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(clazz);*/
    }
    @Test
    public void testDIBySet(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student student = ioc.getBean("studentThree", Student.class);
        System.out.println(student);
    }
@Test
    public void testIOC(){
    //获取IOC容器
    ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
    //获取bean
    //Student studentOne = (Student) ioc.getBean("studentOne");
    //Student student = ioc.getBean(Student.class);
    //System.out.println(student);
    //Student student = ioc.getBean("studentOne", Student.class);
    Person person=ioc.getBean(Person.class);
    System.out.println(person);
}
    @Test
    public void testDIBySetSix(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student student = ioc.getBean("studentSix", Student.class);
        System.out.println(student);
        /*Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(clazz);*/
    }
}
