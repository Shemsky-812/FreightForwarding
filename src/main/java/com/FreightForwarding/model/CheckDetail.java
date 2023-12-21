package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "check_detail")
public class CheckDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    /** detailId */
    @Column(name = "detailId")
    private Integer detailId;

    @Column(name = "checkId")
    private Integer checkId;
    
    /** seqNo */
    @Column(name = "seqNo")
    private Integer seqNo;

    /** funcName */
    @Column(name = "funcName")
    private String funcName;

    /** recordId */
    @Column(name = "recordId")
    private Integer recordId;

    /** checkDesc */
    @Column(name = "checkDesc")
    private String checkDesc;

    /** filePath */
    @Column(name = "filePath")
    private String filePath;

    /** checkUserId */
    @Column(name = "checkUserId")
    private Integer checkUserId;

    /** checkUserName */
    @Column(name = "checkUserName")
    private String checkUserName;

    @Column(name = "checkAction")
    private String checkAction;
    
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
     * 获取 detailId 的值
     * @return Integer
     */
    public Integer getDetailId() {
        return detailId;
    }
    
    /**
     * 设置detailId 的值
     * @param Integer detailId
     */
    public CheckDetail setDetailId(Integer detailId) {
        this.detailId = detailId;
        return this;
    }
    
    public Integer getCheckId() {
		return checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	/**
     * 获取 seqNo 的值
     * @return Integer
     */
    public Integer getSeqNo() {
        return seqNo;
    }
    
    /**
     * 设置seqNo 的值
     * @param Integer seqNo
     */
    public CheckDetail setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
        return this;
    }

    /**
     * 获取 funcName 的值
     * @return String
     */
    public String getFuncName() {
        return funcName;
    }
    
    /**
     * 设置funcName 的值
     * @param String funcName
     */
    public CheckDetail setFuncName(String funcName) {
        this.funcName = funcName;
        return this;
    }

    /**
     * 获取 recordId 的值
     * @return Integer
     */
    public Integer getRecordId() {
        return recordId;
    }
    
    /**
     * 设置recordId 的值
     * @param Integer recordId
     */
    public CheckDetail setRecordId(Integer recordId) {
        this.recordId = recordId;
        return this;
    }

    /**
     * 获取 checkDesc 的值
     * @return String
     */
    public String getCheckDesc() {
        return checkDesc;
    }
    
    /**
     * 设置checkDesc 的值
     * @param String checkDesc
     */
    public CheckDetail setCheckDesc(String checkDesc) {
        this.checkDesc = checkDesc;
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
    public CheckDetail setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    /**
     * 获取 checkUserId 的值
     * @return Integer
     */
    public Integer getCheckUserId() {
        return checkUserId;
    }
    
    /**
     * 设置checkUserId 的值
     * @param Integer checkUserId
     */
    public CheckDetail setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
        return this;
    }

    /**
     * 获取 checkUserName 的值
     * @return String
     */
    public String getCheckUserName() {
        return checkUserName;
    }
    
    /**
     * 设置checkUserName 的值
     * @param String checkUserName
     */
    public CheckDetail setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
        return this;
    }

    
    public String getCheckAction() {
		return checkAction;
	}

	public void setCheckAction(String checkAction) {
		this.checkAction = checkAction;
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
    public CheckDetail setStatus(Integer status) {
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
    public CheckDetail setCrtOptr(Integer crtOptr) {
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
    public CheckDetail setCrtTime(String crtTime) {
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
    public CheckDetail setModOptr(Integer modOptr) {
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
    public CheckDetail setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }

}