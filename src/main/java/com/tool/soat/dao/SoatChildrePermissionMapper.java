package com.tool.soat.dao;

import com.tool.soat.entity.SoatChildrePermission;

public interface SoatChildrePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_childre_permission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer pcId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_childre_permission
     *
     * @mbggenerated
     */
    int insert(SoatChildrePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_childre_permission
     *
     * @mbggenerated
     */
    int insertSelective(SoatChildrePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_childre_permission
     *
     * @mbggenerated
     */
    SoatChildrePermission selectByPrimaryKey(Integer pcId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_childre_permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SoatChildrePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_childre_permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SoatChildrePermission record);
}