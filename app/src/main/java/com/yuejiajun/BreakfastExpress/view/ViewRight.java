package com.yuejiajun.BreakfastExpress.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.adapter.MainSelectorAdapter;


public class ViewRight extends RelativeLayout implements ViewBaseAction {

    private final String[] items = new String[]{"item1", "item2", "item3",
            "item4", "item5", "item6"};// 显示字段
    private final String[] itemsVaule = new String[]{"1", "2", "3", "4", "5",
            "6"};// 隐藏id
    private ListView mListView;
    private OnSelectListener mOnSelectListener;
    private MainSelectorAdapter adapter;
    private String mDistance;
    private String showText = "item1";
    private Context mContext;

    public ViewRight(Context context) {
        super(context);
        init(context);
    }

    public ViewRight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public ViewRight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public String getShowText() {
        return showText;
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_distance, this, true);
        setBackgroundResource(R.drawable.choosearea_bg_right);
        mListView = (ListView) findViewById(R.id.listView);
        adapter = new MainSelectorAdapter(context, items, R.drawable.choose_item_right,
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
