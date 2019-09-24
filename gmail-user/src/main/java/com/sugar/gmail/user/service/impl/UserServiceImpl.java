package com.sugar.gmail.user.service.impl;

import com.sugar.gmail.user.bean.UmsMember;
import com.sugar.gmail.user.mapper.UserMapper;
import com.sugar.gmail.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUser() {
        return userMapper.selectAllUser();
    }
}
