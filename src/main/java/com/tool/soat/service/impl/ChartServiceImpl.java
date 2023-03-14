package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatNavMapper;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.entity.SoatNav;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.mongo.SoatInterfaceMapper;
import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.service.ChartService;
import com.tool.soat.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChartServiceImpl implements ChartService {


    @Autowired
    SoatProjectMapper soatProjectMapper;

    @Autowired
    SoatInterfaceMapper soatInterfaceMapper;

    @Override
    public Map<String, Integer> homeOverview() {
        long interfaceCount = soatInterfaceMapper.queryCount();
        long projectCount = soatProjectMapper.queryCount();
        long runProjectCount = soatProjectMapper.queryRunCount();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("interfaceCount", (int) interfaceCount);
        map.put("projectCount", (int) projectCount);
        map.put("runProjectCount", (int) runProjectCount);
        return map;
    }
}
