package com.yuhaoze.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("user_info")
public class UserInfo extends BaseEntity{
    @TableId(value = "user_infoID",type= IdType.ID_WORKER)
    private int userInfoID;
    @TableField("userId")
    private int userId;
    private int userSex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userBrithday;
    @TableField("userName")
    private String userName;

    public void setUserInfoID(int userInfoID) {
        this.userInfoID = userInfoID;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserInfoID() {
        return userInfoID;
    }

    public int getUserId() {
        return userId;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserBrithday(Date userBrithday) {
        this.userBrithday = userBrithday;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getUserBrithday() {
        return userBrithday;
    }

    public String getUserName() {
        return userName;
    }
}
