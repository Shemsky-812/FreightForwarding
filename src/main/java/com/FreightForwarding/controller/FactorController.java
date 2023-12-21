package com.FreightForwarding.controller;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.FreightForwarding.annotation.PrivilegeInfo;
import com.FreightForwarding.model.Factor;
import com.FreightForwarding.model.Loan;
import com.FreightForwarding.model.SysUser;
import com.FreightForwarding.service.FactorService;
import com.FreightForwarding.service.LoanService;
import com.FreightForwarding.service.SysMenuService;

@Controller
@RequestMapping("/factorController")
public class FactorController {
	private final static Logger log = Logger.getLogger(FactorController.class);
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private FactorService factorService;
	
	@Autowired
	private LoanService loanService;
	
	/**
	 * 保理合同
	 * 
	 */
	@RequestMapping(value = "/factorIndex")
	@PrivilegeInfo(value = "33")
	public ModelAndView factorIndex(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		for(Map<String, Object> map : sysMenuService.getLowMenu(33)){
			mav.addObject(map.get("menuIcon").toString(),map.get("menuAction").toString());
		}
		mav.setViewName("factorList");
		return mav;
	}
	
	/**
	 * 保理合同列表
	 * 
	 */
	@RequestMapping(value = "/factorList",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@PrivilegeInfo(value = "33")
	public @ResponseBody Object factorList(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>();  
		
		SysUser User = (SysUser) session.getAttribute("User");
		
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));  
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
        String factorCode = request.getParameter("factorCode"); 
        
        resultMap = factorService.getList(pageNumber, pageSize,factorCode,User.getUserId());
        
        String jsonString = objectMapper.writeValueAsString(resultMap.get("rows"));
        String json = "{\"total\":" + resultMap.get("total") + ",\"rows\":" + jsonString + "}";
        
