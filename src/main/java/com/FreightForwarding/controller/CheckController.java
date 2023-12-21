package com.FreightForwarding.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FreightForwarding.model.Capital;
import com.FreightForwarding.model.ChargeRate;
import com.FreightForwarding.model.CheckDetail;
import com.FreightForwarding.model.CheckInfo;
import com.FreightForwarding.model.CustAmt;
import com.FreightForwarding.model.CustTransaction;
import com.FreightForwarding.model.CustomerInfo;
import com.FreightForwarding.model.Factor;
import com.FreightForwarding.model.Loan;
import com.FreightForwarding.model.SysUser;
import com.FreightForwarding.service.CapitalService;
import com.FreightForwarding.service.ChargeRateService;
import com.FreightForwarding.service.CheckDetailService;
import com.FreightForwarding.service.CheckInfoService;
import com.FreightForwarding.service.CustAmtService;
import com.FreightForwarding.service.CustTransactionService;
import com.FreightForwarding.service.CustomerInfoService;
import com.FreightForwarding.service.FactorService;
import com.FreightForwarding.service.LoanService;

@Controller
@RequestMapping("/checkController")
public class CheckController {
	private final static Logger log = Logger.getLogger(CheckController.class);
	
	@Autowired
	private CheckInfoService checkInfoService;
	
	@Autowired
	private CheckDetailService checkDetailService;
	
	@Autowired
	private FactorService factorService;
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private CustomerInfoService customerInfoService;
	
	@Autowired
	private CapitalService capitalService;
	
	@Autowired
	private CustTransactionService custTransactionService;
	
	@Autowired
	private CustAmtService custAmtService;
	
	@Autowired
	private ChargeRateService chargeRateService;
	
