package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatProjectMapper;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    SoatProjectMapper soatProjectMapper;

    @Override
    public void addOneProject(SoatProject soatProject) {
        SoatProject project = new SoatProject();
        project.getAddTime();
        soatProjectMapper.addOneProject(project);
    }
}
