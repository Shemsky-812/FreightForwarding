package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    /** regId */
    @Column(name = "regId")
    private Integer regId;

    /** custName */
    @Column(name = "custName")
    private String custName;

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

    /** 登录名 */
    @Column(name = "loginNameInp")
    private String loginNameInp;

    /** 密码 */
    @Column(name = "passwdInp")
    private String passwdInp;

    /** 姓名 */
    @Column(name = "userNameInp")
    private String userNameInp;

    /** 性别 */
    @Column(name = "sexInp")
    private String sexInp;

    /** 电话 */
    @Column(name = "mobileNoInp")
    private String mobileNoInp;

    /** 邮箱 */
    @Column(name = "eMailInp")
    private String eMailInp;

    /** 地址 */
    @Column(name = "addressInp")
    private String addressInp;

    /** 登录名 */
    @Column(name = "loginNameApp")
    private String loginNameApp;

    /** 密码 */
    @Column(name = "passwdApp")
    private String passwdApp;

    /** 姓名 */
    @Column(name = "userNameApp")
    private String userNameApp;

    /** 性别 */
    @Column(name = "sexApp")
    private String sexApp;

    /** 电话 */
    @Column(name = "mobileNoApp")
    private String mobileNoApp;

    /** 邮箱 */
    @Column(name = "eMailApp")
    private String eMailApp;

    /** 地址 */
    @Column(name = "addressApp")
    private String addressApp;

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
     * 获取 regId 的值
     * @return Integer
     */
    public Integer getRegId() {
        return regId;
    }
    
    /**
     * 设置regId 的值
     * @param Integer regId
     */
    public Company setRegId(Integer regId) {
        this.regId = regId;
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
    public Company setCustName(String custName) {
        this.custName = custName;
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
    public Company setPaperNo(String paperNo) {
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
    public Company setPaperPath(String paperPath) {
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
    public Company setAccountBank(String accountBank) {
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
    public Company setAccountName(String accountName) {
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
    public Company setAccountNum(String accountNum) {
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
    public Company setTelNo(String telNo) {
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
    public Company setEMail(String eMail) {
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
    public Company setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * 获取 登录名 的值
     * @return String
     */
    public String getLoginNameInp() {
        return loginNameInp;
    }
    
    /**
     * 设置登录名 的值
     * @param String loginNameInp
     */
    public Company setLoginNameInp(String loginNameInp) {
        this.loginNameInp = loginNameInp;
        return this;
    }

    /**
     * 获取 密码 的值
     * @return String
     */
    public String getPasswdInp() {
        return passwdInp;
    }
    
    /**
     * 设置密码 的值
     * @param String passwdInp
     */
    public Company setPasswdInp(String passwdInp) {
        this.passwdInp = passwdInp;
        return this;
    }

    /**
     * 获取 姓名 的值
     * @return String
     */
    public String getUserNameInp() {
        return userNameInp;
    }
    
    /**
     * 设置姓名 的值
     * @param String userNameInp
     */
    public Company setUserNameInp(String userNameInp) {
        this.userNameInp = userNameInp;
        return this;
    }

    /**
     * 获取 性别 的值
     * @return String
     */
    public String getSexInp() {
        return sexInp;
    }
    
    /**
     * 设置性别 的值
     * @param String sexInp
     */
    public Company setSexInp(String sexInp) {
        this.sexInp = sexInp;
        return this;
    }

    /**
     * 获取 电话 的值
     * @return String
     */
    public String getMobileNoInp() {
        return mobileNoInp;
    }
    
    /**
     * 设置电话 的值
     * @param String mobileNoInp
     */
    public Company setMobileNoInp(String mobileNoInp) {
        this.mobileNoInp = mobileNoInp;
        return this;
    }

    /**
     * 获取 邮箱 的值
     * @return String
     */
    public String getEMailInp() {
        return eMailInp;
    }
    
    /**
     * 设置邮箱 的值
     * @param String eMailInp
     */
    public Company setEMailInp(String eMailInp) {
        this.eMailInp = eMailInp;
        return this;
    }

    /**
     * 获取 地址 的值
     * @return String
     */
    public String getAddressInp() {
        return addressInp;
    }
    
    /**
     * 设置地址 的值
     * @param String addressInp
     */
    public Company setAddressInp(String addressInp) {
        this.addressInp = addressInp;
        return this;
    }

    /**
     * 获取 登录名 的值
     * @return String
     */
    public String getLoginNameApp() {
        return loginNameApp;
    }
    
    /**
     * 设置登录名 的值
     * @param String loginNameApp
     */
    public Company setLoginNameApp(String loginNameApp) {
        this.loginNameApp = loginNameApp;
        return this;
    }

    /**
     * 获取 密码 的值
     * @return String
     */
    public String getPasswdApp() {
        return passwdApp;
    }
    
    /**
     * 设置密码 的值
     * @param String passwdApp
     */
    public Company setPasswdApp(String passwdApp) {
        this.passwdApp = passwdApp;
        return this;
    }

    /**
     * 获取 姓名 的值
     * @return String
     */
    public String getUserNameApp() {
        return userNameApp;
    }
    
    /**
     * 设置姓名 的值
     * @param String userNameApp
     */
    public Company setUserNameApp(String userNameApp) {
        this.userNameApp = userNameApp;
        return this;
    }

    /**
     * 获取 性别 的值
     * @return String
     */
    public String getSexApp() {
        return sexApp;
    }
    
    /**
     * 设置性别 的值
     * @param String sexApp
     */
    public Company setSexApp(String sexApp) {
        this.sexApp = sexApp;
        return this;
    }

    /**
     * 获取 电话 的值
     * @return String
     */
    public String getMobileNoApp() {
        return mobileNoApp;
    }
    
    /**
     * 设置电话 的值
     * @param String mobileNoApp
     */
    public Company setMobileNoApp(String mobileNoApp) {
        this.mobileNoApp = mobileNoApp;
        return this;
    }

    /**
     * 获取 邮箱 的值
     * @return String
     */
    public String getEMailApp() {
        return eMailApp;
    }
    
    /**
     * 设置邮箱 的值
     * @param String eMailApp
     */
    public Company setEMailApp(String eMailApp) {
        this.eMailApp = eMailApp;
        return this;
    }

    /**
     * 获取 地址 的值
     * @return String
     */
    public String getAddressApp() {
        return addressApp;
    }
    
    /**
     * 设置地址 的值
     * @param String addressApp
     */
    public Company setAddressApp(String addressApp) {
        this.addressApp = addressApp;
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
    public Company setStatus(Integer status) {
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
    public Company setCrtOptr(Integer crtOptr) {
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
    public Company setCrtTime(String crtTime) {
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
    public Company setModOptr(Integer modOptr) {
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
    public Company setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }


    /**
     * 设置主表 的值
     * @param main data
     */
    public Company setMain(Company data) {
        this.regId = data.getRegId();
        this.custName = data.getCustName();
        this.paperNo = data.getPaperNo();
        this.paperPath = data.getPaperPath();
        this.accountBank = data.getAccountBank();
        this.accountName = data.getAccountName();
        this.accountNum = data.getAccountNum();
        this.telNo = data.getTelNo();
        this.eMail = data.getEMail();
        this.address = data.getAddress();
        this.loginNameInp = data.getLoginNameInp();
        this.passwdInp = data.getPasswdInp();
        this.userNameInp = data.getUserNameInp();
        this.sexInp = data.getSexInp();
        this.mobileNoInp = data.getMobileNoInp();
        this.eMailInp = data.getEMailInp();
        this.addressInp = data.getAddressInp();
        this.loginNameApp = data.getLoginNameApp();
        this.passwdApp = data.getPasswdApp();
        this.userNameApp = data.getUserNameApp();
        this.sexApp = data.getSexApp();
        this.mobileNoApp = data.getMobileNoApp();
        this.eMailApp = data.getEMailApp();
        this.addressApp = data.getAddressApp();
        this.status = data.getStatus();
        this.crtOptr = data.getCrtOptr();
        this.crtTime = data.getCrtTime();
        this.modOptr = data.getModOptr();
        this.modTime = data.getModTime();

    	return this;
    }

}