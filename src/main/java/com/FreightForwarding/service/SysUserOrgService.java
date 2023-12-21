package com.FreightForwarding.service;

import java.io.Serializable;

import com.FreightForwarding.model.SysUserOrg;

public interface SysUserOrgService {
    
    public Serializable insertSysUserOrg(SysUserOrg data);
    
    public boolean updateSysUserOrg(SysUserOrg data);
    
    public SysUserOrg getSysUserOrg(Integer Id);
    
    public Integer getSysUserOrgByUserId(Integer userId);

}