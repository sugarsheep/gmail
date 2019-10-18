package com.sugar.gmail.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sugar.gmail.bean.UmsMember;
import com.sugar.gmail.bean.UmsMemberReceiveAddress;
import com.sugar.gmail.service.UserService;
import com.sugar.gmail.user.mapper.UmsMemberReceiveAddressMapper;
import com.sugar.gmail.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public List<UmsMemberReceiveAddress> getUserAddressByUserId(String userId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(userId);
        return umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);

//        Example example = new Example(UmsMemberReceiveAddress.class);
//        example.createCriteria().andEqualTo("memberId",userId);
//        return umsMemberReceiveAddressMapper.selectByExample(example);

    }

    @Override
    public UmsMember getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
