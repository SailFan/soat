package com.tool.soat.service;

import com.tool.soat.entity.SoatDocument;


import java.util.List;

public interface DocumentService {
    public List<SoatDocument> queryProject(String creater, Integer currentPage, Integer pageSize);


}
