package com.tool.soat.service;

import com.tool.soat.entity.SoatInterface;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface InterfaceService {
    void addInterfacce(Map<String,Object> map,String nickname,Integer projectId);
    Map<String, Object> getInterface(Integer currentPage, Integer pageSize, String creater,Integer projectId,String name);
    Response runOneInterface(Integer id,Integer projectId) throws IOException;
    SoatInterface getOneSoatInterface(Integer id);
    void delOneSoatInterface(Integer id);
    void UpdateInterface(Integer id,Boolean run);
    Response directlyRunINterface(Map<String,Object> map) throws IOException;
    void savaInterface(Integer id,Map<String, Object> map);
}
