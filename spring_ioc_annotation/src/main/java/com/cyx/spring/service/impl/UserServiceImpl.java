package com.cyx.spring.service.impl;

import com.cyx.spring.dao.UserDao;
import com.cyx.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserDao userDao;
    @Override
    public void saveUser(){

        userDao.saveUser();
    }
}
