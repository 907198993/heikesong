package com.heikesong.weishi.constants;

/**
 * Created by Administrator on 2017/7/13.
 */

public class Constant {
//
//    public static final String URL="http://cs.petzm.com";
//    public static final String HOST="/app/";
//    public static final String HOST="/";
//    public static final String URL="http://peixunapp.petzm618.com";
//    public static final String HOST="/app/";
 public static final String URL="http://192.168.1.61:8080";//绪
//    public static final String URL="http://192.168.1.254:8080";//强
    public static final String HOST="/";
    public static final String PHONELOGIN=HOST+"console/outer/loginWechat";//登陆
    public static final String PHONESMS=HOST+"console/outer/sms/sendSms";//验证码
    public static final String PHONELOGINOUT=HOST+"console/outer/logout";//登出
    public static final String APP_VERSION= HOST+ "console/outer/appVersion/findLatest";//查看版本
    public static final String HOME=HOST+"console/outer/page/homeVideos2";//首页
    public static final String CHANGE_LIKE_LIST=HOST+"console/outer/page/likeList";//猜你喜欢换一换
    public static final String CHANGE_SPLENDID_LIST=HOST+"console/outer/page/splendidList";//精品推荐换一换
    public static final String CHANGE_LIST=HOST+"console/outer/page/change";//首页换一换
    public static final String AUDIT_SPEED=HOST+"console/outer/companyInfo/speed";//审核加速
    public static final String IMAGE_UPLOAD=HOST+ "console/outer/image/imageUpload";//上传图片
    public static final String INFORMATION_UPLOAD=HOST+ "console/outer/companyInfo/companyInfoAdd";//上传资料
    public static final String VIDEO_COMMENT_LIST=HOST+"console/outer/comment/list";//视频评论列
    public static final String VIDEO_ADD_COMMENT=HOST+"console/outer/comment/add";//增加对视频评论
    public static final String VIDEO_COMMENT_DETAIL_LIST=HOST+"console/outer/reply/listFirst";//评论详情列表
    public static final String VIDEO_ADD_USER_COMMENT=HOST+"console/outer/reply/add";//增加对用户的评论
    public static final String VIDEO_HISTORY_ADD=HOST+"console/outer/videoHistory/add";//增加播放历史
    public static final String VIDEO_HISTORY_TIME_ADD=HOST+"console/outer/videoTime/add";//增加播放历史时长
    public static final String VIDEO_HISTORY=HOST+"console/outer/videoHistory/myListHistory";//播放历史
    public static final String VIDEO_HISTORY_DELETE=HOST+"console/outer/videoHistory/delete";//删除播放历史
    public static final String VIDEO_COLLECT_ADD=HOST+"console/outer/collect/add";//增加收藏
    public static final String VIDEO_BUYED=HOST+"console/outer/videoSerial/myList";//已购买列表
    public static final String VIDEO_COLLECT=HOST+"console/outer/collect/list";//收藏列表
    public static final String VIDEO_COLLECT_DELETE=HOST+"console/outer/collect/delete";//删除收藏
    public static final String ADD_WECHAT=HOST+"console/outer/wechat/add";//增加微信绑定
    public static final String USER_INFORMATION=HOST+"console/outer/user/findInfo";//获取用户资料
    public static final String COMPANY_INFORMATION=HOST+ "console/outer/companyInfo/findInfo";//获取公司资料
    public static final String INFORMATION_UPDATE=HOST+ "console/outer/companyInfo/updateCompany";//修改资料
    public static final String VIDEO_LIST=HOST+ "console/outer/video/intro";//视频播放界面下面的列表
    public static final String VERIFY_NAME=HOST+ "console/outer/user/verifyName";//检查用户名
    public static final String UPDATE_INFO=HOST+ "console/outer/user/updateInfo";//更新用户数据
    public static final String ADD_CONCERN=HOST+ "console/outer/concern/add";//添加关注
    public static final String DELETE_CONCERN=HOST+ "console/outer/concern/delete";//取消关注
    public static final String RECOMMEND_LIST=HOST+ "console/outer/lecturerUser/list1";//推荐关注列表
    public static final String CONCERN_LIST=HOST+ "console/outer/concern/list";//已关注列表
    public static final String SEARCH_RESULT_LIST=HOST+ "console/outer/video/list4";//结果列表
    public static final String SEARCH_AD_RESULT=HOST+ "console/outer/search/searchImage";//广告结果

