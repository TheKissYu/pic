package com.yuhaoze.vo;

public class PageVo {
    private int code;
    private String msg;
    private long count;
    private Object data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public long getCount() {
        return count;
    }

    public Object getData() {
        return data;
    }
}
