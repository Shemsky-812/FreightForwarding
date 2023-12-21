package com.FreightForwarding.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.CheckDetail;
import com.FreightForwarding.dao.CheckDetailDao;
import com.FreightForwarding.service.CheckDetailService;

@Service
public class CheckDetailServiceImpl implements CheckDetailService {

	@Autowired
	private CheckDetailDao<CheckDetail> checkDetailDao;


	public Serializable insertCheckDetail(CheckDetail data){
		return checkDetailDao.save(data);
	}
	
	public boolean updateCheckDetail(CheckDetail data){
		return checkDetailDao.saveOrUpdate(data);
	}
	
	public CheckDetail getCheckDetail(Integer Id){
		CheckDetail data = checkDetailDao.get(CheckDetail.class, Id);
		return data;
	}
}
