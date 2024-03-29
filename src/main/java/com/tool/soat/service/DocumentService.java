package com.tool.soat.service;

import com.tool.soat.entity.SoatDocument;


import java.util.List;
import java.util.Map;

public interface DocumentService {
    List<SoatDocument> queryDocument(String creater, Integer currentPage, Integer pageSize);
    void addDocument(Map<String,String> map, String creater);
    void delOneSoatDocument(Integer id);
    SoatDocument getOneSoatDocument(Integer id);
    void editDocument(Map<String, Object> map);
}
