package com.yuhaoze.controller;

import com.yuhaoze.dao.UserInfoDao;
import com.yuhaoze.entity.Login;
import com.yuhaoze.entity.UserInfo;
import com.yuhaoze.service.LoginService;
import com.yuhaoze.service.UserInfoService;
import com.yuhaoze.service.UserLoginService;
import com.yuhaoze.utils.MyUtils;
import com.yuhaoze.vo.JsonData;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * //
 * //                       _oo0oo_
 * //                      o8888888o
 * //                      88" . "88
 * //                      (| -_- |)
 * //                      0\  =  /0
 * //                    ___/`---'\___
 * //                  .' \\|     |// '.
 * //                 / \\|||  :  |||// \
 * //                / _||||| -:- |||||- \
 * //               |   | \\\  -  /// |   |
 * //               | \_|  ''\---/''  |_/ |
 * //               \  .-\__  '-'  ___/-. /
 * //             ___'. .'  /--.--\  `. .'___
 * //          ."" '<  `.___\_<|>_/___.' >' "".
 * //         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * //         \  \ `_.   \_ __\ /__ _/   .-` /  /
 * //     =====`-.____`.___ \_____/___.-`___.-'=====
 * //                       `=---='
 * //
 * //
 * //     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * //
 * //                佛祖保佑         永无BUG
 * //
 */
@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private LoginService loginService;
    @CrossOrigin
    @GetMapping(value = "/login", produces = "application/json; charset=utf-8")
    public JsonData login(String loginName, String password, HttpSession session){

        int i=userLoginService.login(loginName,password);
        if (i != 0){
            session.setAttribute("who","user");
            session.setAttribute("uid",i);
            loginService.addLogin(i);
            return MyUtils.getDate(1);
        }
        return MyUtils.noDate();
    }
    @PostMapping(value = "/register", produces = "application/json; charset=utf-8")
    public String register(String loginName, String password,String confirm_password){
        if (!password.equals(confirm_password)){
            return "两次密码不一致";
        }
        if(password.length()<8||password.length()>20){
            return "密码太短或太长";
        }
        if(userLoginService.verification(loginName) > 0) {
            return "账户已存在";
        }
        if(userLoginService.register(loginName,password)>0){
            System.out.println(loginName);
            return "注册成功";
        }
        return "注册失败";
    }
    @GetMapping("/verification")
    public String verification(String loginName){
        if(userLoginService.verification(loginName) > 0 || loginName.equals("") || loginName ==null) {
            return "账户已存在或不可用";
        }
        return "账号可用";
    }
    @GetMapping("/loginVer")
    public JsonData loginVer(HttpServletRequest request){
        if(MyUtils.eqUid(request.getSession(),loginService)){
            int uid = (int) request.getSession().getAttribute("uid");
            UserInfo userInfo = userInfoService.getByUid(uid);

            if (userInfo == null){
                String name = userLoginService.getLoginName(uid);
                if (name != null)
                return MyUtils.getDate(name);
                return MyUtils.noDate();
            }
            return MyUtils.getDate(userInfo.getUserName());
        }
        return MyUtils.noDate();
    }

}
