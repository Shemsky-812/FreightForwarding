package com.FreightForwarding.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.FreightForwarding.dao.CompanyDao;

@Repository("companyDao")
public class CompanyDaoImpl<Company> extends BaseDaoImpl<Company> implements CompanyDao<Company>{

	@Override
	public List<Map<String, Object>> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData,boolean isPage) {
		String sql ="select "
					+ "regId,"
					+ "custName,"
					+ "paperNo, "
					+ "paperPath, "
					+ "accountBank, "
					+ "accountName, "
					+ "accountNum, "
					+ "telNo, "
					+ "eMail, "
					+ "address, "
					+ "status, "
					+ "(select u.userName from sys_user u where u.userId = company.modOptr) as modOptr, "
					+ "modTime "
				+ "from company "
				+ "where status > 0 ";
		if (mapData.get("custName")!=null && mapData.get("custName")!="") {
			sql += " and custName like '%" + mapData.get("custName") + "%'";
		}
		if (mapData.get("paperNo")!=null && mapData.get("paperNo")!="") {
			sql += " and paperNo like '%" + mapData.get("paperNo") + "%'";
		}
		if (mapData.get("status")!=null && mapData.get("status")!="") {
			sql += " and status = '" + mapData.get("status") + "'";
		}
		if (isPage) {
			sql += " order by status ,"
				+  " regId limit " + (pageNumber - 1) * pageSize + "," + pageSize;
		}
			
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
}