package com.FreightForwarding.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FreightForwarding.service.CustomerInfoService;
import com.FreightForwarding.service.SysRoleService;

@Controller
@RequestMapping("/combobox")
public class ComboboxController {
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@Autowired
	private CustomerInfoService customerInfoService;
	
	/**
	 * 选择角色
	 * 
	 */
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	public @ResponseBody Object product(HttpServletRequest request,HttpSession session) {
		return sysRoleService.getComboList();
	}
	
	/**
	 * 选择企业
	 * 
	 */
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public @ResponseBody Object customer(HttpServletRequest request,HttpSession session) {
		return customerInfoService.getComboList();
	}

}