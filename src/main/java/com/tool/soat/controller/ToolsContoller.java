package com.tool.soat.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/tools")
public class ToolsContoller {

    @RequestMapping("/generateCode")
    public Set<String> generateCode(){
        return null;
    }
}
