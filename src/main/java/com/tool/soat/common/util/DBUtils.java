package com.tool.soat.common.util;




import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    public static final Integer DEFAULT_DB_NUM = 10;

    public static final Integer DEFAULT_TABLE_NUM = 100;

    public static final String DB_PREFIX = "";

    /**
     * 根据 routingKey 获取 库index
     * @param routingKey routingKey
     * @return
     * @throws RuntimeException
     */
    public static String getDBIndex(Long routingKey) throws RuntimeException{
        if (routingKey == null || routingKey <= 0){
            throw new RuntimeException("getDBIndex error, routingKey Not Less than 0");
        }
        if (DEFAULT_DB_NUM < 1){
            throw new RuntimeException("getDBIndex error, DEFAULT_DB_NUM Not Less than 1");
        }
        return  "db"+getIndex(routingKey, DEFAULT_DB_NUM);
    }

    /**
     * 根据 routingKey 获取 库index
     * @param routingKey routingKey
     * @return String
     * @throws RuntimeException
     */
    public static String getDBIndex(String routingKey) throws RuntimeException{
        return DB_PREFIX + getIndex(routingKey, DEFAULT_DB_NUM);
    }


    /**
     * 根据 routingKey 获取表index
     * tableNum 默认是100
     *
     * @param routingKey 路由键
     * @return
     */
    public static Integer getTableIndex(Long routingKey){
        return getTableIndex(routingKey, DEFAULT_TABLE_NUM);
    }

    /**
     * 根据 routingKey 获取表index
     * tableNum 默认是100
     *
     * @param routingKey 路由键
     * @return
     */
    public static Integer getNoSplitDbTableIndex(Long routingKey){
        if (routingKey == null || routingKey <= 0) {
            throw new RuntimeException("getTableIndex error, routingKey Not Less than 0");
        }
        return (int)(routingKey % DEFAULT_TABLE_NUM);
    }

    /**
     * 根据 String类型的 routingKey 获取表index
     * tableNum 默认是100
     *
     * @param routingKey 路由键
     * @return
     */
    public static Integer getTableIndex(String routingKey){
        return getTableIndex(routingKey, DEFAULT_TABLE_NUM);
    }


    /**
     * 根据 routingKey 获取表index
     *
     * @param routingKey 路由键
     * @param tableNum 表数量
     * @return
     */
    public static Integer getTableIndex(Long routingKey, Integer tableNum){
        if (tableNum == null || tableNum <= 0){
            throw new RuntimeException("getTableIndex error, tableNum Less than or equal to 0");
        }
        if (routingKey == null || routingKey <= 0) {
            throw new RuntimeException("getTableIndex error, routingKey Not Less than 0");
        }
        if (routingKey < 10){
            return 0;
        }
        String routingKeyStr = routingKey.toString();
        int routingKeyStrLength = routingKeyStr.length();
        if (routingKey < 100){
            String substring = routingKeyStr.substring(routingKeyStrLength - 2, routingKeyStrLength-1);
            return Integer.parseInt(substring);
        }
        String substring = routingKeyStr.substring(routingKeyStrLength - 3, routingKeyStrLength-1);
        return Integer.parseInt(substring);
    }


    /**
     * 根据 routingKey 获取表index, routingKey是String类型
     *
     * @param routingKey 路由键
     * @param tableNum   表数量
     * @return Integer
     */
    public static Integer getTableIndex(String routingKey, Integer tableNum) {
        return getIndex(routingKey, tableNum);
    }



    /**
     * 统一生成路由规则
     *
     * @param routingKey 路由键
     * @param num  表数量
     * @return
     */
    private static Integer getIndex(Long routingKey, Integer num){
        if (routingKey <= num - 1){
            return 0;
        }
        return (int)(routingKey % num);
    }

    /**
     * 获取以String为Key的路由键
     * 计算规则是按照HashMap的计算规则写的
     *
     * @param routingKey String 类型路由键
     * @param num  库/表数量
     * @return
     */
    private static Integer getIndex(String routingKey, Integer num){
        if (StringUtils.isBlank(routingKey)){
            throw new RuntimeException("routingKey is Not Empty");
        }
        return Math.abs(hash(routingKey.trim())) % num;
    }

    /**
     * 获取以String类型为routingKey的hash值
     * 这个方法是按照 HashMap中的hash计算规则写的
     *
     * @param key
     * @return
     */
    private static int hash(String key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public static void main(String[] args) {

//        String key = "jingkang.du@asiainnovations.com";
//        String key = "test10400000@asiainnovations.com";
//        System.out.println( getDBIndex(key));
//        System.out.println(getTableIndex(key));


//        List<Long> a = new ArrayList<>();
////        a.add(0L);
//        a.add(357L);
//        a.add(1007L);
//        a.add(1017L);
//        a.add(1027L);
//        a.add(1037L);
//        a.add(1047L);
//        a.add(1057L);
//        a.add(1067L);
//        a.add(1077L);
//        a.add(1087L);
//        a.add(1097L);
//        a.add(1107L);
//        a.add(1997L);
//        a.add(1L);
//        a.add(10L);
//        a.add(50L);
//        a.add(88L);
//        a.add(99L);
//        a.add(100L);
//        a.add(101L);
//        a.add(500L);
//        a.add(9999999999999L);
//        a.add(1111111111111L);
//        a.add(1234567898765L);
//
////        for (Long aLong : a) {
////            try {
////                String dbIndex = getDBIndex(aLong);
////                System.out.println( "key: " + aLong + " dbIndex:" +dbIndex);
////            }catch (Exception e){
////                e.printStackTrace();
////            }
////        }
//
//
//        for (Long aLong : a) {
//            try {
//                Integer dbIndex = getTableIndex(aLong,100);
//                System.out.println( "table key: " + aLong + " table:" +dbIndex );
//            }catch (Exception e){
//                System.out.println("table key error ");
//                e.printStackTrace();
//            }
//        }

//        Integer dbIndex10 = getTableIndex(10L,100);
//        System.out.println( "table key: " + 10 + " table:" +dbIndex10 );
//
//        long b = 01;
//        for (int i = 0; i < 159; i++) {
//
//            Integer dbIndex = getTableIndex(b,100);
//            System.out.println( "table key: " + b + " table:" +dbIndex );
//            b+=10;
//        }
//
//
//        long a = 1007;
//        for (int i = 0; i < 159; i++) {
//
//            Integer dbIndex = getTableIndex(a,100);
//            System.out.println( "table key: " + a + " table:" +dbIndex );
//            a+=10;
//        }



        List<String> stringKey = new ArrayList<>();
//        stringKey.add("aaaaaaaaaaaaa");
//        stringKey.add("b");
//        stringKey.add("c");
//        stringKey.add("asdhsdf89ds894jkdsioew90dsjk");
        for (int i = 0; i < 1000000; i++) {
            String a= i+"wangchuanlu";
            stringKey.add(a);
        }


        int[] n = new int[10];

        for (String dbKey : stringKey) {
            try {
                String dbIndex = getDBIndex(dbKey);
//                System.out.println( "key: " + dbKey + " dbIndex: " +dbIndex);
//                int ca = Integer.parseInt(dbIndex.substring(2));
                switch (dbIndex){
                    case "db0": {
                        n[0]++;break;
                    }
                    case "db1": {
                        n[1]++;break;
                    }
                    case "db2": {
                        n[2]++;break;
                    }
                    case "db3": {
                        n[3]++;break;
                    }
                    case "db4": {
                        n[4]++;break;
                    }
                    case "db5": {
                        n[5]++;break;
                    }
                    case "db6": {
                        n[6]++;break;
                    }
                    case "db7": {
                        n[7]++;break;
                    }
                    case "db8": {
                        n[8]++;break;
                    }
                    case "db9": {
                        n[9]++;break;
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("db"+i+"数量: "+ n[i]);
        }

//        for (String tableKey : stringKey) {
//            try {
//                Integer dbIndex = getTableIndex(tableKey,100);
//                System.out.println( "table key: " + tableKey + " table: " +dbIndex);
//            }catch (Exception e){
//                System.out.println("table key error ");
//                e.printStackTrace();
//            }
//        }
    }
}
