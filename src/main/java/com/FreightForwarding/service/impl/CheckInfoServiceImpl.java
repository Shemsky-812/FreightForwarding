package com.FreightForwarding.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.CheckInfo;
import com.FreightForwarding.dao.CheckInfoDao;
import com.FreightForwarding.service.CheckInfoService;

@Service
public class CheckInfoServiceImpl implements CheckInfoService {

	@Autowired
	private CheckInfoDao<CheckInfo> checkInfoDao;


	public Serializable insertCheckInfo(CheckInfo data){
		return checkInfoDao.save(data);
	}
	
	public boolean updateCheckInfo(CheckInfo data){
		return checkInfoDao.saveOrUpdate(data);
	}
	
	public CheckInfo getCheckInfo(Integer Id){
		CheckInfo data = checkInfoDao.get(CheckInfo.class, Id);
		return data;
	}
}
