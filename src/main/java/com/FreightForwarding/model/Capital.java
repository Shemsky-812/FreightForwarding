package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "capital")
public class Capital implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    /** capitalId */
    @Column(name = "capitalId")
    private Integer capitalId;

    /** capitalCode */
    @Column(name = "capitalCode")
    private String capitalCode;

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

    /** tradFromBank */
    @Column(name = "tradFromBank")
    private String tradFromBank;

    /** tradFromAccount */
    @Column(name = "tradFromAccount")
    private String tradFromAccount;

    /** tradTo */
    @Column(name = "tradTo")
    private Integer tradTo;

    /** tradToName */
    @Column(name = "tradToName")
    private String tradToName;

    /** tradToBank */
    @Column(name = "tradToBank")
    private String tradToBank;

    /** tradToAccount */
    @Column(name = "tradToAccount")
    private String tradToAccount;

    /** capitalAmt */
    @Column(name = "capitalAmt")
    private Double capitalAmt;

    /** picPath */
    @Column(name = "picPath")
    private String picPath;

    /** checkId */
    @Column(name = "checkId")
    private Integer checkId;

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
     * 获取 capitalId 的值
     * @return Integer
     */
    public Integer getCapitalId() {
        return capitalId;
    }
    
    /**
     * 设置capitalId 的值
     * @param Integer capitalId
     */
    public Capital setCapitalId(Integer capitalId) {
        this.capitalId = capitalId;
        return this;
    }

    /**
     * 获取 capitalCode 的值
     * @return String
     */
    public String getCapitalCode() {
        return capitalCode;
    }
    
    /**
     * 设置capitalCode 的值
     * @param String capitalCode
     */
    public Capital setCapitalCode(String capitalCode) {
        this.capitalCode = capitalCode;
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
    public Capital setTradId(Integer tradId) {
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
    public Capital setTradType(String tradType) {
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
    public Capital setTradNo(String tradNo) {
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
    public Capital setTradFrom(Integer tradFrom) {
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
    public Capital setTradFromName(String tradFromName) {
        this.tradFromName = tradFromName;
        return this;
    }

    /**
     * 获取 tradFromBank 的值
     * @return String
     */
    public String getTradFromBank() {
        return tradFromBank;
    }
    
    /**
     * 设置tradFromBank 的值
     * @param String tradFromBank
     */
    public Capital setTradFromBank(String tradFromBank) {
        this.tradFromBank = tradFromBank;
        return this;
    }

    /**
     * 获取 tradFromAccount 的值
     * @return String
     */
    public String getTradFromAccount() {
        return tradFromAccount;
    }
    
    /**
     * 设置tradFromAccount 的值
     * @param String tradFromAccount
     */
    public Capital setTradFromAccount(String tradFromAccount) {
        this.tradFromAccount = tradFromAccount;
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
    public Capital setTradTo(Integer tradTo) {
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
    public Capital setTradToName(String tradToName) {
        this.tradToName = tradToName;
        return this;
    }

    /**
     * 获取 tradToBank 的值
     * @return String
     */
    public String getTradToBank() {
        return tradToBank;
    }
    
    /**
     * 设置tradToBank 的值
     * @param String tradToBank
     */
    public Capital setTradToBank(String tradToBank) {
        this.tradToBank = tradToBank;
        return this;
    }

    /**
     * 获取 tradToAccount 的值
     * @return String
     */
    public String getTradToAccount() {
        return tradToAccount;
    }
    
    /**
     * 设置tradToAccount 的值
     * @param String tradToAccount
     */
    public Capital setTradToAccount(String tradToAccount) {
        this.tradToAccount = tradToAccount;
        return this;
    }

    /**
     * 获取 capitalAmt 的值
     * @return Double
     */
    public Double getCapitalAmt() {
        return capitalAmt;
    }
    
    /**
     * 设置capitalAmt 的值
     * @param Double capitalAmt
     */
    public Capital setCapitalAmt(Double capitalAmt) {
        this.capitalAmt = capitalAmt;
        return this;
    }

    /**
     * 获取 picPath 的值
     * @return String
     */
    public String getPicPath() {
        return picPath;
    }
    
    /**
     * 设置picPath 的值
     * @param String picPath
     */
    public Capital setPicPath(String picPath) {
        this.picPath = picPath;
        return this;
    }

    /**
     * 获取 checkId 的值
     * @return Integer
     */
    public Integer getCheckId() {
        return checkId;
    }
    
    /**
     * 设置checkId 的值
     * @param Integer checkId
     */
    public Capital setCheckId(Integer checkId) {
        this.checkId = checkId;
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
    public Capital setStatus(Integer status) {
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
    public Capital setCrtOptr(Integer crtOptr) {
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
    public Capital setCrtTime(String crtTime) {
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
    public Capital setModOptr(Integer modOptr) {
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
    public Capital setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }

}