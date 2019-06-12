package com.yuhaoze.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

@TableName("t_login")

public class Login extends BaseEntity {
    @TableId(value = "loginID",type= IdType.ID_WORKER)
    private int loginID;

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }

    public void setLoseDate(Date loseDate) {
        this.loseDate = loseDate;
    }

    public int getLoginID() {
        return loginID;
    }

    public int getUserID() {
        return userID;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public int getIsLogin() {
        return isLogin;
    }

    public Date getLoseDate() {
        return loseDate;
    }

    @TableField("userID")
    private int userID;
    @TableField("loginDate")
    private Date loginDate;
    @TableField("isLogin")
    private int isLogin;
    @TableField("loseDate")
    private Date loseDate;

//    @Override
//    protected Serializable pkVal() {
//        return this.loginID;
//    }
}
