package com.cyx.spring.service.impl;

import com.cyx.spring.dao.UserDao;
import com.cyx.spring.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void saveUser() {
        System.out.println("保存成功2");
        userDao.saveUser();
    }
}