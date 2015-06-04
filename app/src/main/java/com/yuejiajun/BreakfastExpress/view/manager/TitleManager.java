package com.yuejiajun.BreakfastExpress.view.manager;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;


public class TitleManager {
    public static TextView tv_mid;
    public static LinearLayout btn_left;
    public static ImageView iv_left;
    public static TextView btn_right;
    public static TextView tv_location;

    /*
     * public TitleManager(Activity activity) { this.mContext = mContext; }
     */
    public static void setTitle(Activity activity, int viewId) {
        tv_mid = (TextView) activity.findViewById(R.id.tv_mid);
        btn_left = (LinearLayout) activity.findViewById(R.id.btn_left);
        btn_right = (TextView) activity.findViewById(R.id.btn_right);
        tv_location = (TextView) activity.findViewById(R.id.tv_location);
        iv_left = (ImageView) activity.findViewById(R.id.iv_left);
        initTitle();
        titleSelection(viewId);
    }

    private static void initTitle() {
        tv_location.setVisibility(View.GONE);
        // 设置标题栏标题
        tv_mid.setVisibility(View.GONE);
        // 设置标题按钮显示
        btn_left.setVisibility(View.GONE);
        // 设置标题按钮显示
        btn_right.setVisibility(View.GONE);
    }

    private static void titleSelection(int viewId) {
        initTitle();
        switch (viewId) {
            case ConstantValue.MAINVIEW:
                tv_location.setVisibility(View.VISIBLE);
                btn_left.setVisibility(View.VISIBLE);
                btn_right.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.location);
                btn_right.setBackgroundResource(R.drawable.search);
                break;
            case ConstantValue.STOREVIEW:
                tv_mid.setVisibility(View.VISIBLE);
                tv_mid.setText("餐馆");
                break;
            case ConstantValue.ORDERVIEW:
                tv_mid.setVisibility(View.VISIBLE);
                tv_mid.setText("我的订单");
                break;
            case ConstantValue.MINEVIEW:
                tv_mid.setVisibility(View.VISIBLE);
                tv_mid.setText("我的");
                break;
            case ConstantValue.LOGINVIEW:
                btn_left.setVisibility(View.VISIBLE);
                btn_right.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("登录");
                btn_right.setText("免费注册");
                btn_right.setTextColor(Color.WHITE);
                break;
            case ConstantValue.SETTINGVIEW:
                btn_left.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("设置");
                break;
            case ConstantValue.MYACCOUNTVIEW:
                btn_left.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("我的资料");
                break;
            case ConstantValue.CHANGEMOBILEVIEW:
                btn_left.setVisibility(View.VISIBLE);
                btn_right.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
//                btn_left.setBackgroundResource(R.drawable.back);
                tv_mid.setText("修改手机号码");
                btn_right.setText("提交");
                btn_right.setTextColor(Color.WHITE);
                break;
            case ConstantValue.CHANGENAMEVIEW:
                btn_left.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("修改姓名");
                break;
            case ConstantValue.CHANGEUSERNAMEVIEW:
                btn_left.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("修改用户名");
                break;
            case ConstantValue.CHANGEPWDVIEW:
                btn_left.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("修改密码");
                break;
            case ConstantValue.REGISTVIEW:
                btn_left.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("注册");
                break;
            case ConstantValue.COMPLETEREGISTVIEW:
                btn_left.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("完成注册");
                break;
            case ConstantValue.SETPAYPWDVIEW:
                btn_left.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("设置支付密码");
                break;
            case ConstantValue.MYADDRESSVIEW:
                btn_left.setVisibility(View.VISIBLE);
                tv_mid.setVisibility(View.VISIBLE);
                iv_left.setImageResource(R.drawable.back);
                tv_mid.setText("我的送餐地址");
                break;

            default:
                break;
        }

    }

}
