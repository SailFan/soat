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
            for (SoatRoles role: roles) {
                System.out.println(role);
            }

            return new R(RHttpStatusEnum.SUCCESS.getCode(),roles,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.QUERY_ROLE_LIST_FAIL.getCode(), "",RHttpStatusEnum.QUERY_ROLE_LIST_FAIL.getMessage());
        }


    }

}
