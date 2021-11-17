package com.tool.soat.entity;

import java.io.Serializable;

public class SoatChildrePermission implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_childre_permission.pc_id
     *
     * @mbggenerated
     */
    private Integer pcId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_childre_permission.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_childre_permission.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_childre_permission.level
     *
     * @mbggenerated
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table soat_childre_permission
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_childre_permission.pc_id
     *
     * @return the value of soat_childre_permission.pc_id
     *
     * @mbggenerated
     */
    public Integer getPcId() {
        return pcId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_childre_permission.pc_id
     *
     * @param pcId the value for soat_childre_permission.pc_id
     *
     * @mbggenerated
     */
    public void setPcId(Integer pcId) {
        this.pcId = pcId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_childre_permission.code
     *
     * @return the value of soat_childre_permission.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_childre_permission.code
     *
     * @param code the value for soat_childre_permission.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_childre_permission.name
     *
     * @return the value of soat_childre_permission.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_childre_permission.name
     *
     * @param name the value for soat_childre_permission.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_childre_permission.level
     *
     * @return the value of soat_childre_permission.level
     *
     * @mbggenerated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_childre_permission.level
     *
     * @param level the value for soat_childre_permission.level
     *
     * @mbggenerated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_childre_permission
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pcId=").append(pcId);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}