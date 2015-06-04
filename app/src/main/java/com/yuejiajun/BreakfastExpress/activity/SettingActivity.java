package com.yuejiajun.BreakfastExpress.activity;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.adapter.SettingListViewAdapter;
import com.yuejiajun.BreakfastExpress.bean.SettingListViewBean;
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class SettingActivity extends Activity implements OnItemClickListener {
    @InjectView(R.id.lv_settingListview)
    ListView listView;
    private ArrayList<SettingListViewBean> items;
    private SettingListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.inject(this);
        TitleManager.setTitle(this, ConstantValue.SETTINGVIEW);
        initValue();
        setListener();
    }

    /**
     * 初始化监听
     */
    private void setListener() {
        listView.setOnItemClickListener(this);
    }

    /**
     * 初始化数据
     */
    private void initValue() {
        items = new ArrayList<SettingListViewBean>();
        SettingListViewBean item;
        //0
        item = new SettingListViewBean();
        item.setTitle(ConstantValue.SETTING_LIST[0]);
        item.setrId(ConstantValue.SETTING_RESID[0]);
        item.setText("762.3KB");
        item.setITEMTYPE(ConstantValue.TYPE_DOUBLE);
        items.add(item);

        // 1
        item = new SettingListViewBean();
        item.setTitle(ConstantValue.SETTING_LIST[1]);
        item.setrId(ConstantValue.SETTING_RESID[1]);
        item.setText("1.01");
        item.setITEMTYPE(ConstantValue.TYPE_DOUBLE);
        items.add(item);
        // 2
        item = new SettingListViewBean();
        item.setITEMTYPE(ConstantValue.TYPE_DIVIDER);
        items.add(item);
        // 3
        item = new SettingListViewBean();
        item.setTitle(ConstantValue.SETTING_LIST[2]);
        item.setrId(ConstantValue.SETTING_RESID[2]);
        item.setITEMTYPE(ConstantValue.TYPE_NORMAL);
        items.add(item);
        // 4
        item = new SettingListViewBean();
        item.setTitle(ConstantValue.SETTING_LIST[2]);
        item.setrId(ConstantValue.SETTING_RESID[2]);
        item.setITEMTYPE(ConstantValue.TYPE_NORMAL);
        items.add(item);
        // 5
        item = new SettingListViewBean();
        item.setTitle(ConstantValue.SETTING_LIST[3]);
        item.setrId(ConstantValue.SETTING_RESID[3]);
        item.setITEMTYPE(ConstantValue.TYPE_NORMAL);
        items.add(item);
        // 6
        item = new SettingListViewBean();
        item.setITEMTYPE(ConstantValue.TYPE_DIVIDER);
        items.add(item);
        // 7
        item = new SettingListViewBean();
        item.setTitle(ConstantValue.SETTING_LIST[5]);
        item.setrId(ConstantValue.SETTING_RESID[5]);
        item.setITEMTYPE(ConstantValue.TYPE_NORMAL);
        items.add(item);
        mAdapter = new SettingListViewAdapter(this, items);
        listView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

    }

    @OnClick(R.id.btn_left)
    void back() {
        finish();
    }

}
