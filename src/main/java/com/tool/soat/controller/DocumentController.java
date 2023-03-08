package com.tool.soat.controller;
import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Description: 文档操作view层
 * @Author: Sail
 * @CreateTime: 2023/3/8 14:23
 * @File: Document
 * @Software: IntelliJIDEA
 */

@RestController
@RequestMapping("/document")
public class DocumentController {
    @RequestMapping(value = "/getAllDocument", method = {RequestMethod.GET})
    public R getAllDocument() {
        try {
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.DOCUMENT_OPERATION.getCode(),"",RHttpStatusEnum.DOCUMENT_OPERATION.getMessage());
        }

    }
}
