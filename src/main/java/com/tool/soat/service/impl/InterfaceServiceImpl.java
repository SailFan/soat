package com.tool.soat.service.impl;

import com.tool.soat.common.util.http.OkHttpClientManager;
import com.tool.soat.entity.SoatHeaders;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.entity.SoatParams;
import com.tool.soat.mongo.SoatInterfaceMapper;
import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.service.InterfaceService;
import okhttp3.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service
public class InterfaceServiceImpl implements InterfaceService {


    @Autowired
    SoatProjectMapper soatProjectMapper;

//    @Autowired
//    SoatInterface soatInterface

    @Autowired
    SoatInterfaceMapper soatInterfaceMapper;

//    {baseData={interfaceName=23142134, interfaceProtocol=http, interfacePath=23142134234, interfaceMethod=GET}, params=[{key=213423143, value=213432142334312421}, {key=12344231, value=4213231412}], headers=[{key=231423142, value=4231213421}, {key=4123423, value=214323114234321}]}


    @Override
    public void addInterfacce(Map<String, Object> map, String nickname,Integer projectId) {
        SoatInterface anInterface = new SoatInterface();
        Map<String, Object> base = (Map<String, Object>) map.get("baseData");
        anInterface.setMethod((String) base.get("interfaceMethod"));
        anInterface.setProcotol((String) base.get("interfaceProtocol"));
        anInterface.setName((String) base.get("interfaceName"));
        anInterface.setPath((String) base.get("interfacePath"));
        anInterface.setProjectId(projectId);
        anInterface.setAuthor(nickname);
        anInterface.setParams((List<SoatParams>) map.get("params"));
        anInterface.setHeaders((List<SoatHeaders>) map.get("headers"));
        soatInterfaceMapper.addOneInterface(anInterface);
    }


    @Override
    public List<SoatInterface> getInterface(Integer currentPage, Integer pageSize, String creater,Integer projectId) {
        List<SoatInterface> soatInterfaces = soatInterfaceMapper.queryAllInterface(creater, currentPage, pageSize,projectId);
        return soatInterfaces;
    }

    @Override
    public String runOneInterface(Integer id) throws IOException {
        SoatInterface soatInterface = soatInterfaceMapper.queryOneInterface(id);
        if (soatInterface.getMethod() .equals("GET")){
           System.out.println("This is GET Method");
           System.out.println(soatInterface);
            Response asyn = OkHttpClientManager.getInstance().getAsyn(soatInterface.getPath(), soatInterface.getParams(), soatInterface.getHeaders());
            System.out.println(asyn.body());
            System.out.println(asyn);
            System.out.println(asyn.message());
        }else if (soatInterface.getMethod().equals("POST")){
            System.out.println("This is POST Method");
        }else if(soatInterface.getMethod().equals("UPDATE")){
            System.out.println("This is UPDATE Method");
        }else {
            System.out.println("This is DELETE METHOD");
        }
        return "";
    }

    @Override
    public SoatInterface getOneSoatInterface(Integer id) {
        SoatInterface soatInterface = soatInterfaceMapper.queryOneInterface(id);
        return soatInterface;
    }
    @Override
    public void delOneSoatInterface(Integer id){
        soatInterfaceMapper.delSoatInterface(id);
    }

    @Override
    public void UpdateInterfacce(Map<String, Object> map, String nickname, Integer projectId) {
        SoatInterface anInterface = new SoatInterface();
        Map<String, Object> base = (Map<String, Object>) map.get("baseData");
        anInterface.setMethod((String) base.get("interfaceMethod"));
        anInterface.setProcotol((String) base.get("interfaceProtocol"));
        anInterface.setName((String) base.get("interfaceName"));
        anInterface.setPath((String) base.get("interfacePath"));
        anInterface.setProjectId(projectId);
        anInterface.setParams((List<SoatParams>) map.get("params"));
        anInterface.setHeaders((List<SoatHeaders>) map.get("headers"));
        anInterface.setEditer(nickname);
        soatInterfaceMapper.updateOneInterface(anInterface);
    }
}
