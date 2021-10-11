package com.tool.soat.dao;

import com.tool.soat.entity.SoatNav;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class SoatNavMapperTest {

    @Resource
    SoatNavMapper soatNavMapper;


    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }

    @Test
    void selectAllNav() {
        List<SoatNav> navs = soatNavMapper.selectAllNav();
        System.out.println(navs);
    }

    @Test
    void selectByLevel() {
        List<SoatNav> navs = soatNavMapper.selectByLevel(2);
        System.out.println(navs);
    }
}