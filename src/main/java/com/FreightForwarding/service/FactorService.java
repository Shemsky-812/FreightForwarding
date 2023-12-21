package com.FreightForwarding.service;

import java.io.Serializable;
import java.util.Map;

import com.FreightForwarding.model.Factor;

public interface FactorService {
    
    public Serializable insertFactor(Factor data);
    
    public boolean updateFactor(Factor data);
    
    public Factor getFactor(Integer Id);
    
    public Map<String, Object> getList(Integer pageNumber,Integer pageSize,String factorCode,Integer userId);

}