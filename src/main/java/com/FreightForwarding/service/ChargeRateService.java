package com.FreightForwarding.service;

import java.io.Serializable;
import java.util.Map;

import com.FreightForwarding.model.ChargeRate;

public interface ChargeRateService {
    
    public Serializable insertChargeRate(ChargeRate data);
    
    public boolean updateChargeRate(ChargeRate data);
    
    public ChargeRate getChargeRate(Integer Id);
    
    public ChargeRate getTxRate(String rateType ,Integer roleId);
    
    public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData) ;

}