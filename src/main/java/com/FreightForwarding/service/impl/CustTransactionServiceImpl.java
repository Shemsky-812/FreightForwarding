package com.FreightForwarding.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.CustTransaction;
import com.FreightForwarding.dao.CustTransactionDao;
import com.FreightForwarding.service.CustTransactionService;

@Service
public class CustTransactionServiceImpl implements CustTransactionService {

	@Autowired
	private CustTransactionDao<CustTransaction> custTransactionDao;


	public Serializable insertCustTransaction(CustTransaction data){
		return custTransactionDao.save(data);
	}
	
	public boolean updateCustTransaction(CustTransaction data){
		return custTransactionDao.saveOrUpdate(data);
	}
	
	public CustTransaction getCustTransaction(Integer Id){
		CustTransaction data = custTransactionDao.get(CustTransaction.class, Id);
		return data;
	}
	
	@Override
	public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", custTransactionDao.getList(pageNumber,pageSize,mapData,false).size());
		result.put("rows", custTransactionDao.getList(pageNumber,pageSize,mapData,true));
		return result;
	}
	
	@Override
	public Map<String, Object> getBusinessList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", custTransactionDao.getBusinessList(pageNumber,pageSize,mapData,false).size());
		result.put("rows", custTransactionDao.getBusinessList(pageNumber,pageSize,mapData,true));
		return result;
	}
}
