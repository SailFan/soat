package com.tool.soat.mongo.impl;

import com.mongodb.client.result.UpdateResult;
import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.entity.SoatProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
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
    public List<SoatProject> queryProject(String creater,Integer currentPage, Integer pageSize) {
        Criteria where = new Criteria();
        where.and("creater").is(creater);
        Query query = new Query(where);
        long count = mongoTemplate.count(query, SoatProject.class);
        Pageable pageable = PageRequest.of(currentPage-1,pageSize);
        List<SoatProject> pageList = mongoTemplate.find(query.with(pageable).with(Sort.by(new Sort.Order(Sort.Direction.DESC,"upTime"))), SoatProject.class);
        return pageList;
    }



    @Override
    public List<SoatProject> queryProjectAdmin(Integer currentPage, Integer pageSize) {
        Query query = new Query();
        long count = mongoTemplate.count(query, SoatProject.class);
        Pageable pageable = PageRequest.of(currentPage-1,pageSize);
        List<SoatProject> pageList = mongoTemplate.find(query.with(pageable).with(Sort.by(new Sort.Order(Sort.Direction.DESC,"upTime"))), SoatProject.class);
        return pageList;
    }


    @Override
    public void delOneProject(Integer uid, Integer id) {
//        Query.query(Criteria)
    }

    @Override
    public SoatProject getOneSoatProject(Integer projectId) {
        Criteria where = new Criteria();
        where.and("_id").is(projectId);
        Query query = new Query(where);
        SoatProject mongoTemplateOne = mongoTemplate.findOne(query, SoatProject.class);
        return mongoTemplateOne;
    }

    @Override
    public void updateOneProject(Integer id, String editProjectName, String cron, Date start, Date end) {
        Query query = new Query();
        Update update=new Update();
        query.addCriteria(Criteria.where("_id").is(id));
        update.set("projectName", editProjectName);
        update.set("cron", cron);
        update.set("startTime", start);
        update.set("endTime", end);
        UpdateResult upsert = mongoTemplate.upsert(query, update, SoatProject.class);
    }

    @Override
    public long queryCount() {
        Query query = new Query();
        long count = mongoTemplate.count(query, SoatProject.class);
        return count;
    }

    @Override
    public long queryRunCount() {
        Criteria where = new Criteria();
        where.and("run").is(true);
        Query query = new Query(where);
        return mongoTemplate.count(query, SoatProject.class);
    }


}
