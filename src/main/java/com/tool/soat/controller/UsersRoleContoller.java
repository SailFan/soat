package com.tool.soat.controller;

import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatSet;
import com.tool.soat.entity.SoatUsersRoles;
import com.tool.soat.service.RoleUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/ur")
public class UsersRoleContoller {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    RoleUserService roleUserService;

    @RequestMapping(value = "/delUR", method = RequestMethod.GET)
    public R delUR(@RequestBody SoatUsersRoles soatUsersRoles){
        try {
            roleUserService.removeUserRole(soatUsersRoles);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.ADD_UR_FAIL.getCode(),  "",RHttpStatusEnum.ADD_UR_FAIL.getMessage());
        }
    }

    @RequestMapping(value = "/addUR", method = RequestMethod.GET)
    public R addUR(Integer uId, Integer rId){
        try {
            roleUserService.cCurrentRole(uId, rId);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.REMOVE_UR_FAIL.getCode(), "",RHttpStatusEnum.REMOVE_UR_FAIL.getMessage());
        }
    }

    @RequestMapping(value = "/getCurrentRole")
    public R getCurrentRole(Integer uid){
        try {
            String s = roleUserService.currentRole(uid);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),s,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.GET_CURRENT_ROLE_FAIL.getCode(), "",RHttpStatusEnum.GET_CURRENT_ROLE_FAIL.getMessage());
        }
    }



}
