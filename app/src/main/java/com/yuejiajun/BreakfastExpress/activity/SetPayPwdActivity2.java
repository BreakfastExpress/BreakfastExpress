package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.view.GridPasswordView;
import com.yuejiajun.BreakfastExpress.view.PasswordType;
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by admin on 2015/6/3.
 */
public class SetPayPwdActivity2 extends Activity implements GridPasswordView.OnPasswordChangedListener {
    @InjectView(R.id.gpv_payPwd1)
    GridPasswordView gpvPayPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_setpaypwd2);
        init();

    }

    private void init() {
        ButterKnife.inject(this);
        TitleManager.setTitle(this, ConstantValue.SETPAYPWDVIEW);
        gpvPayPwd.setOnPasswordChangedListener(this);
        gpvPayPwd.setFocusable(true);
        gpvPayPwd.setPasswordType(PasswordType.NUMBER);
    }

    @OnClick(R.id.btn_left)
    void back() {
        finish();
    }

    @Override
    public void onChanged(String psw) {

    }

    @Override
    public void onMaxLength(String psw) {
        startActivity(new Intent(this, SetPayPwdActivity3.class));
        finish();
    }
}
