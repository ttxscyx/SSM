package com.cyx.proxy;

import com.cyx.spring.proxy.Calculator;
import com.cyx.spring.proxy.CalculatorImpl;
import com.cyx.spring.proxy.CalculatorStaticProxy;
import com.cyx.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void testProxy(){
        /*CalculatorStaticProxy proxy =new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);*/
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)factory.getProxy();
        proxy.add(1,0);
        //proxy.div(1,0);
    }
}
