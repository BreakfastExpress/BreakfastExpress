package com.yuejiajun.BreakfastExpress.engine.impl;


import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.bean.User;
import com.yuejiajun.BreakfastExpress.engine.UserRegisterEngine;
import com.yuejiajun.BreakfastExpress.net.HttpClientUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * 用户注册的实现。
 *
 * @author Murphy
 */
public class UserRegisterEngineImpl implements UserRegisterEngine {

    @Override
    public String getUserRegisterInfoByList(User user) {
        // 联网获取数据
        // 1.设置参数
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put("username", user.getUserName());
        jsonMap.put("password", user.getPassword());
        jsonMap.put("mobile", String.valueOf(user.getPhoneNumber()));
        jsonMap.put("nickName", user.getNickName());


        // 界面收集
        // 数据库获取+配置文件
        // 2.访问网络
        HttpClientUtil util = new HttpClientUtil();
        String json = util.sendPost(ConstantValue.ZDDURI.concat("/register"), jsonMap);
        // 3数据处理
        // 获取处理结果(状态+数据)
        // 将服务器传回来的数据进行解析--转换成类是Map的格式
        try {
            JSONObject object = new JSONObject(json);
            return object.getString("response");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // 4数据持久化

        return null;
    }

}
