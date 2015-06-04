package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by admin on 2015/6/2.
 */
public class SetPayPwdActivity extends Activity {
    @InjectView(R.id.et_registSecurityCode)
    EditText etRegistSecurityCode;
    @InjectView(R.id.btn_registSendCode)
    Button btn_sendSecurityCode;
    @InjectView(R.id.btn_setPayPwd1)
    Button btn_setPayPwd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpaypwd);
        ButterKnife.inject(this);
        TitleManager.setTitle(this, ConstantValue.SETPAYPWDVIEW);

    }

    @OnClick(R.id.btn_setPayPwd1)
    void setPayPwd1() {
        startActivity(new Intent(this, SetPayPwdActivity2.class));
        finish();
    }

    @OnClick(R.id.btn_left)
    void back() {
        finish();
    }
}
