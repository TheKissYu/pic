package com.yuhaoze.service;

public interface UserLoginService {
    int login(String loginName, String password);

    int register(String loginName, String password);

    int verification(String loginName);

    String getLoginName(int uid);
}
