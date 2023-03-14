package com.tool.soat.service.impl;

import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.service.ProjectService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    SoatProjectMapper soatProjectMapper;
    private Object SoatProject;

    @Override
    public void addOneProject(SoatProject soatProject) throws ParseException {
        Date date = new Date();
        soatProject.setAddTime(date);
        soatProject.setUpTime(date);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        Date start = ft.parse("2023-03-13 17:32:00");
        Date end = ft.parse("2099-03-13 17:32:00");
        soatProject.setStartTime(start);
        soatProject.setEndTime(end);

        soatProjectMapper.addOneProject(soatProject);
    }


    public List<SoatProject> queryProjectAdmin(Integer currentPage, Integer pageSize) {
        List<SoatProject> soatProjects = soatProjectMapper.queryProjectAdmin(currentPage,pageSize);
        return soatProjects;
    }

    public SoatProject queryOneProject(Integer id) {
        SoatProject soatProject = soatProjectMapper.getOneSoatProject(id);
        return soatProject;
    }



    public List<SoatProject> queryProject(String creater,Integer currentPage, Integer pageSize) {
        List<SoatProject> soatProjects = soatProjectMapper.queryProject(creater,currentPage,pageSize);
        return soatProjects;
    }

    public void setOneProject(Map<String, Object> map) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        Date start = sdf.parse((String) map.get("start"));
        Date end = sdf.parse((String) map.get("end"));
        Integer id = (Integer) map.get("id");
        String projectName = (String) map.get("editProjectName");
        String cron = (String) map.get("cron");
        soatProjectMapper.updateOneProject(id,projectName,cron,start,end);
    }
}
