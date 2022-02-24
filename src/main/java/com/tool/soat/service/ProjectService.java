package com.tool.soat.service;

import com.tool.soat.entity.SoatProject;

import java.util.List;

public interface ProjectService {
    public void addOneProject(SoatProject soatProject);
    public List<SoatProject> queryProject(Integer uid,Integer currentPage, Integer pageSize);

}
