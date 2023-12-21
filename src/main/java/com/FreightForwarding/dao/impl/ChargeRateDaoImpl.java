package com.FreightForwarding.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.FreightForwarding.dao.ChargeRateDao;

@Repository("chargeRateDao")
public class ChargeRateDaoImpl<ChargeRate> extends BaseDaoImpl<ChargeRate> implements ChargeRateDao<ChargeRate>{

	@Override
	public List<Map<String, Object>> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData,boolean isPage) {
		String sql ="select "
					+ "rateId,"
					+ "rateType,"
					+ "rateName,"
					+ "rate, "
					+ "remark, "
					+ "roleId, "
					+ "(select c.custName from customer_info c where c.custId = charge_rate.toCustId) as toCustId, "
					+ "status, "
					+ "(select u.userName from sys_user u where u.userId = charge_rate.modOptr) as modOptr, "
					+ "modTime "
				+ "from charge_rate "
				+ "where status > 0 ";
		if (mapData.get("rateName")!=null && mapData.get("rateName")!="") {
			sql += " and rateName like '%" + mapData.get("rateName") + "%'";
		}
		if (mapData.get("toCustId")!=null && mapData.get("toCustId")!="") {
			sql += " and toCustId = '" + mapData.get("toCustId") + "'";
		}
		if (mapData.get("status")!=null && mapData.get("status")!="") {
			sql += " and status = '" + mapData.get("status") + "'";
		}
		if (isPage) {
			sql += " order by status ,"
				+  " rateId limit " + (pageNumber - 1) * pageSize + "," + pageSize;
		}
			
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
}