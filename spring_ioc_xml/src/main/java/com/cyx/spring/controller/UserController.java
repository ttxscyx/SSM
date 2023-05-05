package com.cyx.spring.controller;

import com.cyx.spring.service.UserService;

public class UserController {


    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void saveUser(){
        System.out.println("保存成功1");
        userService.saveUser();
    }
}
