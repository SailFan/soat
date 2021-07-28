package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatSetMapper;
import com.tool.soat.entity.SoatSet;
import com.tool.soat.service.SetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SetServiceImpl implements SetService {

    @Resource
    SoatSetMapper soatSetMapper;


    @Override
    public void createSet(SoatSet record) {
        soatSetMapper.insert(record);
    }
}
