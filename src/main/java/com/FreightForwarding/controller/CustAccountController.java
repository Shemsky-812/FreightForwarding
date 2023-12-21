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
import com.FreightForwarding.model.ChargeRate;
import com.FreightForwarding.model.CustTransaction;
import com.FreightForwarding.model.CustomerInfo;
import com.FreightForwarding.model.SysUser;
import com.FreightForwarding.service.ChargeRateService;
import com.FreightForwarding.service.CustTransactionService;
import com.FreightForwarding.service.CustomerInfoService;
import com.FreightForwarding.service.SysMenuService;
import com.FreightForwarding.service.SysUserOrgService;

@Controller
@RequestMapping("/custAccountController")
public class CustAccountController {
	private final static Logger log = Logger.getLogger(CustAccountController.class);
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private CustomerInfoService customerInfoService;
	
	@Autowired
	private SysUserOrgService sysUserOrgService;
	
	@Autowired
	private CustTransactionService custTransactionService;
	
	@Autowired
	private ChargeRateService chargeRateService;
	
	
	/**
	 * 账户信息
	 * 
	 */
	@RequestMapping(value = "/custAccount")
	@PrivilegeInfo(value = "20")
	public ModelAndView custAccount(HttpServletRequest request,HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		for(Map<String, Object> map : sysMenuService.getLowMenu(20)){
			mav.addObject(map.get("menuIcon").toString(),map.get("menuAction").toString());
		}
		
		SysUser User = (SysUser) session.getAttribute("User");
		
		Integer orgId = sysUserOrgService.getSysUserOrgByUserId(User.getUserId());
		CustomerInfo customerInfo = customerInfoService.getCustomerInfoByOrgId(orgId);
		
		mav.addObject("custId",customerInfo.getCheckId());
		mav.addObject("custName",customerInfo.getCustName());
		mav.addObject("custDesc",customerInfo.getCustDesc());
		mav.addObject("paperNo",customerInfo.getPaperNo());
		mav.addObject("paperPath",customerInfo.getPaperPath());
		mav.addObject("accountBank",customerInfo.getAccountBank());
		mav.addObject("accountName",customerInfo.getAccountName());
		mav.addObject("accountNum",customerInfo.getAccountNum());
		mav.addObject("telNo",customerInfo.getTelNo());
		mav.addObject("eMail",customerInfo.getEMail());
		mav.addObject("address",customerInfo.getAddress());
		mav.addObject("amtAll",customerInfo.getAmtAll());
		mav.addObject("amtClock",customerInfo.getAmtClock());
		mav.addObject("amtFree",customerInfo.getAmtFree());
		
		mav.setViewName("custAccount");
		return mav;
	}
	
	/**
	 * 获取账户信息
	 * 
	 */
	@RequestMapping(value = "/getcustomer")
	@PrivilegeInfo(value = "20")
	public @ResponseBody Object getcustomer(HttpServletRequest request,HttpSession session){
		
		SysUser User = (SysUser) session.getAttribute("User");
		
		Integer orgId = sysUserOrgService.getSysUserOrgByUserId(User.getUserId());
		
		return customerInfoService.getCustomerInfoByOrgId(orgId);
	}
	
	/**
	 * 转账
	 * 
	 */
	@RequestMapping(value = "/custTransfer")
	@PrivilegeInfo(value = "22")
	public @ResponseBody Object custTransfer(HttpServletRequest request,HttpSession session) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		SysUser User = (SysUser) session.getAttribute("User");
		
		Integer orgId = sysUserOrgService.getSysUserOrgByUserId(User.getUserId());
		ChargeRate chargeRate = chargeRateService.getTxRate("1",User.getRoleId());
		CustomerInfo customerInfo = customerInfoService.getCustomerInfoByOrgId(orgId);
		
