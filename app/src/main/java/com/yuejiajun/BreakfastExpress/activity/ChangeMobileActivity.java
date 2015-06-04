package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
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

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ChangeMobileActivity extends Activity implements OnClickListener {
    @InjectView(R.id.btn_left)
    LinearLayout btnLeft;
    @InjectView(R.id.et_changeMobile)
    EditText etChangeMobile;
    @InjectView(R.id.et_securityCode)
    EditText etSecurityCode;
    @InjectView(R.id.btn_sendSecurityCode)
    Button btnSendSecurityCode;
    @InjectView(R.id.btn_right)
    TextView btnRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changemobile);
        ButterKnife.inject(this);
        TitleManager.setTitle(this, ConstantValue.CHANGEMOBILEVIEW);
        setListener();

    }

    private void setListener() {
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_right:
                GlobalParams.mobile = etChangeMobile.getText().toString().trim();
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
