package com.tool.soat.service;

import com.tool.soat.entity.SoatProject;

import java.util.List;

public interface ProjectService {
    public void addOneProject(SoatProject soatProject);
    public List<SoatProject> queryProject(String creater,Integer currentPage, Integer pageSize);
    public List<SoatProject> queryProjectAdmin(Integer currentPage, Integer pageSize);

}
