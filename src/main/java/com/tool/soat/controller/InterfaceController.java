package com.tool.soat.controller;

import com.tool.soat.common.util.SoatJWTUtil;
import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatHeaders;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.entity.SoatUsers;
import com.tool.soat.service.AuthService;
import com.tool.soat.service.InterfaceService;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import java.util.ArrayList;
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
            Integer projectId = Integer.valueOf((String) map.get("projectId"));
            Map<String, Object> base = (Map<String, Object>) map.get("baseData");
            String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));
            SoatUsers users = authService.queryEmail(email);
            interfaceService.addInterfacce(map,users.getNickname(),projectId);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.ADD_INTERFACE_FAIL_CODE.getCode(),"",RHttpStatusEnum.ADD_INTERFACE_FAIL_CODE.getMessage());
        }

    }

    @GetMapping("/getAllInterface")
    public R getAllInterface(HttpServletRequest httpServletRequest) {
        try {
        String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));
        SoatUsers users = authService.queryEmail(email);
        Integer pageSize = new Integer(httpServletRequest.getParameter("pageSize"));
        Integer currentPage = new Integer(httpServletRequest.getParameter("currentPage"));
        Integer projectId = new Integer(httpServletRequest.getParameter("projectId"));
        List<SoatInterface> anInterface = interfaceService.getInterface(currentPage, pageSize, users.getNickname(),projectId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", anInterface.size());
        map.put("anInterface", anInterface);
        return new R(RHttpStatusEnum.SUCCESS.getCode(),map,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.INTERFACE_LIST_FAIL.getCode(),"",RHttpStatusEnum.INTERFACE_LIST_FAIL.getMessage());
        }

    }

    @RequestMapping(value = "/runInterface", method = {RequestMethod.GET})
    public R runInterface(HttpServletRequest httpServletRequest) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        Integer value = Integer.valueOf(httpServletRequest.getParameter("id"));
        try {
            Response  response = interfaceService.runOneInterface(value);
            map.put("code",response.code());
            map.put("response",response.body().string());
            return new R(RHttpStatusEnum.SUCCESS.getCode(),map,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.INTERFACE_DEL_FAIL.getCode(),"",RHttpStatusEnum.INTERFACE_DEL_FAIL.getMessage());
        }

    }


    @RequestMapping(value = "/delOneInterface", method = {RequestMethod.GET})
    public R delOneInterface(HttpServletRequest httpServletRequest) {
          String id = httpServletRequest.getParameter("id");
          Integer value = Integer.valueOf(id);
          try {
              interfaceService.delOneSoatInterface(value);
              return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
          }catch (Exception e){
              return new R(RHttpStatusEnum.INTERFACE_DEL_FAIL.getCode(),"",RHttpStatusEnum.INTERFACE_DEL_FAIL.getMessage());
          }

    }


    @RequestMapping(value = "/getOneInterface", method = {RequestMethod.GET})
    public R getOneInterface(HttpServletRequest httpServletRequest) {
        String id = httpServletRequest.getParameter("id");
        Integer value = Integer.valueOf(id);
        try {
            SoatInterface soatInterface = interfaceService.getOneSoatInterface(value);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),soatInterface,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.GET_ONE_INTERFACE_FAIL.getCode(),"",RHttpStatusEnum.GET_ONE_INTERFACE_FAIL.getMessage());
        }

    }


    @RequestMapping(value = "/generateDefaultHeaders", method = {RequestMethod.GET})
    public R generateDefaultHeaders() {
        try {
            SoatHeaders soatHeaders = new SoatHeaders();
            soatHeaders.setKey("User-Agent");
            soatHeaders.setValue("SoatRuntime/1.1.0");
            List<SoatHeaders> list = new ArrayList<>();
            list.add(soatHeaders);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),list,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.GET_DEFAULT_HEADER_FAIL.getCode(),"",RHttpStatusEnum.GET_DEFAULT_HEADER_FAIL.getMessage());
        }

    }






}
