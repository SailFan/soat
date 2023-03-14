package com.tool.soat.service;

import com.tool.soat.entity.SoatProject;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ProjectService {
    void addOneProject(SoatProject soatProject) throws ParseException;
    List<SoatProject> queryProject(String creater,Integer currentPage, Integer pageSize);
    List<SoatProject> queryProjectAdmin(Integer currentPage, Integer pageSize);
    SoatProject queryOneProject(Integer id);
    void setOneProject(Map<String, Object> map) throws ParseException;
}
