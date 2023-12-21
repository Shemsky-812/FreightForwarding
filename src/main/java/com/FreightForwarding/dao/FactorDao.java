package com.FreightForwarding.dao;

import java.util.List;
import java.util.Map;

public interface FactorDao<T> extends BaseDao<T>{

	public List<Map<String, Object>> getList(Integer pageNumber,Integer pageSize,String factorCode,Integer userId,boolean isPage);
}
