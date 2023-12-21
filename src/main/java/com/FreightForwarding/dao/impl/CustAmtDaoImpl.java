package com.FreightForwarding.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.FreightForwarding.dao.CustAmtDao;

@Repository("custAmtDao")
public class CustAmtDaoImpl<CustAmt> extends BaseDaoImpl<CustAmt> implements CustAmtDao<CustAmt>{
	
	@Override
	public List<com.FreightForwarding.model.CustAmt> getCustAmtByCustId(Integer custId) {
		String hql = "from CustAmt as u where u.status=1 and u.custId=:custId ";
		Query query = getCurrentSession().createQuery(hql);
		query.setInteger("custId", custId);
		return query.list();
	}
	
	@Override
	public List<Map<String, Object>> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData,boolean isPage) {
		String sql ="select "
					+ "custAmtId,"
					+ "amtCode,"
					+ "amtLevel,"
					+ "amtValue,"
					+ "tradId,"
					+ "tradType, "
					+ "tradNo, "
					+ "tradFrom, "
					+ "tradFromName, "
					+ "tradTo, "
					+ "tradToName, "
					+ "(select c.custName from customer_info c where c.custId = cust_amt.custId) as custId, "
					+ "status, "
					+ "(select u.userName from sys_user u where u.userId = cust_amt.modOptr) as modOptr, "
					+ "modTime "
				+ "from cust_amt "
				+ "where 1=1 ";
		if (mapData.get("amtCode")!=null && mapData.get("amtCode")!="") {
			sql += " and amtCode like '%" + mapData.get("amtCode") + "%'";
		}
		if (mapData.get("tradNo")!=null && mapData.get("tradNo")!="") {
			sql += " and tradNo like '%" + mapData.get("tradNo") + "%'";
		}
		if (isPage) {
			sql += " and custAmtId limit " + (pageNumber - 1) * pageSize + "," + pageSize;
		}
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
}