package com.tool.soat.controller;


import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatSet;
import com.tool.soat.service.SetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/aggregate")
public class SetController {
    @Resource
    SetService setService;

    Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/setIndex")
    public String setIndex(){

        return "sets/set";
    }



    @RequestMapping(value = "/createSet",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public Map<String,String> createSet(@RequestBody SoatSet soatSet){


        HashMap<String, String> stringStringHashMap = new HashMap<>();
        setService.createSet(soatSet);

        return stringStringHashMap;
    }

    @RequestMapping(value = "/updateSet",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public Map<String,String> updateSet(@RequestBody SoatSet soatSet){

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        setService.upSet(soatSet);

        return stringStringHashMap;
    }


    @RequestMapping(value = "/detailsSet")
    public R detailsSet(Integer id){
        try {
            SoatSet soatSet = setService.querySet(id);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),soatSet,RHttpStatusEnum.SUCCESS.getMessage());

        }catch (Exception e){
            logger.debug(String.valueOf(e));

            return new R(RHttpStatusEnum.SET_QUERY_FAIL.getCode(), "",RHttpStatusEnum.SET_QUERY_FAIL.getMessage());
        }


    }


    @RequestMapping(value = "/delSet", method = RequestMethod.DELETE)
    public Map<String,String> delSet(Integer id){

        setService.delteSet(id);
        HashMap<String, String> stringStringHashMap = new HashMap<>();


        return stringStringHashMap;
    }


    @RequestMapping(value = "/qASet", method = RequestMethod.GET)
        public @ResponseBody R qASet(Integer currentPage, Integer pageSize){
        try {
            List<SoatSet> sets = setService.queryAllSet(currentPage, pageSize);
            System.out.println(sets);

            return new R(RHttpStatusEnum.SUCCESS.getCode(),sets,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.debug("11111111111111111");
            return null;
        }

    }


}
