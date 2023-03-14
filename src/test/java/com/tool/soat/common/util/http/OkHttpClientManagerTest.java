package com.tool.soat.common.util.http;

import com.tool.soat.entity.SoatParams;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.Test;
import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description:
 * @Author: 凡子
 * @CreateTime: 2022/9/18 20:31
 * @File: OkHttpClientManagerTest
 * @Software: IntelliJIDEA
 */
class OkHttpClientManagerTest {

    @Test
    void testHttpGetSyn() {
        String url= "http://127.0.0.1:8082/test/testGetRequest";
        ArrayList<SoatParams> list = new ArrayList<>();
        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder();
        if(list.size()>1){
            for (SoatParams soatParams: list)
                builder.addQueryParameter(soatParams.getKey(), (String) soatParams.getValue());
        }
        String newUrl = builder.build().toString();
//        logger.info("generateNewUrl generate"+ newUrl);
        System.out.println(newUrl);
    }
}