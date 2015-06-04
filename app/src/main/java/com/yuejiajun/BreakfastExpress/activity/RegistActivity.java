package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.view.CompleteRegist;
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;


public class RegistActivity extends Activity implements OnClickListener {
    private EditText mobile;
    private EditText code;
    private Button btn_regist;
    private Button btn_sendCode;
    private LinearLayout btn_left;
    private View view;
    private EditText registPwd1;
    private EditText registPwd2;
    private Button btn_completeRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        init();
        TitleManager.setTitle(this, ConstantValue.REGISTVIEW);
        setListener();

    }

    private void setListener() {
        btn_sendCode.setOnClickListener(this);
        btn_regist.setOnClickListener(this);
        btn_left.setOnClickListener(this);


    }

    private void setNextListener() {
        btn_left.setOnClickListener(this);
        btn_completeRegist.setOnClickListener(this);
    }

    private void init() {
        mobile = (EditText) findViewById(R.id.et_registMobile);
        code = (EditText) findViewById(R.id.et_registSecurityCode);
        btn_regist = (Button) findViewById(R.id.btn_regist);
        btn_sendCode = (Button) findViewById(R.id.btn_registSendCode);
        btn_left = (LinearLayout) findViewById(R.id.btn_left);
    }

    private void initNext() {
        view = new CompleteRegist(this).getView();
        btn_left = (LinearLayout) view.findViewById(R.id.btn_left);
        btn_completeRegist = (Button) view.findViewById(R.id.btn_completeRegist);
        registPwd1 = (EditText) view.findViewById(R.id.et_registPwd1);
        registPwd2 = (EditText) view.findViewById(R.id.et_registPwd2);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_regist:
                initNext();
                setContentView(view);
                setNextListener();
                TitleManager.setTitle(this, ConstantValue.COMPLETEREGISTVIEW);
                break;
            case R.id.btn_registSendCode:
                break;
            case R.id.btn_left:
                finish();
                break;
            case R.id.btn_completeRegist:
                finish();
            default:
                break;
        }
    }
}
