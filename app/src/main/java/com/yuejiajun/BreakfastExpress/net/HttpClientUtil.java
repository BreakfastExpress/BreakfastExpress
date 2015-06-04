package com.yuejiajun.BreakfastExpress.net;


import com.yuejiajun.BreakfastExpress.ConstantValue;
import com.yuejiajun.BreakfastExpress.GlobalParams;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Lee on 2015/5/13.
 */
public class HttpClientUtil {
    private HttpClient client;
    private HttpGet get;
    private HttpPost post;

    private HttpRequest request;
    private HttpResponse response;
//    private static Header[] headers;

/*    static {
        headers = new BasicHeader[10];
        headers[0] = new BasicHeader("Appkey", "");
        headers[1] = new BasicHeader("Udid", "");
        headers[2] = new BasicHeader("Os", "android");
        headers[3] = new BasicHeader("Osversion", "");
        headers[4] = new BasicHeader("Appversion", "");
        headers[5] = new BasicHeader("Sourceis", "");
        headers[6] = new BasicHeader("Ver", "");
        headers[7] = new BasicHeader("Userid", "");
        headers[8] = new BasicHeader("Userseesion", "");
        headers[9] = new BasicHeader("Unique", "");
    }*/

    public HttpClientUtil() {
        client = new DefaultHttpClient();
        if (StringUtils.isNotBlank(GlobalParams.PROXY_IP)) {
            HttpHost host = new HttpHost(GlobalParams.PROXY_IP, GlobalParams.PROXY_PORT);
            client.getParams();
        }
    }

    /**
     * 发送post请求
     *
     * @param params
     * @param uri    ַ
     */
    public String sendPost(String uri, Map<String, String> params) {
        post = new HttpPost(uri);
//        post.setHeaders(headers);
        HttpParams httpParams;
        httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 8000);
        HttpConnectionParams.setSoTimeout(httpParams, 8000);
        post.setParams(httpParams);
        if (params != null && params.size() > 0) {
            List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
            for (Map.Entry<String, String> item : params.entrySet()) {
                BasicNameValuePair pair = new BasicNameValuePair(item.getKey(), item.getValue());
                parameters.add(pair);
            }
            try {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, ConstantValue.ENCONDING);
                post.setEntity(entity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), ConstantValue.ENCONDING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送get请求
     *
     * @param uri
     */
    public String sendGet(String uri) {
        get = new HttpGet(uri);
//        get.setHeaders(headers);
        try {
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), ConstantValue.ENCONDING);
            } else {
                System.out.print(response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
