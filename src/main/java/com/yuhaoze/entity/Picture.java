package com.yuhaoze.entity;

import java.io.Serializable;
import java.util.Date;

public class Picture implements Serializable {
    private Integer pictureid;

    private Integer userid;

    private Date creatTime;

    private Integer pictureStatus;

    private String picturePath;

    private Integer pictureClassicId;

    private String pictureName;

    private Integer pictureDownladCount;

    public Integer getPictureid() {
        return pictureid;
    }

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(Integer pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    public Integer getPictureClassicId() {
        return pictureClassicId;
    }

    public void setPictureClassicId(Integer pictureClassicId) {
        this.pictureClassicId = pictureClassicId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public Integer getPictureDownladCount() {
        return pictureDownladCount;
    }

    public void setPictureDownladCount(Integer pictureDownladCount) {
        this.pictureDownladCount = pictureDownladCount;
    }
}