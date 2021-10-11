package com.tool.soat.entity;

import java.io.Serializable;

public class SoatNav implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_nav.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_nav.nav_name
     *
     * @mbggenerated
     */
    private String navName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_nav.level
     *
     * @mbggenerated
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_nav.path
     *
     * @mbggenerated
     */
    private String path;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table soat_nav
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_nav.id
     *
     * @return the value of soat_nav.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_nav.id
     *
     * @param id the value for soat_nav.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_nav.nav_name
     *
     * @return the value of soat_nav.nav_name
     *
     * @mbggenerated
     */
    public String getNavName() {
        return navName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_nav.nav_name
     *
     * @param navName the value for soat_nav.nav_name
     *
     * @mbggenerated
     */
    public void setNavName(String navName) {
        this.navName = navName == null ? null : navName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_nav.level
     *
     * @return the value of soat_nav.level
     *
     * @mbggenerated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_nav.level
     *
     * @param level the value for soat_nav.level
     *
     * @mbggenerated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_nav.path
     *
     * @return the value of soat_nav.path
     *
     * @mbggenerated
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_nav.path
     *
     * @param path the value for soat_nav.path
     *
     * @mbggenerated
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_nav
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", navName=").append(navName);
        sb.append(", level=").append(level);
        sb.append(", path=").append(path);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}