package com.tool.soat.common.util.http;

import com.tool.soat.entity.SoatHeaders;
import com.tool.soat.entity.SoatParams;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2022/8/14 21:18
 * @File: OkHttpClientManager
 * @Software: IntelliJIDEA
 */
public class OkHttpClientManager {

    Logger logger = LoggerFactory.getLogger(getClass());
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
    private Response _getAsyn(String url,Headers headers) throws IOException {
        if (url == "" || url == null) {
            return null;
        }
        final Request build = new Request.Builder().url(url).headers(headers).build();
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
    public Response getsyn(String url,List<SoatParams> params,List < SoatHeaders > list) throws IOException {
        logger.info("执行同步GET方法，Service传来的url为 "+ url, "Service传来的params为" + params,"Service传来的list为"+list);
        String endUrl = generateUrl(url, params);
        Headers headers = setHeaders(list);
        return getInstance()._getAsyn(endUrl,headers);
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
     * @param params
     * @return
     */
    public String generateUrl(String url, List<SoatParams> params){
        logger.info("invoke generateUrl method");
        logger.info("生成url链接，原始url "+url,"生成url链接，请求参数为 "+params);
        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder();
        if(params.size()>1){
            for (SoatParams soatParams: params)
                builder.addQueryParameter(soatParams.getKey(), (String) soatParams.getValue());
        }
        String newUrl = builder.build().toString();
        logger.info("generateNewUrl generate "+ newUrl);
        return newUrl;
    }

    public  Headers setHeaders(List<SoatHeaders> list){
        logger.info("invoke setHeaders method");
        okhttp3.Headers.Builder headersbuilder = new okhttp3.Headers.Builder();
        if (!list.isEmpty()){
            for (SoatHeaders soatHeaders: list)
                headersbuilder.add(soatHeaders.getKey(), (String) soatHeaders.getValue());
            }
        Headers headers = headersbuilder.build();
        logger.info("生成的请求头为"+headers);
        return headers;
    }


}
