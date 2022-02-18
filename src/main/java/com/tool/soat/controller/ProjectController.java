package com.tool.soat.controller;


import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public R createProject(@RequestBody Map<String, Object> map){
        System.out.println(map);
        return new R(RHttpStatusEnum.CREATE_PROJECT_ERROR.getCode(), "",RHttpStatusEnum.CREATE_PROJECT_ERROR.getMessage());
    }

}

