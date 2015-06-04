package com.yuejiajun.BreakfastExpress.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.bean.MyAddressBean;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Murphy on 2015/6/3.
 */
public class MyAddressAdapter extends BaseAdapter {
    private ArrayList<MyAddressBean> dataList;
    private Context mContext;
    private int position;

    public MyAddressAdapter(Context context, ArrayList<MyAddressBean> list) {
        super();
        dataList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        position = i;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_address, null);
            viewHolder = new ViewHolder(view);
            viewHolder.tvNameInAddress.setText(dataList.get(i).getName());
            viewHolder.tvSexInAdress.setText(dataList.get(i).getSex());
            viewHolder.tvMobileInAdress.setText(dataList.get(i).getMobile());
            viewHolder.tvDress.setText(dataList.get(i).getAddress());
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        return view;
    }


    class ViewHolder {
        @InjectView(R.id.tv_nameInAddress)
        TextView tvNameInAddress;
        @InjectView(R.id.tv_sexInAdress)
        TextView tvSexInAdress;
        @InjectView(R.id.tv_mobileInAdress)
        TextView tvMobileInAdress;
        @InjectView(R.id.tv_dress)
        TextView tvDress;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
