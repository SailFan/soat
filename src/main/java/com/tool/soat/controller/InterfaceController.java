package com.tool.soat.controller;

import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.service.AuthService;
import com.tool.soat.service.InterfaceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2022/7/16 22:02
 * @File: InterfaceController
 * @Software: IntelliJIDEA
 */


@RestController
@RequestMapping("/interface")
public class InterfaceController {


    @Resource
    InterfaceService interfaceService;
    @PostMapping("/addInterface")
    public R addInterface(@RequestBody Map<String,Object> map) {
        interfaceService.addInterfacce(map);
        return new R(RHttpStatusEnum.ADD_INTERFACE_FAIL_CODE.getCode(),"",RHttpStatusEnum.ADD_INTERFACE_FAIL_CODE.getMessage());
    }
}
//:auto-format="true"
//        :smart-indent="true"
//        :indent-unit="4"
//        :line-wrap="false"
//        ref="editor"