package com.tool.soat.service;

import com.tool.soat.entity.SoatIdNumber;
import com.tool.soat.entity.SoatUsers;

import java.util.List;
import java.util.Set;


public interface NumberService {

    public Set<SoatIdNumber> createCode();

}
