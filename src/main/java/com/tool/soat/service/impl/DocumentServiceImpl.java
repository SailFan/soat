package com.tool.soat.service.impl;

import com.tool.soat.entity.SoatDocument;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.service.DocumentService;
import com.tool.soat.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.util.Date;
import java.util.List;


@Service
public class DocumentServiceImpl implements DocumentService {


    @Autowired
    SoatProjectMapper soatProjectMapper;

    @Override
    public List<SoatDocument> queryProject(String creater, Integer currentPage, Integer pageSize) {
        return null;
    }
}
