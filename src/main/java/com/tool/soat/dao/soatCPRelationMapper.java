package com.tool.soat.dao;

import com.tool.soat.entity.soatCPRelationKey;

public interface soatCPRelationMapper {

    int deleteByPrimaryKey(soatCPRelationKey key);

    int insert(soatCPRelationKey record);

    int insertSelective(soatCPRelationKey record);
}