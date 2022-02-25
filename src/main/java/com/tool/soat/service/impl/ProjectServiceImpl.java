package com.tool.soat.service.impl;

import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    SoatProjectMapper soatProjectMapper;

    @Override
    public void addOneProject(SoatProject soatProject) {
        Date date = new Date();
        soatProject.setAddTime(date);
        soatProject.setUpTime(date);
        soatProject.setUId(2);
        soatProjectMapper.addOneProject(soatProject);
    }


    public List<SoatProject> queryProject(Integer uid,Integer currentPage, Integer pageSize) {
        List<SoatProject> soatProjects = soatProjectMapper.queryProject(uid,currentPage,pageSize);
        return soatProjects;
    }
}
