package com.tool.soat.service.impl;

import com.tool.soat.common.util.http.OkHttpClientManager;
import com.tool.soat.entity.SoatHeaders;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.entity.SoatParams;
import com.tool.soat.mongo.SoatInterfaceMapper;
import com.tool.soat.service.InterfaceService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Service
public class InterfaceServiceImpl implements InterfaceService {



    @Autowired
    SoatInterfaceMapper soatInterfaceMapper;

//    {baseData={interfaceName=23142134, interfaceProtocol=http, interfacePath=23142134234, interfaceMethod=GET}, params=[{key=213423143, value=213432142334312421}, {key=12344231, value=4213231412}], headers=[{key=231423142, value=4231213421}, {key=4123423, value=214323114234321}]}


    @Override
    public void addInterfacce(Map<String, Object> map, String nickname) {
        SoatInterface anInterface = new SoatInterface();
        Map<String, Object> base = (Map<String, Object>) map.get("baseData");
        anInterface.setMethod((String) base.get("interfaceMethod"));
        anInterface.setProcotol((String) base.get("interfaceProtocol"));
        anInterface.setName((String) base.get("interfaceName"));
        anInterface.setPath((String) base.get("interfacePath"));
        anInterface.setAuthor(nickname);
        anInterface.setParams((List<SoatParams>) map.get("params"));
        anInterface.setHeaders((List<SoatHeaders>) map.get("headers"));
        soatInterfaceMapper.addOneInterface(anInterface);
    }


    @Override
    public List<SoatInterface> getInterface(Integer currentPage, Integer pageSize, String creater) {
        List<SoatInterface> soatInterfaces = soatInterfaceMapper.queryAllInterface(creater, currentPage, pageSize);
        return soatInterfaces;
    }

    @Override
    public String runOneInterface(String name) throws IOException {
        SoatInterface soatInterface = soatInterfaceMapper.queryOneInterface(name);
//        if (soatInterface.getMethod() == "GET"){
//            OkHttpClientManager.getInstance().getAsyn(soatInterface.getPath(),)
//        }
        return "";
    }

    @Override
    public SoatInterface getOneSoatInterface(String name) {
        SoatInterface soatInterface = soatInterfaceMapper.queryOneInterface(name);
        return soatInterface;
    }
}
