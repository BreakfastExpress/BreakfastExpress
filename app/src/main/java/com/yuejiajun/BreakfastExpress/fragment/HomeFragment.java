package com.yuejiajun.BreakfastExpress.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.view.ExpandTabView;
import com.yuejiajun.BreakfastExpress.view.ViewLeft;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private ExpandTabView expandTabView;
    private ArrayList<View> mViewArray = new ArrayList<View>();
    private ViewLeft viewLeft;
    private ViewLeft viewMiddle;
    private ViewLeft viewRight;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home_tab, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initVaule();
        initListener();
    }

    private void initView() {

        expandTabView = (ExpandTabView) getView().findViewById(
                R.id.expandtab_view);
        listView = (ListView) getView().findViewById(R.id.lv_mineListview);
        viewLeft = new ViewLeft(getActivity());
        viewMiddle = new ViewLeft(getActivity());
        viewRight = new ViewLeft(getActivity());
//		viewMiddle = new ViewMiddle(getActivity());
//		viewRight = new ViewRight(getActivity());

    }

    private void initVaule() {

        mViewArray.add(viewLeft);
        mViewArray.add(viewMiddle);
        mViewArray.add(viewRight);
        ArrayList<String> mTextArray = new ArrayList<String>();
        mTextArray.add(ConstantValue.ORDER);
        mTextArray.add(ConstantValue.RESTAURANT);
        mTextArray.add(ConstantValue.FILTER);
        expandTabView.setValue(mTextArray, mViewArray);

		/*
		 * expandTabView.setTitle(viewLeft.getShowText(), 0);
		 * expandTabView.setTitle(viewMiddle.getShowText(), 1);
		 * expandTabView.setTitle(viewRight.getShowText(), 2);
		 */

    }

    private void initListener() {

        viewLeft.setOnSelectListener(new ViewLeft.OnSelectListener() {

            @Override
            public void getValue(String distance, String showText) {
                onRefresh(viewLeft, showText);
            }
        });

        viewMiddle.setOnSelectListener(new ViewLeft.OnSelectListener() {

            @Override
            public void getValue(String distance, String showText) {

                onRefresh(viewMiddle, showText);

            }
        });

        viewRight.setOnSelectListener(new ViewLeft.OnSelectListener() {

            @Override
            public void getValue(String distance, String showText) {
                onRefresh(viewRight, showText);
            }
        });

    }

    private void onRefresh(View view, String showText) {

        expandTabView.onPressBack();
        int position = getPositon(view);
        if (position >= 0 && !expandTabView.getTitle(position).equals(showText)) {
            expandTabView.setTitle(showText, position);
        }
        Toast.makeText(getActivity(), showText, Toast.LENGTH_SHORT).show();

    }

    private int getPositon(View tView) {
        for (int i = 0; i < mViewArray.size(); i++) {
            if (mViewArray.get(i) == tView) {
                return i;
            }
        }
        return -1;
    }

}
