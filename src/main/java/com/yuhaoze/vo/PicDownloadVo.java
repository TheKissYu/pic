package com.yuhaoze.vo;

import java.util.Date;

public class PicDownloadVo {
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

    private int downloadCounts;

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public void setDownloadCounts(int downloadCounts) {
        this.downloadCounts = downloadCounts;
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

    public int getDownloadCounts() {
        return downloadCounts;
    }

    public String getPictureName() {
        return pictureName;
    }

    private String pictureName;
}
