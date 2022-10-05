package com.tool.soat.service.impl;

import com.alibaba.fastjson.JSON;
import com.tool.soat.common.util.http.OkHttpClientManager;
import com.tool.soat.entity.SoatHeaders;
import com.tool.soat.entity.SoatInterface;
import com.tool.soat.entity.SoatParams;
import com.tool.soat.entity.SoatProject;
import com.tool.soat.mongo.SoatInterfaceMapper;
import com.tool.soat.mongo.SoatProjectMapper;
import com.tool.soat.service.InterfaceService;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Service
public class InterfaceServiceImpl implements InterfaceService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SoatProjectMapper soatProjectMapper;

    @Autowired
    SoatInterfaceMapper soatInterfaceMapper;



    @Override
    public void addInterfacce(Map<String, Object> map, String nickname,Integer projectId) {
        SoatInterface anInterface = new SoatInterface();
        Map<String, Object> base = (Map<String, Object>) map.get("baseData");
        SoatProject soatProject = soatProjectMapper.getOneSoatProject(projectId);
        try  {
            Integer id = Integer.valueOf((String) base.get("id"));
            anInterface.setId(id);
        }catch (Exception e){
            logger.info("此处为用户编辑,异常无需处理");
        }finally {
            anInterface.setMethod((String) base.get("interfaceMethod"));
            anInterface.setProcotol((String) base.get("interfaceProtocol"));
            anInterface.setName((String) base.get("interfaceName"));
            anInterface.setPath((String) base.get("interfacePath"));
            anInterface.setProjectId(projectId);
            anInterface.setAuthor(nickname);
            anInterface.setRun(false);
            anInterface.setParams((List<SoatParams>) map.get("params"));
            anInterface.setHeaders((List<SoatHeaders>) map.get("headers"));
            soatInterfaceMapper.addOneInterface(anInterface);
        }
    }


    @Override
    public List<SoatInterface> getInterface(Integer currentPage, Integer pageSize, String creater,Integer projectId) {
        List<SoatInterface> soatInterfaces = soatInterfaceMapper.queryAllInterface(creater, currentPage, pageSize,projectId);
        return soatInterfaces;
    }

    @Override
    public Response runOneInterface(Integer id,Integer projectId) throws IOException {
        logger.info("进入同步执行方法");
        SoatInterface soatInterface = soatInterfaceMapper.queryOneInterface(id);
        SoatProject soatProject = soatProjectMapper.getOneSoatProject(projectId);
        Response asyn = null;
        String fullUrl = soatInterface.getProcotol()+"://"+soatProject.getBasePath()+soatInterface.getPath();
        if (soatInterface.getMethod() .equals("GET")){
            asyn = OkHttpClientManager.getInstance().getsyn(fullUrl, soatInterface.getParams(), soatInterface.getHeaders());
            logger.info("isSuccessful"+asyn.isSuccessful());
            if(asyn.isSuccessful()){
                soatInterfaceMapper.updateOneInterfaceRunStatus(id,true);
            }else {
                soatInterfaceMapper.updateOneInterfaceRunStatus(id,false);
            }
        }else if (soatInterface.getMethod().equals("POST")){
            System.out.println("This is POST Method");
        }else if(soatInterface.getMethod().equals("UPDATE")){
            System.out.println("This is UPDATE Method");
        }else {
            System.out.println("This is DELETE METHOD");
        }
        return asyn;
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
    public void UpdateInterface(Integer id,Boolean run) {
//        SoatInterface anInterface = new SoatInterface();
//        Map<String, Object> base = (Map<String, Object>) map.get("baseData");
//        anInterface.setMethod((String) base.get("interfaceMethod"));
//        anInterface.setProcotol((String) base.get("interfaceProtocol"));
//        anInterface.setName((String) base.get("interfaceName"));
//        anInterface.setPath((String) base.get("interfacePath"));
//        anInterface.setProjectId(projectId);
//        anInterface.setParams((List<SoatParams>) map.get("params"));
//        anInterface.setHeaders((List<SoatHeaders>) map.get("headers"));
//        anInterface.setEditer(nickname);
        soatInterfaceMapper.updateOneInterfaceRunStatus(id,run);
    }

    @Override
    public Response directlyRunINterface(Map<String, Object> map) throws IOException {
        Response asyn = null;
        Integer projectId = Integer.valueOf((String) map.get("projectId"));
        Map<String, Object> base = (Map<String, Object>) map.get("baseData");
        List<SoatHeaders> headers = (List<SoatHeaders>) map.get("headers");
        List<SoatParams> params = (List<SoatParams>) map.get("params");
        SoatProject soatProject = soatProjectMapper.getOneSoatProject(projectId);
        String domain = soatProject.getBasePath();
        String fullUrl = base.get("interfaceProtocol")+"://"+domain+base.get("interfacePath");
        List<SoatParams> paramList = JSON.parseArray(JSON.toJSONString(params), SoatParams.class);
        List<SoatHeaders> headerList = JSON.parseArray(JSON.toJSONString(headers), SoatHeaders.class);
        if (base.get("interfaceMethod") .equals("GET")){
            asyn = OkHttpClientManager.getInstance().getsyn(fullUrl,paramList,headerList);
        }else if (base.get("interfaceMethod").equals("POST")){
            System.out.println("This is POST Method");
        }else if(base.get("interfaceMethod").equals("UPDATE")){
            System.out.println("This is UPDATE Method");
        }else {
            System.out.println("This is DELETE METHOD");
        }
        return asyn;
    }
}
