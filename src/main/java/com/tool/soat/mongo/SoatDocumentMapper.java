package com.tool.soat.mongo;


import com.tool.soat.entity.SoatDocument;
import com.tool.soat.entity.SoatProject;

import java.util.List;

public interface SoatDocumentMapper {
    List<SoatDocument> queryAllDocument(String creater, Integer currentPage, Integer pageSize);
    void addOneDocument(SoatDocument soatDocument);
    void delOneDocument(Integer id);
    SoatDocument getOneDocument(Integer id);
    void editDocument(Integer id, String documentName,String documentAbstract,String value);

}
