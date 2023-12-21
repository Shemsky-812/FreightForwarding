package com.FreightForwarding.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.FreightForwarding.dao.CapitalDao;

@Repository("capitalDao")
public class CapitalDaoImpl<Capital> extends BaseDaoImpl<Capital> implements CapitalDao<Capital>{

	@Override
	public List<Map<String, Object>> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData,boolean isPage) {
		String sql ="select "
					+ "capitalId,"
					+ "capitalCode,"
					+ "tradId,"
					+ "tradType,"
					+ "tradNo,"
					+ "tradFrom, "
					+ "tradFromName, "
					+ "tradFromBank, "
					+ "tradFromAccount, "
					+ "tradTo, "
					+ "tradToName, "
					+ "tradToBank, "
					+ "tradToAccount, "
					+ "capitalAmt, "
					+ "picPath, "
					+ "checkId, "
					+ "status, "
					+ "(select u.userName from sys_user u where u.userId = capital.modOptr) as modOptr, "
					+ "modTime "
				+ "from capital "
				+ "where status > 0 ";
		if (mapData.get("tradType")!=null && mapData.get("tradType")!="") {
			sql += " and tradType like '%" + mapData.get("tradType") + "%'";
		}
		if (mapData.get("tradFromName")!=null && mapData.get("tradFromName")!="") {
			sql += " and tradFromName like '%" + mapData.get("tradFromName") + "%'";
		}
		if (mapData.get("tradToName")!=null && mapData.get("tradToName")!="") {
			sql += " and tradToName like '%" + mapData.get("tradToName") + "%'";
		}
		if (isPage) {
			sql += " and capitalId limit " + (pageNumber - 1) * pageSize + "," + pageSize;
		}
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
}