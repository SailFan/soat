package com.tool.soat.controller;


import com.tool.soat.common.util.SoatJWTUtil;
import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.*;
import com.tool.soat.service.AuthService;
import com.tool.soat.service.ProjectService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProjectService projectService;

    @Autowired
    AuthService authService;

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public R createProject(@RequestBody Map<String, Object> map, HttpServletRequest httpServletRequest){
        logger.info("开始创建项目");
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
            logger.info("获取到的Authorization "+httpServletRequest.getHeader("Authorization"));
            String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));

            SoatUsers users = authService.queryEmail(email);
            project.setCreater(users.getNickname());
            projectService.addOneProject(project);
            System.out.println("project"+project);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.CREATE_PROJECT_ERROR.getCode(), "",RHttpStatusEnum.CREATE_PROJECT_ERROR.getMessage());
        }

    }


    @RequestMapping(value = "/queryProject", method = RequestMethod.GET)
    public R queryProject(HttpServletRequest httpServletRequest){
        logger.info("获取所有测试工程");
      try{
          List<SoatProject> projects;
          String email = SoatJWTUtil.getEmail(httpServletRequest.getHeader("Authorization"));
          SoatUsers users = authService.queryEmail(email);
          HashMap<String, Object> map = new HashMap<>();
          Integer pageSize = new Integer(httpServletRequest.getParameter("pageSize"));
          Integer currentPage = new Integer(httpServletRequest.getParameter("currentPage"));
          if(users.getNickname().equals("admin")){
              projects = projectService.queryProjectAdmin(currentPage,  pageSize);
          }else {
              projects = projectService.queryProject(users.getNickname(), currentPage,  pageSize);
          }
          map.put("total", projects.size());
          map.put("projects", projects);
          return new R(RHttpStatusEnum.SUCCESS.getCode(),map,RHttpStatusEnum.SUCCESS.getMessage());
      }catch (Exception e){
          return new R(RHttpStatusEnum.QUERY_PROJECT_ERROR.getCode(),"",RHttpStatusEnum.QUERY_PROJECT_ERROR.getMessage());
      }

    }

    @RequestMapping(value = "/delOneProject", method = RequestMethod.GET)
    public R delOneProject(HttpServletRequest httpServletRequest){
        try{
            Integer uid = Integer.parseInt( httpServletRequest.getParameter("query"));
            Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.QUERY_PROJECT_ERROR.getCode(),"",RHttpStatusEnum.QUERY_PROJECT_ERROR.getMessage());
        }
    }



}

