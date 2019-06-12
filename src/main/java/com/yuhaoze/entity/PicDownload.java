package com.yuhaoze.entity;

import java.io.Serializable;

public class PicDownload implements Serializable {
    private Integer downloadid;

    private Integer userid;

    private Integer pcitureid;

    public Integer getDownloadid() {
        return downloadid;
    }

    public void setDownloadid(Integer downloadid) {
        this.downloadid = downloadid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPcitureid() {
        return pcitureid;
    }

    public void setPcitureid(Integer pcitureid) {
        this.pcitureid = pcitureid;
    }
}