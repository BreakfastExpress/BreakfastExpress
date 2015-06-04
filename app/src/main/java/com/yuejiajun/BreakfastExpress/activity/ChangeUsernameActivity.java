package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.GlobalParams;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;


public class ChangeUsernameActivity extends Activity implements OnClickListener {
    private EditText et_userName;
    private Button btn_changeUsername;
    private LinearLayout btn_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeusername);
        init();
        TitleManager.setTitle(this, ConstantValue.CHANGEUSERNAMEVIEW);
        setListener();

    }

    private void init() {
        et_userName = (EditText) findViewById(R.id.et_changeUsername);
        btn_changeUsername = (Button) findViewById(R.id.btn_changeUsername);
        btn_left = (LinearLayout) findViewById(R.id.btn_left);
    }

    private void setListener() {
        btn_changeUsername.setOnClickListener(this);
        btn_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_changeUsername:
                GlobalParams.userName = et_userName.getText().toString().trim();
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
