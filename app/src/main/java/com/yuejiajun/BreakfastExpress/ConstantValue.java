package com.yuejiajun.BreakfastExpress;

/**
 * Created by Murphy on 2015/5/13.
 */
public interface ConstantValue {
    String ENCONDING = "UTF-8";
    String SUCCESS = "0";
    String ZDDURI = "http://yue.cookst.com/api";
    String APP_NAME = "早点点";
    int TIME_DELAY_GUIDE = 2000;
    int TIME_DELAY_WELCOME = 2000;
    int TYPE_NORMAL = 0;
    int TYPE_DOUBLE = 1;
    int TYPE_DIVIDER = 2;
    int TYPE_HEAD_UNLOGINED = 3;
    int TYPE_HEAD_LOGINED = 4;
    // 页面代码
    int MAINVIEW = 1000;
    int STOREVIEW = 1001;
    int ORDERVIEW = 1002;
    int MINEVIEW = 1003;
    int LOGINVIEW = 1004;
    int SETTINGVIEW = 1005;
    int MYACCOUNTVIEW = 1006;
    int CHANGEMOBILEVIEW = 1007;
    int CHANGENAMEVIEW = 1008;
    int CHANGEUSERNAMEVIEW = 1009;
    int CHANGEPWDVIEW = 1010;
    int REGISTVIEW = 1011;
    int COMPLETEREGISTVIEW = 1012;
    int SETPAYPWDVIEW = 1013;
    int MYADDRESSVIEW = 1014;
    // 页面代码结束
    String ORDER = "排序方式";
    String RESTAURANT = "餐厅分类";
    String FILTER = "智能筛选";
    // 筛选标题
    String[] ORDERS = {"综合排序", "销量最高", "速度最快", "评分最高", "价格最低"};
    // 餐厅类型
    String[] RESTAURANTS = {"全部口味", "中式早餐", "馄饨面食", "西式餐点", "小吃甜点"};
    String[] ITEM_VALUES = {"1", "2", "3", "4", "5", "6"};
    // 筛选界面图片
    int[] ITEM_RESOURCE = {R.drawable.l1, R.drawable.l2, R.drawable.l3,
            R.drawable.l4, R.drawable.l5, R.drawable.l6};
    // 我的列表图片
    int[] MINE_RESID = {R.drawable.balance, R.drawable.paymima,
            R.drawable.discount, R.drawable.message, R.drawable.address,
            R.drawable.collect, R.drawable.setting};

    // 我的列表标题
    String[] MINE_LISTITEM = {"账户余额", "支付密码", "优惠券", "消息", "我的送餐地址", "收藏",
            "设置"};
    // 设置列表图片
    int[] SETTING_RESID = {R.drawable.clear_cache, R.drawable.update,
            R.drawable.suggestion, R.drawable.help, R.drawable.about_us,
            R.drawable.join_in};
    ;
    // 设置列表标题
    String[] SETTING_LIST = {"清理缓存", "版本更新", "意见反馈", "帮助手册", "关于我们", "联系加盟"};


	
	
	
	

	/*
     * String ORDER_SALES = "销量最高"; String ORDER_SPEEDS = "速度最快"; String
	 * ORDER_SCORES = "评分最高"; String ORDER_PRICES = "价格最低";
	 */
	/*
	 * String ITEM_VALUE2 = "2"; String ITEM_VALUE3 = "3"; String ITEM_VALUE4 =
	 * "4"; String ITEM_VALUE5 = "5";
	 */

}
