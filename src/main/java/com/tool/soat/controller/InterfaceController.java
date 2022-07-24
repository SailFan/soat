package com.tool.soat.controller;

import com.tool.soat.common.util.SoatJWTUtil;
import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.entity.SoatUsers;
import com.tool.soat.service.AuthService;
import com.tool.soat.service.InterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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

    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    InterfaceService interfaceService;

    @Resource
    AuthService authService;

    @PostMapping("/addInterface")
    public R addInterface(@RequestBody Map<String,Object> map, HttpServletRequest httpServletRequest) {
        try {
            String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));
            SoatUsers users = authService.queryEmail(email);
            interfaceService.addInterfacce(map,users.getNickname());
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.ADD_INTERFACE_FAIL_CODE.getCode(),"",RHttpStatusEnum.ADD_INTERFACE_FAIL_CODE.getMessage());
        }

    }

    @GetMapping("/getAllInterface")
    public R getAllInterface(HttpServletRequest httpServletRequest) {
        String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));
        SoatUsers users = authService.queryEmail(email);
        Integer pageSize = new Integer(httpServletRequest.getParameter("pageSize"));
        Integer currentPage = new Integer(httpServletRequest.getParameter("currentPage"));
        List<SoatInterface> anInterface = interfaceService.getInterface(currentPage, pageSize, users.getNickname());
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", anInterface.size());
        map.put("anInterface", anInterface);
        System.out.println("map1"+map);
        return new R(RHttpStatusEnum.SUCCESS.getCode(),map,RHttpStatusEnum.SUCCESS.getMessage());
    }

    @GetMapping("/runInterface")
    public R runInterface(HttpServletRequest httpServletRequest) {

        return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
    }


}
