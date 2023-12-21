package com.FreightForwarding.service;

import java.io.Serializable;
import java.util.Map;

import com.FreightForwarding.model.CustTransaction;

public interface CustTransactionService {
    
    public Serializable insertCustTransaction(CustTransaction data);
    
    public boolean updateCustTransaction(CustTransaction data);
    
    public CustTransaction getCustTransaction(Integer Id);
    
    public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData);
    
    public Map<String, Object> getBusinessList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData);
}