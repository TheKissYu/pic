package com.yuhaoze.vo;

import java.util.Date;

public class PicStVo {
    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public void setDownloadCounts(int downloadCounts) {
        this.downloadCounts = downloadCounts;
    }

    public void setPicStatus(int picStatus) {
        this.picStatus = picStatus;
    }

    public Integer getPictureid() {
        return pictureid;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public int getDownloadCounts() {
        return downloadCounts;
    }

    public int getPicStatus() {
        return picStatus;
    }

    private Integer pictureid;

    private Date creatTime;

    private String pictureName;

    private int downloadCounts;

    private String picPath;

    public int getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    private int cId;
    private String cName;


    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureName() {
        return pictureName;
    }

    private int picStatus;
}
