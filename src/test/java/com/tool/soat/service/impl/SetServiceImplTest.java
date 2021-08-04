package com.tool.soat.service.impl;

import com.tool.soat.entity.SoatSet;
import com.tool.soat.service.SetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/8/1 12:19 上午
 * @File: SetServiceImplTest
 * @Software: IntelliJIDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SetServiceImplTest {

    @Resource
    SetService setService;
    @Test
    public void createSet() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        SoatSet set = new SoatSet(null,"测试集一",new Date(),new Date(),"刘文凡","刘文凡","http://www.baidu.com");
        setService.createSet(set);

    }


    @Test
    public void querySet() {
        SoatSet set = setService.querySet(2);
        System.out.println(set);

    }

    @Test
    public void upSet() {
        SoatSet set = new SoatSet(3,"测试集四",null,null,"刘文","刘1111111文","http://www.baidu.com");
        setService.upSet(set);

    }


    @Test
    public void delteSet() {
       setService.delteSet(2);

    }

    @Test
    public void timeTest(){
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        TimeZone.setDefault(timeZone);
        System.out.println(new Date());
    }


}