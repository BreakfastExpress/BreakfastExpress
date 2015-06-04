package com.yuejiajun.BreakfastExpress.view.manager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.yuejiajun.BreakfastExpress.R;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;


/**
 * 中间容器的管理工具
 *
 * @author Administrator
 */
public class UIManager extends Observable {
    private static final String TAG = "UIManager";
    private static UIManager instance = new UIManager();
    /**
     * 中间内容显示容器，显示内容只需往里加Baseview
     */
    private RelativeLayout middleContainer;
    private Map<String, BaseView> VIEWCACHE = new HashMap<String, BaseView>();// 利用内存的空间换应用的执行时间
    private BaseView currentView;// 当前正在显示
    private LinkedList<String> HISTORY = new LinkedList<String>();

    private UIManager() {
    }

    public static UIManager getInstance() {
        return instance;
    }

    public void setMiddleContainer(RelativeLayout middleContainer) {
        this.middleContainer = middleContainer;
    }

    public BaseView getCurrentView() {
        return currentView;
    }

    /**
     * 问题：参数的传递
     */
    public void changeView(Class<? extends BaseView> targetClass, Bundle bundle) {

        // middleContainer.getChildAt(0)
        // 第一次切换
        // 比对：目标（targetClazz） VS 当前正在显示
        if (currentView != null && currentView.getClass() == targetClass) {
            return;
        }

        // 如果是第一次，创建该对象,并存储起来

        // targetClazz.getSimpleName(); 唯一标示
        String key = targetClass.getSimpleName();

        BaseView target = null;

        if (VIEWCACHE.containsKey(key)) {
            target = VIEWCACHE.get(key);
            target.setBundle(bundle);
        } else {
            try {
                Constructor<? extends BaseView> constructor = targetClass.getConstructor(Context.class, Bundle.class);
                target = constructor.newInstance(getContext(), bundle);

                VIEWCACHE.put(key, target);
            } catch (Exception e) {
                e.getCause();
                e.printStackTrace();
            }
        }

        Log.i(TAG, target.toString());

        // 当前界面要被回收：注销耗费资源操作
        if (currentView != null)
            currentView.onPause();

        // 需要增加参数：切换的目标
        middleContainer.removeAllViews();
        View view2 = target.getView();
        middleContainer.addView(view2);
        // 更新界面数据+注册耗费资源操作
        target.onResume();
        /** 动画*/
        view2.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ia_view_change));

        currentView = target;

        // 添加元素到返回键集合的顶部
        /** 如果该元素已经存在，移动该页面到顶部*/
        if (HISTORY.contains(key)) {
            HISTORY.remove(key);
            HISTORY.addFirst(key);
        } else {
            HISTORY.addFirst(key);
        }

        // 完成三个容器的联动

        changeTitleAndBottom();
    }

    private void changeTitleAndBottom() {
        setChanged();
        notifyObservers(currentView.getId());
    }


    public Context getContext() {
        return middleContainer.getContext();
    }

    /**
     * 返回键处理
     *
     * @return
     */
    public boolean goBack() {
        String key = "";
        if (HISTORY.size() > 0) {
            if (HISTORY.size() == 1) {
                return false;
            } else {
                HISTORY.removeFirst();
            }
            if (HISTORY.size() > 0) {
                key = HISTORY.getFirst();
            }

            if (StringUtils.isNotBlank(key)) {
                BaseView target = VIEWCACHE.get(key);

                currentView.onPause();
                middleContainer.removeAllViews();
                View view2 = target.getView();
                middleContainer.addView(view2);
                target.onResume();
                view2.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ia_view_change));

                // 记录当前正在显示界面的对象
                currentView = target;

                changeTitleAndBottom();
                return true;

            }

        }
        return false;
    }

    public void clear() {
        HISTORY.clear();

    }
}
