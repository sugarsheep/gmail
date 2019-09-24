package com.sugar.gmail.user.service.impl;

import com.sugar.gmail.user.bean.UmsMember;
import com.sugar.gmail.user.bean.UmsMemberReceiveAddress;
import com.sugar.gmail.user.mapper.UmsMemberReceiveAddressMapper;
import com.sugar.gmail.user.mapper.UserMapper;
import com.sugar.gmail.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        umsMemberReceiveAddress.setMemberId(Long.valueOf(userId));
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
