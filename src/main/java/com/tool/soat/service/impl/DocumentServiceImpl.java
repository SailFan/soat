package com.tool.soat.service.impl;

import com.tool.soat.entity.SoatDocument;
import com.tool.soat.mongo.SoatDocumentMapper;
import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
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
        document.setDocumentAbstract(map.get("documentAbstract"));
        document.setCreater(creater);
        document.setIsShow(true);
        document.setUpdateTime(new Date());
        document.setValue(map.get("value"));
        soatDocumentMapper.addOneDocument(document);
    }

    @Override
    public void delOneSoatDocument(Integer id) {
        soatDocumentMapper.delOneDocument(id);
    }

    @Override
    public SoatDocument getOneSoatDocument(Integer id) {
        SoatDocument document = soatDocumentMapper.getOneDocument(id);
        return document;
    }

    @Override
    public void editDocument(Map<String, Object> map) {
        Integer id =Integer.valueOf((String) map.get("id"));
        String documentName = (String) map.get("documentName");
        String documentAbstract  = (String) map.get("documentAbstract");
        String value = (String) map.get("value");
        soatDocumentMapper.editDocument(id,documentName,documentAbstract,value);
    }
}
