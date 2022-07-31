package com.tool.soat.controller;



import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/tools")
public class ToolsContoller {

    @RequestMapping("/generateCode")
    public Set<String> generateCode(){
        return null;
    }

    @RequestMapping(value = "/getAccountLink", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public R getAccountLink(@RequestBody Map<String, Object> map){
        return new R(RHttpStatusEnum.SUCCESS.getCode(),  "",RHttpStatusEnum.SUCCESS.getMessage());
    }
}
