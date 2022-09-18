package com.tool.soat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2022/9/18 20:04
 * @File: TestContoller
 * @Software: IntelliJIDEA
 */
@RequestMapping("/test")
@RestController
public class TestContoller {
    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/testGetRequest",method = RequestMethod.GET)
    public String testGetRequest(@RequestHeader Map<String, String> headers){
        logger.info("headers"+headers);
       return "success";
    }
}
