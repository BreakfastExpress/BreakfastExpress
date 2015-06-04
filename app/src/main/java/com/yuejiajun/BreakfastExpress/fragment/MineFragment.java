package com.yuejiajun.BreakfastExpress.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.GlobalParams;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.activity.LoginActivity;
import com.yuejiajun.BreakfastExpress.activity.MyAccountActivity;
import com.yuejiajun.BreakfastExpress.activity.MyAddressActivity;
import com.yuejiajun.BreakfastExpress.activity.SetPayPwdActivity;
import com.yuejiajun.BreakfastExpress.activity.SettingActivity;
import com.yuejiajun.BreakfastExpress.adapter.MineListViewAdapter;
import com.yuejiajun.BreakfastExpress.bean.MineListViewBean;

import java.util.LinkedList;


public class MineFragment extends Fragment implements OnItemClickListener {
    private LinkedList<MineListViewBean> items;
    private ListView listView;
    private MineListViewBean item;
    private MineListViewAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mine_tab, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        setListener();
    }

    @Override
    public void onResume() {
        if (GlobalParams.userid != 0) {
            refreshUI();
            mAdapter.notifyDataSetChanged();

        } else {
            items.clear();
            initvalues();
//			listView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();

        }
        super.onResume();
    }

    /**
     * 界面刷新
     */
    private void refreshUI() {
        items.removeFirst();
        item = new MineListViewBean();
        item.setITEMTYPE(ConstantValue.TYPE_HEAD_LOGINED);
        item.setTitle("会飞的猪蹄");
        item.setText("12345678901");
        items.addFirst(item);
        if (items.get(1).getITEMTYPE() != ConstantValue.TYPE_DIVIDER) {
            item = new MineListViewBean();
            item.setITEMTYPE(ConstantValue.TYPE_DIVIDER);
            items.add(1, item);
        }
        ;
        item = items.get(2);
        items.remove(2);
        item.setText("15.8元");
        items.add(2, item);

    }

    private void init() {
        listView = (ListView) getView().findViewById(R.id.lv_mineListview);
        items = new LinkedList<MineListViewBean>();
        initvalues();
        mAdapter = new MineListViewAdapter(getActivity(),
                items);
        listView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void setListener() {
        listView.setOnItemClickListener(this);
    }

    private void initvalues() {

        // 0
        item = new MineListViewBean();
        item.setITEMTYPE(ConstantValue.TYPE_HEAD_UNLOGINED);
        items.add(item);
        //第一个分割线
//		item = new MineListViewBean();
//		item.setITEMTYPE(ConstantValue.TYPE_DIVIDER);
//		items.add(item);
        // 1
        item = new MineListViewBean();
        item.setTitle(ConstantValue.MINE_LISTITEM[0]);
        item.setrId(ConstantValue.MINE_RESID[0]);
        item.setText("0.0元");
        item.setITEMTYPE(ConstantValue.TYPE_DOUBLE);
        items.add(item);
        // 2
        item = new MineListViewBean();
        item.setTitle(ConstantValue.MINE_LISTITEM[1]);
        item.setrId(ConstantValue.MINE_RESID[1]);
        item.setText("未设置");
        item.setITEMTYPE(ConstantValue.TYPE_DOUBLE);
        items.add(item);
        // 3
        item = new MineListViewBean();
        item.setTitle(ConstantValue.MINE_LISTITEM[2]);
        item.setrId(ConstantValue.MINE_RESID[2]);
        item.setITEMTYPE(ConstantValue.TYPE_NORMAL);
        items.add(item);
        // 4
        item = new MineListViewBean();
        item.setITEMTYPE(ConstantValue.TYPE_DIVIDER);
        items.add(item);
        // 5
        item = new MineListViewBean();
        item.setTitle(ConstantValue.MINE_LISTITEM[3]);
        item.setrId(ConstantValue.MINE_RESID[3]);
        item.setITEMTYPE(ConstantValue.TYPE_NORMAL);
        items.add(item);
        // 6
        item = new MineListViewBean();
        item.setTitle(ConstantValue.MINE_LISTITEM[4]);
        item.setrId(ConstantValue.MINE_RESID[4]);
        item.setITEMTYPE(ConstantValue.TYPE_NORMAL);
        items.add(item);
        // 7
        item = new MineListViewBean();
        item.setTitle(ConstantValue.MINE_LISTITEM[5]);
        item.setrId(ConstantValue.MINE_RESID[5]);
        item.setITEMTYPE(ConstantValue.TYPE_NORMAL);
        items.add(item);
        // 8
        item = new MineListViewBean();
        item.setITEMTYPE(ConstantValue.TYPE_DIVIDER);
        items.add(item);
        // 9
        item = new MineListViewBean();
        item.setTitle(ConstantValue.MINE_LISTITEM[6]);
        item.setrId(ConstantValue.MINE_RESID[6]);
        item.setITEMTYPE(ConstantValue.TYPE_NORMAL);
        items.add(item);


    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        if (GlobalParams.userid == 0) {
            arg2 = arg2 + 1;
        }
        switch (arg2) {
            case 0:
                startActivity(new Intent(getActivity(), MyAccountActivity.class));
                break;

            case 3:
                if (GlobalParams.userid == 0) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), SetPayPwdActivity.class));
                }
                break;
            case 7:
                if (GlobalParams.userid == 0) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), MyAddressActivity.class));
                }
                break;
            case 10:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            default:
                break;
        }
    }

}
