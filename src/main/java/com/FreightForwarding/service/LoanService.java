package com.FreightForwarding.service;

import java.io.Serializable;

import com.FreightForwarding.model.Loan;

public interface LoanService {
    
    public Serializable insertLoan(Loan data);
    
    public boolean updateLoan(Loan data);
    
    public Loan getLoan(Integer Id);
    
    public Loan getLoanByfactorId(Integer factorId);

}