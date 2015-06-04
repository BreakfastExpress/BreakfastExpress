package com.yuejiajun.BreakfastExpress.view;

import android.app.Activity;
import android.view.View;

import com.yuejiajun.BreakfastExpress.R;


public class CompleteRegist {
    private Activity activity;

    public CompleteRegist(Activity activity) {
        this.activity = activity;
    }

    public View getView() {
        return activity.getLayoutInflater().inflate(R.layout.complete_regist, null);
    }
}
