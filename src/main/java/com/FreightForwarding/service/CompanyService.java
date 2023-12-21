package com.FreightForwarding.service;

import java.io.Serializable;
import java.util.Map;

import com.FreightForwarding.model.Company;

public interface CompanyService {
    
    public Serializable insertCompany(Company data);
    
    public boolean updateCompany(Company data);
    
    public Company getCompany(Integer Id);
    
    public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData);

}