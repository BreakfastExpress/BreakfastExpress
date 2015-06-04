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


public class ViewMiddle extends RelativeLayout implements ViewBaseAction {

    private final String[] items = ConstantValue.RESTAURANTS;// 显示字段
    private final String[] itemsVaule = ConstantValue.ITEM_VALUES;// 隐藏id
    private ListView mListView;
    private OnSelectListener mOnSelectListener;
    private MainSelectorAdapter adapter;
    private String mDistance;
    private String showText = items[0];
    private Context mContext;

    public ViewMiddle(Context context) {
        super(context);
        init(context);
    }

    public ViewMiddle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public ViewMiddle(Context context, AttributeSet attrs) {
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
        setBackgroundResource(R.drawable.choosearea_bg_mid);
        // setBackgroundDrawable(getResources().getDrawable(R.drawable.choosearea_bg_left));
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
/*public class ViewMiddle extends LinearLayout implements ViewBaseAction {

	private ListView regionListView;
	private ListView plateListView;
	private ArrayList<String> groups = new ArrayList<String>();
	private LinkedList<String> childrenItem = new LinkedList<String>();
	private SparseArray<LinkedList<String>> children = new SparseArray<LinkedList<String>>();
	private TextAdapter plateListViewAdapter;
	private TextAdapter earaListViewAdapter;
	private OnSelectListener mOnSelectListener;
	private int tEaraPosition = 0;
	private int tBlockPosition = 0;
	private String showString = "不限";

	public ViewMiddle(Context context) {
		super(context);
		init(context);
	}

	public ViewMiddle(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_region, this, true);
		regionListView = (ListView) findViewById(R.id.listView);
		plateListView = (ListView) findViewById(R.id.listView2);
		setBackgroundResource(R.drawable.choosearea_bg_mid);

		for (int i = 0; i < 10; i++) {
			groups.add(i + "行");
			LinkedList<String> tItem = new LinkedList<String>();
			for (int j = 0; j < 15; j++) {

				tItem.add(i + "行" + j + "列");

			}
			children.put(i, tItem);
		}

		earaListViewAdapter = new TextAdapter(context, groups,
				R.drawable.choose_item_selected,
				R.drawable.choose_eara_item_selector);
		earaListViewAdapter.setTextSize(17);
		earaListViewAdapter.setSelectedPositionNoNotify(tEaraPosition);
		regionListView.setAdapter(earaListViewAdapter);
		earaListViewAdapter
				.setOnItemClickListener(new TextAdapter.OnItemClickListener() {

					@Override
					public void onItemClick(View view, int position) {
						if (position < children.size()) {
							childrenItem.clear();
							childrenItem.addAll(children.get(position));
							plateListViewAdapter.notifyDataSetChanged();
						}
					}
				});
		if (tEaraPosition < children.size())
			childrenItem.addAll(children.get(tEaraPosition));
		plateListViewAdapter = new TextAdapter(context, childrenItem,
				R.drawable.choose_item_right,
				R.drawable.choose_plate_item_selector);
		plateListViewAdapter.setTextSize(15);
		plateListViewAdapter.setSelectedPositionNoNotify(tBlockPosition);
		plateListView.setAdapter(plateListViewAdapter);
		plateListViewAdapter
				.setOnItemClickListener(new TextAdapter.OnItemClickListener() {

					@Override
					public void onItemClick(View view, final int position) {

						showString = childrenItem.get(position);
						if (mOnSelectListener != null) {

							mOnSelectListener.getValue(showString);
						}

					}
				});
		if (tBlockPosition < childrenItem.size())
			showString = childrenItem.get(tBlockPosition);
		if (showString.contains("不限")) {
			showString = showString.replace("不限", "");
		}
		setDefaultSelect();

	}

	public void setDefaultSelect() {
		regionListView.setSelection(tEaraPosition);
		plateListView.setSelection(tBlockPosition);
	}

	public String getShowText() {
		return showString;
	}

	public void setOnSelectListener(OnSelectListener onSelectListener) {
		mOnSelectListener = onSelectListener;
	}

	public interface OnSelectListener {
		public void getValue(String showText);
	}

	@Override
	public void hide() {

	}

	@Override
	public void show() {

	}
}*/
