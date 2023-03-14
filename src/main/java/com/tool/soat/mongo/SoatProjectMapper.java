package com.tool.soat.mongo;

import com.tool.soat.entity.SoatProject;
import java.util.Date;
import java.util.List;

public interface SoatProjectMapper{
    void addOneProject(SoatProject soatProject);
    List<SoatProject> queryProject(String creater,Integer currentPage, Integer pageSize);
    List<SoatProject> queryProjectAdmin(Integer currentPage, Integer pageSize);
    void delOneProject(Integer uid,Integer id);
    SoatProject getOneSoatProject(Integer projectId);
    void updateOneProject(Integer id, String editProjectName, String cron, Date start, Date end);
    long queryCount();
    long queryRunCount();
}