    public static final String VIDEO_INTRO=HOST+ "console/outer/video/serialInfo2";//播放界面简介和推荐视频
//    public static final String VIDEO_INTRO=HOST+ "console/outer/video/introInfo";//播放界面简介和推荐视频
    public static final String VIDEO_INTRO_LOADMORE=HOST+ "console/outer/video/serial";//播放界面上拉推荐视频
    public static final String SEARCH_RECOMMEND = HOST+ "console/outer/search/show";//搜索界面推荐视频和热门搜索
    public static final String VIDEO_COMMENT_ADD_PRAISE=HOST+"console/outer/comment/likeVideoComment";//点赞
    public static final String VIDEO_COMMENT_ADD_PRAISE_TWO=HOST+"console/outer/reply/likeVideoCommentReply";//2级评论点赞
    public static final String CATEGORY= HOST+ "console/outer/videoType/typeList2";//分类界面
    public static final String PLAY_PERMISSIONS = HOST+"console/outer/member/findInfo";//用户播放权限
    public static final String PROJECT = HOST+"console/outer/videoFeature/introInfo";//专栏
    public static final String MAIN_SEARCH_KEY = HOST+"console/outer/searchKey/list";//首页推荐搜索
    public static final String FEEDBACK= HOST+ "console/outer/feedback/add";//反馈
    public static final String WECHAT= HOST+ "console/outer/weixin/apppay";//微信支付
    public static final String ZHIFUBAO= HOST+ "console/outer/zhifubao/addOrders";//支付宝支付
    public static final String MESSAGELIST= HOST+ "console/outer/innerPush/messagesListByUser";//消息列表
    public static final String MESSAGE_DETAIL_LIST= HOST+ "console/outer/innerPush/getMessageDetail";//消息详情列表
    public static final String MESSAGE_READED= HOST+ "console/outer/innerPush/updateMessageStates";//点击新消息后变为已读
    public static final String MESSAGENUMBER= HOST+ "console/outer/innerPush/newMessagesAmount";//消息数量
    public static final String MESSAGENUMBERLOGIN= HOST+ "console/outer/innerPush/messagesAmountAfterLogin";//登陆消息数量
    public static final String DELETEINNERPUSHDETAIL= HOST+ "console/outer/innerPush/deleteInnerPushDetailByUAO";//删除该用户相关官方账号的消息明细


    public static final String ADIMAGE= HOST+ "console/outer/guideImage/list";//广告图

    public static final String BINDDEVICE= HOST+ "console/outer/innerPush/bindAliasAfterLogin";//绑定设备
    public static final String UNBINDDEVICE= HOST+ "console/outer/innerPush/deleteAliasAfterLoginOut";//解绑设备


    public static final String STS=HOST+"console/outer/sts/get";
    public static final String title="title";



    public static class RCode{
        public static final int register=100;
        public static final int update_name=200;
        public static final int update_phone=300;
        public static final int login=400;
        public static final int addTool=1000;
        public static final int addHomework=10001;
        public static final int deleteDefaultAccount=200;
        public static final int tiXianSuccess=2200;
    }
    public static class IParam{
        public static final String phone="phone";
        public static final String name="name";
        public static final String user_id="user_id";
        public static final String path="path";
        public static final String historyOrCollect="historyOrCollect";//观看历史或者收藏

        public static final String officialUserName="officialUserName";
        public static final String messageId="messageId";

        public static final String companyId="companyId";//companyId
        public static final String fromAuditFailture="fromAuditFailture";//从认证失败界面
        public static final String fromAudited="fromAudited";//从首页以加速界面
        public static final String SearchTag="SearchTag";//搜索关键词
        public static final String unbindPhone="unbindPhone";//解绑设备
        public static final String vId="vId";//视频vid
        public static final String videoId="videoId";//视频id
        public static final String videoBean="videoBean";//视频对象
        public static final String url="url";//h5html
        public static final String advertisementUrl="advertisementUrl";//advertisementUrl
        public static final String featureId="featureId";//featureId //专栏id

        public static final String userPhoto="userPhoto";//用户头像
        public static final String serviceCode="serviceCode";//客服二维码
        public static final String servicePhone="servicePhone";//客服电话

        //微信数据
        public static final String fromWechat="fromWechat";
        public static final String unionid="unionid";//unionid
        public static final String nickname="nickname";//name
        public static final String iconurl="iconurl";//头像
        public static final String openid="openid";//openid

        //审核
        public static final String msgId="msgId";
        public static final String title="title";
        public static final String code="code";
        public static final String editAddress="editAddress";
        public static final String Address="Address";
        public static final String address="address";
        public static final String typeName="typeName";
        public static final String type="type";


        //第三方分享
        public static final String shareTitle="shareTitle";
        public static final String shareDescription="shareDescription";
        public static final String shareUrl="shareUrl";
        public static final String shareLogo="shareLogo";
        public static final String shareBackGroundPicture="shareBackGroundPicture";
    }

}
