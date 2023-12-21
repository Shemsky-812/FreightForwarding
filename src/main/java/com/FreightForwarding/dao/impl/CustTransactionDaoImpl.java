package com.FreightForwarding.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.FreightForwarding.dao.CustTransactionDao;

@Repository("custTransactionDao")
public class CustTransactionDaoImpl<CustTransaction> extends BaseDaoImpl<CustTransaction> implements CustTransactionDao<CustTransaction>{

	@Override
	public List<Map<String, Object>> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData,boolean isPage) {
		String sql ="select "
					+ "tradId,"
					+ "tradType,"
					+ "tradNo,"
					+ "tradFrom, "
					+ "tradFromName, "
					+ "tradTo, "
					+ "tradToName, "
					+ "amtAll, "
					+ "amtClock, "
					+ "amtFree, "
					+ "tradAmt, "
					+ "chargeRate, "
					+ "rateAmt, "
					+ "filePath, "
					+ "custId, "
					+ "checkId, "
					+ "status, "
					+ "(select u.userName from sys_user u where u.userId = cust_transaction.modOptr) as modOptr, "
					+ "modTime "
				+ "from cust_transaction "
				+ "where status > 0 "
				+ "  and custId ="+mapData.get("custId");
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
			sql += " and tradId limit " + (pageNumber - 1) * pageSize + "," + pageSize;
		}
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	@Override
	public List<Map<String, Object>> getBusinessList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData,boolean isPage) {
		String sql ="select "
					+ "tradId,"
					+ "tradType,"
					+ "tradNo,"
					+ "tradFrom, "
					+ "tradFromName, "
					+ "tradTo, "
					+ "tradToName, "
					+ "amtAll, "
					+ "amtClock, "
					+ "amtFree, "
					+ "tradAmt, "
					+ "chargeRate, "
					+ "rateAmt, "
					+ "filePath, "
					+ "custId, "
					+ "checkId, "
					+ "status, "
					+ "(select u.userName from sys_user u where u.userId = cust_transaction.modOptr) as modOptr, "
					+ "modTime "
				+ "from cust_transaction "
				+ "where status = 1 "
				+ "  and custId ="+mapData.get("custId");
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
			sql += " and tradId limit " + (pageNumber - 1) * pageSize + "," + pageSize;
		}
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
}