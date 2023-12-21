package com.FreightForwarding.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.Capital;
import com.FreightForwarding.dao.CapitalDao;
import com.FreightForwarding.service.CapitalService;

@Service
public class CapitalServiceImpl implements CapitalService {

	@Autowired
	private CapitalDao<Capital> capitalDao;


	public Serializable insertCapital(Capital data){
		return capitalDao.save(data);
	}
	
	public boolean updateCapital(Capital data){
		return capitalDao.saveOrUpdate(data);
	}
	
	public Capital getCapital(Integer Id){
		Capital data = capitalDao.get(Capital.class, Id);
		return data;
	}
	
	@Override
	public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", capitalDao.getList(pageNumber,pageSize,mapData,false).size());
		result.put("rows", capitalDao.getList(pageNumber,pageSize,mapData,true));
		return result;
	}
	
	@Override
	public Capital getCapitalByTradId(Integer tradId){
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "from Capital where tradId = :tradId ";
		params.put("tradId", tradId);
		Capital data = capitalDao.get(hql, params);
		 return data;
	}
}
