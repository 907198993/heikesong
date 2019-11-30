package com.heikesong.weishi;


import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.aspsine.multithreaddownload.DownloadConfiguration;
import com.aspsine.multithreaddownload.DownloadManager;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.request.target.ViewTarget;
import com.github.retrofitutil.NetWorkManager;
import com.heikesong.weishi.constants.Config;
import com.heikesong.weishi.constants.Constant;
import com.heikesong.weishi.view.ImageLoader;
import com.previewlibrary.ZoomMediaLoader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by administartor on 2017/8/8.
 */

public class MyApplication extends MultiDexApplication {
    private final static String PROCESS_NAME = "com.test";
    private  static final String TAG = MyApplication.class.getName();
    private  static MyApplication myApplication;
    private static Context mContext;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    @SuppressLint("MissingPermission")
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        mContext = getApplicationContext();
        Utils.init(myApplication);
//      LeakCanary.install(myApplication);


//        ViewPump.init(ViewPump.builder()
//                .addInterceptor(new CalligraphyInterceptor(
//                        new CalligraphyConfig.Builder()
//                                .setDefaultFontPath("fonts/SourceHanSansCN-Normal.otf")
//                                .setFontAttrId(R.attr.fontPath)
//                                .build()))
//                .build());

        ViewTarget.setTagId(R.id.glide_tag);//gilde bug

