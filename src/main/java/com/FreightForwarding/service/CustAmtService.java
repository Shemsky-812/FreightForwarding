package com.FreightForwarding.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.FreightForwarding.model.CustAmt;

public interface CustAmtService {
    
    public Serializable insertCustAmt(CustAmt data);
    
    public boolean updateCustAmt(CustAmt data);
    
    public CustAmt getCustAmt(Integer Id);
    
    public List<CustAmt> getCustAmtByCustId(Integer custId);
    
    public Map<String, Object> getList(Integer pageNumber,Integer pageSize,Map<String, Object> mapData);

}