package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust_transaction")
public class CustTransaction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
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

    /** amtAll */
    @Column(name = "amtAll")
    private Double amtAll;

    /** amtClock */
    @Column(name = "amtClock")
    private Double amtClock;

    /** amtFree */
    @Column(name = "amtFree")
    private Double amtFree;

    /** tradAmt */
    @Column(name = "tradAmt")
    private Double tradAmt;
    
    /** tradAmt */
    @Column(name = "chargeRate")
    private Double chargeRate;
    
    /** rateAmt */
    @Column(name = "rateAmt")
    private Double rateAmt;

    /** filePath */
    @Column(name = "filePath")
    private String filePath;

    /** custId */
    @Column(name = "custId")
    private Integer custId;

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
    public CustTransaction setTradId(Integer tradId) {
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
    public CustTransaction setTradType(String tradType) {
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
    public CustTransaction setTradNo(String tradNo) {
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
    public CustTransaction setTradFrom(Integer tradFrom) {
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
    public CustTransaction setTradFromName(String tradFromName) {
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
    public CustTransaction setTradTo(Integer tradTo) {
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
    public CustTransaction setTradToName(String tradToName) {
        this.tradToName = tradToName;
        return this;
    }

    /**
     * 获取 amtAll 的值
     * @return Double
     */
    public Double getAmtAll() {
        return amtAll;
    }
    
    /**
     * 设置amtAll 的值
     * @param Double amtAll
     */
    public CustTransaction setAmtAll(Double amtAll) {
        this.amtAll = amtAll;
        return this;
    }

    /**
     * 获取 amtClock 的值
     * @return Double
     */
    public Double getAmtClock() {
        return amtClock;
    }
    
    /**
     * 设置amtClock 的值
     * @param Double amtClock
     */
    public CustTransaction setAmtClock(Double amtClock) {
        this.amtClock = amtClock;
        return this;
    }

    /**
     * 获取 amtFree 的值
     * @return Double
     */
    public Double getAmtFree() {
        return amtFree;
    }
    
    /**
     * 设置amtFree 的值
     * @param Double amtFree
     */
    public CustTransaction setAmtFree(Double amtFree) {
        this.amtFree = amtFree;
        return this;
    }

    /**
     * 获取 tradAmt 的值
     * @return Double
     */
    public Double getTradAmt() {
        return tradAmt;
    }
    
    /**
     * 设置tradAmt 的值
     * @param Double tradAmt
     */
    public CustTransaction setTradAmt(Double tradAmt) {
        this.tradAmt = tradAmt;
        return this;
    }

    public Double getChargeRate() {
		return chargeRate;
	}

	public void setChargeRate(Double chargeRate) {
		this.chargeRate = chargeRate;
	}

	public Double getRateAmt() {
		return rateAmt;
	}

	public void setRateAmt(Double rateAmt) {
		this.rateAmt = rateAmt;
	}

	/**
     * 获取 filePath 的值
     * @return String
     */
    public String getFilePath() {
        return filePath;
    }
    
    /**
     * 设置filePath 的值
     * @param String filePath
     */
    public CustTransaction setFilePath(String filePath) {
        this.filePath = filePath;
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
    public CustTransaction setCustId(Integer custId) {
        this.custId = custId;
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
    public CustTransaction setCheckId(Integer checkId) {
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
    public CustTransaction setStatus(Integer status) {
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
    public CustTransaction setCrtOptr(Integer crtOptr) {
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
    public CustTransaction setCrtTime(String crtTime) {
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
    public CustTransaction setModOptr(Integer modOptr) {
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
    public CustTransaction setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }

}