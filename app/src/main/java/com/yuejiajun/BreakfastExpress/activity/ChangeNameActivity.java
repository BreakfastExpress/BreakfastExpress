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


public class ChangeNameActivity extends Activity implements OnClickListener {
    private EditText et_name;
    private Button btn_changeName;
    private LinearLayout btn_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changename);
        init();
        TitleManager.setTitle(this, ConstantValue.CHANGENAMEVIEW);
        setListener();

    }

    private void init() {
        et_name = (EditText) findViewById(R.id.et_changeName);
        btn_changeName = (Button) findViewById(R.id.btn_changeName);
        btn_left = (LinearLayout) findViewById(R.id.btn_left);
    }

    private void setListener() {
        btn_changeName.setOnClickListener(this);
        btn_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_changeName:
                GlobalParams.name = et_name.getText().toString().trim();
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
