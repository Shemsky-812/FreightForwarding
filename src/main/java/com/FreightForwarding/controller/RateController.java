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
import com.FreightForwarding.model.SysUser;
import com.FreightForwarding.service.ChargeRateService;
import com.FreightForwarding.service.SysMenuService;

@Controller
@RequestMapping("/rateController")
public class RateController {
	private final static Logger log = Logger.getLogger(RateController.class);
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private ChargeRateService chargeRateService;
	
	/**
	 * 手续费管理
	 * 
	 */
	@RequestMapping(value = "/rateIndex")
	@PrivilegeInfo(value = "43")
	public ModelAndView rateIndex(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		for(Map<String, Object> map : sysMenuService.getLowMenu(43)){
			mav.addObject(map.get("menuIcon").toString(),map.get("menuAction").toString());
		}
		mav.setViewName("rateList");
		return mav;
	}
	/**
	 * 手续费列表
	 * 
	 */
	@RequestMapping(value = "/rateList",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@PrivilegeInfo(value = "43")
	public @ResponseBody Object rateList(HttpServletRequest request) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>();  
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));  
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
        Map<String, Object> mapData = new HashMap<String,Object>();
        mapData.put("rateName", request.getParameter("rateName")); 
        mapData.put("toCustId", request.getParameter("toCustId")); 
        mapData.put("status", request.getParameter("status")); 
        
        resultMap = chargeRateService.getList(pageNumber, pageSize,mapData);
        
        String jsonString = objectMapper.writeValueAsString(resultMap.get("rows"));
        String json = "{\"total\":" + resultMap.get("total") + ",\"rows\":" + jsonString + "}";
        
        log.info("json:"+json);
        return json;
	}
	
	/**
	 * 新增
	 * 
	 */
	@RequestMapping(value = "/rateAdd")
	@PrivilegeInfo(value = "44")
	public @ResponseBody Object rateAdd(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rateAdd");
		return mav;
	}
	/**
	 * 手续费新增提交
	 * 
	 */
	@RequestMapping(value = "/rateAddConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "44")
	public @ResponseBody Object rateAddConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");

		ChargeRate chargeRate = new ChargeRate();
		
		chargeRate.setRateType(request.getParameter("rateType"));
		chargeRate.setRateName(request.getParameter("rateName"));
		BigDecimal rate = new BigDecimal(request.getParameter("rate").toString());
		chargeRate.setRate(rate.doubleValue());
		chargeRate.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		chargeRate.setToCustId(Integer.parseInt(request.getParameter("toCustId")));
		chargeRate.setStatus(1);
		chargeRate.setCrtOptr(User.getUserId());
		chargeRate.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable result = chargeRateService.insertChargeRate(chargeRate);
		
		if (result.equals(0)) {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "新增手续费失败");
		} else {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "新增手续费成功");
		}
		return resultMap;
	}
	
	/**
	 * 修改
	 * 
	 */
	@RequestMapping(value = "/rateAmd")
	@PrivilegeInfo(value = "45")
	public @ResponseBody Object rateAmd(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		ChargeRate chargeRate = chargeRateService.getChargeRate(Integer.parseInt(request.getParameter("rateId")));
		
		mav.addObject("rateId",chargeRate.getRateId());
		mav.addObject("rateType",chargeRate.getRateType());
		mav.addObject("rateName",chargeRate.getRateName());
		mav.addObject("rate",chargeRate.getRate());
		mav.addObject("remark",chargeRate.getRemark());
		mav.addObject("roleId",chargeRate.getRoleId());
		mav.addObject("toCustId",chargeRate.getToCustId());
		mav.addObject("status",chargeRate.getStatus());
		
		mav.setViewName("rateAmd");
		return mav;
	}
	
	/**
	 * 手续费修改提交
	 * 
	 */
	@RequestMapping(value = "/rateAmdConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "45")
	public @ResponseBody Object rateAmdConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");

		ChargeRate chargeRate1 = chargeRateService.getChargeRate(Integer.parseInt(request.getParameter("rateId")));
		
		chargeRate1.setStatus(2);
		chargeRate1.setModOptr(User.getUserId());
		chargeRate1.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		chargeRateService.updateChargeRate(chargeRate1);
		
		ChargeRate chargeRate = new ChargeRate();
		
		chargeRate.setRateType(request.getParameter("rateType"));
		chargeRate.setRateName(request.getParameter("rateName"));
		BigDecimal rate = new BigDecimal(request.getParameter("rate").toString());
		chargeRate.setRate(rate.doubleValue());
		chargeRate.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		chargeRate.setToCustId(Integer.parseInt(request.getParameter("toCustId")));
		chargeRate.setStatus(1);
		chargeRate.setCrtOptr(User.getUserId());
		chargeRate.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable result = chargeRateService.insertChargeRate(chargeRate);
		
		if (result.equals(0)) {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "修改手续费失败");
		} else {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "修改手续费成功");
		}
		return resultMap;
	}
	
	/**
	 * 删除
	 * 
	 */
	@RequestMapping(value = "/rateDel", method = RequestMethod.POST)
	@PrivilegeInfo(value = "46")
	public @ResponseBody Object rateDel(HttpServletRequest request,HttpSession session){
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");

		ChargeRate chargeRate = chargeRateService.getChargeRate(Integer.parseInt(request.getParameter("rateId")));
		
		chargeRate.setStatus(2);
		chargeRate.setModOptr(User.getUserId());
		chargeRate.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		boolean result = chargeRateService.updateChargeRate(chargeRate);
		
		if (result) {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "删除手续费成功");
		} else {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "删除手续费失败");
		}
		return resultMap;
	}

	/**
	 * 检查手续费是否存在
	 *
	 */
	@RequestMapping(value = "/checkChargeRate", method = RequestMethod.GET)
	public @ResponseBody Object checkChargeRate(HttpServletRequest request,HttpSession session){
		String rateType = request.getParameter("rateType");
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		ChargeRate chargeRate = chargeRateService.getTxRate(rateType,roleId);
		if (chargeRate!=null) {
			return true;
		} else {
			return false;
		}
	}
}