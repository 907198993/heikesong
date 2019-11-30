package com.heikesong.weishi.base;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/20.
 */

public class BaseObj implements Serializable {
    private String msg;

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



}
