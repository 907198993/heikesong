package com.heikesong.weishi.base;

import android.content.Context;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.CleanUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.github.baseclass.view.Loading;
import com.github.retrofitutil.NoNetworkException;
import com.heikesong.weishi.activity.LoginActivity;
import com.heikesong.weishi.view.ProgressLayout;

import java.net.ConnectException;

import in.srain.cube.views.ptr.PtrFrameLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2017/5/18.
 */

public abstract class MyCallBack<T> implements Callback<ResponseObj<T>> {

    private Context context;
    private boolean noHiddenLoad;
    private PtrFrameLayout pfl;
    private ProgressLayout progressLayout;
    public Context getContext() {
        return context;
    }
    public MyCallBack(Context ctx) {
        this.context = ctx;
    }
    public MyCallBack(Context ctx, ProgressLayout pl) {
        this.context = ctx;
        this.progressLayout=pl;
    }
    public MyCallBack(Context ctx, PtrFrameLayout pfl) {
        this.context = ctx;
        this.pfl=pfl;
    }
    public MyCallBack(Context ctx, PtrFrameLayout pfl, ProgressLayout pl) {
        this.context = ctx;
        this.pfl=pfl;
        this.progressLayout=pl;
    }
    public MyCallBack(Context ctx, ProgressLayout pl, PtrFrameLayout pfl) {
        this.context = ctx;
        this.pfl=pfl;
        this.progressLayout=pl;
    }
    public MyCallBack(Context ctx, boolean noHiddenLoad) {
        this.context = ctx;
        this.noHiddenLoad = noHiddenLoad;
    }

    public abstract void onSuccess(T obj);

    public void onError(Throwable e){
        if(pfl!=null){
            pfl.refreshComplete();
            pfl=null;
        }
        if(e instanceof  AccountException){
            if(((AccountException) e).errorCode == 1){
                ToastUtils.showLong("您的账号未登录或登录已过期，请重新登录");
                ActivityUtils.finishAllActivities();//清除所有activity
                CleanUtils.cleanInternalSp();
                ActivityUtils.startActivity(LoginActivity.class);//跳转到登陆
            }else if(((AccountException) e).errorCode == 999){//返回999 不提示

            }else if(((AccountException) e).errorCode == 2132||((AccountException) e).errorCode == 2135||((AccountException) e).errorCode == 2103||((AccountException) e).errorCode == 2102||((AccountException) e).errorCode == 2121||((AccountException) e).errorCode == 2134){
                ToastUtils.showLong(e.getMessage());
            }
        }else if(e instanceof ServerException ||e instanceof NoNetworkException){
            ToastUtils.showLong(e.getMessage());
        }else{
            ToastUtils.showShort("连接失败");
            e.printStackTrace();
        }

        if (progressLayout != null) {
            progressLayout.showErrorText();
            if(e instanceof ServerException){
                if (((ServerException) e).errorCode!=0) {
                    progressLayout.againView.setVisibility(View.INVISIBLE);
                    progressLayout.tv_load_error_msg.setText(e.getMessage());
                }
            }
            progressLayout=null;
        }
        Loading.dismissLoading();
    }

    public void onCompelte(){
        if(!noHiddenLoad){
            Loading.dismissLoading();
        }
        if(pfl!=null){
            pfl.refreshComplete();
        }
        if (progressLayout != null) {
            progressLayout.showContent();
            progressLayout=null;
        }
        this.context=null;
    }
    @Override
    public void onFailure(Call<ResponseObj<T>> call, Throwable t) {
        if(t instanceof ConnectException){
            onError(new ServerException("服务器开小差去了,请稍后再试"));
        }else{
            onError(t);
        }

    }
    @Override
    public void onResponse(Call<ResponseObj<T>> call, Response<ResponseObj<T>> response) {
        if(response.body()==null){
            if(response.code()==500){
                onError(new ServerException("服务器开小差,请稍后再试"));
            }else{
                onError(new ServerException("连接异常"));
            }
            return;
        }
        int errCode = response.body().getCode();
        if(errCode == 1){
            onError(new AccountException(errCode,response.body().getMsg()));
            return ;
        }
        if(errCode == 2129||errCode==2132){
            onError(new AccountException(errCode,response.body().getMsg()));
            return ;
        }
        if(errCode!=0){
            onError(new ServerException(errCode,response.body().getMsg()));
            return;
        }
        T res = response.body().getData();
        if(res!=null){
            Class<?> aClass = res.getClass();
            Class baseClass=BaseObj.class;
            boolean assignableFrom = baseClass.isAssignableFrom(aClass);
            if (assignableFrom) {
                ((BaseObj)res).setMsg(response.body().getMsg());

                onSuccess(res);
            }else{
                onSuccess(res);
            }
        }else{
            T result= (T) new BaseObj();
            ((BaseObj)result).setMsg(response.body().getMsg());
            onSuccess(result);
//            onError(new ServerException("暂无数据"));
        }
        onCompelte();
        res=null;
    }
}
