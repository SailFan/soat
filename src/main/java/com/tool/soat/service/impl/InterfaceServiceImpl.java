package com.tool.soat.service.impl;

import com.tool.soat.entity.SoatIdNumber;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.service.InterfaceService;
import com.tool.soat.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class InterfaceServiceImpl implements InterfaceService {
    public void addInterfacce(Map<String,Object> map){
        System.out.println(map);
    };

}
