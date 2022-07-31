package com.tool.soat.mongo;


import com.tool.soat.entity.SoatInterface;
import org.bson.types.ObjectId;

import java.util.List;


public interface SoatInterfaceMapper {
    void addOneInterface(SoatInterface soatInterface);
    List<SoatInterface> queryAllInterface(String creater, Integer currentPage, Integer pageSize);
    SoatInterface queryOneInterface(ObjectId objectId);
}
