package com.tool.soat.mongo.impl;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.mongo.SoatInterfaceMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SoatInterfaceMapperImpl implements SoatInterfaceMapper {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public void addOneInterface(SoatInterface soatInterface) {
        mongoTemplate.save(soatInterface);
    }

    @Override
    public List<SoatInterface> queryAllInterface(String creater, Integer currentPage, Integer pageSize){
        Criteria where = new Criteria();
        where.and("author").is(creater);
        Query query = new Query(where);
        long count = mongoTemplate.count(query, SoatInterface.class);
        Pageable pageable = PageRequest.of(currentPage-1,pageSize);
        List<SoatInterface> pageList = mongoTemplate.find(query.with(pageable).with(Sort.by(new Sort.Order(Sort.Direction.DESC,"upTime"))), SoatInterface.class);
        return pageList;
    }

    @Override
    public SoatInterface queryOneInterface(String name) {
        Criteria where = new Criteria();
        where.and("name").is(name);
        Query query = new Query(where);
        List<SoatInterface> interfaces = mongoTemplate.find(query, SoatInterface.class);
        SoatInterface mongoTemplateOne = mongoTemplate.findOne(query, SoatInterface.class);
        return mongoTemplateOne;

    }
}
