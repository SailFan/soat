package com.tool.soat.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Random_str {
    public static String RandomJianHan(int len) {
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBk"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        return ret;
    }
}





//    public static void main(String[] args) {
//        Random_str ran = new Random_str();
//        String content1 = ran.RandomJianHan(4);
//        System.out.println(content1);
//    }