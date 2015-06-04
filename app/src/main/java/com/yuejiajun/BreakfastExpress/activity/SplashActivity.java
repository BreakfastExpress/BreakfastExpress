package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;


public class SplashActivity extends Activity {
    private static final int sleepTime = ConstantValue.TIME_DELAY_WELCOME;
    boolean isFirstIn = false;
    SharedPreferences pref;

    private boolean isFirstIn() {
        return pref.getBoolean("isFirstIn", true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = getSharedPreferences("zaodiandian", 0);
        isFirstIn = isFirstIn();
        if (isFirstIn) {
            Editor editor = pref.edit();
            editor.putBoolean("isFirstIn", false);
            editor.commit();
            startActivity(new Intent(this, GuideActivity.class));
            finish();
        } else {
            setContentView(R.layout.activity_splash);
            new Thread(new Runnable() {
                public void run() {
                    long start = System.currentTimeMillis();
                    long costTime = System.currentTimeMillis() - start;
                    if (sleepTime - costTime > 0) {
                        try {
                            Thread.sleep(sleepTime - costTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        startActivity(new Intent(SplashActivity.this,
                                MainActivity.class));
                        finish();
                    } else {
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {
                        }
                        startActivity(new Intent(SplashActivity.this,
                                MainActivity.class));
                        finish();
                    }
                }
            }).start();
        }
    }

}
