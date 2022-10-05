package com.tool.soat.service;

import com.tool.soat.entity.SoatInterface;
import okhttp3.Response;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface InterfaceService {
    public void addInterfacce(Map<String,Object> map,String nickname,Integer projectId);
    public List<SoatInterface> getInterface(Integer currentPage, Integer pageSize, String creater,Integer projectId);
    public Response runOneInterface(Integer id,Integer projectId) throws IOException;
    public SoatInterface getOneSoatInterface(Integer id);
    public void delOneSoatInterface(Integer id);
    public void UpdateInterface(Integer id,Boolean run);
    public Response directlyRunINterface(Map<String,Object> map) throws IOException;
}
