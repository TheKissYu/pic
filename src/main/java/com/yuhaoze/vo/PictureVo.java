package com.yuhaoze.vo;

import java.util.Date;

public class PictureVo {
    private Integer pictureid;


    private String userName;

    private Date creatTime;

    private String picPath;

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getPicPath() {
        return picPath;
    }

    private String pictureName;

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public Integer getPictureid() {
        return pictureid;
    }

    public String getUserName() {
        return userName;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public String getPictureName() {
        return pictureName;
    }
}
