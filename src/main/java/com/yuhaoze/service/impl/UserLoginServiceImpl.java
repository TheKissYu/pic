package com.yuhaoze.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuhaoze.dao.UserInfoDao;
import com.yuhaoze.dao.UserLoginMapper;
import com.yuhaoze.entity.UserInfo;
import com.yuhaoze.entity.UserLogin;
import com.yuhaoze.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserLoginMapper userLoginMapper;
    @Override
    public int login(String loginName, String password) {
        UserLogin userLogin = userLoginMapper.UserLoginMapper(loginName);
        if(userLogin != null){
            if (userLogin.getUserPassword().equals(password)){
                System.out.println(userLogin.getUserid());
                return userLogin.getUserid();
            }

        }
        return 0;
    }

    @Override
    public int register(String loginName, String password) {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserLoginName(loginName);
        userLogin.setUserPassword(password);
        return userLoginMapper.insertSelective(userLogin);
    }

    @Override
    public int verification(String loginName) {
        if(userLoginMapper.UserLoginMapper(loginName) != null)
        return 1;
        return 0;
    }

    @Override
    public String getLoginName(int uid) {
       UserLogin user = userLoginMapper.selectByPrimaryKey(uid);
        return user.getUserLoginName();
    }

}
