package com.FreightForwarding.service;

import java.io.Serializable;

import com.FreightForwarding.model.CheckInfo;

public interface CheckInfoService {
    
    public Serializable insertCheckInfo(CheckInfo data);
    
    public boolean updateCheckInfo(CheckInfo data);
    
    public CheckInfo getCheckInfo(Integer Id);

}