package com.heikesong.weishi.base;

/**
 * Created by Administrator on 2017/6/28.
 */

public class ResponseObj<T> {

    /**
     * ErrCode : 0
     * ErrMsg : 注册成功，欢迎成为本站会员！
     * Response : {"avatar":"http://yinya.hai-tao.net","mobile":"15601772922","nick_name":"156***2922","sex":"保密","user_name":"15601772922","user_id":"1117"}
     */

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess(){
        if(getCode()==0){
            return true;
        }
        return false;
    }
}
