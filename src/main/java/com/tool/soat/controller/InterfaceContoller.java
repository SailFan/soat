package com.tool.soat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("interfaceApi")
public class InterfaceContoller {

    @RequestMapping("/interfaceContoller")
    public String interfaceContoller(){
        return "sets/interface";
    }
}
