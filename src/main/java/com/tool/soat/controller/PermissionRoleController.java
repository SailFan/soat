package com.tool.soat.controller;


import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatRolesPermissions;
import com.tool.soat.service.PermissionService;
import com.tool.soat.service.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/rp")
public class PermissionRoleController {
    @Resource
    RolePermissionService PermissionService;



    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/addRP", method = RequestMethod.POST)
    public R addRP(@RequestBody Map<String,Object> map){
        try {
            Integer rid = (Integer) map.get("rid");
            List<Integer> pid = (List<Integer>) map.get("pid");
            System.out.println(pid);
            System.out.println(rid);
            PermissionService.roleRelationPermission(rid,pid);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.ADD_PERMISSION_ROLE_FAIL.getCode(), "",RHttpStatusEnum.ADD_PERMISSION_ROLE_FAIL.getMessage());
        }


    }
    @RequestMapping(value = "/removeRolePermission", method = RequestMethod.GET)
    public R removeRolePermission(Integer rid, Integer pid){
        try {
            PermissionService.removeRP(rid,pid);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());

        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.REMOVE_PR_FAIL.getCode(), "",RHttpStatusEnum.REMOVE_PR_FAIL.getMessage());
        }

    }
}
