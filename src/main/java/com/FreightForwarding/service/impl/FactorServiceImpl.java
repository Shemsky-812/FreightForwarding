package com.FreightForwarding.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.Factor;
import com.FreightForwarding.dao.FactorDao;
import com.FreightForwarding.service.FactorService;

@Service
public class FactorServiceImpl implements FactorService {

	@Autowired
	private FactorDao<Factor> factorDao;


	public Serializable insertFactor(Factor data){
		return factorDao.save(data);
	}
	
	public boolean updateFactor(Factor data){
		return factorDao.saveOrUpdate(data);
	}
	
	public Factor getFactor(Integer Id){
		Factor data = factorDao.get(Factor.class, Id);
		return data;
	}
	
	@Override
	public Map<String, Object> getList(Integer pageNumber,Integer pageSize,String factorCode,Integer userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", factorDao.getList(pageNumber,pageSize,factorCode,userId,false).size());
		result.put("rows", factorDao.getList(pageNumber,pageSize,factorCode,userId,true));
		return result;
	}
}
