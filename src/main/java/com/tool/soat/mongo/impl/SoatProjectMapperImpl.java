package com.tool.soat.mongo.impl;

import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.entity.SoatProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SoatProjectMapperImpl implements SoatProjectMapper {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void addOneProject(SoatProject soatProject) {
        mongoTemplate.save(soatProject);
    }

    @Override
    public List<SoatProject> queryProject(Integer currentPage, Integer pageSize) {
        Query query = new Query();
        query.skip((currentPage-1)*pageSize);
        query.limit(pageSize);
        Criteria criteria = new Criteria();
        List<SoatProject> objects = mongoTemplate.find(query, SoatProject.class);
        int count = (int)mongoTemplate.count(query, SoatProject.class);
        Page<SoatProject> page = new Page<>();
        return null;
    }

}
