package com.yuejiajun.BreakfastExpress.net;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceUtil {
    /**
     * 检查是否成功的从服务拿到正确的json文件
     *
     * @param json 从服务器拿到的数据
     * @return true：成功的拿到的正确的数据，false：获取失败
     */
    public static boolean checkResponse(JSONObject json) {
        try {
            String resposne = json.getString("response");
            if ("error".equals(resposne)) {
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

}
