package com.tool.soat.controller;

import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.service.ChartService;
import com.tool.soat.service.InterfaceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/8/4 11:13 下午
 * @File: IndexController
 * @Software: IntelliJIDEA
 */

@RestController
@RequestMapping("/chart")
public class ChartController {

    @Resource
    ChartService chartService;

    @RequestMapping("/overview")
    public R overview(){
        try {
            Map<String, Integer> map = chartService.homeOverview();
            return new R(RHttpStatusEnum.SUCCESS.getCode(),map,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.SERVER_ERROR.getCode(),"",RHttpStatusEnum.SERVER_ERROR.getMessage());
        }
    }
}
