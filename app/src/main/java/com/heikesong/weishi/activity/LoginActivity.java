package com.heikesong.weishi.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.github.baseclass.utils.ActUtils;
import com.github.rxjava.rxbus.RxUtils;
import com.google.gson.Gson;
import com.heikesong.weishi.R;
import com.heikesong.weishi.base.BaseActivity;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.autosize.internal.CustomAdapt;
import rx.Observable;
import rx.Observer;
import rx.Subscription;

/**
 * Created by administartor on 2017/9/5.
 */

public class LoginActivity extends BaseActivity implements CustomAdapt {

    @BindView(R.id.et_register_phone)
    EditText et_register_phone;

    @BindView(R.id.et_register_code)
    EditText et_register_code;

    @BindView(R.id.tv_register_getcode)
    TextView tv_register_getcode;

    @BindView(R.id.ll_wechat)
    LinearLayout llWechat;

    private int fromWechat = 0;
    private String unionid;
    private String nickname;
    private String iconurl;
    private String openid;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarColor(R.color.white)
                .fitsSystemWindows(true)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login_phone;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_register_getcode, R.id.tv_register_commit, R.id.iv_login_wechat})
    protected void onViewClick(View view) {
        switch (view.getId()) {

            case R.id.tv_register_getcode:
                if (TextUtils.isEmpty(getSStr(et_register_phone))) {
                    showMsg("手机号不能为空");
                    return;
                }
//                else if (!GetSign.isMobile(getSStr(et_register_phone))) {
//                    showMsg("请输入正确手机号");
//                    return;
//                }
                getMsgCode();
                break;
            case R.id.tv_register_commit:
                String phone = getSStr(et_register_phone);
                String code = getSStr(et_register_code);

                if (TextUtils.isEmpty(getSStr(et_register_phone))) {
                    showMsg("手机号不能为空");
                    return;
                }
//                else if (!GetSign.isMobile(getSStr(et_register_phone))) {
//                    showMsg("请输入正确手机号");
//                    return;
//                }
                else if (TextUtils.isEmpty(code)) {
                    showMsg("请输入正确验证码");
                    return;
                }
                loginPhone(phone, code);
                break;

            case R.id.iv_login_wechat://微信登陆

                break;
        }
    }


    private void loginPhone(String phone, String vcode) {
        showLoading();
        Map<String, String> map = new HashMap<String, String>();
        map.put("loginPwd", vcode);
        map.put("phone", phone);
        map.put("deviceId", DeviceUtils.getAndroidID());
//        ApiRequest.userLogin(map, new MyCallBack<UserInfoBean>(mContext) {
//            @Override
//            public void onSuccess(UserInfoBean obj) {
//                SPUtils.getInstance().put(Config.user_id, obj.getId());
//                STActivity((Class) MainActivity.class);
//                finish();
//            }
//        });
    }

    private void getMsgCode() {
        showLoading();
        Map<String, String> map = new HashMap<String, String>();
        map.put("phone",getSStr(et_register_phone));
        map.put("deviceId", DeviceUtils.getAndroidID());
        countDown();

    }

    private void countDown() {
        tv_register_getcode.setEnabled(false);
        final long count = 60;
        Subscription subscribe = Observable.interval(1, TimeUnit.SECONDS)
                .take(61)//计时次数
                .map(integer -> count - integer)
                .compose(RxUtils.appSchedulers())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        tv_register_getcode.setEnabled(true);
                        tv_register_getcode.setText("获取验证码");
                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onNext(Long aLong) {
                        tv_register_getcode.setText("剩下" + aLong + "s");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
        addSubscription(subscribe);
    }

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return 640;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.cancel();
    }
}
