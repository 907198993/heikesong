package com.heikesong.weishi.base;

/**
 * Created by Administrator on 2017/7/20.
 */

public class AccountException extends Exception {
    //errorCode不为0时为服务器返回错误信息，需要显示在页面上面，
    public int errorCode;
    public AccountException(String msg) {
        super(msg);
    }
    public AccountException(int errorCode, String msg) {
        super(msg);
        this.errorCode=errorCode;
    }

}
