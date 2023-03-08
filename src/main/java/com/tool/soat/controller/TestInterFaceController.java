package com.tool.soat.controller;

import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description:
 * @Author: Sail
 * @CreateTime: 2022/10/23 22:51
 * @File: TestInterFaceController
 * @Software: IntelliJIDEA
 */
@RestController
@RequestMapping("/testInterface")
public class TestInterFaceController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/postInterface",method = RequestMethod.POST)
    public R postInterface(@RequestHeader Map<String, String> headers, @RequestParam Map<String, String> params,@RequestBody Map<String,String> body){
        logger.info("收到的post请求参数为"+params);
        logger.info("收到的接口请求头为"+headers);
        logger.info("收到的请求体"+body);
        return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
    }

    @RequestMapping(value = "/getInterface",method = RequestMethod.GET)
    public R getInterface(@RequestHeader Map<String, String> headers, @RequestParam Map<String, String> params,@RequestBody Map<String,String> body){
        logger.info("收到的get请求参数为"+params);
        logger.info("收到的接口请求头为"+headers);
        logger.info("收到的请求体"+body);
        return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
    }
}
