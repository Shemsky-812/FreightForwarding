package com.FreightForwarding.dao.impl;

import org.springframework.stereotype.Repository;

import com.FreightForwarding.dao.CheckInfoDao;

@Repository("checkInfoDao")
public class CheckInfoDaoImpl<CheckInfo> extends BaseDaoImpl<CheckInfo> implements CheckInfoDao<CheckInfo>{

}