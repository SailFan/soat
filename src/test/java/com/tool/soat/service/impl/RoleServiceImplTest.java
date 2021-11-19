package com.tool.soat.service.impl;

import com.tool.soat.entity.SoatPermission;
import com.tool.soat.entity.SoatRoles;
import com.tool.soat.service.AuthService;
import com.tool.soat.service.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleServiceImplTest {


    @Resource
    RoleService roleService;

    @Test
    void insertRole(){
        SoatRoles roles = new SoatRoles();
        roles.setRoleName("dev1");
        Integer role = roleService.insertRole(roles);
        System.out.println(role);

    }


    @Test
    void queryAllRolePer(){
        List<SoatRoles> roles = roleService.queryAllRolePer();
        System.out.println(roles);
    }
}