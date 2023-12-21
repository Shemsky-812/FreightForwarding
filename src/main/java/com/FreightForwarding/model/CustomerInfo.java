package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_info")
public class CustomerInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    /** custId */
    @Column(name = "custId")
    private Integer custId;

    /** custName */
    @Column(name = "custName")
    private String custName;

    /** custDesc */
    @Column(name = "custDesc")
    private String custDesc;

    /** paperNo */
    @Column(name = "paperNo")
    private String paperNo;

    /** paperPath */
    @Column(name = "paperPath")
    private String paperPath;

    /** accountBank */
    @Column(name = "accountBank")
    private String accountBank;

    /** accountName */
    @Column(name = "accountName")
    private String accountName;

    /** accountNum */
    @Column(name = "accountNum")
    private String accountNum;

    /** telNo */
    @Column(name = "telNo")
    private String telNo;

    /** eMail */
    @Column(name = "eMail")
    private String eMail;

    /** address */
    @Column(name = "address")
    private String address;

    /** amtAll */
    @Column(name = "amtAll")
    private Double amtAll;

    /** amtClock */
    @Column(name = "amtClock")
    private Double amtClock;

    /** amtFree */
    @Column(name = "amtFree")
    private Double amtFree;

    /** orgId */
    @Column(name = "orgId")
    private Integer orgId;

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
    public CustomerInfo setCustId(Integer custId) {
        this.custId = custId;
        return this;
    }

    /**
     * 获取 custName 的值
     * @return String
     */
    public String getCustName() {
        return custName;
    }
    
    /**
     * 设置custName 的值
     * @param String custName
     */
    public CustomerInfo setCustName(String custName) {
        this.custName = custName;
        return this;
    }

    /**
     * 获取 custDesc 的值
     * @return String
     */
    public String getCustDesc() {
        return custDesc;
    }
    
    /**
     * 设置custDesc 的值
     * @param String custDesc
     */
    public CustomerInfo setCustDesc(String custDesc) {
        this.custDesc = custDesc;
        return this;
    }

    /**
     * 获取 paperNo 的值
     * @return String
     */
    public String getPaperNo() {
        return paperNo;
    }
    
    /**
     * 设置paperNo 的值
     * @param String paperNo
     */
    public CustomerInfo setPaperNo(String paperNo) {
        this.paperNo = paperNo;
        return this;
    }

    /**
     * 获取 paperPath 的值
     * @return String
     */
    public String getPaperPath() {
        return paperPath;
    }
    
    /**
     * 设置paperPath 的值
     * @param String paperPath
     */
    public CustomerInfo setPaperPath(String paperPath) {
        this.paperPath = paperPath;
        return this;
    }

    /**
     * 获取 accountBank 的值
     * @return String
     */
    public String getAccountBank() {
        return accountBank;
    }
    
    /**
     * 设置accountBank 的值
     * @param String accountBank
     */
    public CustomerInfo setAccountBank(String accountBank) {
        this.accountBank = accountBank;
        return this;
    }

    /**
     * 获取 accountName 的值
     * @return String
     */
    public String getAccountName() {
        return accountName;
    }
    
    /**
     * 设置accountName 的值
     * @param String accountName
     */
    public CustomerInfo setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    /**
     * 获取 accountNum 的值
     * @return String
     */
    public String getAccountNum() {
        return accountNum;
    }
    
    /**
     * 设置accountNum 的值
     * @param String accountNum
     */
    public CustomerInfo setAccountNum(String accountNum) {
        this.accountNum = accountNum;
        return this;
    }

    /**
     * 获取 telNo 的值
     * @return String
     */
    public String getTelNo() {
        return telNo;
    }
    
    /**
     * 设置telNo 的值
     * @param String telNo
     */
    public CustomerInfo setTelNo(String telNo) {
        this.telNo = telNo;
        return this;
    }

    /**
     * 获取 eMail 的值
     * @return String
     */
    public String getEMail() {
        return eMail;
    }
    
    /**
     * 设置eMail 的值
     * @param String eMail
     */
    public CustomerInfo setEMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    /**
     * 获取 address 的值
     * @return String
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * 设置address 的值
     * @param String address
     */
    public CustomerInfo setAddress(String address) {
        this.address = address;
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
    public CustomerInfo setAmtAll(Double amtAll) {
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
    public CustomerInfo setAmtClock(Double amtClock) {
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
    public CustomerInfo setAmtFree(Double amtFree) {
        this.amtFree = amtFree;
        return this;
    }

    /**
     * 获取 orgId 的值
     * @return Integer
     */
    public Integer getOrgId() {
        return orgId;
    }
    
    /**
     * 设置orgId 的值
     * @param Integer orgId
     */
    public CustomerInfo setOrgId(Integer orgId) {
        this.orgId = orgId;
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
    public CustomerInfo setCheckId(Integer checkId) {
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
    public CustomerInfo setStatus(Integer status) {
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
    public CustomerInfo setCrtOptr(Integer crtOptr) {
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
    public CustomerInfo setCrtTime(String crtTime) {
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
    public CustomerInfo setModOptr(Integer modOptr) {
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
    public CustomerInfo setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }

}