package com.yuhaoze.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuhaoze.dao.LoginDao;
import com.yuhaoze.entity.Login;
import com.yuhaoze.service.LoginService;
import com.yuhaoze.utils.MyUtils;
import com.yuhaoze.vo.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public JsonData get() {
        QueryWrapper<Login> queryWrapper = new QueryWrapper<>();
        List<Login> list = loginDao.selectList(queryWrapper);
        return MyUtils.getDate(list);
    }

    @Override
    public int addLogin(int uid) {


        Login login = new Login();
        login.setUserID(uid);
        Date date =new Date();
        login.setLoseDate(date);
        login.setIsLogin(0);
        QueryWrapper<Login> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userID",uid);
        queryWrapper.eq("isLogin",1);
        loginDao.update(login,queryWrapper);

        login.setLoginDate(new Date());
        login.setLoseDate(null);
        login.setIsLogin(1);
        return loginDao.insert(login);
    }

    @Override
    public int logout(int uid) {
        Login login = new Login();
        login.setUserID(uid);
        Date date =new Date();
        login.setLoseDate(date);
        login.setIsLogin(0);
        QueryWrapper<Login> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userID",uid);
        queryWrapper.eq("isLogin",1);

        return  loginDao.update(login,queryWrapper);
    }

    @Override
    public Login getByUid(int uid) {
        QueryWrapper<Login> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userID",uid);
        queryWrapper.eq("isLogin",1);
        Login login = loginDao.selectOne(queryWrapper);
        return login;
    }
}
