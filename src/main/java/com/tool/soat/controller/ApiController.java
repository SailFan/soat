package com.tool.soat.controller;

import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.service.ChartService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description:
 * @Author: 凡子
 * @CreateTime: 2023/3/14 17:22下午
 * @File: ApiController
 * @Software: IntelliJIDEA
 */

@RestController
@RequestMapping("/api")
public class ApiController {



    @PostMapping(value = "/uploadimg")
    @ResponseBody
    public R uploadFile(@RequestParam("file") MultipartFile file){
        try {
            System.out.println("file");
            System.out.println(file);
            System.out.println("file");
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.SERVER_ERROR.getCode(),"",RHttpStatusEnum.SERVER_ERROR.getMessage());
        }
    }
}
