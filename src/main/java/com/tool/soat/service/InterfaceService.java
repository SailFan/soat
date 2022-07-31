package com.tool.soat.service;

import com.tool.soat.entity.SoatInterface;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public interface InterfaceService {
    public void addInterfacce(Map<String,Object> map,String nickname);
    public List<SoatInterface> getInterface(Integer currentPage, Integer pageSize, String creater);
    public SoatInterface runOneInterface(ObjectId interfaceId);

}
