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
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;


public class ChangePwdActivity extends Activity implements OnClickListener {
    private EditText et_newPwd1;
    private EditText et_newPwd2;
    private Button btn_changePwd;
    private LinearLayout btn_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepwd);
        init();
        TitleManager.setTitle(this, ConstantValue.CHANGEPWDVIEW);
        setListener();

    }

    private void init() {
        et_newPwd1 = (EditText) findViewById(R.id.et_newPwd1);
        et_newPwd2 = (EditText) findViewById(R.id.et_newPwd2);
        btn_changePwd = (Button) findViewById(R.id.btn_changePwd);
        btn_left = (LinearLayout) findViewById(R.id.btn_left);
    }

    private void setListener() {
        btn_changePwd.setOnClickListener(this);
        btn_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_changePwd:
                if (et_newPwd1.getText().toString().trim()
                        .equals(et_newPwd2.getText().toString().trim())) {

                }
                finish();
                break;
            case R.id.btn_left:
                finish();
                break;

            default:
                break;
        }
    }
}
