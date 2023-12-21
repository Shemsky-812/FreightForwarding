package com.FreightForwarding.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.CustomerInfo;
import com.FreightForwarding.dao.CustomerInfoDao;
import com.FreightForwarding.service.CustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

	@Autowired
	private CustomerInfoDao<CustomerInfo> customerInfoDao;


	public Serializable insertCustomerInfo(CustomerInfo data){
		return customerInfoDao.save(data);
	}
	
	public boolean updateCustomerInfo(CustomerInfo data){
		return customerInfoDao.saveOrUpdate(data);
	}
	
	public CustomerInfo getCustomerInfo(Integer Id){
		CustomerInfo data = customerInfoDao.get(CustomerInfo.class, Id);
		return data;
	}
	
	public List<Map<String, Object>> getComboList() {
		List<Map<String, Object>> result = customerInfoDao.getComboList();
		return result;
	}
	
	@Override
	public CustomerInfo getCustomerInfoByOrgId(Integer orgId){
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "from CustomerInfo where orgId = :orgId ";
		params.put("orgId", orgId);
		CustomerInfo data = customerInfoDao.get(hql, params);
		 return data;
	}
	
	@Override
	public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", customerInfoDao.getList(pageNumber,pageSize,mapData,false).size());
		result.put("rows", customerInfoDao.getList(pageNumber,pageSize,mapData,true));
		return result;
	}
}
