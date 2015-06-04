package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.fragment.HomeFragment;
import com.yuejiajun.BreakfastExpress.fragment.MineFragment;
import com.yuejiajun.BreakfastExpress.fragment.OrderFragment;
import com.yuejiajun.BreakfastExpress.fragment.StoreFragment;
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;


public class MainActivity extends Activity implements
        RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg_bottom;
    private LinearLayout btn_left;
    private TextView tv_location;
    private TextView btn_right;
    private long exitTime = 0;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private StoreFragment storeFragment;
    private OrderFragment orderFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getFragmentManager();
        setListner();
        setTabSelection(0);

    }

    /**
     * 设置监听事件
     */
    private void setListner() {
        rg_bottom.setOnCheckedChangeListener(this);
    }

    /**
     * 初始化控件
     */
    private void initViews() {
        rg_bottom = (RadioGroup) findViewById(R.id.rg_bottom);
        tv_location = (TextView) findViewById(R.id.tv_location);
        btn_left = (LinearLayout) findViewById(R.id.btn_left);
        btn_right = (TextView) findViewById(R.id.btn_right);
    }


    /**
     * 底部导航栏的监听事件
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.btn_first:
                setTabSelection(0);
                break;
            case R.id.btn_second:
                setTabSelection(1);
                break;
            case R.id.btn_third:
                setTabSelection(2);
                break;
            case R.id.btn_forth:
                setTabSelection(3);
                break;

            default:
                break;
        }

    }

    /**
     * 设置选项卡选中
     *
     * @param index
     */
    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 隐藏掉所有的fragment，以防止有多个Fragment显示在界面上
        hideFragments(transaction);
        switch (index) {
            case 0:
                TitleManager.setTitle(MainActivity.this, ConstantValue.MAINVIEW);
                // 点击第一个按钮时显示首页
                if (homeFragment == null) {
                    // 如果homeFragment为空，则创建一个并添加到界面上
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.id_mainview, homeFragment);
                } else {
                    // 如果不为空，则直接将它显示出来
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                TitleManager.setTitle(MainActivity.this, ConstantValue.STOREVIEW);
                if (storeFragment == null) {
                    storeFragment = new StoreFragment();
                    transaction.add(R.id.id_mainview, storeFragment);
                } else {
                    transaction.show(storeFragment);
                }
                break;
            case 2:
                TitleManager.setTitle(MainActivity.this, ConstantValue.ORDERVIEW);
                if (orderFragment == null) {
                    orderFragment = new OrderFragment();
                    transaction.add(R.id.id_mainview, orderFragment);
                } else {
                    transaction.show(orderFragment);
                }
                break;
            case 3:
                TitleManager.setTitle(MainActivity.this, ConstantValue.MINEVIEW);
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.id_mainview, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * Fragment隐藏，防止多个Fragment显示
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (storeFragment != null) {
            transaction.hide(storeFragment);
        }
        if (orderFragment != null) {
            transaction.hide(orderFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }

    }

    /**
     * 重写返回键，两次返回键退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                // System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