		mav.addObject("custId",customerInfo.getCustId());
		mav.addObject("custName",customerInfo.getCustName());
		mav.addObject("custDesc",customerInfo.getCustDesc());
		mav.addObject("paperNo",customerInfo.getPaperNo());
		mav.addObject("paperPath",customerInfo.getPaperPath());
		mav.addObject("accountBank",customerInfo.getAccountBank());
		mav.addObject("accountName",customerInfo.getAccountName());
		mav.addObject("accountNum",customerInfo.getAccountNum());
		mav.addObject("telNo",customerInfo.getTelNo());
		mav.addObject("eMail",customerInfo.getEMail());
		mav.addObject("address",customerInfo.getAddress());
		mav.addObject("amtAll",customerInfo.getAmtAll());
		mav.addObject("amtClock",customerInfo.getAmtClock());
		mav.addObject("amtFree",customerInfo.getAmtFree());
		mav.addObject("chargeRate",chargeRate.getRate());
		
		mav.setViewName("custTransfer");
		return mav;
	}

	/**
	 * 查询是否设置手续费
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/isChargeRate", method = RequestMethod.POST)
	@PrivilegeInfo(value = "22")
	public @ResponseBody Object isChargeRate(HttpServletRequest request,HttpSession session) throws IOException {
		Map<String, Object> resultMap = new HashMap<>();
		String rateType = request.getParameter("rateType");
		SysUser User = (SysUser) session.getAttribute("User");
		ChargeRate chargeRate = chargeRateService.getTxRate(rateType,User.getRoleId());
		if (chargeRate!=null){
			resultMap.put("isChargeRate",true);
		}else {
			resultMap.put("isChargeRate",false);
		}
		return resultMap;
	}
	
	/**
	 * 转账提交
	 * 
	 */
	@RequestMapping(value = "/custTransferConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "22")
	public @ResponseBody Object custTransferConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");

		CustTransaction custTransaction = new CustTransaction();
		
		custTransaction.setTradType("转账");
		custTransaction.setTradNo("TRANSFER"+java.util.UUID.randomUUID().toString().replace("-","").substring(0, 30));
		custTransaction.setTradFrom(Integer.parseInt(request.getParameter("custId")));
		custTransaction.setTradFromName(request.getParameter("custName"));
		custTransaction.setTradTo(Integer.parseInt(request.getParameter("tradTo")));
		custTransaction.setTradToName(request.getParameter("tradToName"));
		
		CustomerInfo customerInfo = customerInfoService.getCustomerInfo(Integer.parseInt(request.getParameter("custId")));
		
		custTransaction.setAmtAll(customerInfo.getAmtAll());
		custTransaction.setAmtClock(customerInfo.getAmtClock());
		custTransaction.setAmtFree(customerInfo.getAmtFree());
		
		BigDecimal tradAmt=new BigDecimal((String) request.getParameter("tradAmt"));
		double dbtradAmt = tradAmt.doubleValue();
		custTransaction.setTradAmt(dbtradAmt);
		BigDecimal chargeRate=new BigDecimal((String) request.getParameter("chargeRate"));
		custTransaction.setChargeRate(chargeRate.doubleValue());
		BigDecimal rateAmt=new BigDecimal((String) request.getParameter("rateAmt"));
		custTransaction.setRateAmt(rateAmt.doubleValue());
		custTransaction.setFilePath(request.getParameter("filePath"));
		custTransaction.setCustId(Integer.parseInt(request.getParameter("custId")));
		custTransaction.setCheckId(0);
		custTransaction.setStatus(1);
		custTransaction.setCrtOptr(User.getUserId());
		custTransaction.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable result = custTransactionService.insertCustTransaction(custTransaction);
		
		if (result.equals(0)) {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "转账失败");
		} else {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "转账成功");
		}
		return resultMap;
	}
	
	/**
	 * 提现
	 * 
	 */
	@RequestMapping(value = "/custCash")
	@PrivilegeInfo(value = "23")
	public @ResponseBody Object custCash(HttpServletRequest request,HttpSession session) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		SysUser User = (SysUser) session.getAttribute("User");
		
		Integer orgId = sysUserOrgService.getSysUserOrgByUserId(User.getUserId());
		ChargeRate chargeRate = chargeRateService.getTxRate("2",User.getRoleId());
		CustomerInfo customerInfo = customerInfoService.getCustomerInfoByOrgId(orgId);
		
		mav.addObject("custId",customerInfo.getCustId());
		mav.addObject("custName",customerInfo.getCustName());
		mav.addObject("custDesc",customerInfo.getCustDesc());
		mav.addObject("paperNo",customerInfo.getPaperNo());
		mav.addObject("paperPath",customerInfo.getPaperPath());
		mav.addObject("accountBank",customerInfo.getAccountBank());
		mav.addObject("accountName",customerInfo.getAccountName());
		mav.addObject("accountNum",customerInfo.getAccountNum());
		mav.addObject("telNo",customerInfo.getTelNo());
		mav.addObject("eMail",customerInfo.getEMail());
		mav.addObject("address",customerInfo.getAddress());
		mav.addObject("amtAll",customerInfo.getAmtAll());
		mav.addObject("amtClock",customerInfo.getAmtClock());
		mav.addObject("amtFree",customerInfo.getAmtFree());
		mav.addObject("chargeRate",chargeRate.getRate());
		
		mav.setViewName("custCash");
		
		return mav;
	}
	
	/**
	 * 提现提交
	 * 
	 */
	@RequestMapping(value = "/custCashConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "23")
	public @ResponseBody Object custCashConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");

		CustTransaction custTransaction = new CustTransaction();
		
		custTransaction.setTradType("提现");
		custTransaction.setTradNo("CASH"+java.util.UUID.randomUUID().toString().replace("-","").substring(0, 30));
		custTransaction.setTradFrom(Integer.parseInt(request.getParameter("custId")));
		custTransaction.setTradFromName(request.getParameter("custName"));
		custTransaction.setTradTo(Integer.parseInt(request.getParameter("tradTo")));
		custTransaction.setTradToName(request.getParameter("tradToName"));
		
		CustomerInfo customerInfo = customerInfoService.getCustomerInfo(Integer.parseInt(request.getParameter("custId")));
		
		custTransaction.setAmtAll(customerInfo.getAmtAll());
		custTransaction.setAmtClock(customerInfo.getAmtClock());
		custTransaction.setAmtFree(customerInfo.getAmtFree());
		
		BigDecimal tradAmt=new BigDecimal((String) request.getParameter("tradAmt"));
		double dbtradAmt = tradAmt.doubleValue();
		custTransaction.setTradAmt(dbtradAmt);
		BigDecimal chargeRate=new BigDecimal((String) request.getParameter("chargeRate"));
		custTransaction.setChargeRate(chargeRate.doubleValue());
		BigDecimal rateAmt=new BigDecimal((String) request.getParameter("rateAmt"));
		custTransaction.setRateAmt(rateAmt.doubleValue());
		custTransaction.setFilePath(request.getParameter("filePath"));
		custTransaction.setCustId(Integer.parseInt(request.getParameter("custId")));
		custTransaction.setCheckId(0);
		custTransaction.setStatus(1);
		custTransaction.setCrtOptr(User.getUserId());
		custTransaction.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable result = custTransactionService.insertCustTransaction(custTransaction);
		
		if (result.equals(0)) {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "转账失败");
		} else {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "新增成功");
		}
		return resultMap;
	}
	
	/**
	 * 交易历史
	 * 
	 */
	@RequestMapping(value = "/custHis")
	@PrivilegeInfo(value = "24")
	public @ResponseBody Object custHis(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("custHis");
		return mav;
	}
	
	/**
	 * 交易历史列表
	 * 
	 */
	@RequestMapping(value = "/custHisList",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@PrivilegeInfo(value = "24")
	public @ResponseBody Object custHisList(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>();  
		
		SysUser User = (SysUser) session.getAttribute("User");
		Integer orgId = sysUserOrgService.getSysUserOrgByUserId(User.getUserId());
		CustomerInfo customerInfo = customerInfoService.getCustomerInfoByOrgId(orgId);
		
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));  
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
        Map<String, Object> mapData = new HashMap<String,Object>();
        mapData.put("tradType", request.getParameter("tradType")); 
        mapData.put("tradFromName", request.getParameter("tradFromName")); 
        mapData.put("tradToName", request.getParameter("tradToName")); 
        mapData.put("custId", customerInfo.getCustId()); 
        
        resultMap = custTransactionService.getList(pageNumber, pageSize,mapData);
        
        String jsonString = objectMapper.writeValueAsString(resultMap.get("rows"));
        String json = "{\"total\":" + resultMap.get("total") + ",\"rows\":" + jsonString + "}";
        
        log.info("json:"+json);
        return json;
	}
	
	/**
	 * 交易复核
	 * 
	 */
	@RequestMapping(value = "/custBusiness")
	@PrivilegeInfo(value = "25")
	public ModelAndView orgIndex(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		for(Map<String, Object> map : sysMenuService.getLowMenu(25)){
			mav.addObject(map.get("menuIcon").toString(),map.get("menuAction").toString());
		}
		mav.setViewName("custBusiness");
		return mav;
	}
	
	/**
	 * 交易复核列表
	 * 
	 */
	@RequestMapping(value = "/custBusinessList",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@PrivilegeInfo(value = "25")
	public @ResponseBody Object custBusinessList(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>();  
		
		SysUser User = (SysUser) session.getAttribute("User");
		Integer orgId = sysUserOrgService.getSysUserOrgByUserId(User.getUserId());
		CustomerInfo customerInfo = customerInfoService.getCustomerInfoByOrgId(orgId);
		
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));  
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
        Map<String, Object> mapData = new HashMap<String,Object>();
        mapData.put("tradType", request.getParameter("tradType")); 
        mapData.put("tradFromName", request.getParameter("tradFromName")); 
        mapData.put("tradToName", request.getParameter("tradToName")); 
        mapData.put("custId", customerInfo.getCustId()); 
        
        resultMap = custTransactionService.getBusinessList(pageNumber, pageSize,mapData);
        
        String jsonString = objectMapper.writeValueAsString(resultMap.get("rows"));
        String json = "{\"total\":" + resultMap.get("total") + ",\"rows\":" + jsonString + "}";
        
        log.info("json:"+json);
        return json;
	}
	
	/**
	 * 转账复核
	 * 
	 */
	@RequestMapping(value = "/custTransferCheck")
	@PrivilegeInfo(value = "26")
	public @ResponseBody Object custTransferCheck(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		CustTransaction custTransaction = custTransactionService.getCustTransaction(Integer.parseInt(request.getParameter("tradId")));
		
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
		
		mav.setViewName("custTransferCheck");
		return mav;
	}
	
	/**
	 * 提现复核
	 * 
	 */
	@RequestMapping(value = "/custCashCheck")
	@PrivilegeInfo(value = "27")
	public @ResponseBody Object custCashCheck(HttpServletRequest request,HttpSession session) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		CustTransaction custTransaction = custTransactionService.getCustTransaction(Integer.parseInt(request.getParameter("tradId")));
		
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
		
		SysUser User = (SysUser) session.getAttribute("User");
		Integer orgId = sysUserOrgService.getSysUserOrgByUserId(User.getUserId());
		CustomerInfo customerInfo = customerInfoService.getCustomerInfoByOrgId(orgId);
		
		mav.addObject("accountBank",customerInfo.getAccountBank());
		mav.addObject("accountName",customerInfo.getAccountName());
		mav.addObject("accountNum",customerInfo.getAccountNum());

		
		mav.setViewName("custCashCheck");
		return mav;
	}
}