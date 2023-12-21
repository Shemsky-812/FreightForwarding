package com.FreightForwarding.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.FreightForwarding.annotation.PrivilegeInfo;
import com.FreightForwarding.model.Capital;
import com.FreightForwarding.model.CustTransaction;
import com.FreightForwarding.model.CustomerInfo;
import com.FreightForwarding.service.CapitalService;
import com.FreightForwarding.service.CustTransactionService;
import com.FreightForwarding.service.CustomerInfoService;
import com.FreightForwarding.service.SysMenuService;

@Controller
@RequestMapping("/capitalController")
public class CapitalController {
	private final static Logger log = Logger.getLogger(CapitalController.class);
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private CapitalService capitalService;
	
	@Autowired
	private CustomerInfoService customerInfoService;
	
	@Autowired
	private CustTransactionService custTransactionService;
	
	
	/**
	 * 资金交易
	 * 
	 */
	@RequestMapping(value = "/capitalIndex")
	@PrivilegeInfo(value = "28")
	public ModelAndView capitalIndex(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		for(Map<String, Object> map : sysMenuService.getLowMenu(28)){
			mav.addObject(map.get("menuIcon").toString(),map.get("menuAction").toString());
		}
		mav.setViewName("capitalList");
		return mav;
	}
	
	/**
	 * 资金交易列表
	 * 
	 */
	@RequestMapping(value = "/capitalList",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@PrivilegeInfo(value = "28")
	public @ResponseBody Object capitalList(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>();  
		
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));  
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
        Map<String, Object> mapData = new HashMap<String,Object>();
        mapData.put("tradType", request.getParameter("tradType")); 
        mapData.put("tradFromName", request.getParameter("tradFromName")); 
        mapData.put("tradToName", request.getParameter("tradToName")); 
        
        resultMap = capitalService.getList(pageNumber, pageSize,mapData);
        
        String jsonString = objectMapper.writeValueAsString(resultMap.get("rows"));
        String json = "{\"total\":" + resultMap.get("total") + ",\"rows\":" + jsonString + "}";
        
        log.info("json:"+json);
        return json;
	}
	
	/**
	 * 提现确认
	 * 
	 */
	@RequestMapping(value = "/capitalCash")
	@PrivilegeInfo(value = "29")
	public @ResponseBody Object capitalCash(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		Capital capital = capitalService.getCapital(Integer.parseInt(request.getParameter("capitalId")));
		
		CustTransaction custTransaction = custTransactionService.getCustTransaction(capital.getTradId());
		
		mav.addObject("tradId",custTransaction.getTradId());
		mav.addObject("tradType",custTransaction.getTradType());
		mav.addObject("tradNo",custTransaction.getTradNo());
		mav.addObject("tradFrom",custTransaction.getTradFrom());
		mav.addObject("tradFromName",custTransaction.getTradFromName());
		mav.addObject("tradTo",custTransaction.getTradTo());
		mav.addObject("tradToName",custTransaction.getTradToName());
		mav.addObject("amtAll",custTransaction.getAmtAll());
		mav.addObject("amtClock",custTransaction.getAmtClock());
		mav.addObject("amtFree",custTransaction.getAmtFree());
		mav.addObject("tradAmt",custTransaction.getTradAmt());
		mav.addObject("chargeRate",custTransaction.getChargeRate());
		mav.addObject("rateAmt",custTransaction.getRateAmt());
		mav.addObject("filePath",custTransaction.getFilePath());
		mav.addObject("custId",custTransaction.getCustId());
		mav.addObject("checkId",custTransaction.getCheckId());
		mav.addObject("status",custTransaction.getStatus());
		
		CustomerInfo customerInfo = customerInfoService.getCustomerInfo(custTransaction.getTradFrom());
		
		mav.addObject("accountBank",customerInfo.getAccountBank());
		mav.addObject("accountName",customerInfo.getAccountName());
		mav.addObject("accountNum",customerInfo.getAccountNum());
		
		mav.setViewName("capitalCash");
		return mav;
	}
	
	/**
	 * 保理收款
	 * 
	 */
	@RequestMapping(value = "/capitalFactorReceived")
	@PrivilegeInfo(value = "30")
	public @ResponseBody Object capitalFactorReceived(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("capitalFactorReceived");
		return mav;
	}
	
	/**
	 * 贷款偿还
	 * 
	 */
	@RequestMapping(value = "/capitalLoanPayment")
	@PrivilegeInfo(value = "31")
	public @ResponseBody Object capitalLoanPayment(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("capitalLoanPayment");
		return mav;
	}
}