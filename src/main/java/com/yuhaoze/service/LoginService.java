package com.yuhaoze.service;

import com.yuhaoze.entity.Login;
import com.yuhaoze.vo.JsonData;

public interface LoginService {
    public JsonData get();
    public int addLogin(int uid);
    public int logout(int uid);
    public Login getByUid(int uid);
}
