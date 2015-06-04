package com.yuejiajun.BreakfastExpress.view.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.yuejiajun.BreakfastExpress.net.NetWorkUtil;
import com.yuejiajun.BreakfastExpress.utils.PromptManager;


public abstract class BaseView implements View.OnClickListener {
    protected Context context;
    protected Bundle bundle;
    protected SharedPreferences sp;
    protected ViewGroup showView;

    // 构造方法
    // 模板方法
    public BaseView(Context context, Bundle bundle) {
        super();
        this.context = context;
        this.bundle = bundle;
        init();
        setListener();
    }

    /**
     * 中间容器需要显示的内容
     *
     * @return
     */
    public View getView() {
        // LayoutParams 类型LinearLayout？
        // 原则：不是依据layout配置文件中设置LinearLayout
        // 看需要将LinearLayout添加到那个父容器里面（RelativeLayout）

        if (showView.getLayoutParams() == null) {
            // (RelativeLayout.LayoutParams)
            // child.getLayoutParams();如果设置成其他的layout，有可能会抛出类型转换的异常
            showView.setLayoutParams(new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.FILL_PARENT,
                    RelativeLayout.LayoutParams.FILL_PARENT));
        }
        return showView;
    }

    /**
     * 每个BaseView的子类都有一个唯一的标示
     *
     * @return
     */
    public abstract int getId();

    /**
     * 初始化
     *
     * @return
     */
    protected abstract void init();

    /**
     * 设置监听
     *
     * @return
     */
    protected abstract void setListener();

    @Override
    public void onClick(View v) {
    }

    protected View findViewById(int resId) {
        return showView.findViewById(resId);
    }

    // 调用类：UIManager(addView removeView)

    /**
     * 当界面加载完成(addView之后)，更行或耗时操作
     */
    public void onResume() {
        /** 设置默认监听, 防止遗留的监听事件影响 */

        /** 界面显示的时候设置左右两边button的点击事件 */
        setTitleClickListener();

        /** 当界面显示时，显示自己定义的文本 */
        setTitleContent();
    }

    /**
     * 当要回收到界面的时候（removeView之前），取消掉耗时的操作
     */
    public void onPause() {
    }

    // Fragment

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    /**
     * 设置标题左右两边按钮的监听 默认设置为null
     */
    protected abstract void setTitleClickListener();

    /**
     * 设置中间TextView文本 和 左右两边button的文本
     */
    protected abstract void setTitleContent();

    /**
     * 访问网络的异步任务
     *
     * @param <Params>
     * @author Administrator
     */
    protected abstract class MyHttpTask<Params, Result> extends
            AsyncTask<Params, Void, Result> {
        /**
         * 在原有的execute方法上增加了判断网络状态的功能
         *
         * @param params
         * @return
         */
        public final AsyncTask<Params, Void, Result> executeProxy(
                Params... params) {
            if (NetWorkUtil.checkNetWork(context)) {
                return super.execute(params);
            } else {
                PromptManager.showNoNetWork(context);
            }
            return null;
        }
    }

}
