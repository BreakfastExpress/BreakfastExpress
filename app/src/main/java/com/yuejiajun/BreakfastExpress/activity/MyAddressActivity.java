package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.adapter.MyAddressAdapter;
import com.yuejiajun.BreakfastExpress.bean.MyAddressBean;
import com.yuejiajun.BreakfastExpress.view.manager.TitleManager;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by Murphy on 2015/6/3.
 */
public class MyAddressActivity extends Activity implements AdapterView.OnItemClickListener {
    @InjectView(R.id.lv_myAddress)
    ListView lvMyAddress;
    private MyAddressAdapter mAdapter;
    private ArrayList<MyAddressBean> items;
    private MyAddressBean item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_myaddress);
        initValues();
        init();


    }

    private void initValues() {
        items = new ArrayList<MyAddressBean>();
        item = new MyAddressBean();
        item.setName("张三1");
        item.setSex("男");
        item.setAddress("火星逗比州2货市傻叉街道号");
        item.setMobile("18012359856");
        items.add(item);
        item = new MyAddressBean();
        item.setName("张三2");
        item.setSex("男");
        item.setAddress("火星逗比州2货市傻叉街道号");
        item.setMobile("18012359856");
        items.add(item);
        item = new MyAddressBean();
        item.setName("张三3");
        item.setSex("男");
        item.setAddress("火星逗比州2货市傻叉街道号");
        item.setMobile("18012359856");
        items.add(item);
        item = new MyAddressBean();
        item.setName("张三4");
        item.setSex("男");
        item.setAddress("火星逗比州2货市傻叉街道号");
        item.setMobile("18012359856");
        items.add(item);
        item = new MyAddressBean();
        item.setName("张三5");
        item.setSex("男");
        item.setAddress("火星逗比州2货市傻叉街道号");
        item.setMobile("18012359856");
        items.add(item);
        item = new MyAddressBean();
        item.setName("张三6");
        item.setSex("男");
        item.setAddress("火星逗比州2货市傻叉街道号");
        item.setMobile("18012359856");
        items.add(item);
        item = new MyAddressBean();
        item.setName("张三7");
        item.setSex("男");
        item.setAddress("火星逗比州2货市傻叉街道号");
        item.setMobile("18012359856");
        items.add(item);
        item = new MyAddressBean();
        item.setName("张三8");
        item.setSex("男");
        item.setAddress("火星逗比州2货市傻叉街道号");
        item.setMobile("18012359856");
        items.add(item);
    }


    private void init() {
        ButterKnife.inject(this);
        TitleManager.setTitle(this, ConstantValue.MYADDRESSVIEW);
        lvMyAddress.setOnItemClickListener(this);
        mAdapter = new MyAddressAdapter(this, items);
        lvMyAddress.setAdapter(mAdapter);
    }

    @OnClick(R.id.btn_left)
    void back() {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
