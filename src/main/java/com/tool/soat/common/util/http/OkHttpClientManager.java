package com.tool.soat.common.util.http;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2022/8/14 21:18
 * @File: OkHttpClientManager
 * @Software: IntelliJIDEA
 */
public class OkHttpClientManager {
    private static OkHttpClientManager instance;
    private OkHttpClient okHttpClient;

    OkHttpClientManager(){
        okHttpClient = new OkHttpClient();
    }

    public static OkHttpClientManager getInstance(){
        if(instance == null){
            synchronized (OkHttpClientManager.class){
                if (instance==null){
                    instance = new OkHttpClientManager();

                }
            }
        }
        return instance;
    }

    /**
     * 同步的get方法
     * @param url
     * @return
     * @throws IOException
     */
    private Response _getAsyn(String url) throws IOException {
        if (url == "" || url == null) {
            return null;
        }
        final Request build = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(build);
        Response response = call.execute();
        return response;
    }




    /**
     * 同步post方法， json参数
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    private Response _postAsyn(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json.toString());
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        return response;
    }

    /**
     *
     * 私有的post方法
     * @param url
     * @param map
     * @return
     * @throws IOException
     */
    private Response _postAsynWithFormdata(String url, HashMap<String, Object> map) throws IOException {
        MultipartBody.Builder body = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (String key : map.keySet()){
            body.addFormDataPart(key,(String) map.get(key));
        }

        Request requst = new Request.Builder()
                .url(url)
                .post(body.build())
                .build();
        Call call = okHttpClient.newCall(requst);
        Response response = call.execute();
        return response;
    }


    /***
     * X_WWW_Form_Urlencoded格式私有post方法，同步方法
     * @param url
     * @param content
     * @return
     * @throws IOException
     */
    private Response _postAsynX_WWW_Form_Urlencoded(String url, String content) throws IOException {

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response;
    }



    /**
     *
     * post 方法使用json 向外暴露的方法
     * @param url
     * @param json
     * @return
     * @throws IOException
     */

    public Response postAsynWithJson(String url, String json) throws IOException {
        return getInstance()._postAsyn(url, json);
    }


    /**
     *
     * post 向外暴露的方法， X_WWW_Form_Urlencoded 格式
     * @param url
     * @param map
     * @return
     * @throws IOException
     */

    public Response postAsynX_WWW_Form_Urlencoded(String url, HashMap<String,Object> map) throws IOException {
        String content = "key1=value2&key2=value2&key3=value3";
        return getInstance()._postAsynX_WWW_Form_Urlencoded(url, content);
    }




    /**
     *
     * 向外暴露的get方法
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public Response getAsyn(String url,LinkedHashMap<String,Object> params) throws IOException {
        String endUrl = generateUrl(url, params);
        return getInstance()._getAsyn(endUrl);
    }


    /**
     *
     * post formdata 对外暴露的方法
     * @param url
     * @param map
     * @return
     * @throws IOException
     */

    public Response postAsynWithFormdata(String url,LinkedHashMap<String,Object> map) throws IOException {
        return getInstance()._postAsynWithFormdata(url,map);
    }


    /**
     *
     * generating url
     * @param url
     * @param linkedHashMap
     * @return
     */
    public String generateUrl(String url, LinkedHashMap<String, Object> linkedHashMap){
        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder();
        if (!(linkedHashMap==null || linkedHashMap.isEmpty())){
            for(String key: linkedHashMap.keySet()){
                builder.addQueryParameter(key, (String) linkedHashMap.get(key));
            }
        }
        String newUrl = builder.build().toString();
        return newUrl;
    }


}
