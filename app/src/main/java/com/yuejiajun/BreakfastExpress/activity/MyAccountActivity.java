package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.GlobalParams;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;


public class MyAccountActivity extends Activity implements OnClickListener {
    private LinearLayout btn_myMobile;
    private LinearLayout btn_name;
    private LinearLayout btn_userName;
    private LinearLayout btn_changePassword;
    private TextView tv_myMobile;
    private TextView tv_name;
    private TextView tv_userName;
    private LinearLayout btn_left;
    private Button btn_unlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        init();
        TitleManager.setTitle(this, ConstantValue.MYACCOUNTVIEW);
        setListener();
    }

    @Override
    protected void onResume() {

        super.onResume();
        if (GlobalParams.userid != 0 && GlobalParams.mobile != null) {
            tv_myMobile.setText(GlobalParams.mobile);
        }
        if (GlobalParams.userid != 0 && GlobalParams.name != null) {
            tv_name.setText(GlobalParams.name);
        }
        if (GlobalParams.userid != 0 && GlobalParams.userName != null) {
            tv_userName.setText(GlobalParams.userName);
        }
    }

    private void initValue() {
        tv_myMobile.setText(GlobalParams.mobile);
        tv_name.setText(GlobalParams.name);
        tv_userName.setText(GlobalParams.userName);
    }

    private void init() {
        btn_myMobile = (LinearLayout) findViewById(R.id.ll_myMobile);
        btn_name = (LinearLayout) findViewById(R.id.ll_name);
        btn_userName = (LinearLayout) findViewById(R.id.ll_userName);
        btn_changePassword = (LinearLayout) findViewById(R.id.ll_changePassword);
        btn_left = (LinearLayout) findViewById(R.id.btn_left);
        tv_myMobile = (TextView) findViewById(R.id.tv_myMobile);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_userName = (TextView) findViewById(R.id.tv_userName);
        btn_unlogin = (Button) findViewById(R.id.btn_unlogined);

    }

    private void setListener() {
        btn_myMobile.setOnClickListener(this);
        btn_name.setOnClickListener(this);
        btn_userName.setOnClickListener(this);
        btn_changePassword.setOnClickListener(this);
        btn_left.setOnClickListener(this);
        btn_unlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_unlogined:
                GlobalParams.userid = 0;
                finish();
                break;
            case R.id.ll_myMobile:
                startActivity(new Intent(this, ChangeMobileActivity.class));
                break;
            case R.id.ll_name:
                startActivity(new Intent(this, ChangeNameActivity.class));
                break;
            case R.id.ll_userName:
                startActivity(new Intent(this, ChangeUsernameActivity.class));
                break;
            case R.id.ll_changePassword:
                startActivity(new Intent(this, ChangePwdActivity.class));
                break;
            case R.id.btn_left:
                finish();
            default:
                break;
        }
    }

}
