package com.tool.soat.mongo.impl;

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
}
