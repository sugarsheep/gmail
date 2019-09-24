package com.sugar.gmail.user.service;

import com.sugar.gmail.user.bean.UmsMember;
import com.sugar.gmail.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getUserAddressByUserId(String userId);

    UmsMember getUserById(Long userId);
}
