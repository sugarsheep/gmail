package com.sugar.gmail.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sugar.gmail.common.util.ResponseBean;
import com.sugar.gmail.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/getAllUser")
    public ResponseBean getAllUser() {
        return new ResponseBean().success(userService.getAllUser(), "success");
    }

    @GetMapping("/getUserById")
    public ResponseBean getUserById(Long userId) {
        return new ResponseBean().success(userService.getUserById(userId), "success");
    }

    @GetMapping("/getUserAddressByUserId")
    public ResponseBean getUserAddressByUserId(String userId) {
        return new ResponseBean().success(userService.getUserAddressByUserId(userId), "success");
    }

}
