package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatNavMapper;
import com.tool.soat.entity.SoatNav;
import com.tool.soat.service.NavService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class NavServiceImpl implements NavService {
    @Resource
    SoatNavMapper soatNavMapper;

    @Override
    public List<SoatNav> queryNavS() {
        List<SoatNav> navs = new ArrayList<>();
        Map<Integer, SoatNav> map = new HashMap<>();

        List<SoatNav> soatNavs = soatNavMapper.selectAllNav();

        for (SoatNav s : soatNavs){
            if (s.getLevel()==0){
                if (soatNavMapper.selectByLevel(s.getId()).size()!=0){
                    for (SoatNav r : soatNavMapper.selectByLevel(s.getId())){
                        s.getList().add(r);
                    }
                }
                navs.add(s);
            }
        }

        return navs;
    }
}
