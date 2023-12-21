package com.FreightForwarding.dao.impl;

import org.springframework.stereotype.Repository;

import com.FreightForwarding.dao.LoanDao;

@Repository("loanDao")
public class LoanDaoImpl<Loan> extends BaseDaoImpl<Loan> implements LoanDao<Loan>{

}