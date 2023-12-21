package com.FreightForwarding.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.CustAmt;
import com.FreightForwarding.dao.CustAmtDao;
import com.FreightForwarding.service.CustAmtService;

@Service
public class CustAmtServiceImpl implements CustAmtService {

	@Autowired
	private CustAmtDao<CustAmt> custAmtDao;


	public Serializable insertCustAmt(CustAmt data){
		return custAmtDao.save(data);
	}
	
	public boolean updateCustAmt(CustAmt data){
		return custAmtDao.saveOrUpdate(data);
	}
	
	public CustAmt getCustAmt(Integer Id){
		CustAmt data = custAmtDao.get(CustAmt.class, Id);
		return data;
	}
	
	public List<CustAmt> getCustAmtByCustId(Integer custId) {
		return custAmtDao.getCustAmtByCustId(custId);
	}
	
	@Override
	public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", custAmtDao.getList(pageNumber,pageSize,mapData,false).size());
		result.put("rows", custAmtDao.getList(pageNumber,pageSize,mapData,true));
		return result;
	}
}