	@RequestMapping(value = "/checkConfirm", method = RequestMethod.POST)
	public @ResponseBody Object checkConfirm(HttpServletRequest request,HttpSession session) {
		
		Map<String, Object> resultMap = new HashMap<>();  
		
		SysUser User = (SysUser) session.getAttribute("User");
		
		String txType = request.getParameter("txType"); 
		int txId = Integer.parseInt(request.getParameter("txId"));
		int txStatus = Integer.parseInt(request.getParameter("txStatus"));
		String checkMsg = request.getParameter("checkMsg"); 
		String checkStatus = request.getParameter("checkStatus"); 
		int checkId = Integer.parseInt(request.getParameter("checkId"));
		String checkFilePath = request.getParameter("checkFilePath"); 
		
		if (checkStatus.equals("backStrat")) {
			txStatus = 1;
		} else if(checkStatus.equals("agree")){
			txStatus = txStatus + 1;
		} else if(checkStatus.equals("refuse")){
			txStatus = txStatus - 1;
		}
		Integer seq = 0;
		//更新审批信息
		if (checkId == 0){
			CheckInfo checkInfo = new CheckInfo();
			
			seq= 1;
			checkInfo.setSeqNo(seq);
			checkInfo.setFuncName(txType);
			checkInfo.setRecordId(txId);
			checkInfo.setStatus(txStatus);
			checkInfo.setCrtOptr(User.getUserId());
			checkInfo.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			Serializable id = checkInfoService.insertCheckInfo(checkInfo);
			checkId = Integer.parseInt(id.toString());
		}else{
			CheckInfo checkInfo = checkInfoService.getCheckInfo(checkId);
			
			seq= checkInfo.getSeqNo()+1;
			checkInfo.setSeqNo(seq);
			checkInfo.setFuncName(txType);
			checkInfo.setRecordId(txId);
			checkInfo.setStatus(txStatus);
			checkInfo.setModOptr(User.getUserId());
			checkInfo.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			checkInfoService.updateCheckInfo(checkInfo);
		}
		
		CheckDetail checkDetail = new CheckDetail();
		checkDetail.setCheckId(checkId);
		checkDetail.setSeqNo(seq);
		checkDetail.setFuncName(txType);
		checkDetail.setRecordId(txId);
		checkDetail.setCheckDesc(checkMsg);
		checkDetail.setFilePath(checkFilePath);
		checkDetail.setCheckUserId(User.getUserId());
		checkDetail.setCheckUserName(User.getUserName());
		checkDetail.setCheckAction(checkStatus);
		checkDetail.setStatus(txStatus);
		checkDetail.setCrtOptr(User.getUserId());
		checkDetail.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		checkDetailService.insertCheckDetail(checkDetail);
		
		switch (txType) {
		case "factor":
			//更新保理审批状态
			Factor factor1 = factorService.getFactor(txId);
			
			factor1.setStatus(txStatus);
			factor1.setCheckId(checkId);
			factor1.setModOptr(User.getUserId());
			factor1.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			boolean result1 = factorService.updateFactor(factor1);
			
			if (result1) {
				resultMap.put("isSuc", true);
				resultMap.put("errMsg", "审批成功");
				resultMap.put("returnUrl", "/factorController/factorIndex");
			} else {
				resultMap.put("isSuc", false);
				resultMap.put("errMsg", "审批失败");
			}
			
			break;
			
		case "loanAct":

			Factor factor2 = factorService.getFactor(txId);
			
			factor2.setStatus(txStatus);
			factor2.setCheckId(checkId);
			factor2.setModOptr(User.getUserId());
			factor2.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			boolean result2 = factorService.updateFactor(factor2);
			
			if (result2) {
				Loan loan2 = loanService.getLoanByfactorId(factor2.getFactorId());
				
				//金币信息-生成金币
				CustAmt custAmt = new CustAmt();
				
				custAmt.setAmtCode(java.util.UUID.randomUUID().toString().replace("-","").substring(0, 30));
				custAmt.setAmtLevel(1);
				custAmt.setAmtValue(loan2.getLoanAmt());
				custAmt.setTradId(loan2.getLoanId());
				custAmt.setTradType("生成");
				custAmt.setTradNo(loan2.getLoanCode());
				custAmt.setTradFrom(loan2.getCustCreditor());
				custAmt.setTradFromName(loan2.getCustCreditorName());
				custAmt.setTradTo(loan2.getCustDebtor());
				custAmt.setTradToName(loan2.getCustDebtorName());
				custAmt.setCustId(loan2.getCustDebtor());
				custAmt.setStatus(1);//1-可用，2-已用，0-回收
				custAmt.setCrtOptr(User.getUserId());
				custAmt.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
				custAmtService.insertCustAmt(custAmt);
				
				//更新账户余额
				CustomerInfo tradto = customerInfoService.getCustomerInfo(loan2.getCustDebtor());
				
				BigDecimal loanAmt = new BigDecimal(loan2.getLoanAmt().toString());
				BigDecimal amtAll = new BigDecimal(tradto.getAmtAll().toString());
				tradto.setAmtAll(amtAll.add(loanAmt).doubleValue());
				BigDecimal amtFree = new BigDecimal(tradto.getAmtFree().toString());
				tradto.setAmtFree(amtFree.add(loanAmt).doubleValue());
				tradto.setModOptr(User.getUserId());
				tradto.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
				customerInfoService.updateCustomerInfo(tradto);
				
				//生成转账记录
				CustTransaction custTransaction = new CustTransaction();
				
				custTransaction.setTradType("充值");
				custTransaction.setTradNo(loan2.getLoanCode());
				custTransaction.setTradFrom(loan2.getCustCreditor());
				custTransaction.setTradFromName(loan2.getCustCreditorName());
				custTransaction.setTradTo(loan2.getCustDebtor());
				custTransaction.setTradToName(loan2.getCustDebtorName());
				custTransaction.setAmtAll(loan2.getLoanAmt());
				custTransaction.setAmtClock(0.00);
				custTransaction.setAmtFree(loan2.getLoanAmt());
				custTransaction.setTradAmt(loan2.getLoanAmt());
				custTransaction.setChargeRate(0.00);
				custTransaction.setRateAmt(0.00);
				custTransaction.setFilePath("");
				custTransaction.setCustId(loan2.getCustDebtor());
				custTransaction.setCheckId(0);
				custTransaction.setStatus(2);
				custTransaction.setCrtOptr(User.getUserId());
				custTransaction.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
				custTransactionService.insertCustTransaction(custTransaction);
				
				//生成贷款应付记录-现金
				Capital capital = new Capital();
				
				capital.setCapitalCode("");
				capital.setTradId(loan2.getLoanId());
				capital.setTradType("贷款");
				capital.setTradNo(loan2.getLoanCode());
				capital.setTradFrom(loan2.getCustDebtor());
				capital.setTradFromName(tradto.getAccountName());
				capital.setTradFromBank(tradto.getAccountBank());
				capital.setTradFromAccount(tradto.getAccountNum());
				capital.setTradTo(loan2.getCustCreditor());
				capital.setTradToName(loan2.getCustCreditorName());
				capital.setTradToBank("");
				capital.setTradToAccount("");
				capital.setCapitalAmt(loan2.getLoanAmt()+loan2.getInterest());
				capital.setPicPath("");
				capital.setCheckId(0);
				capital.setStatus(1);
				capital.setCrtOptr(User.getUserId());
				capital.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
				Serializable result = capitalService.insertCapital(capital);
				
				if (result.equals(0)) {
					resultMap.put("isSuc", false);
					resultMap.put("errMsg", "审批失败");
				} else {
					resultMap.put("isSuc", true);
					resultMap.put("errMsg", "审批成功");
					resultMap.put("returnUrl", "/factorController/factorIndex");
				}
			} else {
				resultMap.put("isSuc", false);
				resultMap.put("errMsg", "审批失败");
			}
			
			break;
			
		case "factorAct":
			
			Factor factor3 = factorService.getFactor(txId);
			
			factor3.setStatus(txStatus);
			factor3.setCheckId(checkId);
			factor3.setModOptr(User.getUserId());
			factor3.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			boolean result3 = factorService.updateFactor(factor3);
			
			if (result3) {
				//计算手续费
				ChargeRate chargeRate = chargeRateService.getTxRate("1",User.getRoleId());
				
				BigDecimal factoramt = new BigDecimal(factor3.getFactorAmt().toString());
				BigDecimal rate = new BigDecimal(chargeRate.getRate().toString());
				BigDecimal chargeAmt = factoramt.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal valueAmt = factoramt.subtract(chargeAmt);
				
				//更新账户余额-出账
				CustomerInfo tradFrom = customerInfoService.getCustomerInfo(factor3.getCustfactor());
				
				tradFrom.setAmtAll((new BigDecimal(tradFrom.getAmtAll().toString())).subtract(factoramt).doubleValue());
				tradFrom.setAmtFree((new BigDecimal(tradFrom.getAmtFree().toString())).subtract(factoramt).doubleValue());
				tradFrom.setModOptr(User.getUserId());
				tradFrom.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
				customerInfoService.updateCustomerInfo(tradFrom);
				//生成转账记录-出账
				CustTransaction custTransaction1 = new CustTransaction();
				
				custTransaction1.setTradType("转账");
				custTransaction1.setTradNo(factor3.getFactorCode());
				custTransaction1.setTradFrom(factor3.getCustfactor());
				custTransaction1.setTradFromName(factor3.getCustfactorName());
				custTransaction1.setTradTo(factor3.getCustSell());
				custTransaction1.setTradToName(factor3.getCustSellName());
				custTransaction1.setAmtAll(tradFrom.getAmtAll());
				custTransaction1.setAmtClock(tradFrom.getAmtClock());
				custTransaction1.setAmtFree(tradFrom.getAmtFree());
				custTransaction1.setTradAmt(factoramt.doubleValue());
				custTransaction1.setChargeRate(rate.doubleValue());
				custTransaction1.setRateAmt(chargeAmt.doubleValue());
				custTransaction1.setFilePath("");
				custTransaction1.setCustId(factor3.getCustfactor());
				custTransaction1.setCheckId(0);
				custTransaction1.setStatus(2); //1-待审核，2-复核通过
				custTransaction1.setCrtOptr(User.getUserId());
				custTransaction1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
				custTransactionService.insertCustTransaction(custTransaction1);
				//更新账户余额-入账
				CustomerInfo tradTo = customerInfoService.getCustomerInfo(factor3.getCustSell());
				
				tradTo.setAmtAll((new BigDecimal(tradTo.getAmtAll().toString())).add(valueAmt).doubleValue());
				tradTo.setAmtFree((new BigDecimal(tradTo.getAmtFree().toString())).add(valueAmt).doubleValue());
				tradTo.setModOptr(User.getUserId());
				tradTo.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
				customerInfoService.updateCustomerInfo(tradTo);
				//生成转账记录-入账
				CustTransaction custTransaction2 = new CustTransaction();
				
				custTransaction2.setTradType("转账");
				custTransaction2.setTradNo(factor3.getFactorCode());
				custTransaction2.setTradFrom(factor3.getCustfactor());
				custTransaction2.setTradFromName(factor3.getCustfactorName());
				custTransaction2.setTradTo(factor3.getCustSell());
				custTransaction2.setTradToName(factor3.getCustSellName());
				custTransaction2.setAmtAll(tradTo.getAmtAll());
				custTransaction2.setAmtClock(tradTo.getAmtClock());
				custTransaction2.setAmtFree(tradTo.getAmtFree());
				custTransaction2.setTradAmt(valueAmt.doubleValue());
				custTransaction2.setChargeRate(rate.doubleValue());
				custTransaction2.setRateAmt(chargeAmt.doubleValue());
				custTransaction2.setFilePath("");
				custTransaction2.setCustId(factor3.getCustSell());
				custTransaction2.setCheckId(0);
				custTransaction2.setStatus(2); //1-待审核，2-复核通过
				custTransaction2.setCrtOptr(User.getUserId());
				custTransaction2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
				custTransactionService.insertCustTransaction(custTransaction2);
				
				//更新账户余额-手续费
				CustomerInfo tradCharge = customerInfoService.getCustomerInfo(chargeRate.getToCustId());
				
				if (chargeAmt.doubleValue() > 0){
					
					tradCharge.setAmtAll((new BigDecimal(tradCharge.getAmtAll().toString())).add(chargeAmt).doubleValue());
					tradCharge.setAmtFree((new BigDecimal(tradCharge.getAmtFree().toString())).add(chargeAmt).doubleValue());
					tradCharge.setModOptr(User.getUserId());
					tradCharge.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					customerInfoService.updateCustomerInfo(tradCharge);
					//生成转账记录-手续费
					CustTransaction custTransaction3 = new CustTransaction();
					
					custTransaction3.setTradType("手续费");
					custTransaction3.setTradNo(factor3.getFactorCode());
					custTransaction3.setTradFrom(factor3.getCustfactor());
					custTransaction3.setTradFromName(factor3.getCustfactorName());
					custTransaction3.setTradTo(chargeRate.getToCustId());
					custTransaction3.setTradToName(tradCharge.getCustName());
					custTransaction3.setAmtAll(tradCharge.getAmtAll());
					custTransaction3.setAmtClock(tradCharge.getAmtClock());
					custTransaction3.setAmtFree(tradCharge.getAmtFree());
					custTransaction3.setTradAmt(chargeAmt.doubleValue());
					custTransaction3.setChargeRate(0.00);
					custTransaction3.setRateAmt(0.00);
					custTransaction3.setFilePath("");
					custTransaction3.setCustId(chargeRate.getToCustId());
					custTransaction3.setCheckId(0);
					custTransaction3.setStatus(2); //1-待审核，2-复核通过
					custTransaction3.setCrtOptr(User.getUserId());
					custTransaction3.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					custTransactionService.insertCustTransaction(custTransaction3);
				}
				
				//金币信息-金币拆分与转让
				//转账金额（扣除手续费后剩余）
				List<CustAmt> custAmtList1 = custAmtService.getCustAmtByCustId(factor3.getCustfactor());
				
				for(CustAmt custAmt : custAmtList1){
					int seqNo = custAmt.getAmtLevel();
					if (valueAmt.doubleValue() > 0) {
						if (valueAmt.doubleValue() >= custAmt.getAmtValue()) {
							//金币使用
							custAmt.setStatus(2);//1-可用，2-已用，0-回收
							custAmt.setModOptr(User.getUserId());
							custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							
							custAmtService.updateCustAmt(custAmt);
							
							//金币转出
							CustAmt custAmt1 = new CustAmt();
							
							custAmt1.setAmtCode(custAmt.getAmtCode());
							custAmt1.setAmtLevel(seqNo+1);
							custAmt1.setAmtValue(custAmt.getAmtValue());
							custAmt1.setTradId(factor3.getFactorId());
							custAmt1.setTradType("转出");
							custAmt1.setTradNo(factor3.getFactorCode());
							custAmt1.setTradFrom(factor3.getCustfactor());
							custAmt1.setTradFromName(factor3.getCustfactorName());
							custAmt1.setTradTo(factor3.getCustSell());
							custAmt1.setTradToName(factor3.getCustSellName());
							custAmt1.setCustId(factor3.getCustfactor());
							custAmt1.setStatus(2);//1-可用，2-已用，0-回收
							custAmt1.setCrtOptr(User.getUserId());
							custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt1);
							
							//金币转入
							CustAmt custAmt2 = new CustAmt();
							
							custAmt2.setAmtCode(custAmt.getAmtCode());
							custAmt2.setAmtLevel(seqNo+1);
							custAmt2.setAmtValue(custAmt.getAmtValue());
							custAmt2.setTradId(factor3.getFactorId());
							custAmt2.setTradType("转入");
							custAmt2.setTradNo(factor3.getFactorCode());
							custAmt2.setTradFrom(factor3.getCustfactor());
							custAmt2.setTradFromName(factor3.getCustfactorName());
							custAmt2.setTradTo(factor3.getCustSell());
							custAmt2.setTradToName(factor3.getCustSellName());
							custAmt2.setCustId(factor3.getCustSell());
							custAmt2.setStatus(1);//1-可用，2-已用，0-回收
							custAmt2.setCrtOptr(User.getUserId());
							custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt2);
							
							valueAmt = valueAmt.subtract(new BigDecimal(custAmt.getAmtValue().toString()));
						}else{
							//金币使用
							custAmt.setStatus(2);//1-可用，2-已用，0-回收
							custAmt.setModOptr(User.getUserId());
							custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							
							custAmtService.updateCustAmt(custAmt);
							//金币转出
							CustAmt custAmt3 = new CustAmt();
							
							custAmt3.setAmtCode(custAmt.getAmtCode());
							custAmt3.setAmtLevel(seqNo+1);
							custAmt3.setAmtValue(valueAmt.doubleValue());
							custAmt3.setTradId(factor3.getFactorId());
							custAmt3.setTradType("转出");
							custAmt3.setTradNo(factor3.getFactorCode());
							custAmt3.setTradFrom(factor3.getCustfactor());
							custAmt3.setTradFromName(factor3.getCustfactorName());
							custAmt3.setTradTo(factor3.getCustSell());
							custAmt3.setTradToName(factor3.getCustSellName());
							custAmt3.setCustId(factor3.getCustfactor());
							custAmt3.setStatus(2);//1-可用，2-已用，0-回收
							custAmt3.setCrtOptr(User.getUserId());
							custAmt3.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt3);
							//金币拆分
							CustAmt custAmt1 = new CustAmt();
							
							custAmt1.setAmtCode(custAmt.getAmtCode());
							custAmt1.setAmtLevel(seqNo+1);
							BigDecimal amtValue = new BigDecimal(custAmt.getAmtValue().toString());
							custAmt1.setAmtValue(amtValue.subtract(valueAmt).doubleValue());
							custAmt1.setTradId(factor3.getFactorId());
							custAmt1.setTradType("拆分");
							custAmt1.setTradNo(factor3.getFactorCode());
							custAmt1.setCustId(factor3.getCustfactor());
							custAmt1.setStatus(1);//1-可用，2-已用，0-回收
							custAmt1.setCrtOptr(User.getUserId());
							custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt1);
							//金币转入
							CustAmt custAmt2 = new CustAmt();
							
							custAmt2.setAmtCode(custAmt.getAmtCode());
							custAmt2.setAmtLevel(seqNo+1);
							custAmt2.setAmtValue(valueAmt.doubleValue());
							custAmt2.setTradId(factor3.getFactorId());
							custAmt2.setTradType("转入");
							custAmt2.setTradNo(factor3.getFactorCode());
							custAmt2.setTradFrom(factor3.getCustfactor());
							custAmt2.setTradFromName(factor3.getCustfactorName());
							custAmt2.setTradTo(factor3.getCustSell());
							custAmt2.setTradToName(factor3.getCustSellName());
							custAmt2.setCustId(factor3.getCustSell());
							custAmt2.setStatus(1);//1-可用，2-已用，0-回收
							custAmt2.setCrtOptr(User.getUserId());
							custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt2);
							
							valueAmt = new BigDecimal("0.00");
						}
					}
				}
				//转账手续费
				List<CustAmt> custAmtList2 = custAmtService.getCustAmtByCustId(factor3.getCustfactor());
				
				for(CustAmt custAmt : custAmtList2){
					if (chargeAmt.doubleValue() > 0) {
						if (chargeAmt.doubleValue() >= custAmt.getAmtValue()) {
							//金币使用
							custAmt.setStatus(2);//1-可用，2-已用，0-回收
							custAmt.setModOptr(User.getUserId());
							custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							
							custAmtService.updateCustAmt(custAmt);
							
							//金币转出
							CustAmt custAmt1 = new CustAmt();
							
							custAmt1.setAmtCode(custAmt.getAmtCode());
							custAmt1.setAmtLevel(custAmt.getAmtLevel()+1);
							custAmt1.setAmtValue(custAmt.getAmtValue());
							custAmt1.setTradId(factor3.getFactorId());
							custAmt1.setTradType("转出");
							custAmt1.setTradNo(factor3.getFactorCode());
							custAmt1.setTradFrom(factor3.getCustfactor());
							custAmt1.setTradFromName(factor3.getCustfactorName());
							custAmt1.setTradTo(chargeRate.getToCustId());
							custAmt1.setTradToName(tradCharge.getCustName());
							custAmt1.setCustId(factor3.getCustfactor());
							custAmt1.setStatus(2);//1-可用，2-已用，0-回收
							custAmt1.setCrtOptr(User.getUserId());
							custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt1);
							//金币转入
							CustAmt custAmt2 = new CustAmt();
							
							custAmt2.setAmtCode(custAmt.getAmtCode());
							custAmt2.setAmtLevel(custAmt.getAmtLevel()+1);
							custAmt2.setAmtValue(custAmt.getAmtValue());
							custAmt2.setTradId(factor3.getFactorId());
							custAmt2.setTradType("转入");
							custAmt2.setTradNo(factor3.getFactorCode());
							custAmt2.setTradFrom(factor3.getCustfactor());
							custAmt2.setTradFromName(factor3.getCustfactorName());
							custAmt2.setTradTo(chargeRate.getToCustId());
							custAmt2.setTradToName(tradCharge.getCustName());
							custAmt2.setCustId(chargeRate.getToCustId());
							custAmt2.setStatus(1);//1-可用，2-已用，0-回收
							custAmt2.setCrtOptr(User.getUserId());
							custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt2);
							
							chargeAmt = chargeAmt.subtract(new BigDecimal(custAmt.getAmtValue().toString()));
						}else{
							//金币使用
							custAmt.setStatus(2);//1-可用，2-已用，0-回收
							custAmt.setModOptr(User.getUserId());
							custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							
							custAmtService.updateCustAmt(custAmt);
							//金币转出
							CustAmt custAmt3 = new CustAmt();
							
							custAmt3.setAmtCode(custAmt.getAmtCode());
							custAmt3.setAmtLevel(custAmt.getAmtLevel()+1);
							custAmt3.setAmtValue(chargeAmt.doubleValue());
							custAmt3.setTradId(factor3.getFactorId());
							custAmt3.setTradType("转出");
							custAmt3.setTradNo(factor3.getFactorCode());
							custAmt3.setTradFrom(factor3.getCustfactor());
							custAmt3.setTradFromName(factor3.getCustfactorName());
							custAmt3.setTradTo(chargeRate.getToCustId());
							custAmt3.setTradToName(tradCharge.getCustName());
							custAmt3.setCustId(factor3.getCustfactor());
							custAmt3.setStatus(2);//1-可用，2-已用，0-回收
							custAmt3.setCrtOptr(User.getUserId());
							custAmt3.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt3);
							//金币拆分
							CustAmt custAmt1 = new CustAmt();
							
							custAmt1.setAmtCode(custAmt.getAmtCode());
							custAmt1.setAmtLevel(custAmt.getAmtLevel()+1);
							BigDecimal amtValue = new BigDecimal(custAmt.getAmtValue().toString());
							custAmt1.setAmtValue(amtValue.subtract(chargeAmt).doubleValue());
							custAmt1.setTradId(factor3.getFactorId());
							custAmt1.setTradType("拆分");
							custAmt1.setTradNo(factor3.getFactorCode());
							custAmt1.setCustId(factor3.getCustfactor());
							custAmt1.setStatus(1);//1-可用，2-已用，0-回收
							custAmt1.setCrtOptr(User.getUserId());
							custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt1);
							//金币转入
							CustAmt custAmt2 = new CustAmt();
							
							custAmt2.setAmtCode(custAmt.getAmtCode());
							custAmt2.setAmtLevel(custAmt.getAmtLevel()+1);
							custAmt2.setAmtValue(chargeAmt.doubleValue());
							custAmt2.setTradId(factor3.getFactorId());
							custAmt2.setTradType("转入");
							custAmt2.setTradNo(factor3.getFactorCode());
							custAmt2.setTradFrom(factor3.getCustfactor());
							custAmt2.setTradFromName(factor3.getCustfactorName());
							custAmt2.setTradTo(chargeRate.getToCustId());
							custAmt2.setTradToName(tradCharge.getCustName());
							custAmt2.setCustId(chargeRate.getToCustId());
							custAmt2.setStatus(1);//1-可用，2-已用，0-回收
							custAmt2.setCrtOptr(User.getUserId());
							custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							custAmtService.insertCustAmt(custAmt2);
							
							chargeAmt = new BigDecimal("0.00");
						}
					}
				}
				
				//生成保理应收记录-现金
				Capital capital = new Capital();
				
				capital.setCapitalCode("");
				capital.setTradId(factor3.getFactorId());
				capital.setTradType("保理");
				capital.setTradNo(factor3.getFactorCode());
				capital.setTradFrom(factor3.getCustSell());
				capital.setTradFromName(tradTo.getAccountName());
				capital.setTradFromBank(tradTo.getAccountBank());
				capital.setTradFromAccount(tradTo.getAccountNum());
				capital.setTradTo(factor3.getCustfactor());
				capital.setTradToName(tradFrom.getAccountName());
				capital.setTradToBank(tradFrom.getAccountName());
				capital.setTradToAccount(tradFrom.getAccountName());
				capital.setCapitalAmt(factor3.getFactorAmt()+factor3.getInterest());
				capital.setPicPath("");
				capital.setCheckId(0);
				capital.setStatus(1);
				capital.setCrtOptr(User.getUserId());
				capital.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				
				Serializable result = capitalService.insertCapital(capital);
				
				if (result.equals(0)) {
					resultMap.put("isSuc", false);
					resultMap.put("errMsg", "审批失败");
				} else {
					resultMap.put("isSuc", true);
					resultMap.put("errMsg", "审批成功");
					resultMap.put("returnUrl", "/factorController/factorIndex");
				}
			} else {
				resultMap.put("isSuc", false);
				resultMap.put("errMsg", "审批失败");
			}
			
			break;
			
		case "transfer":
			CustTransaction custTransfer = custTransactionService.getCustTransaction(txId);
			
			custTransfer.setStatus(txStatus);
			custTransfer.setCheckId(checkId);
			custTransfer.setModOptr(User.getUserId());
			custTransfer.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			boolean result4 = custTransactionService.updateCustTransaction(custTransfer);
			
			if (result4) {
				if (checkStatus.equals("agree")) {
					//计算手续费
					ChargeRate chargeRate = chargeRateService.getTxRate("1",User.getRoleId());
					
					BigDecimal tradAmt = new BigDecimal(custTransfer.getTradAmt().toString());
					BigDecimal rate = new BigDecimal(chargeRate.getRate().toString());
					BigDecimal chargeAmt = tradAmt.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
					BigDecimal valueAmt = tradAmt.subtract(chargeAmt);
					
					//更新账户余额-出账
					CustomerInfo tradFrom = customerInfoService.getCustomerInfo(custTransfer.getTradFrom());
					
					tradFrom.setAmtAll((new BigDecimal(tradFrom.getAmtAll().toString())).subtract(tradAmt).doubleValue());
					tradFrom.setAmtFree((new BigDecimal(tradFrom.getAmtFree().toString())).subtract(tradAmt).doubleValue());
					tradFrom.setModOptr(User.getUserId());
					tradFrom.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					customerInfoService.updateCustomerInfo(tradFrom);
					//生成转账记录-出账
					CustTransaction custTransaction1 = custTransactionService.getCustTransaction(txId);
					
					custTransaction1.setAmtAll(tradFrom.getAmtAll());
					custTransaction1.setAmtClock(tradFrom.getAmtClock());
					custTransaction1.setAmtFree(tradFrom.getAmtFree());
					custTransaction1.setTradAmt(tradAmt.doubleValue());
					custTransaction1.setChargeRate(rate.doubleValue());
					custTransaction1.setRateAmt(chargeAmt.doubleValue());
					custTransaction1.setCheckId(checkId);
					custTransaction1.setStatus(2); //1-待审核，2-复核通过
					custTransaction1.setCrtOptr(User.getUserId());
					custTransaction1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					custTransactionService.updateCustTransaction(custTransaction1);
					//更新账户余额-入账
					CustomerInfo tradTo = customerInfoService.getCustomerInfo(custTransfer.getTradTo());
					
					tradTo.setAmtAll((new BigDecimal(tradTo.getAmtAll().toString())).add(valueAmt).doubleValue());
					tradTo.setAmtFree((new BigDecimal(tradTo.getAmtFree().toString())).add(valueAmt).doubleValue());
					tradTo.setModOptr(User.getUserId());
					tradTo.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					customerInfoService.updateCustomerInfo(tradTo);
					//生成转账记录-入账
					CustTransaction custTransaction2 = new CustTransaction();
					
					custTransaction2.setTradType("转账");
					custTransaction2.setTradNo(custTransfer.getTradNo());
					custTransaction2.setTradFrom(custTransfer.getTradFrom());
					custTransaction2.setTradFromName(custTransfer.getTradFromName());
					custTransaction2.setTradTo(custTransfer.getTradTo());
					custTransaction2.setTradToName(custTransfer.getTradToName());
					custTransaction2.setAmtAll(tradTo.getAmtAll());
					custTransaction2.setAmtClock(tradTo.getAmtClock());
					custTransaction2.setAmtFree(tradTo.getAmtFree());
					custTransaction2.setTradAmt(valueAmt.doubleValue());
					custTransaction2.setChargeRate(rate.doubleValue());
					custTransaction2.setRateAmt(chargeAmt.doubleValue());
					custTransaction2.setFilePath("");
					custTransaction2.setCustId(custTransfer.getTradTo());
					custTransaction2.setCheckId(0);
					custTransaction2.setStatus(2); //1-待审核，2-复核通过
					custTransaction2.setCrtOptr(User.getUserId());
					custTransaction2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					custTransactionService.insertCustTransaction(custTransaction2);
					
					//更新账户余额-手续费
					CustomerInfo tradCharge = customerInfoService.getCustomerInfo(chargeRate.getToCustId());
					
					if (chargeAmt.doubleValue() > 0){
						
						tradCharge.setAmtAll((new BigDecimal(tradCharge.getAmtAll().toString())).add(chargeAmt).doubleValue());
						tradCharge.setAmtFree((new BigDecimal(tradCharge.getAmtFree().toString())).add(chargeAmt).doubleValue());
						tradCharge.setModOptr(User.getUserId());
						tradCharge.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						
						customerInfoService.updateCustomerInfo(tradCharge);
						//生成转账记录-手续费
						CustTransaction custTransaction3 = new CustTransaction();
						
						custTransaction3.setTradType("手续费");
						custTransaction3.setTradNo(custTransfer.getTradNo());
						custTransaction3.setTradFrom(custTransfer.getTradFrom());
						custTransaction3.setTradFromName(custTransfer.getTradFromName());
						custTransaction3.setTradTo(chargeRate.getToCustId());
						custTransaction3.setTradToName(tradCharge.getCustName());
						custTransaction3.setAmtAll(tradCharge.getAmtAll());
						custTransaction3.setAmtClock(tradCharge.getAmtClock());
						custTransaction3.setAmtFree(tradCharge.getAmtFree());
						custTransaction3.setTradAmt(chargeAmt.doubleValue());
						custTransaction3.setChargeRate(0.00);
						custTransaction3.setRateAmt(0.00);
						custTransaction3.setFilePath("");
						custTransaction3.setCustId(chargeRate.getToCustId());
						custTransaction3.setCheckId(0);
						custTransaction3.setStatus(2); //1-待审核，2-复核通过
						custTransaction3.setCrtOptr(User.getUserId());
						custTransaction3.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						
						custTransactionService.insertCustTransaction(custTransaction3);
					}
					
					//金币信息-金币拆分与转让
					//转账金额（扣除手续费后剩余）
					List<CustAmt> custAmtList1 = custAmtService.getCustAmtByCustId(custTransfer.getTradFrom());
					
					for(CustAmt custAmt : custAmtList1){
						int seqNo = custAmt.getAmtLevel();
						if (valueAmt.doubleValue() > 0) {
							if (valueAmt.doubleValue() >= custAmt.getAmtValue()) {
								//金币使用
								custAmt.setStatus(2);//1-可用，2-已用，0-回收
								custAmt.setModOptr(User.getUserId());
								custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								
								custAmtService.updateCustAmt(custAmt);
								
								//金币转出
								CustAmt custAmt1 = new CustAmt();
								
								custAmt1.setAmtCode(custAmt.getAmtCode());
								custAmt1.setAmtLevel(seqNo+1);
								custAmt1.setAmtValue(custAmt.getAmtValue());
								custAmt1.setTradId(custTransfer.getTradId());
								custAmt1.setTradType("转出");
								custAmt1.setTradNo(custTransfer.getTradNo());
								custAmt1.setTradFrom(custTransfer.getTradFrom());
								custAmt1.setTradFromName(custTransfer.getTradFromName());
								custAmt1.setTradTo(custTransfer.getTradTo());
								custAmt1.setTradToName(custTransfer.getTradToName());
								custAmt1.setCustId(custTransfer.getTradFrom());
								custAmt1.setStatus(2);//1-可用，2-已用，0-回收
								custAmt1.setCrtOptr(User.getUserId());
								custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt1);
								
								//金币转入
								CustAmt custAmt2 = new CustAmt();
								
								custAmt2.setAmtCode(custAmt.getAmtCode());
								custAmt2.setAmtLevel(seqNo+1);
								custAmt2.setAmtValue(custAmt.getAmtValue());
								custAmt2.setTradId(custTransfer.getTradId());
								custAmt2.setTradType("转入");
								custAmt2.setTradNo(custTransfer.getTradNo());
								custAmt2.setTradFrom(custTransfer.getTradFrom());
								custAmt2.setTradFromName(custTransfer.getTradFromName());
								custAmt2.setTradTo(custTransfer.getTradTo());
								custAmt2.setTradToName(custTransfer.getTradToName());
								custAmt2.setCustId(custTransfer.getTradTo());
								custAmt2.setStatus(1);//1-可用，2-已用，0-回收
								custAmt2.setCrtOptr(User.getUserId());
								custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt2);
								
								valueAmt = valueAmt.subtract(new BigDecimal(custAmt.getAmtValue().toString()));
							}else{
								//金币使用
								custAmt.setStatus(2);//1-可用，2-已用，0-回收
								custAmt.setModOptr(User.getUserId());
								custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								
								custAmtService.updateCustAmt(custAmt);
								//金币转出
								CustAmt custAmt3 = new CustAmt();
								
								custAmt3.setAmtCode(custAmt.getAmtCode());
								custAmt3.setAmtLevel(seqNo+1);
								custAmt3.setAmtValue(valueAmt.doubleValue());
								custAmt3.setTradId(custTransfer.getTradId());
								custAmt3.setTradType("转出");
								custAmt3.setTradNo(custTransfer.getTradNo());
								custAmt3.setTradFrom(custTransfer.getTradFrom());
								custAmt3.setTradFromName(custTransfer.getTradFromName());
								custAmt3.setTradTo(custTransfer.getTradTo());
								custAmt3.setTradToName(custTransfer.getTradToName());
								custAmt3.setCustId(custTransfer.getTradFrom());
								custAmt3.setStatus(2);//1-可用，2-已用，0-回收
								custAmt3.setCrtOptr(User.getUserId());
								custAmt3.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt3);
								//金币拆分
								CustAmt custAmt1 = new CustAmt();
								
								custAmt1.setAmtCode(custAmt.getAmtCode());
								custAmt1.setAmtLevel(seqNo+1);
								BigDecimal amtValue = new BigDecimal(custAmt.getAmtValue().toString());
								custAmt1.setAmtValue(amtValue.subtract(valueAmt).doubleValue());
								custAmt1.setTradId(custTransfer.getTradId());
								custAmt1.setTradType("拆分");
								custAmt1.setTradNo(custTransfer.getTradNo());
								custAmt1.setCustId(custTransfer.getTradFrom());
								custAmt1.setStatus(1);//1-可用，2-已用，0-回收
								custAmt1.setCrtOptr(User.getUserId());
								custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt1);
								//金币转入
								CustAmt custAmt2 = new CustAmt();
								
								custAmt2.setAmtCode(custAmt.getAmtCode());
								custAmt2.setAmtLevel(seqNo+1);
								custAmt2.setAmtValue(valueAmt.doubleValue());
								custAmt2.setTradId(custTransfer.getTradId());
								custAmt2.setTradType("转入");
								custAmt2.setTradNo(custTransfer.getTradNo());
								custAmt2.setTradFrom(custTransfer.getTradFrom());
								custAmt2.setTradFromName(custTransfer.getTradFromName());
								custAmt2.setTradTo(custTransfer.getTradTo());
								custAmt2.setTradToName(custTransfer.getTradToName());
								custAmt2.setCustId(custTransfer.getTradTo());
								custAmt2.setStatus(1);//1-可用，2-已用，0-回收
								custAmt2.setCrtOptr(User.getUserId());
								custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt2);
								
								valueAmt = new BigDecimal("0.00");
							}
						}
					}
					//转账手续费
					List<CustAmt> custAmtList2 = custAmtService.getCustAmtByCustId(custTransfer.getTradFrom());
					
					for(CustAmt custAmt : custAmtList2){
						if (chargeAmt.doubleValue() > 0) {
							if (chargeAmt.doubleValue() >= custAmt.getAmtValue()) {
								//金币使用
								custAmt.setStatus(2);//1-可用，2-已用，0-回收
								custAmt.setModOptr(User.getUserId());
								custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								
								custAmtService.updateCustAmt(custAmt);
								
								//金币转出
								CustAmt custAmt1 = new CustAmt();
								
								custAmt1.setAmtCode(custAmt.getAmtCode());
								custAmt1.setAmtLevel(custAmt.getAmtLevel()+1);
								custAmt1.setAmtValue(custAmt.getAmtValue());
								custAmt1.setTradId(custTransfer.getTradId());
								custAmt1.setTradType("转出");
								custAmt1.setTradNo(custTransfer.getTradNo());
								custAmt1.setTradFrom(custTransfer.getTradFrom());
								custAmt1.setTradFromName(custTransfer.getTradFromName());
								custAmt1.setTradTo(chargeRate.getToCustId());
								custAmt1.setTradToName(tradCharge.getCustName());
								custAmt1.setCustId(custTransfer.getTradFrom());
								custAmt1.setStatus(2);//1-可用，2-已用，0-回收
								custAmt1.setCrtOptr(User.getUserId());
								custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt1);
								//金币转入
								CustAmt custAmt2 = new CustAmt();
								
								custAmt2.setAmtCode(custAmt.getAmtCode());
								custAmt2.setAmtLevel(custAmt.getAmtLevel()+1);
								custAmt2.setAmtValue(custAmt.getAmtValue());
								custAmt2.setTradId(custTransfer.getTradId());
								custAmt2.setTradType("转入");
								custAmt2.setTradNo(custTransfer.getTradNo());
								custAmt2.setTradFrom(custTransfer.getTradFrom());
								custAmt2.setTradFromName(custTransfer.getTradFromName());
								custAmt2.setTradTo(chargeRate.getToCustId());
								custAmt2.setTradToName(tradCharge.getCustName());
								custAmt2.setCustId(chargeRate.getToCustId());
								custAmt2.setStatus(1);//1-可用，2-已用，0-回收
								custAmt2.setCrtOptr(User.getUserId());
								custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt2);
								
								chargeAmt = chargeAmt.subtract(new BigDecimal(custAmt.getAmtValue().toString()));
							}else{
								//金币使用
								custAmt.setStatus(2);//1-可用，2-已用，0-回收
								custAmt.setModOptr(User.getUserId());
								custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								
								custAmtService.updateCustAmt(custAmt);
								//金币转出
								CustAmt custAmt3 = new CustAmt();
								
								custAmt3.setAmtCode(custAmt.getAmtCode());
								custAmt3.setAmtLevel(custAmt.getAmtLevel()+1);
								custAmt3.setAmtValue(chargeAmt.doubleValue());
								custAmt3.setTradId(custTransfer.getTradId());
								custAmt3.setTradType("转出");
								custAmt3.setTradNo(custTransfer.getTradNo());
								custAmt3.setTradFrom(custTransfer.getTradFrom());
								custAmt3.setTradFromName(custTransfer.getTradFromName());
								custAmt3.setTradTo(chargeRate.getToCustId());
								custAmt3.setTradToName(tradCharge.getCustName());
								custAmt3.setCustId(custTransfer.getTradFrom());
								custAmt3.setStatus(2);//1-可用，2-已用，0-回收
								custAmt3.setCrtOptr(User.getUserId());
								custAmt3.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt3);
								//金币拆分
								CustAmt custAmt1 = new CustAmt();
								
								custAmt1.setAmtCode(custAmt.getAmtCode());
								custAmt1.setAmtLevel(custAmt.getAmtLevel()+1);
								BigDecimal amtValue = new BigDecimal(custAmt.getAmtValue().toString());
								custAmt1.setAmtValue(amtValue.subtract(chargeAmt).doubleValue());
								custAmt1.setTradId(custTransfer.getTradId());
								custAmt1.setTradType("拆分");
								custAmt1.setTradNo(custTransfer.getTradNo());
								custAmt1.setCustId(custTransfer.getTradFrom());
								custAmt1.setStatus(1);//1-可用，2-已用，0-回收
								custAmt1.setCrtOptr(User.getUserId());
								custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt1);
								//金币转入
								CustAmt custAmt2 = new CustAmt();
								
								custAmt2.setAmtCode(custAmt.getAmtCode());
								custAmt2.setAmtLevel(custAmt.getAmtLevel()+1);
								custAmt2.setAmtValue(chargeAmt.doubleValue());
								custAmt2.setTradId(custTransfer.getTradId());
								custAmt2.setTradType("转入");
								custAmt2.setTradNo(custTransfer.getTradNo());
								custAmt2.setTradFrom(custTransfer.getTradFrom());
								custAmt2.setTradFromName(custTransfer.getTradFromName());
								custAmt2.setTradTo(chargeRate.getToCustId());
								custAmt2.setTradToName(tradCharge.getCustName());
								custAmt2.setCustId(chargeRate.getToCustId());
								custAmt2.setStatus(1);//1-可用，2-已用，0-回收
								custAmt2.setCrtOptr(User.getUserId());
								custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt2);
								
								chargeAmt = new BigDecimal("0.00");
							}
						}
					}
				}
				resultMap.put("isSuc", true);
				resultMap.put("errMsg", "审批成功");
				resultMap.put("returnUrl", "/custAccountController/custBusiness");
			} else {
				resultMap.put("isSuc", false);
				resultMap.put("errMsg", "审批失败");
			}
			
			break;
		case "cashCheck":
			CustTransaction custCashCheck = custTransactionService.getCustTransaction(txId);
			
			custCashCheck.setStatus(txStatus);
			custCashCheck.setCheckId(checkId);
			custCashCheck.setModOptr(User.getUserId());
			custCashCheck.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			boolean result5 = custTransactionService.updateCustTransaction(custCashCheck);
			
			if (result5) {
				if (checkStatus.equals("agree")) {
					//更新账户余额-冻结
					CustomerInfo tradFrom = customerInfoService.getCustomerInfo(custCashCheck.getTradFrom());
					
					BigDecimal amtAll = new BigDecimal(tradFrom.getAmtAll().toString());
					BigDecimal amtClock = new BigDecimal(tradFrom.getAmtClock().toString());
					BigDecimal amtFree = new BigDecimal(tradFrom.getAmtFree().toString());
					BigDecimal tradAmt = new BigDecimal(custCashCheck.getTradAmt().toString());
					BigDecimal rateAmt = new BigDecimal(custCashCheck.getRateAmt().toString());
					
					tradFrom.setAmtAll(amtAll.doubleValue());
					tradFrom.setAmtClock(amtClock.add(tradAmt).doubleValue());
					tradFrom.setAmtFree(amtFree.subtract(tradAmt).doubleValue());
					tradFrom.setModOptr(User.getUserId());
					tradFrom.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					customerInfoService.updateCustomerInfo(tradFrom);
					CustomerInfo tradTo = customerInfoService.getCustomerInfo(custCashCheck.getTradTo());
					//更新提现记录-冻结
					CustTransaction custTransaction1 = custTransactionService.getCustTransaction(txId);
					
					custTransaction1.setAmtAll(amtAll.doubleValue());
					custTransaction1.setAmtClock(amtClock.add(tradAmt).doubleValue());
					custTransaction1.setAmtFree(amtFree.subtract(tradAmt).doubleValue());
					custTransaction1.setTradAmt(tradAmt.doubleValue());
					custTransaction1.setModOptr(User.getUserId());
					custTransaction1.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					custTransactionService.updateCustTransaction(custTransaction1);
					//生成提现应付记录-现金
					Capital capital = new Capital();
					
					capital.setCapitalCode("");
					capital.setTradId(custCashCheck.getTradId());
					capital.setTradType("提现");
					capital.setTradNo(custCashCheck.getTradNo());
					capital.setTradFrom(custCashCheck.getTradTo());
					capital.setTradFromName(tradTo.getAccountName());
					capital.setTradFromBank(tradTo.getAccountBank());
					capital.setTradFromAccount(tradTo.getAccountNum());
					capital.setTradTo(custCashCheck.getTradFrom());
					capital.setTradToName(tradFrom.getAccountName());
					capital.setTradToBank(tradFrom.getAccountName());
					capital.setTradToAccount(tradFrom.getAccountName());
					capital.setCapitalAmt(tradAmt.subtract(rateAmt).doubleValue());
					capital.setPicPath("");
					capital.setCheckId(0);
					capital.setStatus(1);
					capital.setCrtOptr(User.getUserId());
					capital.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					capitalService.insertCapital(capital);
				}
				
				resultMap.put("isSuc", true);
				resultMap.put("errMsg", "审批成功");
				resultMap.put("returnUrl", "/custAccountController/custBusiness");
			} else {
				resultMap.put("isSuc", false);
				resultMap.put("errMsg", "审批失败");
			}
			
			break;
		case "cashConfirm":
			//
			Capital capital = capitalService.getCapitalByTradId(txId);
			capital.setStatus(2);
			capital.setCheckId(checkId);
			capital.setModOptr(User.getUserId());
			capital.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			capitalService.updateCapital(capital);
			//
			
			CustTransaction custCash = custTransactionService.getCustTransaction(txId);
			
			custCash.setStatus(txStatus);
			custCash.setCheckId(checkId);
			custCash.setModOptr(User.getUserId());
			custCash.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			boolean result6 = custTransactionService.updateCustTransaction(custCash);
			
			
			
			if (result6) {
				if (checkStatus.equals("agree")) {
					//计算手续费
					ChargeRate chargeRate = chargeRateService.getTxRate("2",User.getRoleId());
					
					BigDecimal tradAmt = new BigDecimal(custCash.getTradAmt().toString());
					BigDecimal rate = new BigDecimal(custCash.getChargeRate().toString());
					BigDecimal chargeAmt = tradAmt.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
					BigDecimal valueAmt = tradAmt.subtract(chargeAmt);
					
					//更新账户余额-出账
					CustomerInfo tradFrom = customerInfoService.getCustomerInfo(custCash.getTradFrom());
					
					tradFrom.setAmtAll((new BigDecimal(tradFrom.getAmtAll().toString())).subtract(tradAmt).doubleValue());
					tradFrom.setAmtClock((new BigDecimal(tradFrom.getAmtClock().toString())).subtract(tradAmt).doubleValue());
					tradFrom.setModOptr(User.getUserId());
					tradFrom.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					customerInfoService.updateCustomerInfo(tradFrom);
					//更新提现记录-出账
					CustTransaction custTransaction1 = custTransactionService.getCustTransaction(txId);
					
					custTransaction1.setAmtAll(tradFrom.getAmtAll());
					custTransaction1.setAmtClock(tradFrom.getAmtClock());
					custTransaction1.setAmtFree(tradFrom.getAmtFree());
					custTransaction1.setTradAmt(tradAmt.doubleValue());
					custTransaction1.setChargeRate(rate.doubleValue());
					custTransaction1.setRateAmt(chargeAmt.doubleValue());
					custTransaction1.setModOptr(User.getUserId());
					custTransaction1.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					custTransactionService.updateCustTransaction(custTransaction1);
					
					//更新账户余额-手续费
					CustomerInfo tradCharge = customerInfoService.getCustomerInfo(chargeRate.getToCustId());
					
					if (chargeAmt.doubleValue() > 0){
						
						tradCharge.setAmtAll((new BigDecimal(tradCharge.getAmtAll().toString())).add(chargeAmt).doubleValue());
						tradCharge.setAmtFree((new BigDecimal(tradCharge.getAmtFree().toString())).add(chargeAmt).doubleValue());
						tradCharge.setModOptr(User.getUserId());
						tradCharge.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						
						customerInfoService.updateCustomerInfo(tradCharge);
						//生成转账记录-手续费
						CustTransaction custTransaction3 = new CustTransaction();
						
						custTransaction3.setTradType("手续费");
						custTransaction3.setTradNo(custCash.getTradNo());
						custTransaction3.setTradFrom(custCash.getTradFrom());
						custTransaction3.setTradFromName(custCash.getTradFromName());
						custTransaction3.setTradTo(custCash.getTradTo());
						custTransaction3.setTradToName(custCash.getTradToName());
						custTransaction3.setAmtAll(tradCharge.getAmtAll());
						custTransaction3.setAmtClock(tradCharge.getAmtClock());
						custTransaction3.setAmtFree(tradCharge.getAmtFree());
						custTransaction3.setTradAmt(chargeAmt.doubleValue());
						custTransaction3.setChargeRate(0.00);
						custTransaction3.setRateAmt(0.00);
						custTransaction3.setFilePath("");
						custTransaction3.setCustId(chargeRate.getToCustId());
						custTransaction3.setCheckId(0);
						custTransaction3.setStatus(2); //1-待审核，2-复核通过
						custTransaction3.setCrtOptr(User.getUserId());
						custTransaction3.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						
						custTransactionService.insertCustTransaction(custTransaction3);
					}
					
					//金币信息-金币拆分与转让
					//转账金额（扣除手续费后剩余）
					List<CustAmt> custAmtList1 = custAmtService.getCustAmtByCustId(custCash.getTradFrom());
					
					for(CustAmt custAmt : custAmtList1){
						int seqNo = custAmt.getAmtLevel();
						if (valueAmt.doubleValue() > 0) {
							if (valueAmt.doubleValue() >= custAmt.getAmtValue()) {
								//金币使用
								custAmt.setStatus(2);//1-可用，2-已用，0-回收
								custAmt.setModOptr(User.getUserId());
								custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								
								custAmtService.updateCustAmt(custAmt);
								
								//金币转出
								CustAmt custAmt1 = new CustAmt();
								
								custAmt1.setAmtCode(custAmt.getAmtCode());
								custAmt1.setAmtLevel(seqNo+1);
								custAmt1.setAmtValue(custAmt.getAmtValue());
								custAmt1.setTradId(custCash.getTradId());
								custAmt1.setTradType("转出");
								custAmt1.setTradNo(custCash.getTradNo());
								custAmt1.setTradFrom(custCash.getTradFrom());
								custAmt1.setTradFromName(custCash.getTradFromName());
								custAmt1.setTradTo(custCash.getTradTo());
								custAmt1.setTradToName(custCash.getTradToName());
								custAmt1.setCustId(custCash.getTradFrom());
								custAmt1.setStatus(2);//1-可用，2-已用，0-回收
								custAmt1.setCrtOptr(User.getUserId());
								custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt1);
								
								//金币销毁
								CustAmt custAmt2 = new CustAmt();
								
								custAmt2.setAmtCode(custAmt.getAmtCode());
								custAmt2.setAmtLevel(seqNo+1);
								custAmt2.setAmtValue(custAmt.getAmtValue());
								custAmt2.setTradId(custCash.getTradId());
								custAmt2.setTradType("回收");
								custAmt2.setTradNo(custCash.getTradNo());
								custAmt2.setTradFrom(custCash.getTradFrom());
								custAmt2.setTradFromName(custCash.getTradFromName());
								custAmt2.setTradTo(custCash.getTradTo());
								custAmt2.setTradToName(custCash.getTradToName());
								custAmt2.setCustId(custCash.getTradTo());
								custAmt2.setStatus(0);//1-可用，2-已用，0-回收
								custAmt2.setCrtOptr(User.getUserId());
								custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt2);
								
								valueAmt = valueAmt.subtract(new BigDecimal(custAmt.getAmtValue().toString()));
							}else{
								//金币使用
								custAmt.setStatus(2);//1-可用，2-已用，0-回收
								custAmt.setModOptr(User.getUserId());
								custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								
								custAmtService.updateCustAmt(custAmt);
								//金币转出
								CustAmt custAmt3 = new CustAmt();
								
								custAmt3.setAmtCode(custAmt.getAmtCode());
								custAmt3.setAmtLevel(seqNo+1);
								custAmt3.setAmtValue(valueAmt.doubleValue());
								custAmt3.setTradId(custCash.getTradId());
								custAmt3.setTradType("转出");
								custAmt3.setTradNo(custCash.getTradNo());
								custAmt3.setTradFrom(custCash.getTradFrom());
								custAmt3.setTradFromName(custCash.getTradFromName());
								custAmt3.setTradTo(custCash.getTradTo());
								custAmt3.setTradToName(custCash.getTradToName());
								custAmt3.setCustId(custCash.getTradFrom());
								custAmt3.setStatus(2);//1-可用，2-已用，0-回收
								custAmt3.setCrtOptr(User.getUserId());
								custAmt3.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt3);
								//金币拆分
								CustAmt custAmt1 = new CustAmt();
								
								custAmt1.setAmtCode(custAmt.getAmtCode());
								custAmt1.setAmtLevel(seqNo+1);
								BigDecimal amtValue = new BigDecimal(custAmt.getAmtValue().toString());
								custAmt1.setAmtValue(amtValue.subtract(valueAmt).doubleValue());
								custAmt1.setTradId(custCash.getTradId());
								custAmt1.setTradType("拆分");
								custAmt1.setTradNo(custCash.getTradNo());
								custAmt1.setTradFrom(custCash.getTradFrom());
								custAmt1.setTradFromName(custCash.getTradFromName());
								custAmt1.setTradTo(custCash.getTradTo());
								custAmt1.setTradToName(custCash.getTradToName());
								custAmt1.setCustId(custCash.getTradFrom());
								custAmt1.setStatus(1);//1-可用，2-已用，0-回收
								custAmt1.setCrtOptr(User.getUserId());
								custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt1);
								//金币转入
								CustAmt custAmt2 = new CustAmt();
								
								custAmt2.setAmtCode(custAmt.getAmtCode());
								custAmt2.setAmtLevel(seqNo+1);
								custAmt2.setAmtValue(valueAmt.doubleValue());
								custAmt2.setTradId(custCash.getTradId());
								custAmt2.setTradType("回收");
								custAmt2.setTradNo(custCash.getTradNo());
								custAmt2.setTradFrom(custCash.getTradFrom());
								custAmt2.setTradFromName(custCash.getTradFromName());
								custAmt2.setTradTo(custCash.getTradTo());
								custAmt2.setTradToName(custCash.getTradToName());
								custAmt2.setCustId(custCash.getTradTo());
								custAmt2.setStatus(0);//1-可用，2-已用，0-回收
								custAmt2.setCrtOptr(User.getUserId());
								custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt2);
								
								valueAmt = new BigDecimal("0.00");
							}
						}
					}
					//转账手续费
					List<CustAmt> custAmtList2 = custAmtService.getCustAmtByCustId(custCash.getTradFrom());
					
					for(CustAmt custAmt : custAmtList2){
						if (chargeAmt.doubleValue() > 0) {
							if (chargeAmt.doubleValue() >= custAmt.getAmtValue()) {
								//金币使用
								custAmt.setStatus(2);//1-可用，2-已用，0-回收
								custAmt.setModOptr(User.getUserId());
								custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								
								custAmtService.updateCustAmt(custAmt);
								
								//金币转出
								CustAmt custAmt1 = new CustAmt();
								
								custAmt1.setAmtCode(custAmt.getAmtCode());
								custAmt1.setAmtLevel(custAmt.getAmtLevel()+1);
								custAmt1.setAmtValue(custAmt.getAmtValue());
								custAmt1.setTradId(custCash.getTradId());
								custAmt1.setTradType("转出");
								custAmt1.setTradNo(custCash.getTradNo());
								custAmt1.setTradFrom(custCash.getTradFrom());
								custAmt1.setTradFromName(custCash.getTradFromName());
								custAmt1.setTradTo(chargeRate.getToCustId());
								custAmt1.setTradToName(tradCharge.getCustName());
								custAmt1.setCustId(custCash.getTradFrom());
								custAmt1.setStatus(2);//1-可用，2-已用，0-回收
								custAmt1.setCrtOptr(User.getUserId());
								custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt1);
								//金币转入
								CustAmt custAmt2 = new CustAmt();
								
								custAmt2.setAmtCode(custAmt.getAmtCode());
								custAmt2.setAmtLevel(custAmt.getAmtLevel()+1);
								custAmt2.setAmtValue(custAmt.getAmtValue());
								custAmt2.setTradId(custCash.getTradId());
								custAmt2.setTradType("转入");
								custAmt2.setTradNo(custCash.getTradNo());
								custAmt2.setTradFrom(custCash.getTradFrom());
								custAmt2.setTradFromName(custCash.getTradFromName());
								custAmt2.setTradTo(chargeRate.getToCustId());
								custAmt2.setTradToName(tradCharge.getCustName());
								custAmt2.setCustId(chargeRate.getToCustId());
								custAmt2.setStatus(1);//1-可用，2-已用，0-回收
								custAmt2.setCrtOptr(User.getUserId());
								custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt2);
								
								chargeAmt = chargeAmt.subtract(new BigDecimal(custAmt.getAmtValue().toString()));
							}else{
								//金币使用
								custAmt.setStatus(2);//1-可用，2-已用，0-回收
								custAmt.setModOptr(User.getUserId());
								custAmt.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								
								custAmtService.updateCustAmt(custAmt);
								//金币转出
								CustAmt custAmt3 = new CustAmt();
								
								custAmt3.setAmtCode(custAmt.getAmtCode());
								custAmt3.setAmtLevel(custAmt.getAmtLevel());
								custAmt3.setAmtValue(chargeAmt.doubleValue());
								custAmt3.setTradId(custCash.getTradId());
								custAmt3.setTradType("转出");
								custAmt3.setTradNo(custCash.getTradNo());
								custAmt3.setTradFrom(custCash.getTradFrom());
								custAmt3.setTradFromName(custCash.getTradFromName());
								custAmt3.setTradTo(chargeRate.getToCustId());
								custAmt3.setTradToName(tradCharge.getCustName());
								custAmt3.setCustId(custCash.getTradFrom());
								custAmt3.setStatus(1);//1-可用，2-已用，0-回收
								custAmt3.setCrtOptr(User.getUserId());
								custAmt3.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt3);
								//金币拆分
								CustAmt custAmt1 = new CustAmt();
								
								custAmt1.setAmtCode(custAmt.getAmtCode());
								custAmt1.setAmtLevel(custAmt.getAmtLevel());
								BigDecimal amtValue = new BigDecimal(custAmt.getAmtValue().toString());
								custAmt1.setAmtValue(amtValue.subtract(chargeAmt).doubleValue());
								custAmt1.setTradId(custCash.getTradId());
								custAmt1.setTradType("拆分");
								custAmt1.setTradNo(custCash.getTradNo());
								custAmt1.setCustId(custCash.getTradFrom());
								custAmt1.setStatus(1);//1-可用，2-已用，0-回收
								custAmt1.setCrtOptr(User.getUserId());
								custAmt1.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt1);
								//金币转入
								CustAmt custAmt2 = new CustAmt();
								
								custAmt2.setAmtCode(custAmt.getAmtCode());
								custAmt2.setAmtLevel(custAmt.getAmtLevel()+1);
								custAmt2.setAmtValue(chargeAmt.doubleValue());
								custAmt2.setTradId(custCash.getTradId());
								custAmt2.setTradType("转入");
								custAmt2.setTradNo(custCash.getTradNo());
								custAmt2.setTradFrom(custCash.getTradFrom());
								custAmt2.setTradFromName(custCash.getTradFromName());
								custAmt2.setTradTo(chargeRate.getToCustId());
								custAmt2.setTradToName(tradCharge.getCustName());
								custAmt2.setCustId(chargeRate.getToCustId());
								custAmt2.setStatus(1);//1-可用，2-已用，0-回收
								custAmt2.setCrtOptr(User.getUserId());
								custAmt2.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
								custAmtService.insertCustAmt(custAmt2);
								
								chargeAmt = new BigDecimal("0.00");
							}
						}
					} 
				}else if (checkStatus.equals("refuse")){
					//更新账户余额-冻结
					CustomerInfo tradFrom = customerInfoService.getCustomerInfo(custCash.getTradFrom());
					
					BigDecimal amtAll = new BigDecimal(tradFrom.getAmtAll().toString());
					BigDecimal amtClock = new BigDecimal(tradFrom.getAmtClock().toString());
					BigDecimal amtFree = new BigDecimal(tradFrom.getAmtFree().toString());
					BigDecimal tradAmt = new BigDecimal(custCash.getTradAmt().toString());
					BigDecimal rateAmt = new BigDecimal(custCash.getRateAmt().toString());
					
					tradFrom.setAmtAll(amtAll.doubleValue());
					tradFrom.setAmtClock(amtClock.subtract(tradAmt).doubleValue());
					tradFrom.setAmtFree(amtFree.add(tradAmt).doubleValue());
					tradFrom.setModOptr(User.getUserId());
					tradFrom.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					customerInfoService.updateCustomerInfo(tradFrom);
					//更新提现记录-冻结
					CustTransaction custTransaction1 = custTransactionService.getCustTransaction(txId);
					
					custTransaction1.setAmtAll(tradFrom.getAmtAll());
					custTransaction1.setAmtClock(tradFrom.getAmtClock());
					custTransaction1.setAmtFree(tradFrom.getAmtFree());
					custTransaction1.setTradAmt(tradAmt.doubleValue());
					custTransaction1.setStatus(0);
					custTransaction1.setModOptr(User.getUserId());
					custTransaction1.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					custTransactionService.updateCustTransaction(custTransaction1);
					//删除提现应付记录-现金
					Capital capital1 = capitalService.getCapitalByTradId(txId);
					capital1.setStatus(0);
					capital1.setCheckId(checkId);
					capital1.setModOptr(User.getUserId());
					capital1.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					
					capitalService.updateCapital(capital1);
				}
				
				resultMap.put("isSuc", true);
				resultMap.put("errMsg", "审批成功");
				resultMap.put("returnUrl", "/capitalController/capitalIndex");
			} else {
				resultMap.put("isSuc", false);
				resultMap.put("errMsg", "审批失败");
			}
			
			break;
			
		case "capital":
			//更新保理审批状态
			Capital capital2 = capitalService.getCapital(txId);
			
			capital2.setStatus(txStatus);
			capital2.setCheckId(checkId);
			capital2.setModOptr(User.getUserId());
			capital2.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			boolean result7 = capitalService.updateCapital(capital2);
			
			if (result7) {
				resultMap.put("isSuc", true);
				resultMap.put("errMsg", "审批成功");
				resultMap.put("returnUrl", "/factorController/factorIndex");
			} else {
				resultMap.put("isSuc", false);
				resultMap.put("errMsg", "审批失败");
			}
			
			break;
		default:
			log.info("失败");
			break;
		}
		
		return resultMap;
	}
	
}