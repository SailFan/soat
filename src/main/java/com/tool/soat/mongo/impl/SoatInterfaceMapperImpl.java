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
import org.springframework.data.mongodb.core.query.Update;
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
    public List<SoatInterface> queryAllInterface(String creater, Integer currentPage, Integer pageSize,Integer projectId){
        Criteria where = new Criteria();
        where.and("author").is(creater);
        where.and("projectId").is(projectId);
        Query query = new Query(where);
        long count = mongoTemplate.count(query, SoatInterface.class);
        Pageable pageable = PageRequest.of(currentPage-1,pageSize);
        List<SoatInterface> pageList = mongoTemplate.find(query.with(pageable).with(Sort.by(new Sort.Order(Sort.Direction.DESC,"upTime"))), SoatInterface.class);
        return pageList;
    }

    @Override
    public SoatInterface queryOneInterface(Integer id) {
        Criteria where = new Criteria();
        where.and("id").is(id);
        Query query = new Query(where);
        SoatInterface mongoTemplateOne = mongoTemplate.findOne(query, SoatInterface.class);
        return mongoTemplateOne;

    }

    @Override
    public void delSoatInterface(Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query,SoatInterface.class);
    }

    @Override
    public void updateOneInterfaceRunStatus(Integer id,Boolean run) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update=new Update().set("run",run);
        mongoTemplate.updateFirst(query,update,SoatInterface.class);

    }
}
