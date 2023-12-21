package com.FreightForwarding.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.FreightForwarding.dao.FactorDao;

@Repository("factorDao")
public class FactorDaoImpl<Factor> extends BaseDaoImpl<Factor> implements FactorDao<Factor>{

	@Override
	public List<Map<String, Object>> getList(Integer pageNumber,Integer pageSize,String factorCode,Integer userId,boolean isPage) {
		String sql ="select "
					+ "factor.factorId,"
					+ "factor.factorCode,"
					+ "factor.custSell,"
					+ "factor.custSellName, "
					+ "factor.custfactor, "
					+ "factor.custfactorName, "
					+ "factor.factorAmt, "
					+ "factor.startDate, "
					+ "factor.tenor, "
					+ "factor.status, "
					+ "(select u.userName from sys_user u where u.userId = factor.modOptr) as modOptr, "
					+ "factor.modTime "
				+ "from factor "
				+ "where factor.status > 0 ";
		if (factorCode!=null && factorCode!="") {
			sql += " and factorCode like '%" + factorCode + "%'";
		}
		if (userId!=null && userId!=0){
			sql += " and ("
			    +    "(custSell in (select orgId from sys_user_org where status > 0 and userId = " + userId + "))"
			    +    " or (custfactor in (select orgId from sys_user_org where status > 0 and userId = " + userId + "))"
			    +  ")";
		}
		if (isPage) {
			sql += " and factorId limit " + (pageNumber - 1) * pageSize + "," + pageSize;
		}
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
}