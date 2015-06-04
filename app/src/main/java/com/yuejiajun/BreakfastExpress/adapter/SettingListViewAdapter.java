package com.yuejiajun.BreakfastExpress.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.bean.SettingListViewBean;

import java.util.ArrayList;


public class SettingListViewAdapter extends BaseAdapter {
    private static final String TAG = "SettingListViewAdapter";
    private static final int TYPE_COUNT = 3;// item类型的总数
    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_DOUBLE = 1;
    private static final int TYPE_DIVIDER = 2;
    private ArrayList<SettingListViewBean> dataList;// 数据集合
    private Context mContext;
    private int currentType;// 当前item类型

    public SettingListViewAdapter(Context mContext,
                                  ArrayList<SettingListViewBean> dataList) {
        super();
        this.dataList = dataList;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).getITEMTYPE() == 0) {
            return TYPE_NORMAL;
        } else if (dataList.get(position).getITEMTYPE() == 1) {
            return TYPE_DOUBLE;
        } else if (dataList.get(position).getITEMTYPE() == 2) {
            return TYPE_DIVIDER;
        } else {
            return 1000;
        }
    }

    @Override
    public boolean isEnabled(int position) {
        if (dataList.get(position).getITEMTYPE() == TYPE_DIVIDER) {
            return !(super.isEnabled(position));
        }
        return super.isEnabled(position);
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View normalView = null;
        View doubleView = null;
        View dividerView = null;
        View headView = null;
        currentType = getItemViewType(position);

        if (currentType == TYPE_NORMAL) {
            NormalViewHolder normalHolder = null;
            if (convertView == null) {
                normalHolder = new NormalViewHolder();
                normalView = LayoutInflater.from(mContext).inflate(
                        R.layout.minelist_item1, null);
                normalHolder.iv_image = (ImageView) normalView
                        .findViewById(R.id.iv_item1_image);
                normalHolder.tv_title = (TextView) normalView
                        .findViewById(R.id.tv_item1_title);
                normalView.setTag(normalHolder);

                convertView = normalView;
            } else {
                normalHolder = (NormalViewHolder) convertView.getTag();
            }
            normalHolder.tv_title.setText(dataList.get(position).getTitle());// title
            normalHolder.iv_image.setBackgroundResource(dataList.get(position)
                    .getrId());
        } else if (currentType == TYPE_DOUBLE) {
            DoubleViewHolder doubleHoler = null;
            if (convertView == null) {
                doubleHoler = new DoubleViewHolder();
                doubleView = LayoutInflater.from(mContext).inflate(
                        R.layout.minelist_item2, null);
                doubleHoler.tv_title = (TextView) doubleView
                        .findViewById(R.id.tv_item2_title);
                doubleHoler.tv_text = (TextView) doubleView
                        .findViewById(R.id.tv_item2_text);
                doubleHoler.iv_image = (ImageView) doubleView
                        .findViewById(R.id.iv_item2_image);
                doubleHoler.iv_next = (ImageView) doubleView
                        .findViewById(R.id.iv_item2_next);

                doubleView.setTag(doubleHoler);
                convertView = doubleView;
            } else {
                doubleHoler = (DoubleViewHolder) convertView.getTag();
            }

            doubleHoler.tv_title.setText(dataList.get(position).getTitle());
            doubleHoler.tv_text.setText(dataList.get(position).getText());
            doubleHoler.iv_image.setBackgroundResource(dataList.get(position)
                    .getrId());
        } else if (currentType == TYPE_DIVIDER) {
            DividerViewHolder dividerHolder = null;
            if (convertView == null) {

                dividerHolder = new DividerViewHolder();
                dividerView = LayoutInflater.from(mContext).inflate(
                        R.layout.minelist_item3, null);
                dividerHolder.view = (View) dividerView
                        .findViewById(R.id.view_divider);
                dividerView.setTag(dividerHolder);
                convertView = dividerView;
            } else {
                dividerHolder = (DividerViewHolder) convertView.getTag();
            }
        }
        return convertView;

    }

    class NormalViewHolder {
        ImageView iv_image;
        TextView tv_title;
        ImageView iv_next;
    }

    class DoubleViewHolder {
        ImageView iv_image;
        TextView tv_title;
        TextView tv_text;
        ImageView iv_next;
    }

    class DividerViewHolder {
        View view;
    }


}
