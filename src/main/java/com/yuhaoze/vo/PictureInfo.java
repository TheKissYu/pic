package com.yuhaoze.vo;

import java.util.Date;

public class PictureInfo {
    private Integer pictureid;

    private Integer userid;

    private Date creatTime;

    private Integer pictureStatus;

    private String picturePath;

    private Integer pictureClassicId;

    private String pictureName;

    public void setPictureDownladCount(Integer pictureDownladCount) {
        this.pictureDownladCount = pictureDownladCount;
    }

    public Integer getPictureDownladCount() {
        return pictureDownladCount;
    }

    private Integer pictureDownladCount;
    private String pictureClassicName;

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public void setPictureStatus(Integer pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public void setPictureClassicId(Integer pictureClassicId) {
        this.pictureClassicId = pictureClassicId;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public void setPictureClassicName(String pictureClassicName) {
        this.pictureClassicName = pictureClassicName;
    }

    public Integer getPictureid() {
        return pictureid;
    }

    public Integer getUserid() {
        return userid;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public Integer getPictureStatus() {
        return pictureStatus;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public Integer getPictureClassicId() {
        return pictureClassicId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public String getPictureClassicName() {
        return pictureClassicName;
    }
}
