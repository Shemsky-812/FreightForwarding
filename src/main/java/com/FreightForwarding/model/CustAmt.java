package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust_amt")
public class CustAmt implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    /** custAmtId */
    @Column(name = "custAmtId")
    private Integer custAmtId;

    /** amtCode */
    @Column(name = "amtCode")
    private String amtCode;

    /** amtLevel */
    @Column(name = "amtLevel")
    private Integer amtLevel;

    /** amtValue */
    @Column(name = "amtValue")
    private Double amtValue;

    /** tradId */
    @Column(name = "tradId")
    private Integer tradId;

    /** tradType */
    @Column(name = "tradType")
    private String tradType;

    /** tradNo */
    @Column(name = "tradNo")
    private String tradNo;

    /** tradFrom */
    @Column(name = "tradFrom")
    private Integer tradFrom;

    /** tradFromName */
    @Column(name = "tradFromName")
    private String tradFromName;

    /** tradTo */
    @Column(name = "tradTo")
    private Integer tradTo;

    /** tradToName */
    @Column(name = "tradToName")
    private String tradToName;

    /** custId */
    @Column(name = "custId")
    private Integer custId;

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
     * 获取 custAmtId 的值
     * @return Integer
     */
    public Integer getCustAmtId() {
        return custAmtId;
    }
    
    /**
     * 设置custAmtId 的值
     * @param Integer custAmtId
     */
    public CustAmt setCustAmtId(Integer custAmtId) {
        this.custAmtId = custAmtId;
        return this;
    }

    /**
     * 获取 amtCode 的值
     * @return String
     */
    public String getAmtCode() {
        return amtCode;
    }
    
    /**
     * 设置amtCode 的值
     * @param String amtCode
     */
    public CustAmt setAmtCode(String amtCode) {
        this.amtCode = amtCode;
        return this;
    }

    /**
     * 获取 amtLevel 的值
     * @return Integer
     */
    public Integer getAmtLevel() {
        return amtLevel;
    }
    
    /**
     * 设置amtLevel 的值
     * @param Integer amtLevel
     */
    public CustAmt setAmtLevel(Integer amtLevel) {
        this.amtLevel = amtLevel;
        return this;
    }

    /**
     * 获取 amtValue 的值
     * @return Double
     */
    public Double getAmtValue() {
        return amtValue;
    }
    
    /**
     * 设置amtValue 的值
     * @param Double amtValue
     */
    public CustAmt setAmtValue(Double amtValue) {
        this.amtValue = amtValue;
        return this;
    }

    /**
     * 获取 tradId 的值
     * @return Integer
     */
    public Integer getTradId() {
        return tradId;
    }
    
    /**
     * 设置tradId 的值
     * @param Integer tradId
     */
    public CustAmt setTradId(Integer tradId) {
        this.tradId = tradId;
        return this;
    }

    /**
     * 获取 tradType 的值
     * @return String
     */
    public String getTradType() {
        return tradType;
    }
    
    /**
     * 设置tradType 的值
     * @param String tradType
     */
    public CustAmt setTradType(String tradType) {
        this.tradType = tradType;
        return this;
    }

    /**
     * 获取 tradNo 的值
     * @return String
     */
    public String getTradNo() {
        return tradNo;
    }
    
    /**
     * 设置tradNo 的值
     * @param String tradNo
     */
    public CustAmt setTradNo(String tradNo) {
        this.tradNo = tradNo;
        return this;
    }

    /**
     * 获取 tradFrom 的值
     * @return Integer
     */
    public Integer getTradFrom() {
        return tradFrom;
    }
    
    /**
     * 设置tradFrom 的值
     * @param Integer tradFrom
     */
    public CustAmt setTradFrom(Integer tradFrom) {
        this.tradFrom = tradFrom;
        return this;
    }

    /**
     * 获取 tradFromName 的值
     * @return String
     */
    public String getTradFromName() {
        return tradFromName;
    }
    
    /**
     * 设置tradFromName 的值
     * @param String tradFromName
     */
    public CustAmt setTradFromName(String tradFromName) {
        this.tradFromName = tradFromName;
        return this;
    }

    /**
     * 获取 tradTo 的值
     * @return Integer
     */
    public Integer getTradTo() {
        return tradTo;
    }
    
    /**
     * 设置tradTo 的值
     * @param Integer tradTo
     */
    public CustAmt setTradTo(Integer tradTo) {
        this.tradTo = tradTo;
        return this;
    }

    /**
     * 获取 tradToName 的值
     * @return String
     */
    public String getTradToName() {
        return tradToName;
    }
    
    /**
     * 设置tradToName 的值
     * @param String tradToName
     */
    public CustAmt setTradToName(String tradToName) {
        this.tradToName = tradToName;
        return this;
    }

    /**
     * 获取 custId 的值
     * @return Integer
     */
    public Integer getCustId() {
        return custId;
    }
    
    /**
     * 设置custId 的值
     * @param Integer custId
     */
    public CustAmt setCustId(Integer custId) {
        this.custId = custId;
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
    public CustAmt setStatus(Integer status) {
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
    public CustAmt setCrtOptr(Integer crtOptr) {
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
    public CustAmt setCrtTime(String crtTime) {
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
    public CustAmt setModOptr(Integer modOptr) {
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
    public CustAmt setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }

}