package com.cyx.spring.controller;

import com.cyx.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//@Controller("controller")

public class UserController {
@Autowired

    private UserService userService;

    /*public UserController(UserService userService) {
        this.userService = userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    public void saveUser(){

        userService.saveUser();
    }
}
