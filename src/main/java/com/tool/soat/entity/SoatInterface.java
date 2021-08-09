package com.tool.soat.entity;

import java.io.Serializable;

public class SoatInterface implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_interface.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_interface.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_interface.path
     *
     * @mbggenerated
     */
    private String path;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_interface.method
     *
     * @mbggenerated
     */
    private String method;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_interface.params
     *
     * @mbggenerated
     */
    private String params;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_interface.run
     *
     * @mbggenerated
     */
    private Integer run;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_interface.headers
     *
     * @mbggenerated
     */
    private String headers;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_interface.set_id
     *
     * @mbggenerated
     */
    private Integer setId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table soat_interface
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_interface.id
     *
     * @return the value of soat_interface.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_interface.id
     *
     * @param id the value for soat_interface.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_interface.name
     *
     * @return the value of soat_interface.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_interface.name
     *
     * @param name the value for soat_interface.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_interface.path
     *
     * @return the value of soat_interface.path
     *
     * @mbggenerated
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_interface.path
     *
     * @param path the value for soat_interface.path
     *
     * @mbggenerated
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_interface.method
     *
     * @return the value of soat_interface.method
     *
     * @mbggenerated
     */
    public String getMethod() {
        return method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_interface.method
     *
     * @param method the value for soat_interface.method
     *
     * @mbggenerated
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_interface.params
     *
     * @return the value of soat_interface.params
     *
     * @mbggenerated
     */
    public String getParams() {
        return params;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_interface.params
     *
     * @param params the value for soat_interface.params
     *
     * @mbggenerated
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_interface.run
     *
     * @return the value of soat_interface.run
     *
     * @mbggenerated
     */
    public Integer getRun() {
        return run;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_interface.run
     *
     * @param run the value for soat_interface.run
     *
     * @mbggenerated
     */
    public void setRun(Integer run) {
        this.run = run;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_interface.headers
     *
     * @return the value of soat_interface.headers
     *
     * @mbggenerated
     */
    public String getHeaders() {
        return headers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_interface.headers
     *
     * @param headers the value for soat_interface.headers
     *
     * @mbggenerated
     */
    public void setHeaders(String headers) {
        this.headers = headers == null ? null : headers.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_interface.set_id
     *
     * @return the value of soat_interface.set_id
     *
     * @mbggenerated
     */
    public Integer getSetId() {
        return setId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_interface.set_id
     *
     * @param setId the value for soat_interface.set_id
     *
     * @mbggenerated
     */
    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_interface
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
        sb.append(", name=").append(name);
        sb.append(", path=").append(path);
        sb.append(", method=").append(method);
        sb.append(", params=").append(params);
        sb.append(", run=").append(run);
        sb.append(", headers=").append(headers);
        sb.append(", setId=").append(setId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}