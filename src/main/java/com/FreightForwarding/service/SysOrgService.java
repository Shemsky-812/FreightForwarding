package com.FreightForwarding.service;

import java.io.Serializable;
import java.util.Map;

import com.FreightForwarding.model.SysOrg;

public interface SysOrgService {
    
    public Serializable insertSysOrg(SysOrg data);
    
    public boolean updateSysOrg(SysOrg data);
    
    public SysOrg getSysOrg(Integer Id);
    
    public Map<String, Object> getList(Integer pageNumber,Integer pageSize,String orgName);
    
    public Map<String, Object> getOrgUserList(Integer pageNumber,Integer pageSize,Integer orgId);
    
    public Map<String, Object> getOrgUserInList(Integer pageNumber,Integer pageSize);

    public SysOrg getSysOrgByOrgCode(String orgCode);

}