package com.sugar.gmail.user.mapper;

import com.sugar.gmail.user.bean.UmsMember;

import java.util.List;

public interface UserMapper {
    List<UmsMember> selectAllUser();
}
