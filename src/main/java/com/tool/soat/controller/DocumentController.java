package com.tool.soat.controller;
import com.tool.soat.common.util.SoatJWTUtil;
import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatDocument;
import com.tool.soat.entity.SoatUsers;
import com.tool.soat.service.AuthService;
import com.tool.soat.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description: 文档操作view层
 * @Author: 凡子
 * @CreateTime: 2023/3/8 14:23
 * @File: Document
 * @Software: IntelliJIDEA
 */

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    AuthService authService;

    @Autowired
    DocumentService documentService;


    @RequestMapping(value = "/getAllDocument", method = {RequestMethod.GET})
    public R getAllDocument(HttpServletRequest httpServletRequest) {
        try {
            String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));
            SoatUsers users = authService.queryEmail(email);
            Integer pagesize = Integer.parseInt(httpServletRequest.getParameter("pagesize"));
            Integer pagenum = Integer.parseInt(httpServletRequest.getParameter("pageful"));
            List<SoatDocument> documents = documentService.queryDocument(users.getNickname(),pagenum,pagesize);
            HashMap<String, Object> map = new HashMap<>();
            map.put("total", documents.size());
            map.put("documents", documents);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),map,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.DOCUMENT_OPERATION.getCode(),"",RHttpStatusEnum.DOCUMENT_OPERATION.getMessage());
        }
    }

    @RequestMapping(value = "/delOneDocument", method = {RequestMethod.GET})
    public R delOneDocument(HttpServletRequest httpServletRequest) {
        String id = httpServletRequest.getParameter("id");
        Integer value = Integer.valueOf(id);
        try {
            documentService.delOneSoatDocument(value);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.INTERFACE_DEL_FAIL.getCode(),"",RHttpStatusEnum.INTERFACE_DEL_FAIL.getMessage());
        }

    }





    @RequestMapping(value = "/addDocument", method = {RequestMethod.POST})
    public R addDocument(@RequestBody Map<String,String> map, HttpServletRequest httpServletRequest) {
        try {
            String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));
            SoatUsers users = authService.queryEmail(email);
            documentService.addDocument(map, users.getNickname());
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.DOCUMENT_OPERATION.getCode(),"",RHttpStatusEnum.DOCUMENT_OPERATION.getMessage());
        }

    }

    @RequestMapping(value = "/getOneDocument", method = {RequestMethod.GET})
    public R getOneDocument(HttpServletRequest httpServletRequest) {
        String id = httpServletRequest.getParameter("id");
        Integer value = Integer.valueOf(id);
        try {
            SoatDocument soatDocument = documentService.getOneSoatDocument(value);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),soatDocument,RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.INTERFACE_DEL_FAIL.getCode(),"",RHttpStatusEnum.INTERFACE_DEL_FAIL.getMessage());
        }

    }

    @RequestMapping(value = "/editDocument", method = {RequestMethod.POST})
    public R editDocument(@RequestBody Map<String,Object> map) {
//        try {
            documentService.editDocument(map);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
//        }catch (Exception e){
//            return new R(RHttpStatusEnum.DOCUMENT_OPERATION.getCode(),"",RHttpStatusEnum.DOCUMENT_OPERATION.getMessage());
//        }

    }



}
