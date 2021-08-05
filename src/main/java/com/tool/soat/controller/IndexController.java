package com.tool.soat.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/8/4 11:13 下午
 * @File: IndexController
 * @Software: IntelliJIDEA
 */

public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
