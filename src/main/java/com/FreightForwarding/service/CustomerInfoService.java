package com.FreightForwarding.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.FreightForwarding.model.CustomerInfo;

public interface CustomerInfoService {
    
    public Serializable insertCustomerInfo(CustomerInfo data);
    
    public boolean updateCustomerInfo(CustomerInfo data);
    
    public CustomerInfo getCustomerInfo(Integer Id);
    
    public List<Map<String, Object>> getComboList();
    
    public CustomerInfo getCustomerInfoByOrgId(Integer orgId);
    
    public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData);

}