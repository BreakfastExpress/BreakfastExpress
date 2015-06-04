package com.yuejiajun.BreakfastExpress.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yuejiajun.BreakfastExpress.R;
import com.yuejiajun.BreakfastExpress.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;


public class GuideActivity extends Activity implements OnClickListener,
        OnPageChangeListener {
    // 引导图片资源
    private static final int[] pics = {R.drawable.a1, R.drawable.a2,
            R.drawable.a3,};
    private ViewPager vp;
    private GuideAdapter vpAdapter;
    private List<View> views;
    private Button btn_loding_main;
    // 底部小点图片
    private ImageView[] dots;
    // 记录当前选中位置
    private int currentIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        views = new ArrayList<View>();
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // 初始化引导图片列表
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setBackgroundResource(pics[i]);
            views.add(iv);
        }
        vp = (ViewPager) findViewById(R.id.viewpager);
        // 初始化Adapter
        vpAdapter = new GuideAdapter(views);
        vp.setAdapter(vpAdapter);
        // 绑定回调
        vp.setOnPageChangeListener(this);
        initDots();
        btn_loding_main = (Button) findViewById(R.id.btn_loding_main);
        btn_loding_main.setVisibility(View.INVISIBLE);
        btn_loding_main.setOnClickListener(this);
        // 初始化底部小点
    }

    /**
     * 初始化页面指示器
     */
    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

        dots = new ImageView[pics.length];

        // 循环取得小点图片
        for (int i = 0; i < pics.length; i++) {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);// 都设为灰色
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);// 设置位置tag，方便取出与当前位置对应
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(false);// 设置为白色，即选中状态
    }

    /**
     * 设置当前的引导页
     */
    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        vp.setCurrentItem(position);
    }

    /**
     * 设置当前选中小点
     *
     * @param positon
     */
    private void setCurDot(int positon) {
        if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
            return;
        }

        dots[positon].setEnabled(false);
        dots[currentIndex].setEnabled(true);
        if (positon == pics.length - 1) {
            btn_loding_main.setVisibility(View.VISIBLE);
        } else {
            btn_loding_main.setVisibility(View.INVISIBLE);
        }
        currentIndex = positon;
    }

    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    // 当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int arg0) {
        // 设置底部小点选中状态
        setCurDot(arg0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_loding_main:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;

            default:
                break;
        }
        if ((Integer) v.getTag() != null) {
            int position = (Integer) v.getTag();
            setCurView(position);
            setCurDot(position);
        }

    }
}