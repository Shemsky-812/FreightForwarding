package com.FreightForwarding.dao;

import java.util.List;
import java.util.Map;

public interface SysMenuDao<T> extends BaseDao<T>{

	public List<Map<String, Object>> getLowMenu(Integer pId);
}