        ZoomMediaLoader.getInstance().init(new ImageLoader());
        //配置数据库
//        setupDatabase();
//        if(true&&BuildConfig.DEBUG){                           //http://192.168.1.38:8080/        //http://121.40.186.118:5108
        //   NetWorkManager.getInstance(getApplicationContext(),"http://121.40.186.118:5108",BuildConfig.DEBUG).complete();
//        NetWorkManager.getInstance(getApplicationContext(),"http://www.wanandroid.com/tools/mockapi/12410/",BuildConfig.DEBUG).complete();
         NetWorkManager.getInstance(getApplicationContext(), Constant.URL,true).complete();
//        }else{
//          //  NetWorkManager.getInstance(getApplicationContext(),"http://121.40.186.118:5008",BuildConfig.DEBUG).complete();
//            NetWorkManager.getInstance(getApplicationContext(),"http://1v8z769925.51mypc.cn:8081/outer/",false).complete();
//        }
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
//        SDKInitializer.initialize(this);
//        if(true&&BuildConfig.DEBUG){                           //http://192.168.0.19:20001/        //http://121.40.186.118:5108
//            NetWorkManager.getInstance(getApplicationContext(),"http://121.40.186.118:5108",BuildConfig.DEBUG).complete();
//
//           // NetWorkManager.getInstance(getApplicationContext(),"http://192.168.0.19:20001",BuildConfig.DEBUG).complete();
//        }else{
//           NetWorkManager.getInstance(getApplicationContext(),"http://121.40.186.118:5008",BuildConfig.DEBUG).complete();
////            NetWorkManager.getInstance(getApplicationContext(),"http://192.168.0.19:20001",BuildConfig.DEBUG).complete();
//        }
//        MobPush.setAlias("test");//设置别名
//        MobPush.addTags(java.lang.String[] tags);//设置标签
        initUmeng();
        initPush();
        initDownloader();
    }

    private void initUmeng() {
//        //初始化组件化基础库, 统计SDK/推送SDK/分享SDK都必须调用此初始化接口
//        UMConfigure.init(this,"5bc456cbb465f56fd9000083"
//                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"9c553f38d835638922e6bdc22d34d001");
//        // 选用LEGACY_AUTO页面采集模式
//        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_MANUAL);
//        // 支持在子进程中统计自定义事件
//        UMConfigure.setProcessEvent(true);
////        // 打开统计SDK调试模式
//        UMConfigure.setLogEnabled(false);
//        PlatformConfig.setWeixin(Config.weixing_id, Config.weixing_secret);
//        PlatformConfig.setQQZone(Config.qq_id, Config.qq_key);
//        //获取消息推送代理示例
//        PushAgent mPushAgent = PushAgent.getInstance(this);
//        //注册推送服务，每次调用register方法都会回调该接口
//        mPushAgent.register(new IUmengRegisterCallback() {
//            @Override
//            public void onSuccess(String deviceToken) {
//                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
//                Log.i(TAG,"注册成功：deviceToken：-------->  " + deviceToken);
//            }
//            @Override
//            public void onFailure(String s, String s1) {
//                Log.e(TAG,"注册失败：-------->  " + "s:" + s + ",s1:" + s1);
//            }
//        });
    }
    //初始化推送
    private void initPush() {

//        PushAgent.getInstance(this).register(new IUmengRegisterCallback(){
//
//            @Override
//            public void onSuccess(String s) {
//                Log.i("walle", "--->>> onSuccess, s is " + s);
//            }
//
//            @Override
//            public void onFailure(String s, String s1) {
//                Log.i("walle", "--->>> onFailure, s is " + s + ", s1 is " + s1);
//            }
//        });
//        MiPushRegistar.register(this, "2882303761517999094", "5261799935094");
//        HuaWeiRegister.register(this);
//        //OPPO通道，参数1为app key，参数2为app secret
//        OppoRegister.register(this, "e2419144278d4c36b2cd5d0af36ae748", "90469beb36c346439a3268e5c39897d9");
//        //vivo 通道
//        VivoRegister.register(this);
//        String userId =  SPUtils.getInstance().getString(Config.user_id);
//        if(!userId.equals("")){
//            PushAgent.getInstance(this).setAlias(userId, "宠行僧", new UTrack.ICallBack() {
//                @Override
//                public void onMessage(boolean isSuccess, String message) {
//                    Log.i("Alias", message);
//                    Map<String, String> map = new HashMap<String, String>();
//                    map.put("userId", userId);
//                    map.put("phoneType","2");
//                    com.petzm.training.module.home.network.ApiRequest.bindDevice(map, new MyCallBack<Object>(mContext) {
//                        @Override
//                        public void onSuccess(Object s) {
//                        }
//                    });
//                }
//            });
//        }
//
//
//        //自定义通知栏打开动作
//        UmengNotificationClickHandler notificationClickHandler =new UmengNotificationClickHandler() {
//            @Override
//            public void launchApp(Context context, UMessage msg) {
//                super.launchApp(context, msg);
//                Toast.makeText(context, "launchApp"+msg.custom, Toast.LENGTH_LONG).show();
//            }
//            @Override
//            public void openUrl(Context context, UMessage msg) {
//                super.openUrl(context, msg);
//                Toast.makeText(context, "openUrl"+msg.custom, Toast.LENGTH_LONG).show();
//            }
//            @Override
//            public void openActivity(Context context, UMessage msg) {
//                super.openActivity(context, msg);
//                Toast.makeText(context, "openActivity"+msg.custom, Toast.LENGTH_LONG).show();
//            }
//            @Override
//            public void dealWithCustomAction(Context context, UMessage msg) {
//                Log.i(TAG, "dealWithCustomAction"+msg.extra);
////                PushExtraBean pushExtraBean = new Gson().fromJson(msg.extra.toString(),PushExtraBean.class);
//                Intent intent=new Intent();
//                Log.i(TAG, "01");
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                VideoBean videoBean = new VideoBean();
//                videoBean.setvId(msg.extra.get("vId"));
//                videoBean.setVideoId(msg.extra.get("videoId"));
//                videoBean.setTag(msg.extra.get("tag"));
//                videoBean.setLecturerId(msg.extra.get("lecturerId"));
//                Log.i(TAG, "1");
//                if(msg.extra.get("pushType").equals("1")){//跳转到视频播放
//                    Log.i(TAG, "videoBean");
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable(Constant.IParam.videoBean,videoBean);
//                    intent.putExtras(bundle);
//                    intent.setClass(getApplicationContext(), VideoPlayActivity.class);
//                    startActivity(intent);
//                }else if(msg.extra.get("pushType").equals("2")){
//                    Log.i(TAG, "getH5");
//                    intent.putExtra(Constant.IParam.url,msg.extra.get("h5"));
//                    intent.setClass(getApplicationContext(), WebActivity.class);
//                    startActivity(intent);
//                }else if(msg.extra.get("pushType").equals("3")){
//                    Log.i(TAG, "getFeatureId");
//                    intent.putExtra(Constant.IParam.featureId,msg.extra.get("featureId"));
//                    intent.setClass(getApplicationContext(), ProjectActivity.class);
//                    startActivity(intent);
//                }else if(msg.extra.get("pushType").equals("4")){
//                    Log.i(TAG, "getSearchKey");
//                    intent.putExtra(Constant.IParam.SearchTag, msg.extra.get("searchKey"));
//                    intent.setClass(getApplicationContext(), SearchCoursesResultActivity.class);
//                    startActivity(intent);
//                }
//            }
//        };
//        PushAgent.getInstance(mContext).setNotificationClickHandler(notificationClickHandler);
//
//        //自定义消息
//        UmengMessageHandler messageHandler = new UmengMessageHandler(){
//
////            @Override  //
////            public Notification getNotification(Context context, UMessage msg) {
////
////                for (Map.Entry entry : msg.extra.entrySet()) {
////                    Object key = entry.getKey();
////                    Object value = entry.getValue();
////                    Toast.makeText(context, "key=="+key+"value"+value, Toast.LENGTH_LONG).show();
////                }
////
////                return super.getNotification(context, msg);
////            }
//
//            @Override
//            public void dealWithCustomMessage(final Context context, final UMessage msg) {
//                new Handler(getMainLooper()).post(new Runnable() {
//                    @Override
//                    public void run() {
//                        // 对于自定义消息，PushSDK默认只统计送达。若开发者需要统计点击和忽略，则需手动调用统计方法。
//                        boolean isClickOrDismissed = true;
//                        if(isClickOrDismissed) {
//                            //自定义消息的点击统计
//                            UTrack.getInstance(getApplicationContext()).trackMsgClick(msg);
//                        } else {
//                            //自定义消息的忽略统计
//                            UTrack.getInstance(getApplicationContext()).trackMsgDismissed(msg);
//                        }
//                           Log.i(TAG, msg.extra.toString()+"1");
//                           Log.i(TAG, msg.custom.toString()+"c");
//                           RxBus.getInstance().post(new MessageNumberEvent(msg.extra.get("targetType"),msg.extra.get("innerId"), SPUtils.getInstance().getString(Config.user_id)));
//                    }
//                });
//            }
//        };
//        PushAgent.getInstance(mContext).setMessageHandler(messageHandler);
    }






    /**
     * 获取Application
     */
    public static MyApplication getApp() {
        return myApplication;
    }

    /**
     * 判断是不是UI主进程，因为有些东西只能在UI主进程初始化
     */
    public static boolean isAppMainProcess() {
        try {
            int pid = android.os.Process.myPid();
            String process = getAppNameByPID(getContext(), pid);
            if (TextUtils.isEmpty(process)) {
                return true;
            } else if (PROCESS_NAME.equalsIgnoreCase(process)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * 根据Pid得到进程名
     */
    public static String getAppNameByPID(Context context, int pid) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                return processInfo.processName;
            }
        }
        return "";
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public static Context getContext(){
        return mContext;
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
        //整体摧毁的时候调用这个方法
    }

    private void initDownloader() {
        DownloadConfiguration configuration = new DownloadConfiguration();
        configuration.setMaxThreadNum(10);
        configuration.setThreadNum(3);
        DownloadManager.getInstance().init(getApplicationContext(), configuration);
    }
}
