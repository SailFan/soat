package com.tool.soat.service;

import com.tool.soat.entity.SoatInterface;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface InterfaceService {
    public void addInterfacce(Map<String,Object> map,String nickname,Integer projectId);
    public List<SoatInterface> getInterface(Integer currentPage, Integer pageSize, String creater,Integer projectId);
    public String runOneInterface(String name) throws IOException;
    public SoatInterface getOneSoatInterface(String name);
}
