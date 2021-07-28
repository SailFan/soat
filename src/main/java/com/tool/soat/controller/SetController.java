package com.tool.soat.controller;


import com.tool.soat.service.SetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/set")
public class SetController {
    @Resource
    SetService setService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "createSet",method = RequestMethod.POST)
    public String createSet(){
        return "test";
    }


}
