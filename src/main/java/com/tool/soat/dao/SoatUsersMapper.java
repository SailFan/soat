package com.tool.soat.dao;

import com.tool.soat.entity.SoatUsers;

public interface SoatUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_users
     *
     * @mbggenerated
     */
    int insert(SoatUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_users
     *
     * @mbggenerated
     */
    int insertSelective(SoatUsers record);

    /**
     * 查询用户
     */

    SoatUsers queryUserByUsername(String username);

}