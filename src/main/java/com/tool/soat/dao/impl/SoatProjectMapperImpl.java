package com.tool.soat.dao.impl;

import com.tool.soat.dao.SoatProjectMapper;
import com.tool.soat.entity.SoatProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class SoatProjectMapperImpl implements SoatProjectMapper {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addOneProject(SoatProject soatProject) {
        mongoTemplate.save(soatProject);
    }
}
