package com.FreightForwarding.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.Company;
import com.FreightForwarding.dao.CompanyDao;
import com.FreightForwarding.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao<Company> companyDao;


	public Serializable insertCompany(Company data){
		return companyDao.save(data);
	}
	
	public boolean updateCompany(Company data){
		return companyDao.saveOrUpdate(data);
	}
	
	public Company getCompany(Integer Id){
		Company data = companyDao.get(Company.class, Id);
		return data;
	}
	
	@Override
	public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", companyDao.getList(pageNumber,pageSize,mapData,false).size());
		result.put("rows", companyDao.getList(pageNumber,pageSize,mapData,true));
		return result;
	}
}
