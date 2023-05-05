package com.cyx.spring.dao.impl;

import com.cyx.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功3");
    }
}