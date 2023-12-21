package com.FreightForwarding.controller;

import java.io.IOException;
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
import com.FreightForwarding.model.Capital;
import com.FreightForwarding.model.CustTransaction;
import com.FreightForwarding.model.CustomerInfo;
import com.FreightForwarding.service.CapitalService;
import com.FreightForwarding.service.CustAmtService;
import com.FreightForwarding.service.CustTransactionService;
import com.FreightForwarding.service.CustomerInfoService;
import com.FreightForwarding.service.SysMenuService;

@Controller
@RequestMapping("/custAmtController")
public class custAmtController {
	private final static Logger log = Logger.getLogger(custAmtController.class);
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private CustAmtService custAmtService;
	
	/**
	 * 资金追踪
	 * 
	 */
	@RequestMapping(value = "/custAmtIndex")
	@PrivilegeInfo(value = "52")
	public ModelAndView capitalIndex(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		for(Map<String, Object> map : sysMenuService.getLowMenu(52)){
			mav.addObject(map.get("menuIcon").toString(),map.get("menuAction").toString());
		}
		mav.setViewName("custAmtList");
		return mav;
	}
	
	/**
	 * 资金交易列表
	 * 
	 */
	@RequestMapping(value = "/custAmtList",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@PrivilegeInfo(value = "52")
	public @ResponseBody Object custAmtList(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>();  
		
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));  
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
        Map<String, Object> mapData = new HashMap<String,Object>();
        mapData.put("amtCode", request.getParameter("amtCode")); 
        mapData.put("tradNo", request.getParameter("tradNo")); 
        
        resultMap = custAmtService.getList(pageNumber, pageSize,mapData);
        
        String jsonString = objectMapper.writeValueAsString(resultMap.get("rows"));
        String json = "{\"total\":" + resultMap.get("total") + ",\"rows\":" + jsonString + "}";
        
        log.info("json:"+json);
        return json;
	}
}