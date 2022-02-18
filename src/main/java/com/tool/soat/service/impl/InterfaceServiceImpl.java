package com.tool.soat.service.impl;



import com.tool.soat.entity.SoatInterface;
import com.tool.soat.service.InterfaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InterfaceServiceImpl implements InterfaceService {

    @Resource
    SoatInterfaceMapper soatInterfaceMapper;

    @Override
    public void insertInterface(SoatInterface soatInterface) {
        soatInterfaceMapper.insert(soatInterface);
    }
}
