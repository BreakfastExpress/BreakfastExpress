package com.yuejiajun.BreakfastExpress;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Murphy on 2015/5/13.
 */
public class GlobalParams {
    public static String PROXY_IP = "";
    public static int PROXY_PORT;
    public static int WIN_WIDTH;
    public static Activity gMainActivity;
    public static Context context;
    public static int ID;
    // 全局变量记录用户登录状态
    public static int userid;
    public static String mobile;
    public static String name;
    public static String userName;
    public static String payType;
    public static String sendTime;
    public static String invoiceTitle;
    public static String invoiceType;
    public static String orderID;
    public static String pay;
    public static int price;
    // 购物车的商品数量
    public static int count;
    // 判断是否需要再次联网获取分类信息
    public static boolean isdownload = true;

}
