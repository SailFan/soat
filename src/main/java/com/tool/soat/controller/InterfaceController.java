package com.tool.soat.controller;
import com.tool.soat.common.util.SoatJWTUtil;
import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatHeaders;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.entity.SoatUsers;
import com.tool.soat.service.AuthService;
import com.tool.soat.service.InterfaceService;
import com.tool.soat.service.ProjectService;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: 凡子
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
            logger.info("新增或者编辑接口参数为"+map);
            Integer projectId = Integer.valueOf((String) map.get("projectId"));
            Map<String, Object> base = (Map<String, Object>) map.get("baseData");
            String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));
            SoatUsers users = authService.queryEmail(email);
            if (base.get("id") == null) {
                logger.info("ID为空，当前执行新增操作。参数为"+map);
                interfaceService.addInterfacce(map,users.getNickname(),projectId);
            }else {
                logger.info("编辑操作ID为"+base.get("id"));
                interfaceService.savaInterface(Integer.valueOf((String) base.get("id")),map);
            }


            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return new R(RHttpStatusEnum.ADD_INTERFACE_FAIL_CODE.getCode(),"",RHttpStatusEnum.ADD_INTERFACE_FAIL_CODE.getMessage());
        }

    }


    @GetMapping("/getAllInterface")
    public R getAllInterface(HttpServletRequest httpServletRequest) {
        try {
        String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));
        String name = httpServletRequest.getParameter("query");
        SoatUsers users = authService.queryEmail(email);
        Integer pageSize = new Integer(httpServletRequest.getParameter("pageSize"));
        Integer currentPage = new Integer(httpServletRequest.getParameter("currentPage"));
        Integer projectId = new Integer(httpServletRequest.getParameter("projectId"));
        Map<String, Object> anInterface = interfaceService.getInterface(currentPage, pageSize, users.getNickname(), projectId, name);
        logger.info("查询所有接口，返回的结果为"+anInterface);
        return new R(RHttpStatusEnum.SUCCESS.getCode(),anInterface,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.INTERFACE_LIST_FAIL.getCode(),"",RHttpStatusEnum.INTERFACE_LIST_FAIL.getMessage());
        }

    }

    @RequestMapping(value = "/runInterface", method = {RequestMethod.GET})
    public R runInterface(HttpServletRequest httpServletRequest) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        Integer value = Integer.valueOf(httpServletRequest.getParameter("id"));
        Integer projectId = Integer.valueOf(httpServletRequest.getParameter("projectId"));
        try {
            Response response = interfaceService.runOneInterface(value,projectId);
            map.put("code",response.code());
            map.put("response",response.body().string());
            //判断上一次接口运行情况，具体断言后续补充
            if(response.isSuccessful()==false){
                interfaceService.UpdateInterface(value,false);
            }else {
                interfaceService.UpdateInterface(value,true);
            }
            logger.info("运行接口返回的response为"+response);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),map,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (UnknownHostException e){
            map.put("response","当前地址有错误，请检查");
            return new R(RHttpStatusEnum.SUCCESS.getCode(),map,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (IllegalStateException e){
            map.put("response","Multipart body must have at least one part");
        return new R(RHttpStatusEnum.SUCCESS.getCode(),map,RHttpStatusEnum.SUCCESS.getMessage());
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
        Integer value = Integer.valueOf((String) id);
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
            SoatHeaders user_agent = new SoatHeaders();
            user_agent.setKey("User-Agent");
            user_agent.setValue("SoatRuntime/1.1.0");
            SoatHeaders accept = new SoatHeaders();
            accept.setKey("accept");
            accept.setValue("*/*");
            SoatHeaders cache_control = new SoatHeaders();
            cache_control.setKey("cache-control");
            cache_control.setValue("no-cache");
            SoatHeaders accept_encoding = new SoatHeaders();
            accept_encoding.setKey("accept-encoding");
            accept_encoding.setValue("gzip, deflate, br");
            List<SoatHeaders> list = new ArrayList<>();
            list.add(user_agent);
            list.add(cache_control);
            list.add(accept_encoding);
            list.add(accept);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),list,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.GET_DEFAULT_HEADER_FAIL.getCode(),"",RHttpStatusEnum.GET_DEFAULT_HEADER_FAIL.getMessage());
        }

    }


    @RequestMapping(value = "/directlyRunInterface", method = {RequestMethod.POST})
    public R directlyRunInterface( @RequestBody Map<String,Object> map,HttpServletRequest httpServletRequest) throws IOException {
        try {
            HashMap<String, Object> hashMap = new HashMap<>();
            Response response = interfaceService.directlyRunINterface(map);
            hashMap.put("message",response.body().string());
            return new R(RHttpStatusEnum.SUCCESS.getCode(),hashMap,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.RUN_DETAIL_INTERFACE_FAIL.getCode(),"",RHttpStatusEnum.RUN_DETAIL_INTERFACE_FAIL.getMessage());
        }

    }

    //更新方法，看样子是可以不要这个方法的，废弃
    @RequestMapping(value = "/saveInterface", method = {RequestMethod.POST})
    public R saveInterface( @RequestBody Map<String,Object> map,HttpServletRequest httpServletRequest) throws IOException {
        logger.info("saveInterface" + map);
//        interfaceService.savaInterface();
        try {
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.RUN_DETAIL_INTERFACE_FAIL.getCode(),"",RHttpStatusEnum.RUN_DETAIL_INTERFACE_FAIL.getMessage());
        }

    }


}
