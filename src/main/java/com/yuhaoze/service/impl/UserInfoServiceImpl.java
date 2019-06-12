package com.yuhaoze.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuhaoze.dao.UserInfoDao;
import com.yuhaoze.entity.UserInfo;
import com.yuhaoze.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo getByUid(int uid) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId",uid);
        return userInfoDao.selectOne(queryWrapper);
    }

    @Override
    public int updateOrInsert(int sex, String name, Date birthday, int uid) {
        UserInfo userInfo =new UserInfo();
        userInfo.setUserName(name);
        userInfo.setUserSex(sex);
        userInfo.setUserBrithday(birthday);
        userInfo.setUserId(uid);
        if(getByUid(uid) != null){
            QueryWrapper<UserInfo> queryWrapper =new QueryWrapper<>();
            queryWrapper.eq("userId",uid);
            return userInfoDao.update(userInfo,queryWrapper);

        }


        return userInfoDao.insert(userInfo);
    }
}
