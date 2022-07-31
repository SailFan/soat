package com.tool.soat.service.impl;

import com.tool.soat.dao.SoatSetMapper;
import com.tool.soat.entity.SoatSet;
import com.tool.soat.service.SetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class SetServiceImpl implements SetService {

    @Resource
    SoatSetMapper soatSetMapper;


    @Override
    public void createSet(SoatSet record) {
        record.setCreater("刘文凡");
        record.setCreateTime(new Date());
        record.setName("测试集二");
        record.setUpdater("刘文凡");
        record.setUpdateTime(new Date());
        soatSetMapper.insert(record);
    }

    public void delteSet(Integer id){
        soatSetMapper.deleteByPrimaryKey(id);
    }

    public void upSet(SoatSet soatSet){
        soatSet.setUpdateTime(new Date());
        soatSetMapper.updateByPrimaryKey(soatSet);
    }

    public SoatSet querySet(Integer id){
        return soatSetMapper.selectByPrimaryKey(id);
    }

    public List<SoatSet> queryAllSet(Integer currentPage, Integer pageSize){
        List<SoatSet> sets = soatSetMapper.queryAll(currentPage, pageSize);
        return sets;
    }
}
