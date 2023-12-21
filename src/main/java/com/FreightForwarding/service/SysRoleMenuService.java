package com.FreightForwarding.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.FreightForwarding.model.SysRoleMenu;
import com.FreightForwarding.utils.MenuVo;

public interface SysRoleMenuService {
    
    public Serializable insertSysRoleMenu(SysRoleMenu data);
    
    public boolean updateSysRoleMenu(SysRoleMenu data);
    
    public int deleteSysRoleMenu(Integer roleId);
    
    public SysRoleMenu getSysRoleMenu(Integer Id);
    
    public List<MenuVo> getMenus(Integer roleId, Integer pmenuId);
    
    public List<Map<String, Object>> rolePrivilege(Integer roleId);

}