//package com.tool.soat.controller;
//
//
//import com.tool.soat.common.vo.R;
//import com.tool.soat.common.vo.RHttpStatusEnum;
//import org.apache.shiro.authz.UnauthenticatedException;
//import org.apache.shiro.authz.UnauthorizedException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @Description:
// * @Author: Sail
// * @CreateTime: 2022/7/3 17:10
// * @File: WebExceptionHandler
// * @Software: IntelliJIDEA
// */
//@ControllerAdvice
//public class WebExceptionHandler {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//
//    @ExceptionHandler(UnauthorizedException.class)
//    @ResponseBody
//    public R handleUnauthorizedException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
//        logger.error("{}", ex.getMessage());
//        return new R(RHttpStatusEnum.PERMISSION_DENIED_CODE.getCode(), "",RHttpStatusEnum.PERMISSION_DENIED_CODE.getMessage());
//
//    }
//
//    @ExceptionHandler(UnauthenticatedException.class)
//    @ResponseBody
//    public R handleUnauthenticatedException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
//        logger.error("{}", ex.getMessage());
//        return new R(RHttpStatusEnum.INVALID_LOGIN_CODE.getCode(), "",RHttpStatusEnum.INVALID_LOGIN_CODE.getMessage());
//
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Object handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
//        logger.error("{}", ex.getMessage());
//        return new R(RHttpStatusEnum.SERVER_ERROR.getCode(), "",RHttpStatusEnum.SERVER_ERROR.getMessage());
//
//    }
//}
