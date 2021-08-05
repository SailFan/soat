package com.tool.soat.service;

import com.tool.soat.entity.SoatSet;

import java.util.List;

public interface SetService {
    void createSet(SoatSet record);
    void delteSet(Integer id);

    void upSet(SoatSet soatSet);

    SoatSet querySet(Integer id);

    List<SoatSet> queryAllSet(Integer currentPage, Integer pageSize);
}
