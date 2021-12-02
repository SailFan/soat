package com.tool.soat.controller;


import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatNav;
import com.tool.soat.entity.SoatSet;
import com.tool.soat.service.NavService;
import com.tool.soat.service.SetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nav")
public class NavController {
    @Resource
    NavService navService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping (value = "/getNav")
    public R getNav(){
        try {
            List<SoatNav> navs =  navService.queryNavS();
            return new R(RHttpStatusEnum.SUCCESS.getCode(),navs,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug(String.valueOf(e));
            return new R(RHttpStatusEnum.NAV_QUERY_FAIL.getCode(), "",RHttpStatusEnum.NAV_QUERY_FAIL.getMessage());
        }


    }


}
