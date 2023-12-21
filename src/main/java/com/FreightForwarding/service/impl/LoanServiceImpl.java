package com.FreightForwarding.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightForwarding.model.Loan;
import com.FreightForwarding.dao.LoanDao;
import com.FreightForwarding.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDao<Loan> loanDao;


	public Serializable insertLoan(Loan data){
		return loanDao.save(data);
	}
	
	public boolean updateLoan(Loan data){
		return loanDao.saveOrUpdate(data);
	}
	
	public Loan getLoan(Integer Id){
		Loan data = loanDao.get(Loan.class, Id);
		return data;
	}
	
	public Loan getLoanByfactorId(Integer factorId){
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "from Loan as u where u.factorId=:factorId ";
		params.put("factorId", factorId);
		try{
			return loanDao.get(hql, params);
		}catch (Exception e) {
			// TODO: handle exception;
			return new Loan();
		}
	}
}
