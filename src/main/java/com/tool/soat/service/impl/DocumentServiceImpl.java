package com.tool.soat.service.impl;

import com.sun.org.apache.xpath.internal.operations.String;
import com.tool.soat.entity.SoatDocument;
import com.tool.soat.mongo.SoatDocumentMapper;
import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class DocumentServiceImpl implements DocumentService {


    @Autowired
    SoatDocumentMapper soatDocumentMapper;


    @Override
    public List<SoatDocument> queryDocument(java.lang.String creater, Integer currentPage, Integer pageSize) {
        List<SoatDocument> documents = soatDocumentMapper.queryAllDocument(creater, currentPage, pageSize);
        return documents;
    }

    @Override
    public void addDocument(Map<java.lang.String, java.lang.String> map, java.lang.String creater) {
        SoatDocument document = new SoatDocument();
        document.setDocumentName(map.get("documentName"));
        document.setDocumentName(map.get("documentAbstract"));
        document.setCreater(creater);
        document.setIsShow(true);
        document.setUpdateTime(new Date());
        document.setValue(map.get("value"));
        soatDocumentMapper.addOneDocument(document);
    }
}
