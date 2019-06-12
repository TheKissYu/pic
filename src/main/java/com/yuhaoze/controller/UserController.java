package com.yuhaoze.controller;

import com.yuhaoze.entity.UserInfo;
import com.yuhaoze.service.LoginService;
import com.yuhaoze.service.UserInfoService;
import com.yuhaoze.utils.MyUtils;
import com.yuhaoze.vo.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/userlogin")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LoginService loginService;
    @GetMapping("/get")
    public JsonData get(){
        return loginService.get();
    }

    @GetMapping("/logout")
    public  JsonData loginout(HttpSession session){
        Object o = session.getAttribute("uid");
        if (o!=null&!o.equals("")){
            int uid = (int)o;
            return MyUtils.setAll(loginService.logout(uid),null);
        }

        return MyUtils.setAll(0,null);
    }
    @GetMapping("/getUserInfo")
    public  JsonData getUserInfo(HttpSession session){
        try{
            int uid = (int) session.getAttribute("uid");
            UserInfo userInfo = userInfoService.getByUid(uid);
            if(userInfo == null){
                return MyUtils.noDate();
            }else {
                return MyUtils.getDate(userInfo);
            }
        }catch (Exception e){
            return MyUtils.setAll(0,e.getMessage());
        }
    }
    @PostMapping("/updateUserInfo")
    public int updateUserInfo(HttpSession session, String name, int sex, Date birthday ){

        try {
            int uid = (int) session.getAttribute("uid");
            return userInfoService.updateOrInsert(sex,name,birthday,uid);
        }catch (Exception e){
            return -1;
        }
    }
}
