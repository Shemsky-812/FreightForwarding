package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factor")
public class Factor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    /** factorId */
    @Column(name = "factorId")
    private Integer factorId;

    /** factorCode */
    @Column(name = "factorCode")
    private String factorCode;

    /** custSell */
    @Column(name = "custSell")
    private Integer custSell;

    @Column(name = "custSellName")
    private String custSellName;
    
    /** custfactor */
    @Column(name = "custfactor")
    private Integer custfactor;
    
    @Column(name = "custfactorName")
    private String custfactorName;
    
    @Column(name = "factorAmt")
    private Double factorAmt;

    /** payment */
    @Column(name = "payment")
    private String payment;

    /** rate */
    @Column(name = "rate")
    private Double rate;

    /** interest */
    @Column(name = "interest")
    private Double interest;

    /** tenor */
    @Column(name = "tenor")
    private String tenor;

    /** startDate */
    @Column(name = "startDate")
    private String startDate;

    /** endDate */
    @Column(name = "endDate")
    private String endDate;

    /** filePath */
    @Column(name = "filePath")
    private String filePath;

    /** remark */
    @Column(name = "remark")
    private String remark;

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
     * 获取 factorId 的值
     * @return Integer
     */
    public Integer getFactorId() {
        return factorId;
    }
    
    /**
     * 设置factorId 的值
     * @param Integer factorId
     */
    public Factor setFactorId(Integer factorId) {
        this.factorId = factorId;
        return this;
    }

    /**
     * 获取 factorCode 的值
     * @return String
     */
    public String getFactorCode() {
        return factorCode;
    }
    
    /**
     * 设置factorCode 的值
     * @param String factorCode
     */
    public Factor setFactorCode(String factorCode) {
        this.factorCode = factorCode;
        return this;
    }

    /**
     * 获取 custSell 的值
     * @return Integer
     */
    public Integer getCustSell() {
        return custSell;
    }
    
    /**
     * 设置custSell 的值
     * @param Integer custSell
     */
    public Factor setCustSell(Integer custSell) {
        this.custSell = custSell;
        return this;
    }

    /**
     * 获取 custfactor 的值
     * @return Integer
     */
    public Integer getCustfactor() {
        return custfactor;
    }
    
    /**
     * 设置custfactor 的值
     * @param Integer custfactor
     */
    public Factor setCustfactor(Integer custfactor) {
        this.custfactor = custfactor;
        return this;
    }

    /**
     * 获取 payment 的值
     * @return String
     */
    public String getPayment() {
        return payment;
    }
    
    /**
     * 设置payment 的值
     * @param String payment
     */
    public Factor setPayment(String payment) {
        this.payment = payment;
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
    public Factor setRate(Double rate) {
        this.rate = rate;
        return this;
    }

    /**
     * 获取 interest 的值
     * @return Double
     */
    public Double getInterest() {
        return interest;
    }
    
    /**
     * 设置interest 的值
     * @param Double interest
     */
    public Factor setInterest(Double interest) {
        this.interest = interest;
        return this;
    }

    /**
     * 获取 tenor 的值
     * @return String
     */
    public String getTenor() {
        return tenor;
    }
    
    /**
     * 设置tenor 的值
     * @param String tenor
     */
    public Factor setTenor(String tenor) {
        this.tenor = tenor;
        return this;
    }

    /**
     * 获取 startDate 的值
     * @return String
     */
    public String getStartDate() {
        return startDate;
    }
    
    /**
     * 设置startDate 的值
     * @param String startDate
     */
    public Factor setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * 获取 endDate 的值
     * @return String
     */
    public String getEndDate() {
        return endDate;
    }
    
    /**
     * 设置endDate 的值
     * @param String endDate
     */
    public Factor setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
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
    public Factor setFilePath(String filePath) {
        this.filePath = filePath;
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
    public Factor setRemark(String remark) {
        this.remark = remark;
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
    public Factor setCheckId(Integer checkId) {
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
    public Factor setStatus(Integer status) {
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
    public Factor setCrtOptr(Integer crtOptr) {
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
    public Factor setCrtTime(String crtTime) {
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
    public Factor setModOptr(Integer modOptr) {
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
    public Factor setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }

	public String getCustSellName() {
		return custSellName;
	}

	public void setCustSellName(String custSellName) {
		this.custSellName = custSellName;
	}

	public String getCustfactorName() {
		return custfactorName;
	}

	public void setCustfactorName(String custfactorName) {
		this.custfactorName = custfactorName;
	}

	public Double getFactorAmt() {
		return factorAmt;
	}

	public void setFactorAmt(Double factorAmt) {
		this.factorAmt = factorAmt;
	}

}