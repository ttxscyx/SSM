package com.cyx.spring.factory;

import com.cyx.spring.User;
import org.springframework.beans.factory.FactoryBean;
/*
 * FactoryBean是一个接口，需要创建一个类实现该接口
 * 其中有三个方法：
 * getObject():通过一个对象交给IOC容器管理
 * getObjectType():设置所提供对象的类型
 * isSingleton():所提供的对象是否单例
 * 当把FactoryBean的实现类配置为bean时，会将当前类中getObject()所返回的对象交给IOC容器管理
 * */
public class UserFactoryBean implements FactoryBean<User> {
@Override
    public User getObject() throws Exception {
        return new User(null,"123","123",1);
}
@Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
