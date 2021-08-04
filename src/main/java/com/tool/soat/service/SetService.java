package com.tool.soat.service;

import com.tool.soat.entity.SoatSet;

public interface SetService {
    void createSet(SoatSet record);
    void delteSet(Integer id);

    void upSet(SoatSet soatSet);

    SoatSet querySet(Integer id);
}
