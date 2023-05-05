package com.cyx.spring.dao.impl;

import com.cyx.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser(){
        System.out.println("保存成功");
    }
}
