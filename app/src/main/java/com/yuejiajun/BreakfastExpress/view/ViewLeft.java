package com.yuejiajun.BreakfastExpress.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.adapter.MainSelectorAdapter;
import com.yuejiajun.BreakfastExpress.bean.SelectorListItemBean;

import java.util.ArrayList;
import java.util.List;


public class ViewLeft extends RelativeLayout implements ViewBaseAction {

    private final String[] items = ConstantValue.ORDERS;// 显示字段
    private final String[] itemsVaule = ConstantValue.ITEM_VALUES;// 隐藏id
    private final int[] itemRID = ConstantValue.ITEM_RESOURCE;
    private ListView mListView;
    private List<SelectorListItemBean> listItems;
    private OnSelectListener mOnSelectListener;
    private MainSelectorAdapter adapter;
    private String mDistance;
    private String showText = items[0];
    @SuppressWarnings("unused")
    private Context mContext;

    public ViewLeft(Context context) {
        super(context);
        init(context);
    }

    public ViewLeft(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public ViewLeft(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public String getShowText() {
        return showText;
    }

    private void init(Context context) {
        mContext = context;
        listItems = new ArrayList<SelectorListItemBean>();
        initValues();
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_distance, this, true);
        setBackgroundResource(R.drawable.choosearea_bg_left);
        // setBackgroundDrawable(getResources().getDrawable(R.drawable.choosearea_bg_left));
        mListView = (ListView) findViewById(R.id.listView);
        adapter = new MainSelectorAdapter(context, listItems,
                R.drawable.choose_item_right,
                R.drawable.choose_eara_item_selector);
        adapter.setTextSize(17);
        if (mDistance != null) {
            for (int i = 0; i < itemsVaule.length; i++) {
                if (itemsVaule[i].equals(mDistance)) {
                    adapter.setSelectedPositionNoNotify(i);
                    showText = items[i];
                    break;
                }
            }
        }
        mListView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MainSelectorAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

                if (mOnSelectListener != null) {
                    showText = items[position];
                    mOnSelectListener.getValue(itemsVaule[position],
                            items[position]);
                }
            }
        });
    }

    private void initValues() {
        SelectorListItemBean listItemBean;
        for (int i = 0; i < items.length; i++) {
            listItemBean = new SelectorListItemBean();
            listItemBean.setTitle(items[i]);
            listItemBean.setrID(itemRID[i]);
            listItems.add(listItemBean);
        }
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        mOnSelectListener = onSelectListener;
    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

    public interface OnSelectListener {
        public void getValue(String distance, String showText);
    }

}
