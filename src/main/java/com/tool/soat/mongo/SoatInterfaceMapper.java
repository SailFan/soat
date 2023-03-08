package com.tool.soat.mongo;


import com.tool.soat.entity.SoatInterface;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;


public interface SoatInterfaceMapper {
    void addOneInterface(SoatInterface soatInterface);
    List<SoatInterface> queryAllInterface(String creater, Integer currentPage, Integer pageSize,Integer projectId);
    SoatInterface queryOneInterface(Integer id);
    void delSoatInterface(Integer id);
    void updateOneInterfaceRunStatus(Integer id,Boolean run);
    void updateOneInterface(Integer id, Map<String, Object> map);
}
