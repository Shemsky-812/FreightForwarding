package com.FreightForwarding.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.FreightForwarding.annotation.PrivilegeInfo;
import com.FreightForwarding.annotation.SystemControllerLog;
import com.FreightForwarding.service.SysLogService;
import com.FreightForwarding.service.SysMenuService;

@Controller
@RequestMapping("/sysLogController")
public class SysLogController {
	private final static Logger log = Logger.getLogger(SysLogController.class);
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private SysLogService sysLogService;
	
	/**
	 * 日志管理主界面
	 * 
	 */
	@RequestMapping(value = "/logIndex")
	@PrivilegeInfo(value = "18")
	public ModelAndView logIndex(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		for(Map<String, Object> map : sysMenuService.getLowMenu(18)){
			mav.addObject(map.get("menuIcon").toString(),map.get("menuAction").toString());
		}
		mav.setViewName("logList");
		return mav;
	}
	
	/**
	 * 日志列表
	 * 
	 */
	@RequestMapping(value = "/logList",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@PrivilegeInfo(value = "18")
	@SystemControllerLog(value = "日志列表")
	public @ResponseBody Object logList(HttpServletRequest request) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>();  
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));  
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
        String status = request.getParameter("status"); 
        resultMap = sysLogService.getList(pageNumber, pageSize, status);
        
        String jsonString = objectMapper.writeValueAsString(resultMap.get("rows"));
        String json = "{\"total\":" + resultMap.get("total") + ",\"rows\":" + jsonString + "}";
        
        log.info("json:"+json);
        return json;
	}
}