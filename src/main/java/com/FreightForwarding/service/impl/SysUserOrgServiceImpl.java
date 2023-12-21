package com.FreightForwarding.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.SysUserOrg;
import com.FreightForwarding.dao.SysUserOrgDao;
import com.FreightForwarding.service.SysUserOrgService;

@Service
public class SysUserOrgServiceImpl implements SysUserOrgService {

	@Autowired
	private SysUserOrgDao<SysUserOrg> sysUserOrgDao;


	public Serializable insertSysUserOrg(SysUserOrg data){
		return sysUserOrgDao.save(data);
	}
	
	public boolean updateSysUserOrg(SysUserOrg data){
		return sysUserOrgDao.saveOrUpdate(data);
	}
	
	public SysUserOrg getSysUserOrg(Integer Id){
		SysUserOrg data = sysUserOrgDao.get(SysUserOrg.class, Id);
		return data;
	}
	
	@Override
	public Integer getSysUserOrgByUserId(Integer userId){
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "from SysUserOrg where status > 0 and userId = :userId ";
		params.put("userId", userId);
		SysUserOrg data = sysUserOrgDao.get(hql, params);
		 return data.getOrgId();
	}
}
