package com.tool.soat.entity;

import java.io.Serializable;
import java.util.Date;

public class SoatDevices implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_devices.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_devices.devices_type
     *
     * @mbggenerated
     */
    private String devicesType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_devices.devices_possessor
     *
     * @mbggenerated
     */
    private String devicesPossessor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_devices.borrow_date
     *
     * @mbggenerated
     */
    private Date borrowDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_devices.plan_date
     *
     * @mbggenerated
     */
    private Date planDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_devices.current_possessor
     *
     * @mbggenerated
     */
    private String currentPossessor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_devices.is_return
     *
     * @mbggenerated
     */
    private String isReturn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column soat_devices.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table soat_devices
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_devices.id
     *
     * @return the value of soat_devices.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_devices.id
     *
     * @param id the value for soat_devices.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_devices.devices_type
     *
     * @return the value of soat_devices.devices_type
     *
     * @mbggenerated
     */
    public String getDevicesType() {
        return devicesType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_devices.devices_type
     *
     * @param devicesType the value for soat_devices.devices_type
     *
     * @mbggenerated
     */
    public void setDevicesType(String devicesType) {
        this.devicesType = devicesType == null ? null : devicesType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_devices.devices_possessor
     *
     * @return the value of soat_devices.devices_possessor
     *
     * @mbggenerated
     */
    public String getDevicesPossessor() {
        return devicesPossessor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_devices.devices_possessor
     *
     * @param devicesPossessor the value for soat_devices.devices_possessor
     *
     * @mbggenerated
     */
    public void setDevicesPossessor(String devicesPossessor) {
        this.devicesPossessor = devicesPossessor == null ? null : devicesPossessor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_devices.borrow_date
     *
     * @return the value of soat_devices.borrow_date
     *
     * @mbggenerated
     */
    public Date getBorrowDate() {
        return borrowDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_devices.borrow_date
     *
     * @param borrowDate the value for soat_devices.borrow_date
     *
     * @mbggenerated
     */
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_devices.plan_date
     *
     * @return the value of soat_devices.plan_date
     *
     * @mbggenerated
     */
    public Date getPlanDate() {
        return planDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_devices.plan_date
     *
     * @param planDate the value for soat_devices.plan_date
     *
     * @mbggenerated
     */
    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_devices.current_possessor
     *
     * @return the value of soat_devices.current_possessor
     *
     * @mbggenerated
     */
    public String getCurrentPossessor() {
        return currentPossessor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_devices.current_possessor
     *
     * @param currentPossessor the value for soat_devices.current_possessor
     *
     * @mbggenerated
     */
    public void setCurrentPossessor(String currentPossessor) {
        this.currentPossessor = currentPossessor == null ? null : currentPossessor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_devices.is_return
     *
     * @return the value of soat_devices.is_return
     *
     * @mbggenerated
     */
    public String getIsReturn() {
        return isReturn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_devices.is_return
     *
     * @param isReturn the value for soat_devices.is_return
     *
     * @mbggenerated
     */
    public void setIsReturn(String isReturn) {
        this.isReturn = isReturn == null ? null : isReturn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column soat_devices.remark
     *
     * @return the value of soat_devices.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column soat_devices.remark
     *
     * @param remark the value for soat_devices.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table soat_devices
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
        sb.append(", devicesType=").append(devicesType);
        sb.append(", devicesPossessor=").append(devicesPossessor);
        sb.append(", borrowDate=").append(borrowDate);
        sb.append(", planDate=").append(planDate);
        sb.append(", currentPossessor=").append(currentPossessor);
        sb.append(", isReturn=").append(isReturn);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}