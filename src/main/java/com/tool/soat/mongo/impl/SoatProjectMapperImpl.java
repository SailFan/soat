package com.tool.soat.mongo.impl;

import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.entity.SoatProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


    public List<SoatProject> queryProject(Integer currentPage, Integer pageSize) {
        return null;
    }

    @Override
    public List<SoatProject> queryProject(Integer uid,Integer currentPage, Integer pageSize) {
        Criteria where = new Criteria();
        where.and("uId").is(uid);
        Query query = new Query(where);
        long count = mongoTemplate.count(query, SoatProject.class);
        Pageable pageable = PageRequest.of(currentPage-1,pageSize);
        List<SoatProject> pageList = mongoTemplate.find(query.with(pageable).with(Sort.by(new Sort.Order(Sort.Direction.DESC,"upTime"))), SoatProject.class);
        return pageList;
    }

}
