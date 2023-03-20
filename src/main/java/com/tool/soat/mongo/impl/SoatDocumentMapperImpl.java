package com.tool.soat.mongo.impl;

import com.mongodb.client.result.UpdateResult;
import com.tool.soat.entity.SoatDocument;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.mongo.SoatDocumentMapper;
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
public class SoatDocumentMapperImpl implements SoatDocumentMapper {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<SoatDocument> queryAllDocument(String creater, Integer currentPage, Integer pageSize) {
        Criteria where = new Criteria();
        where.and("creater").is(creater);
        Query query = new Query(where);
        long count = mongoTemplate.count(query, SoatDocument.class);
        Pageable pageable = PageRequest.of(currentPage-1,pageSize);
        List<SoatDocument> pageList = mongoTemplate.find(query.with(pageable).with(Sort.by(new Sort.Order(Sort.Direction.DESC,"upTime"))), SoatDocument.class);
        return pageList;
    }

    @Override
    public void addOneDocument(SoatDocument soatDocument) {
        mongoTemplate.save(soatDocument);
    }

    @Override
    public void delOneDocument(Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query,SoatDocument.class);
    }

    @Override
    public SoatDocument getOneDocument(Integer id) {
        Criteria where = new Criteria();
        where.and("id").is(id);
        Query query = new Query(where);
        SoatDocument mongoTemplateOne = mongoTemplate.findOne(query, SoatDocument.class);
        return mongoTemplateOne;
    }

    @Override
    public void editDocument(Integer id, String documentName, String documentAbstract, String value) {
        Query query = new Query();
        Update update=new Update();
        query.addCriteria(Criteria.where("_id").is(id));
        update.set("documentName", documentName);
        update.set("documentAbstract", documentAbstract);
        update.set("value", value);
        mongoTemplate.upsert(query, update, SoatDocument.class);
    }
}
