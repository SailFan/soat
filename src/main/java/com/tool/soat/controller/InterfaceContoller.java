package com.tool.soat.controller;

import com.tool.soat.common.vo.R;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.service.InterfaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("interfaceApi")
public class InterfaceContoller {
    @Resource
    InterfaceService interfaceService;



    @RequestMapping("/interfaceIndex")
    public String interfaceIndex(){
        return "sets/interface";
    }


    @RequestMapping(value = "/insertInterface", method = RequestMethod.POST)
    @ResponseBody
    public R insertInterface(@RequestBody SoatInterface soatInterface){
        soatInterface.setRun(0);
        System.out.println(soatInterface);
        interfaceService.insertInterface(soatInterface);

        return new R();
    }


}



