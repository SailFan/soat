package com.tool.soat.controller;


import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/getPermissionList", method = RequestMethod.GET)
    public R getPermissionList(){
        try {


            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.QUERY_ROLE_LIST_FAIL.getCode(), "",RHttpStatusEnum.QUERY_ROLE_LIST_FAIL.getMessage());
        }


    }
}
