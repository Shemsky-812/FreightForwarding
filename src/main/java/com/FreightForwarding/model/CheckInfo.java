package com.FreightForwarding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "check_info")
public class CheckInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    /** checkId */
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
    public CheckInfo setCheckId(Integer checkId) {
        this.checkId = checkId;
        return this;
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
    public CheckInfo setSeqNo(Integer seqNo) {
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
    public CheckInfo setFuncName(String funcName) {
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
    public CheckInfo setRecordId(Integer recordId) {
        this.recordId = recordId;
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
    public CheckInfo setStatus(Integer status) {
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
    public CheckInfo setCrtOptr(Integer crtOptr) {
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
    public CheckInfo setCrtTime(String crtTime) {
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
    public CheckInfo setModOptr(Integer modOptr) {
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
    public CheckInfo setModTime(String modTime) {
        this.modTime = modTime;
        return this;
    }
}