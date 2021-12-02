package com.tool.soat.controller;


import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatNav;
import com.tool.soat.entity.SoatRoles;
import com.tool.soat.entity.SoatSet;
import com.tool.soat.service.RoleService;
import com.tool.soat.service.SetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.roles;

@RestController
@RequestMapping("/role")
public class RolesController {
    @Resource
    RoleService roleService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
    public R getRoleList(){
        try {
            List<SoatRoles> roles = roleService.queryAllRolePer();
            System.out.println(roles);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),roles,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.QUERY_ROLE_LIST_FAIL.getCode(), "",RHttpStatusEnum.QUERY_ROLE_LIST_FAIL.getMessage());
        }

    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST,consumes="application/json")
    public R addRole(@RequestBody SoatRoles soatRoles){
        try {
            Integer integer = roleService.insertRole(soatRoles);
            if (integer!=1){
                return new R(RHttpStatusEnum.ADD_ROLE_FAIL.getCode(),  "",RHttpStatusEnum.ADD_ROLE_FAIL.getMessage());
            }
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.ADD_ROLE_FAIL.getCode(), "",RHttpStatusEnum.ADD_ROLE_FAIL.getMessage());
        }
    }

    @RequestMapping(value = "/editRole", method = RequestMethod.POST,consumes="application/json")
    public R editRole(@RequestBody SoatRoles soatRoles){
        try {
            roleService.updateCurrentRole(soatRoles);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.EDIT_ROLE_FAIL.getCode(), "",RHttpStatusEnum.EDIT_ROLE_FAIL.getMessage());
        }
    }

    @RequestMapping(value = "/delRole")
    public R delRole(Integer rid){
        try {
            roleService.removeRoleAllRelation(rid);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.DEL_ROLE_FAIL.getCode(), "",RHttpStatusEnum.DEL_ROLE_FAIL.getMessage());
        }
    }

    @RequestMapping(value = "/getRole", method = RequestMethod.GET)
    public R getRole(Integer rid){
        try {
            SoatRoles roles = roleService.queryRole(rid);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),roles,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.QUERY_ROLE_FAIL.getCode(), "",RHttpStatusEnum.QUERY_ROLE_FAIL.getMessage());
        }

    }

    @RequestMapping(value = "/getRolePermissions", method = RequestMethod.GET)
    public R getRolePermissions(Integer rid){
        try {
            List<Integer> integers = roleService.queryPermission(rid);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),integers,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.QUERY_ASSIGN_ROLE_PERMISSION_FAIL.getCode(), "",RHttpStatusEnum.QUERY_ASSIGN_ROLE_PERMISSION_FAIL.getMessage());
        }
    }

}

