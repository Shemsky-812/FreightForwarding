package com.FreightForwarding.dao.impl;

import org.springframework.stereotype.Repository;

import com.FreightForwarding.dao.CheckDetailDao;

@Repository("checkDetailDao")
public class CheckDetailDaoImpl<CheckDetail> extends BaseDaoImpl<CheckDetail> implements CheckDetailDao<CheckDetail>{

}