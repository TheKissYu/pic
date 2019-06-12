package com.yuhaoze.service;

import com.yuhaoze.entity.UserInfo;

import java.util.Date;

public interface UserInfoService {
    UserInfo getByUid(int uid);
    int updateOrInsert(int sex, String name, Date birthday, int uid);
}
