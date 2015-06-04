package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.GlobalParams;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;


public class LoginActivity extends Activity implements OnClickListener {
    private EditText et_username;
    private EditText et_password;
    private LinearLayout btn_left;
    private TextView btn_right;
    private Button btn_login;
    private Button btn_to_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        TitleManager.setTitle(this, ConstantValue.LOGINVIEW);
        setLinister();

    }

    private void setLinister() {
        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_to_regist.setOnClickListener(this);
    }

    private void init() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_to_regist = (Button) findViewById(R.id.btn_to_forgetpwd);
        btn_left = (LinearLayout) findViewById(R.id.btn_left);
        btn_right = (TextView) findViewById(R.id.btn_right);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                GlobalParams.userid = 1;
                finish();
                break;
            case R.id.btn_to_forgetpwd:
                startActivity(new Intent(LoginActivity.this, RegistActivity.class));
                finish();
                break;
            case R.id.btn_left:
                finish();
                break;
            case R.id.btn_right:
                startActivity(new Intent(LoginActivity.this, RegistActivity.class));
                finish();
                break;
            default:
                break;
        }

    }
}
