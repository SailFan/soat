package com.tool.soat.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2021/6/27 9:48 下午
 * @File: ExceptionHandler
 * @Software: IntelliJIDEA
 */
//@ControllerAdvice
//public class SoatExceptionHandler {


//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public HashMap<Object, Object> handleException(Exception e){
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put("code","1111111");
//        objectObjectHashMap.put("message",e.getMessage());
//        return objectObjectHashMap;
//    }

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public String handleException(Exception e, HttpServletRequest request){
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        request.setAttribute("javax.servlet.error.status_code",400);
//        objectObjectHashMap.put("code","1111111");
//        objectObjectHashMap.put("message",e.getMessage());
//        return "forward:/error";
//    }
//




//}
