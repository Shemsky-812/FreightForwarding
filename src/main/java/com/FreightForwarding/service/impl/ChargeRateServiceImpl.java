package com.FreightForwarding.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.ChargeRate;
import com.FreightForwarding.dao.ChargeRateDao;
import com.FreightForwarding.service.ChargeRateService;

@Service
public class ChargeRateServiceImpl implements ChargeRateService {

	@Autowired
	private ChargeRateDao<ChargeRate> chargeRateDao;


	public Serializable insertChargeRate(ChargeRate data){
		return chargeRateDao.save(data);
	}
	
	public boolean updateChargeRate(ChargeRate data){
		return chargeRateDao.saveOrUpdate(data);
	}
	
	public ChargeRate getChargeRate(Integer Id){
		ChargeRate data = chargeRateDao.get(ChargeRate.class, Id);
		return data;
	}
	
	public ChargeRate getTxRate(String rateType ,Integer roleId){
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "from ChargeRate as u where u.rateType=:rateType and u.roleId=:roleId";
		params.put("rateType", rateType);
		params.put("roleId", roleId);
		return chargeRateDao.get(hql, params);
	}
	
	@Override
	public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", chargeRateDao.getList(pageNumber,pageSize,mapData,false).size());
		result.put("rows", chargeRateDao.getList(pageNumber,pageSize,mapData,true));
		return result;
	}
}
