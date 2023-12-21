package com.FreightForwarding.dao;

import java.util.List;
import java.util.Map;

public interface CustomerInfoDao<T> extends BaseDao<T>{

	public List<Map<String, Object>> getComboList();
	
	public List<Map<String, Object>> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData,boolean isPage);
}