        log.info("json:"+json);
        return json;
	}
	
	/**
	 * 录入
	 * 
	 */
	@RequestMapping(value = "/factorAdd")
	@PrivilegeInfo(value = "34")
	public @ResponseBody Object factorAdd(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("factorAdd");
		return mav;
	}
	
	/**
	 * 录入提交
	 * 
	 */
	@RequestMapping(value = "/factorAddConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "34")
	public @ResponseBody Object factorAddConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");

		Factor factor = new Factor();
		
		factor.setFactorCode(request.getParameter("factorCode"));
		factor.setCustSell(Integer.parseInt(request.getParameter("custSell")));
		factor.setCustSellName(request.getParameter("custSellName"));
		factor.setCustfactor(Integer.parseInt(request.getParameter("custfactor")));
		factor.setCustfactorName(request.getParameter("custfactorName"));
		BigDecimal factorAmt=new BigDecimal((String) request.getParameter("factorAmt"));
		double dbfactorAmt = factorAmt.doubleValue();
		factor.setFactorAmt(dbfactorAmt);
		factor.setPayment(request.getParameter("payment"));
		BigDecimal rate=new BigDecimal((String) request.getParameter("rate"));
		double dbrate = rate.doubleValue();
		factor.setRate(dbrate);
		BigDecimal interest=new BigDecimal((String) request.getParameter("interest"));
		double dbinterest = interest.doubleValue();
		factor.setInterest(dbinterest);
		factor.setTenor(request.getParameter("tenor"));
		factor.setStartDate(request.getParameter("startDate"));
		factor.setEndDate(request.getParameter("endDate"));
		factor.setFilePath(request.getParameter("filePath"));
		factor.setRemark(request.getParameter("remark"));
		factor.setCheckId(0);
		factor.setStatus(2);
		factor.setCrtOptr(User.getUserId());
		factor.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable result = factorService.insertFactor(factor);
		
		if (result.equals(0)) {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "新增失败");
		} else {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "新增成功");
		}
		return resultMap;
	}
	
	/**
	 * 修改
	 * 
	 */
	@RequestMapping(value = "/factorAmd")
	@PrivilegeInfo(value = "35")
	public @ResponseBody Object contractAmd(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		Factor factor = factorService.getFactor(Integer.parseInt(request.getParameter("factorId")));
		
		mav.addObject("factorId",factor.getFactorId());
		mav.addObject("factorCode",factor.getFactorCode());
		mav.addObject("custSell",factor.getCustSell());
		mav.addObject("custSellName",factor.getCustSellName());
		mav.addObject("custfactor",factor.getCustfactor());
		mav.addObject("custfactorName",factor.getCustfactorName());
		mav.addObject("factorAmt",factor.getFactorAmt());
		mav.addObject("payment",factor.getPayment());
		mav.addObject("rate",factor.getRate());
		mav.addObject("interest",factor.getInterest());
		mav.addObject("tenor",factor.getTenor());
		mav.addObject("startDate",factor.getStartDate());
		mav.addObject("endDate",factor.getEndDate());
		mav.addObject("filePath",factor.getFilePath());
		mav.addObject("remark",factor.getRemark());
		mav.addObject("checkId",factor.getCheckId());
		mav.addObject("status",factor.getStatus());
		
		mav.setViewName("factorAmd");
		return mav;
	}
	
	/**
	 * 修改提交
	 * 
	 */
	@RequestMapping(value = "/factorAmdConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "35")
	public @ResponseBody Object factorAmdConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");

		Factor factor = factorService.getFactor(Integer.parseInt(request.getParameter("factorId")));
		
		factor.setFactorCode(request.getParameter("factorCode"));
		factor.setCustSell(Integer.parseInt(request.getParameter("custSell")));
		factor.setCustSellName(request.getParameter("custSellName"));
		factor.setCustfactor(Integer.parseInt(request.getParameter("custfactor")));
		factor.setCustfactorName(request.getParameter("custfactorName"));
		BigDecimal factorAmt=new BigDecimal((String) request.getParameter("factorAmt"));
		double dbfactorAmt = factorAmt.doubleValue();
		factor.setFactorAmt(dbfactorAmt);
		factor.setPayment(request.getParameter("payment"));
		BigDecimal rate=new BigDecimal((String) request.getParameter("rate"));
		double dbrate = rate.doubleValue();
		factor.setRate(dbrate);
		BigDecimal interest=new BigDecimal((String) request.getParameter("interest"));
		double dbinterest = interest.doubleValue();
		factor.setInterest(dbinterest);
		factor.setTenor(request.getParameter("tenor"));
		factor.setStartDate(request.getParameter("startDate"));
		factor.setEndDate(request.getParameter("endDate"));
		factor.setFilePath(request.getParameter("filePath"));
		factor.setRemark(request.getParameter("remark"));
		factor.setCheckId(0);
		factor.setStatus(2);
		factor.setModOptr(User.getUserId());
		factor.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		boolean result = factorService.updateFactor(factor);
		
		if (result) {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "修改成功");
		} else {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "修改失败");
			
		}
		return resultMap;
	}
	
	/**
	 * 删除
	 * 
	 */
	@RequestMapping(value = "/factorDel")
	@PrivilegeInfo(value = "36")
	public @ResponseBody Object factorDel(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");
		
		Factor factor = factorService.getFactor(Integer.parseInt(request.getParameter("factorId")));
		
		factor.setStatus(0);
		factor.setModOptr(User.getUserId());
		factor.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		boolean result = factorService.updateFactor(factor);
		
		if (result) {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "删除成功");
		} else {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "删除失败");
			
		}
		return resultMap;
	}
	
	/**
	 * 录入复核
	 * 
	 */
	@RequestMapping(value = "/factorAddCheck")
	@PrivilegeInfo(value = "37")
	public @ResponseBody Object factorAddCheck(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		Factor factor = factorService.getFactor(Integer.parseInt(request.getParameter("factorId")));
		
		mav.addObject("factorId",factor.getFactorId());
		mav.addObject("factorCode",factor.getFactorCode());
		mav.addObject("custSell",factor.getCustSell());
		mav.addObject("custSellName",factor.getCustSellName());
		mav.addObject("custfactor",factor.getCustfactor());
		mav.addObject("custfactorName",factor.getCustfactorName());
		mav.addObject("factorAmt",factor.getFactorAmt());
		mav.addObject("payment",factor.getPayment());
		mav.addObject("rate",factor.getRate());
		mav.addObject("interest",factor.getInterest());
		mav.addObject("tenor",factor.getTenor());
		mav.addObject("startDate",factor.getStartDate());
		mav.addObject("endDate",factor.getEndDate());
		mav.addObject("filePath",factor.getFilePath());
		mav.addObject("remark",factor.getRemark());
		mav.addObject("checkId",factor.getCheckId());
		mav.addObject("status",factor.getStatus());
		
		mav.setViewName("factorAddCheck");
		return mav;
	}
	
	/**
	 * 质押
	 * 
	 */
	@RequestMapping(value = "/factorLoan")
	@PrivilegeInfo(value = "38")
	public @ResponseBody Object contractLoan(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		Factor factor = factorService.getFactor(Integer.parseInt(request.getParameter("factorId")));
		
		mav.addObject("factorId1",factor.getFactorId());
		mav.addObject("factorCode1",factor.getFactorCode());
		mav.addObject("custSell1",factor.getCustSell());
		mav.addObject("custSellName1",factor.getCustSellName());
		mav.addObject("custfactor1",factor.getCustfactor());
		mav.addObject("custfactorName1",factor.getCustfactorName());
		mav.addObject("factorAmt1",factor.getFactorAmt());
		mav.addObject("payment1",factor.getPayment());
		mav.addObject("rate1",factor.getRate());
		mav.addObject("interest1",factor.getInterest());
		mav.addObject("tenor1",factor.getTenor());
		mav.addObject("startDate1",factor.getStartDate());
		mav.addObject("endDate1",factor.getEndDate());
		mav.addObject("filePath1",factor.getFilePath());
		mav.addObject("remark1",factor.getRemark());
		mav.addObject("checkId1",factor.getCheckId());
		mav.addObject("status1",factor.getStatus());
		
		try {
			Loan loan = loanService.getLoanByfactorId(factor.getFactorId());
			
			
			mav.addObject("loanId2",loan.getLoanId());
			mav.addObject("loanCode2",loan.getLoanCode());
			mav.addObject("custDebtor2",loan.getCustDebtor());
			mav.addObject("custDebtorName2",loan.getCustDebtorName());
			mav.addObject("custCreditor2",loan.getCustCreditor());
			mav.addObject("custCreditorName2",loan.getCustCreditorName());
			mav.addObject("loanAmt2",loan.getLoanAmt());
			mav.addObject("payment2",loan.getPayment());
			mav.addObject("rate2",loan.getRate());
			mav.addObject("interest2",loan.getInterest());
			mav.addObject("tenor2",loan.getTenor());
			mav.addObject("startDate2",loan.getStartDate());
			mav.addObject("endDate2",loan.getEndDate());
			mav.addObject("filePath2",loan.getFilePath());
			mav.addObject("remark2",loan.getRemark());
		} catch (Exception e) {
			// TODO: handle exception
		}

		mav.setViewName("factorLoan");
		return mav;
	}
	
	/**
	 * 质押提交
	 * 
	 */
	@RequestMapping(value = "/factorLoanConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "38")
	public @ResponseBody Object factorLoanConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");
		
		if (request.getParameter("loanId2").equals(null) || request.getParameter("loanId2").equals("") || request.getParameter("loanId2").equals("0")) {
			Loan loan = new Loan();
			
			loan.setLoanCode(request.getParameter("loanCode2"));
			loan.setCustDebtor(Integer.parseInt(request.getParameter("custDebtor2")));
			loan.setCustDebtorName(request.getParameter("custDebtorName2"));
			loan.setCustCreditor(0);
			loan.setCustCreditorName(request.getParameter("custCreditorName2"));
			BigDecimal loanAmt=new BigDecimal((String) request.getParameter("loanAmt2"));
			double dbloanAmt = loanAmt.doubleValue();
			loan.setLoanAmt(dbloanAmt);
			loan.setPayment(request.getParameter("payment2"));
			BigDecimal rate=new BigDecimal((String) request.getParameter("rate2"));
			double dbrate = rate.doubleValue();
			loan.setRate(dbrate);
			BigDecimal interest=new BigDecimal((String) request.getParameter("interest2"));
			double dbinterest = interest.doubleValue();
			loan.setInterest(dbinterest);
			loan.setTenor(request.getParameter("tenor2"));
			loan.setStartDate(request.getParameter("startDate2"));
			loan.setEndDate(request.getParameter("endDate2"));
			loan.setFilePath(request.getParameter("filePath2"));
			loan.setRemark(request.getParameter("remark2"));
			loan.setFactorId(Integer.parseInt(request.getParameter("factorId1")));
			loan.setStatus(1);
			loan.setCrtOptr(User.getUserId());
			loan.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			loanService.insertLoan(loan);
			
		} else {
			Loan loan = loanService.getLoan(Integer.parseInt(request.getParameter("loanId2")));
			
			loan.setLoanCode(request.getParameter("loanCode2"));
			loan.setCustDebtor(Integer.parseInt(request.getParameter("custDebtor2")));
			loan.setCustDebtorName(request.getParameter("custDebtorName2"));
			loan.setCustCreditor(0);
			loan.setCustCreditorName(request.getParameter("custCreditorName2"));
			BigDecimal loanAmt=new BigDecimal((String) request.getParameter("loanAmt2"));
			double dbloanAmt = loanAmt.doubleValue();
			loan.setLoanAmt(dbloanAmt);
			loan.setPayment(request.getParameter("payment2"));
			BigDecimal rate=new BigDecimal((String) request.getParameter("rate2"));
			double dbrate = rate.doubleValue();
			loan.setRate(dbrate);
			BigDecimal interest=new BigDecimal((String) request.getParameter("interest2"));
			double dbinterest = interest.doubleValue();
			loan.setInterest(dbinterest);
			loan.setTenor(request.getParameter("tenor2"));
			loan.setStartDate(request.getParameter("startDate2"));
			loan.setEndDate(request.getParameter("endDate2"));
			loan.setFilePath(request.getParameter("filePath2"));
			loan.setRemark(request.getParameter("remark2"));
			loan.setFactorId(Integer.parseInt(request.getParameter("factorId1")));
			loan.setStatus(1);
			loan.setModOptr(User.getUserId());
			loan.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			loanService.updateLoan(loan);
		}

		Factor factor = factorService.getFactor(Integer.parseInt(request.getParameter("factorId1")));
		
		factor.setStatus(factor.getStatus()+1);
		factor.setModOptr(User.getUserId());
		factor.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		boolean result = factorService.updateFactor(factor);
		
		if (result) {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "质押成功");
		} else {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "质押失败");
			
		}
		return resultMap;
	}
	
	/**
	 * 质押复核
	 * 
	 */
	@RequestMapping(value = "/factorLoanCheck")
	@PrivilegeInfo(value = "39")
	public @ResponseBody Object contractLoanCheck(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		Factor factor = factorService.getFactor(Integer.parseInt(request.getParameter("factorId")));
		
		mav.addObject("factorId1",factor.getFactorId());
		mav.addObject("factorCode1",factor.getFactorCode());
		mav.addObject("custSell1",factor.getCustSell());
		mav.addObject("custSellName1",factor.getCustSellName());
		mav.addObject("custfactor1",factor.getCustfactor());
		mav.addObject("custfactorName1",factor.getCustfactorName());
		mav.addObject("factorAmt1",factor.getFactorAmt());
		mav.addObject("payment1",factor.getPayment());
		mav.addObject("rate1",factor.getRate());
		mav.addObject("interest1",factor.getInterest());
		mav.addObject("tenor1",factor.getTenor());
		mav.addObject("startDate1",factor.getStartDate());
		mav.addObject("endDate1",factor.getEndDate());
		mav.addObject("filePath1",factor.getFilePath());
		mav.addObject("remark1",factor.getRemark());
		mav.addObject("checkId1",factor.getCheckId());
		mav.addObject("status1",factor.getStatus());
		
		try {
			Loan loan = loanService.getLoanByfactorId(factor.getFactorId());
			
			mav.addObject("loanId2",loan.getLoanId());
			mav.addObject("loanCode2",loan.getLoanCode());
			mav.addObject("custDebtor2",loan.getCustDebtor());
			mav.addObject("custDebtorName2",loan.getCustDebtorName());
			mav.addObject("custCreditor2",loan.getCustCreditor());
			mav.addObject("custCreditorName2",loan.getCustCreditorName());
			mav.addObject("loanAmt2",loan.getLoanAmt());
			mav.addObject("payment2",loan.getPayment());
			mav.addObject("rate2",loan.getRate());
			mav.addObject("interest2",loan.getInterest());
			mav.addObject("tenor2",loan.getTenor());
			mav.addObject("startDate2",loan.getStartDate());
			mav.addObject("endDate2",loan.getEndDate());
			mav.addObject("filePath2",loan.getFilePath());
			mav.addObject("remark2",loan.getRemark());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		mav.setViewName("factorLoanCheck");
		return mav;
	}
	
	/**
	 * 质押放款
	 * 
	 */
	@RequestMapping(value = "/factorLoanAct")
	@PrivilegeInfo(value = "40")
	public @ResponseBody Object contractLoanAct(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		Factor factor = factorService.getFactor(Integer.parseInt(request.getParameter("factorId")));
		
		mav.addObject("factorId1",factor.getFactorId());
		mav.addObject("factorCode1",factor.getFactorCode());
		mav.addObject("custSell1",factor.getCustSell());
		mav.addObject("custSellName1",factor.getCustSellName());
		mav.addObject("custfactor1",factor.getCustfactor());
		mav.addObject("custfactorName1",factor.getCustfactorName());
		mav.addObject("factorAmt1",factor.getFactorAmt());
		mav.addObject("payment1",factor.getPayment());
		mav.addObject("rate1",factor.getRate());
		mav.addObject("interest1",factor.getInterest());
		mav.addObject("tenor1",factor.getTenor());
		mav.addObject("startDate1",factor.getStartDate());
		mav.addObject("endDate1",factor.getEndDate());
		mav.addObject("filePath1",factor.getFilePath());
		mav.addObject("remark1",factor.getRemark());
		mav.addObject("checkId1",factor.getCheckId());
		mav.addObject("status1",factor.getStatus());
		
		Loan loan = loanService.getLoanByfactorId(factor.getFactorId());
		
		mav.addObject("loanId2",loan.getLoanId());
		mav.addObject("loanCode2",loan.getLoanCode());
		mav.addObject("custDebtor2",loan.getCustDebtor());
		mav.addObject("custDebtorName2",loan.getCustDebtorName());
		mav.addObject("custCreditor2",loan.getCustCreditor());
		mav.addObject("custCreditorName2",loan.getCustCreditorName());
		mav.addObject("loanAmt2",loan.getLoanAmt());
		mav.addObject("payment2",loan.getPayment());
		mav.addObject("rate2",loan.getRate());
		mav.addObject("interest2",loan.getInterest());
		mav.addObject("tenor2",loan.getTenor());
		mav.addObject("startDate2",loan.getStartDate());
		mav.addObject("endDate2",loan.getEndDate());
		mav.addObject("filePath2",loan.getFilePath());
		mav.addObject("remark2",loan.getRemark());
		
		mav.setViewName("factorLoanAct");
		return mav;
	}
	
	/**
	 * 合同执行
	 * 
	 */
	@RequestMapping(value = "/factorAct")
	@PrivilegeInfo(value = "41")
	public @ResponseBody Object contractAct(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		Factor factor = factorService.getFactor(Integer.parseInt(request.getParameter("factorId")));
		
		mav.addObject("factorId1",factor.getFactorId());
		mav.addObject("factorCode1",factor.getFactorCode());
		mav.addObject("custSell1",factor.getCustSell());
		mav.addObject("custSellName1",factor.getCustSellName());
		mav.addObject("custfactor1",factor.getCustfactor());
		mav.addObject("custfactorName1",factor.getCustfactorName());
		mav.addObject("factorAmt1",factor.getFactorAmt());
		mav.addObject("payment1",factor.getPayment());
		mav.addObject("rate1",factor.getRate());
		mav.addObject("interest1",factor.getInterest());
		mav.addObject("tenor1",factor.getTenor());
		mav.addObject("startDate1",factor.getStartDate());
		mav.addObject("endDate1",factor.getEndDate());
		mav.addObject("filePath1",factor.getFilePath());
		mav.addObject("remark1",factor.getRemark());
		mav.addObject("checkId1",factor.getCheckId());
		mav.addObject("status1",factor.getStatus());
		
		Loan loan = loanService.getLoanByfactorId(factor.getFactorId());
		
		mav.addObject("loanId2",loan.getLoanId());
		mav.addObject("loanCode2",loan.getLoanCode());
		mav.addObject("custDebtor2",loan.getCustDebtor());
		mav.addObject("custDebtorName2",loan.getCustDebtorName());
		mav.addObject("custCreditor2",loan.getCustCreditor());
		mav.addObject("custCreditorName2",loan.getCustCreditorName());
		mav.addObject("loanAmt2",loan.getLoanAmt());
		mav.addObject("payment2",loan.getPayment());
		mav.addObject("rate2",loan.getRate());
		mav.addObject("interest2",loan.getInterest());
		mav.addObject("tenor2",loan.getTenor());
		mav.addObject("startDate2",loan.getStartDate());
		mav.addObject("endDate2",loan.getEndDate());
		mav.addObject("filePath2",loan.getFilePath());
		mav.addObject("remark2",loan.getRemark());
		
		mav.setViewName("factorAct");
		return mav;
	}
	
}