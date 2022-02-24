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
        SoatProject project = new SoatProject();
        project.setAddTime(date);
        project.setUpTime(date);
        project.setUId(2);
        soatProjectMapper.addOneProject(project);
    }

    @Override
    public List<SoatProject> queryProject() {
        return null;
    }

//    public List<SoatProject> queryProject(Integer currentPage, Integer pageSize) {
//        List<SoatProject> soatProjects = soatProjectMapper.queryProject(Integer currentPage, Integer pageSize);
//        return soatProjects;
//    }
}
