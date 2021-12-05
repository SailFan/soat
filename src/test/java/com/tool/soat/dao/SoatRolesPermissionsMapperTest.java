package com.tool.soat.dao;

import com.tool.soat.entity.SoatRolesPermissions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SoatRolesPermissionsMapperTest {
    @Resource
    SoatRolesPermissionsMapper soatRolesPermissionsMapper;


    @Test
    public void test1(){
        SoatRolesPermissions permissions = new SoatRolesPermissions(4,4);
//        int i = soatRolesPermissionsMapper.insertOneRP(permissions);
//        System.out.println(i);
    }

}