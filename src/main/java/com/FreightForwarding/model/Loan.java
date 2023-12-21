package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    /** loanId */
    @Column(name = "loanId")
    private Integer loanId;

    /** loanCode */
    @Column(name = "loanCode")
    private String loanCode;

    /** custDebtor */
    @Column(name = "custDebtor")
    private Integer custDebtor;
    
    @Column(name = "custDebtorName")
    private String custDebtorName;

    /** custCreditor */
    @Column(name = "custCreditor")
    private Integer custCreditor;
    
    @Column(name = "custCreditorName")
    private String custCreditorName;
    
    @Column(name = "loanAmt")
    private Double loanAmt;

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

    /** factorId */
    @Column(name = "factorId")
    private Integer factorId;

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
     * 获取 loanId 的值
     * @return Integer
     */
    public Integer getLoanId() {
        return loanId;
    }
    
    /**
     * 设置loanId 的值
     * @param Integer loanId
     */
    public Loan setLoanId(Integer loanId) {
        this.loanId = loanId;
        return this;
    }

    /**
     * 获取 loanCode 的值
     * @return String
     */
    public String getLoanCode() {
        return loanCode;
    }
    
    /**
     * 设置loanCode 的值
     * @param String loanCode
     */
    public Loan setLoanCode(String loanCode) {
        this.loanCode = loanCode;
        return this;
    }

    /**
     * 获取 custDebtor 的值
     * @return Integer
     */
    public Integer getCustDebtor() {
        return custDebtor;
    }
    
    /**
     * 设置custDebtor 的值
     * @param Integer custDebtor
     */
    public Loan setCustDebtor(Integer custDebtor) {
        this.custDebtor = custDebtor;
        return this;
    }

    /**
     * 获取 custCreditor 的值
     * @return Integer
     */
    public Integer getCustCreditor() {
        return custCreditor;
    }
    
    /**
     * 设置custCreditor 的值
     * @param Integer custCreditor
     */
    public Loan setCustCreditor(Integer custCreditor) {
        this.custCreditor = custCreditor;
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
    public Loan setPayment(String payment) {
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
    public Loan setRate(Double rate) {
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
    public Loan setInterest(Double interest) {
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
    public Loan setTenor(String tenor) {
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
    public Loan setStartDate(String startDate) {
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
    public Loan setEndDate(String endDate) {
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
    public Loan setFilePath(String filePath) {
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
    public Loan setRemark(String remark) {
        this.remark = remark;
        return this;
    }

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
    public Loan setFactorId(Integer factorId) {
        this.factorId = factorId;
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
    public Loan setStatus(Integer status) {
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
    public Loan setCrtOptr(Integer crtOptr) {
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
    public Loan setCrtTime(String crtTime) {
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
    public Loan setModOptr(Integer modOptr) {
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
    public Loan setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }

	public String getCustDebtorName() {
		return custDebtorName;
	}

	public void setCustDebtorName(String custDebtorName) {
		this.custDebtorName = custDebtorName;
	}

	public String getCustCreditorName() {
		return custCreditorName;
	}

	public void setCustCreditorName(String custCreditorName) {
		this.custCreditorName = custCreditorName;
	}

	public Double getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(Double loanAmt) {
		this.loanAmt = loanAmt;
	}
	
}