package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "charge_rate")
public class ChargeRate implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    /** rateId */
    @Column(name = "rateId")
    private Integer rateId;

    /** rateType */
    @Column(name = "rateType")
    private String rateType;

    /** rateName */
    @Column(name = "rateName")
    private String rateName;

    /** rate */
    @Column(name = "rate")
    private Double rate;

    /** remark */
    @Column(name = "remark")
    private String remark;

    /** roleId */
    @Column(name = "roleId")
    private Integer roleId;

    /** toCustId */
    @Column(name = "toCustId")
    private Integer toCustId;

    /** status */
    @Column(name = "status")
    private Integer status;

    /** 新增用户 */
    @Column(name = "crtOptr")
    private Integer crtOptr;

    /** 新增日期 */
    @Column(name = "crtTime")
    private String crtTime;

    /** 修改用户 */
    @Column(name = "modOptr")
    private Integer modOptr;

    /** 修改时间 */
    @Column(name = "modTime")
    private String modTime;



    /**
     * 获取 rateId 的值
     * @return Integer
     */
    public Integer getRateId() {
        return rateId;
    }
    
    /**
     * 设置rateId 的值
     * @param Integer rateId
     */
    public ChargeRate setRateId(Integer rateId) {
        this.rateId = rateId;
        return this;
    }

    /**
     * 获取 rateType 的值
     * @return String
     */
    public String getRateType() {
        return rateType;
    }
    
    /**
     * 设置rateType 的值
     * @param String rateType
     */
    public ChargeRate setRateType(String rateType) {
        this.rateType = rateType;
        return this;
    }

    /**
     * 获取 rateName 的值
     * @return String
     */
    public String getRateName() {
        return rateName;
    }
    
    /**
     * 设置rateName 的值
     * @param String rateName
     */
    public ChargeRate setRateName(String rateName) {
        this.rateName = rateName;
        return this;
    }

    /**
     * 获取 rate 的值
     * @return Double
     */
    public Double getRate() {
        return rate;
    }
    
    /**
     * 设置rate 的值
     * @param Double rate
     */
    public ChargeRate setRate(Double rate) {
        this.rate = rate;
        return this;
    }

    /**
     * 获取 remark 的值
     * @return String
     */
    public String getRemark() {
        return remark;
    }
    
    /**
     * 设置remark 的值
     * @param String remark
     */
    public ChargeRate setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    /**
     * 获取 roleId 的值
     * @return Integer
     */
    public Integer getRoleId() {
        return roleId;
    }
    
    /**
     * 设置roleId 的值
     * @param Integer roleId
     */
    public ChargeRate setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    /**
     * 获取 toOrgId 的值
     * @return Integer
     */
    public Integer getToCustId() {
        return toCustId;
    }
    
    /**
     * 设置toCustId 的值
     * @param Integer toCustId
     */
    public ChargeRate setToCustId(Integer toCustId) {
        this.toCustId = toCustId;
        return this;
    }

    /**
     * 获取 status 的值
     * @return Integer
     */
    public Integer getStatus() {
        return status;
    }
    
    /**
     * 设置status 的值
     * @param Integer status
     */
    public ChargeRate setStatus(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * 获取 新增用户 的值
     * @return Integer
     */
    public Integer getCrtOptr() {
        return crtOptr;
    }
    
    /**
     * 设置新增用户 的值
     * @param Integer crtOptr
     */
    public ChargeRate setCrtOptr(Integer crtOptr) {
        this.crtOptr = crtOptr;
        return this;
    }

    /**
     * 获取 新增日期 的值
     * @return String
     */
    public String getCrtTime() {
        return crtTime;
    }
    
    /**
     * 设置新增日期 的值
     * @param String crtTime
     */
    public ChargeRate setCrtTime(String crtTime) {
        this.crtTime = crtTime;
        return this;
    }

    /**
     * 获取 修改用户 的值
     * @return Integer
     */
    public Integer getModOptr() {
        return modOptr;
    }
    
    /**
     * 设置修改用户 的值
     * @param Integer modOptr
     */
    public ChargeRate setModOptr(Integer modOptr) {
        this.modOptr = modOptr;
        return this;
    }

    /**
     * 获取 修改时间 的值
     * @return String
     */
    public String getModTime() {
        return modTime;
    }
    
    /**
     * 设置修改时间 的值
     * @param String modTime
     */
    public ChargeRate setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }

}