package com.tool.soat.dao;

import com.tool.soat.entity.SoatAccount;

public interface SoatAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_account
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_account
     *
     * @mbggenerated
     */
    int insert(SoatAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_account
     *
     * @mbggenerated
     */
    int insertSelective(SoatAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_account
     *
     * @mbggenerated
     */
    SoatAccount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_account
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SoatAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_account
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SoatAccount record);
}