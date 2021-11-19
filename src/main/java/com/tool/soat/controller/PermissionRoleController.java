package com.tool.soat.controller;


import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("/rp")
public class PermissionRoleController {
    @Resource
    PermissionService PermissionService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/rolepermission", method = RequestMethod.POST)
    public R getPermissionList(){
        try {
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.QUERY_PERMISSIONS_FAIL.getCode(), "",RHttpStatusEnum.QUERY_PERMISSIONS_FAIL.getMessage());
        }


    }
}
