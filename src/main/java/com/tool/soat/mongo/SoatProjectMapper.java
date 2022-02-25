package com.tool.soat.mongo;


import com.tool.soat.entity.SoatProject;

import java.util.List;

public interface SoatProjectMapper{
    void addOneProject(SoatProject soatProject);
    List<SoatProject> queryProject(Integer uid,Integer currentPage, Integer pageSize);
    void delOneProject(Integer uid,Integer id);
}
