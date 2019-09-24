package com.sugar.gmail.user.controller;

import com.sugar.gmail.user.bean.UmsMember;
import com.sugar.gmail.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getAllUser")
    public List<UmsMember > getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("index")
    public String index(){
        return "hello";
    }
}
