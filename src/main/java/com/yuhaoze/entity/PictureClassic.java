package com.yuhaoze.entity;

import java.io.Serializable;

public class PictureClassic implements Serializable {
    private Integer picClassicId;

    private String picClassicName;

    public Integer getPicClassicId() {
        return picClassicId;
    }

    public void setPicClassicId(Integer picClassicId) {
        this.picClassicId = picClassicId;
    }

    public String getPicClassicName() {
        return picClassicName;
    }

    public void setPicClassicName(String picClassicName) {
        this.picClassicName = picClassicName == null ? null : picClassicName.trim();
    }
}