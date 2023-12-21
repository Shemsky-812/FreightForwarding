package com.FreightForwarding.dao;

import java.util.List;
import java.util.Map;

import com.FreightForwarding.model.CustAmt;

public interface CustAmtDao<T> extends BaseDao<T>{

	public List<CustAmt> getCustAmtByCustId(Integer custId);
	
	public List<Map<String, Object>> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData,boolean isPage);
}
