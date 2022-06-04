package com.tool.soat.controller;


import com.tool.soat.common.vo.R;
import com.tool.soat.common.vo.RHttpStatusEnum;
import com.tool.soat.entity.SoatAccount;
import com.tool.soat.entity.SoatEnv;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.entity.SoatTag;
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

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public R createProject(@RequestBody Map<String, Object> map){
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
            SoatAccount user = (SoatAccount) SecurityUtils.getSubject().getPrincipal(); // 获取当前登录用户
            logger.info("session "+user);
            projectService.addOneProject(project);
            return new R(RHttpStatusEnum.SUCCESS.getCode(),"",RHttpStatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            return new R(RHttpStatusEnum.CREATE_PROJECT_ERROR.getCode(), "",RHttpStatusEnum.CREATE_PROJECT_ERROR.getMessage());
        }

    }


    @RequestMapping(value = "/queryProject", method = RequestMethod.GET)
    public R queryProject(HttpServletRequest httpServletRequest){
        logger.info("加载出所有工程开始");
      try{
          HashMap<String, Object> map = new HashMap<>();
          Integer uid = new Integer( httpServletRequest.getParameter("uid"));
          Integer pageSize = new Integer(httpServletRequest.getParameter("pageSize"));

          Integer currentPage = new Integer(httpServletRequest.getParameter("currentPage"));
          List<SoatProject> projects = projectService.queryProject(uid, currentPage,  pageSize);
          map.put("total", projects.size());
          map.put("projects", projects);

          logger.info("返回的project集合内容"+map);
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

