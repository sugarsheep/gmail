package com.sugar.gmail.user.controller;

import com.sugar.gmail.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index(){
        return "hello";
    }
}
