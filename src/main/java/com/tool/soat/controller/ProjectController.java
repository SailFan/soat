package com.tool.soat.controller;


import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatEnv;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.entity.SoatTag;
import com.tool.soat.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public R createProject(@RequestBody Map<String, Object> map){
        try{
            SoatProject project = new SoatProject();
            Map<String, Object> baseData = (Map<String, Object>) (map.get("baseData"));
            List<SoatEnv> envs = (List<SoatEnv>) map.get("env");
            List<SoatTag> tags = (List<SoatTag>) map.get("tag");
            project.setBasePath((String) baseData.get("basePath"));
            project.setProjectType((Boolean) baseData.get("projectType"));
            project.setProjectName((String) baseData.get("projectName"));
            project.setEnv(envs);
            project.setTag(tags);
            projectService.addOneProject(project);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.CREATE_PROJECT_ERROR.getCode(), "",RHttpStatusEnum.CREATE_PROJECT_ERROR.getMessage());
        }

    }


    @RequestMapping(value = "/queryProject", method = RequestMethod.GET)
    public R queryProject(){
      try{
          List<SoatProject> projects = projectService.queryProject();
          return new R(RHttpStatusEnum.SUCCESS.getCode(),projects,RHttpStatusEnum.SUCCESS.getMessage());
      }catch (Exception e){
          return new R(RHttpStatusEnum.QUERY_PROJECT_ERROR.getCode(),"",RHttpStatusEnum.QUERY_PROJECT_ERROR.getMessage());
      }
    }






}

