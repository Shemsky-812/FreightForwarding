package com.FreightForwarding.service;

import java.io.Serializable;
import java.util.Map;

import com.FreightForwarding.model.Capital;

public interface CapitalService {
    
    public Serializable insertCapital(Capital data);
    
    public boolean updateCapital(Capital data);
    
    public Capital getCapital(Integer Id);
    
    public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData);
    
    public Capital getCapitalByTradId(Integer tradId);

}