package com.yuejiajun.BreakfastExpress.adapter;


import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.bean.SelectorListItemBean;

import java.util.List;

;


public class MainSelectorAdapter extends BaseAdapter {

    private Context mContext;
    private List<SelectorListItemBean> mListData;
    private String[] mArrayData;
    private int selectedPos = -1;
    private String selectedText = "";
    private int normalDrawbleId;
    private int rID;
    private float textSize;
    private OnClickListener onClickListener;
    private OnItemClickListener mOnItemClickListener;

    public MainSelectorAdapter(Context context, List<SelectorListItemBean> listData,
                               int sId, int nId) {
        super();
        mContext = context;
        mListData = listData;
        rID = sId;
        normalDrawbleId = nId;

        init();
    }

    public MainSelectorAdapter(Context context, String[] arrayData, int sId,
                               int nId) {
        super();
        mContext = context;
        mArrayData = arrayData;
        rID = sId;
        normalDrawbleId = nId;
        init();
    }

    private void init() {
        onClickListener = new OnClickListener() {

            @Override
            public void onClick(View view) {
                selectedPos = (Integer) view.getTag();
                setSelectedPosition(selectedPos);
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, selectedPos);
                }
            }
        };
    }

    /**
     * 设置选中的position,但不通知刷新
     */
    public void setSelectedPositionNoNotify(int pos) {
        selectedPos = pos;
        if (mListData != null && pos < mListData.size()) {
            selectedText = mListData.get(pos).getTitle();
        } else if (mArrayData != null && pos < mArrayData.length) {
            selectedText = mArrayData[pos];
        }
    }

    /**
     * 获取选中的position
     */
    public int getSelectedPosition() {
        if (mArrayData != null && selectedPos < mArrayData.length) {
            return selectedPos;
        }
        if (mListData != null && selectedPos < mListData.size()) {
            return selectedPos;
        }

        return -1;
    }

    /**
     * 设置选中的position,并通知列表刷新
     */
    public void setSelectedPosition(int pos) {
        if (mListData != null && pos < mListData.size()) {
            selectedPos = pos;
            selectedText = mListData.get(pos).getTitle();
            notifyDataSetChanged();
        } else if (mArrayData != null && pos < mArrayData.length) {
            selectedPos = pos;
            selectedText = mArrayData[pos];
            notifyDataSetChanged();
        }

    }

    /**
     * 设置列表字体大小
     */
    public void setTextSize(float tSize) {
        textSize = tSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(
                    R.layout.choose_item, parent, false);
        } else {
            view = convertView;
        }
        view.setTag(position);
        TextView tv_image = (TextView) view.findViewById(R.id.tv_list_image);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_list_title);
        String mString = "";
        int image = 0;
        if (mListData != null) {
            if (position < mListData.size()) {
                mString = mListData.get(position).getTitle();
                image = mListData.get(position).getrID();
            }
        } else if (mArrayData != null) {
            if (position < mArrayData.length) {
                mString = mArrayData[position];
            }
        }
        if (mString.contains("不限"))
            tv_title.setText("不限");
        else
            tv_title.setText(mString);
        tv_image.setBackgroundResource(image);
        tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        if (selectedText != null && selectedText.equals(mString)) {
            view.setBackgroundResource(rID);// 设置选中的背景图片
        } else {
            view.setBackgroundResource(normalDrawbleId);// 设置未选中状态背景图片
        }
        view.setPadding(20, 0, 0, 0);
        view.setOnClickListener(onClickListener);
        return view;
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        mOnItemClickListener = l;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * 重新定义菜单选项单击接口
     */
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

}
