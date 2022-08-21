package com.tool.soat.service.impl;

import com.tool.soat.common.util.http.OkHttpClientManager;
import com.tool.soat.entity.SoatInterface;
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

    @Override
    public void addInterfacce(Map<String, Object> map, String nickname) {
        SoatInterface anInterface = new SoatInterface();
        Map<String, Object> base = (Map<String, Object>) map.get("baseData");
        anInterface.setMethod((String) base.get("interfaceMethod"));
        anInterface.setProcotol((String) base.get("interfaceProtocol"));
        anInterface.setName((String) base.get("interfaceName"));
        anInterface.setPath((String) base.get("interfacePath"));
        anInterface.setAuthor(nickname);
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
}
