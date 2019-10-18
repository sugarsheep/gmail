package com.sugar.gmail.service;


import com.sugar.gmail.bean.UmsMember;
import com.sugar.gmail.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getUserAddressByUserId(String userId);

    UmsMember getUserById(Long userId);
}
