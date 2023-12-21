package com.FreightForwarding.service;

import java.io.Serializable;

import com.FreightForwarding.model.CheckDetail;

public interface CheckDetailService {
    
    public Serializable insertCheckDetail(CheckDetail data);
    
    public boolean updateCheckDetail(CheckDetail data);
    
    public CheckDetail getCheckDetail(Integer Id);

}