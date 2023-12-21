package com.FreightForwarding.controller;

import java.io.IOException;
import java.io.Serializable;
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
import com.FreightForwarding.model.Company;
import com.FreightForwarding.model.CustomerInfo;
import com.FreightForwarding.model.SysOrg;
import com.FreightForwarding.model.SysUser;
import com.FreightForwarding.model.SysUserOrg;
import com.FreightForwarding.service.CompanyService;
import com.FreightForwarding.service.CustomerInfoService;
import com.FreightForwarding.service.SysMenuService;
import com.FreightForwarding.service.SysOrgService;
import com.FreightForwarding.service.SysUserOrgService;
import com.FreightForwarding.service.SysUserService;
import com.FreightForwarding.utils.EncryptUtil;

@Controller
@RequestMapping("/companyController")
public class CompanyController {
	private final static Logger log = Logger.getLogger(CompanyController.class);
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private SysOrgService sysOrgService;
	
	@Autowired
	private SysUserOrgService sysUserOrgService;
	
	@Autowired
	private CustomerInfoService customerInfoService;
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 企业信息认证
	 * 
	 */
	@RequestMapping(value = "/companyIndex")
	@PrivilegeInfo(value = "47")
	public ModelAndView companyIndex(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		for(Map<String, Object> map : sysMenuService.getLowMenu(47)){
			mav.addObject(map.get("menuIcon").toString(),map.get("menuAction").toString());
		}
		mav.setViewName("companyList");
		return mav;
	}
	
	/**
	 * 企业信息列表
	 * 
	 */
	@RequestMapping(value = "/companyList",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@PrivilegeInfo(value = "47")
	public @ResponseBody Object companyList(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>();  
		
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));  
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
        Map<String, Object> mapData = new HashMap<String,Object>();
        mapData.put("custName", request.getParameter("custName")); 
        mapData.put("paperNo", request.getParameter("paperNo")); 
        mapData.put("status", request.getParameter("status")); 
        
        resultMap = companyService.getList(pageNumber, pageSize,mapData);
        
        String jsonString = objectMapper.writeValueAsString(resultMap.get("rows"));
        String json = "{\"total\":" + resultMap.get("total") + ",\"rows\":" + jsonString + "}";
        
        log.info("json:"+json);
        return json;
	}
	
	/**
	 * 新增
	 * 
	 */
	@RequestMapping(value = "/companyAdd")
	@PrivilegeInfo(value = "48")
	public @ResponseBody Object companyAdd(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("companyAdd");
		return mav;
	}
	/**
	 * 企业新增提交
	 * 
	 */
	@RequestMapping(value = "/companyAddConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "48")
	public @ResponseBody Object companyAddConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");
		//企业信息
		Company company = new Company();
		
		company.setCustName(request.getParameter("custName"));
		company.setPaperNo(request.getParameter("paperNo"));
		company.setPaperPath(request.getParameter("paperPath"));
		company.setAccountBank(request.getParameter("accountBank"));
		company.setAccountName(request.getParameter("accountName"));
		company.setAccountNum(request.getParameter("accountNum"));
		company.setTelNo(request.getParameter("telNo"));
		company.setEMail(request.getParameter("eMail"));
		company.setAddress(request.getParameter("address"));
		company.setLoginNameInp(request.getParameter("loginNameInp"));
		company.setPasswdInp(request.getParameter("passwdInp"));
		company.setUserNameInp(request.getParameter("userNameInp"));
		company.setSexInp(request.getParameter("sexInp"));
		company.setMobileNoInp(request.getParameter("mobileNoInp"));
		company.setEMailInp(request.getParameter("eMailInp"));
		company.setAddressInp(request.getParameter("addressInp"));
		company.setLoginNameApp(request.getParameter("loginNameApp"));
		company.setPasswdApp(request.getParameter("passwdApp"));
		company.setUserNameApp(request.getParameter("userNameApp"));
		company.setSexApp(request.getParameter("sexApp"));
		company.setMobileNoApp(request.getParameter("mobileNoApp"));
		company.setEMailApp(request.getParameter("eMailApp"));
		company.setAddressApp(request.getParameter("addressApp"));
		company.setStatus(2);
		company.setCrtOptr(User.getUserId());
		company.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable result = companyService.insertCompany(company);
		
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
	@RequestMapping(value = "/companyAmd")
	@PrivilegeInfo(value = "49")
	public @ResponseBody Object companyAmd(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
Company company = companyService.getCompany(Integer.parseInt(request.getParameter("regId")));
		
		mav.addObject("regId",company.getRegId());
		mav.addObject("custName",company.getCustName());
		mav.addObject("paperNo",company.getPaperNo());
		mav.addObject("paperPath",company.getPaperPath());
		mav.addObject("accountBank",company.getAccountBank());
		mav.addObject("accountName",company.getAccountName());
		mav.addObject("accountNum",company.getAccountNum());
		mav.addObject("telNo",company.getTelNo());
		mav.addObject("eMail",company.getEMail());
		mav.addObject("address",company.getAddress());
		mav.addObject("loginNameInp",company.getLoginNameInp());
		mav.addObject("passwdInp",company.getPasswdInp());
		mav.addObject("userNameInp",company.getUserNameInp());
		mav.addObject("sexInp",company.getSexInp());
		mav.addObject("mobileNoInp",company.getMobileNoInp());
		mav.addObject("eMailInp",company.getEMailInp());
		mav.addObject("addressInp",company.getAddressInp());
		mav.addObject("loginNameApp",company.getLoginNameApp());
		mav.addObject("passwdApp",company.getPasswdApp());
		mav.addObject("userNameApp",company.getUserNameApp());
		mav.addObject("sexApp",company.getSexApp());
		mav.addObject("mobileNoApp",company.getMobileNoApp());
		mav.addObject("eMailApp",company.getEMailApp());
		mav.addObject("addressApp",company.getAddressApp());
		mav.addObject("addressApp",company.getAddressApp());
		
		mav.setViewName("companyAmd");
		return mav;
	}
	/**
	 * 企业修改提交
	 * 
	 */
	@RequestMapping(value = "/companyAmdConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "49")
	public @ResponseBody Object companyAmdConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");
		//企业信息
		Company company = companyService.getCompany(Integer.parseInt(request.getParameter("regId")));
		
		company.setCustName(request.getParameter("custName"));
		company.setPaperNo(request.getParameter("paperNo"));
		company.setPaperPath(request.getParameter("paperPath"));
		company.setAccountBank(request.getParameter("accountBank"));
		company.setAccountName(request.getParameter("accountName"));
		company.setAccountNum(request.getParameter("accountNum"));
		company.setTelNo(request.getParameter("telNo"));
		company.setEMail(request.getParameter("eMail"));
		company.setAddress(request.getParameter("address"));
		company.setLoginNameInp(request.getParameter("loginNameInp"));
		company.setPasswdInp(request.getParameter("passwdInp"));
		company.setUserNameInp(request.getParameter("userNameInp"));
		company.setSexInp(request.getParameter("sexInp"));
		company.setMobileNoInp(request.getParameter("mobileNoInp"));
		company.setEMailInp(request.getParameter("eMailInp"));
		company.setAddressInp(request.getParameter("addressInp"));
		company.setLoginNameApp(request.getParameter("loginNameApp"));
		company.setPasswdApp(request.getParameter("passwdApp"));
		company.setUserNameApp(request.getParameter("userNameApp"));
		company.setSexApp(request.getParameter("sexApp"));
		company.setMobileNoApp(request.getParameter("mobileNoApp"));
		company.setEMailApp(request.getParameter("eMailApp"));
		company.setAddressApp(request.getParameter("addressApp"));
		company.setStatus(2);
		company.setModOptr(User.getUserId());
		company.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		boolean result = companyService.updateCompany(company);
		
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
	 * 企业删除
	 * 
	 */
	@RequestMapping(value = "/companyDel", method = RequestMethod.POST)
	@PrivilegeInfo(value = "50")
	public @ResponseBody Object companyDel(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");
		//企业信息
		Company company = companyService.getCompany(Integer.parseInt(request.getParameter("regId")));
		
		company.setStatus(0);
		company.setModOptr(User.getUserId());
		company.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		boolean result = companyService.updateCompany(company);
		
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
	 * 审核
	 * 
	 */
	@RequestMapping(value = "/companyCheck")
	@PrivilegeInfo(value = "51")
	public @ResponseBody Object companyCheck(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		
		Company company = companyService.getCompany(Integer.parseInt(request.getParameter("regId")));
		
		mav.addObject("regId",company.getRegId());
		mav.addObject("custName",company.getCustName());
		mav.addObject("paperNo",company.getPaperNo());
		mav.addObject("paperPath",company.getPaperPath());
		mav.addObject("accountBank",company.getAccountBank());
		mav.addObject("accountName",company.getAccountName());
		mav.addObject("accountNum",company.getAccountNum());
		mav.addObject("telNo",company.getTelNo());
		mav.addObject("eMail",company.getEMail());
		mav.addObject("address",company.getAddress());
		mav.addObject("loginNameInp",company.getLoginNameInp());
		mav.addObject("passwdInp",company.getPasswdInp());
		mav.addObject("userNameInp",company.getUserNameInp());
		mav.addObject("sexInp",company.getSexInp());
		mav.addObject("mobileNoInp",company.getMobileNoInp());
		mav.addObject("eMailInp",company.getEMailInp());
		mav.addObject("addressInp",company.getAddressInp());
		mav.addObject("loginNameApp",company.getLoginNameApp());
		mav.addObject("passwdApp",company.getPasswdApp());
		mav.addObject("userNameApp",company.getUserNameApp());
		mav.addObject("sexApp",company.getSexApp());
		mav.addObject("mobileNoApp",company.getMobileNoApp());
		mav.addObject("eMailApp",company.getEMailApp());
		mav.addObject("addressApp",company.getAddressApp());
		mav.addObject("addressApp",company.getAddressApp());
		
		mav.setViewName("companyCheck");
		return mav;
	}
	/**
	 * 企业注册不通过 - 返回修改或删除
	 * 
	 */
	@RequestMapping(value = "/backCompanyAmd", method = RequestMethod.POST)
	@PrivilegeInfo(value = "51")
	public @ResponseBody Object backCompanyAmd(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");
		//企业信息
		Company company = companyService.getCompany(Integer.parseInt(request.getParameter("regId")));
		
		company.setStatus(1);
		company.setModOptr(User.getUserId());
		company.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		boolean result = companyService.updateCompany(company);
		
		if (result) {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "回退成功");
		} else {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "回退失败");
		}
		return resultMap;
	}
	
	/**
	 * 企业注册通过-新建机构，企业账户，用户，用户机构信息
	 * 
	 */
	@RequestMapping(value = "/companyCheckConfirm", method = RequestMethod.POST)
	@PrivilegeInfo(value = "51")
	public @ResponseBody Object companyCheckConfirm(HttpServletRequest request,HttpSession session) throws IOException {
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		SysUser User = (SysUser) session.getAttribute("User");
		
		String custName = request.getParameter("custName");
		String paperNo = request.getParameter("paperNo");
		String paperPath = request.getParameter("paperPath");
		String accountBank = request.getParameter("accountBank");
		String accountName = request.getParameter("accountName");
		String accountNum = request.getParameter("accountNum");
		String telNo = request.getParameter("telNo");
		String eMail = request.getParameter("eMail");
		String address = request.getParameter("address");
		String loginNameInp = request.getParameter("loginNameInp");
		String passwdInp = request.getParameter("passwdInp");
		String userNameInp = request.getParameter("userNameInp");
		String sexInp = request.getParameter("sexInp");
		String mobileNoInp = request.getParameter("mobileNoInp");
		String eMailInp = request.getParameter("eMailInp");
		String addressInp = request.getParameter("addressInp");
		String roleIdInp = request.getParameter("roleIdInp");
		String loginNameApp = request.getParameter("loginNameApp");
		String passwdApp = request.getParameter("passwdApp");
		String userNameApp = request.getParameter("userNameApp");
		String sexApp = request.getParameter("sexApp");
		String mobileNoApp = request.getParameter("mobileNoApp");
		String eMailApp = request.getParameter("eMailApp");
		String addressApp = request.getParameter("addressApp");
		String roleIdApp = request.getParameter("roleIdApp");
		
		
		//新增机构
		SysOrg org = new SysOrg();
		
		org.setPorgId(0);
		org.setOrgCode(paperNo);
		org.setOrgName(custName);
		org.setOrgDesc(custName);
		org.setStatus(1);
		org.setCrtOptr(User.getUserId());
		org.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable orgId = sysOrgService.insertSysOrg(org);
		//新增企业账户
		CustomerInfo customerInfo = new CustomerInfo();
		
		customerInfo.setCustName(custName);
		customerInfo.setCustDesc("");
		customerInfo.setPaperNo(paperNo);
		customerInfo.setPaperPath(paperPath);
		customerInfo.setAccountBank(accountBank);
		customerInfo.setAccountName(accountName);
		customerInfo.setAccountNum(accountNum);
		customerInfo.setTelNo(telNo);
		customerInfo.setEMail(eMail);
		customerInfo.setAddress(address);
		customerInfo.setAmtAll(0.00);
		customerInfo.setAmtClock(0.00);
		customerInfo.setAmtFree(0.00);
		customerInfo.setOrgId(org.getOrgId());
		customerInfo.setCheckId(0);
		customerInfo.setStatus(1);
		customerInfo.setCrtOptr(User.getUserId());
		customerInfo.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable custId = customerInfoService.insertCustomerInfo(customerInfo);
		
		//新增用户-操作人员
		SysUser userInp = new SysUser();
		
		userInp.setLoginName(loginNameInp);
		try {
			userInp.setPasswd(EncryptUtil.addMD5(passwdInp).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userInp.setUserName(userNameInp);
		userInp.setSex(sexInp);
		userInp.setUserCode("");
		userInp.setMobileNo(mobileNoInp);
		userInp.setEMail(eMailInp);
		userInp.setAddress(addressInp);
		userInp.setRoleId(Integer.parseInt(roleIdInp));
		userInp.setStatus(1);
		userInp.setCrtOptr(User.getUserId());
		userInp.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable userInpId = sysUserService.insertSysUser(userInp);
		
		//新增用户-审核人员
		SysUser userApp = new SysUser();
		
		userApp.setLoginName(loginNameApp);
		try {
			userApp.setPasswd(EncryptUtil.addMD5(passwdApp).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userApp.setUserName(userNameApp);
		userApp.setSex(sexApp);
		userApp.setUserCode("");
		userApp.setMobileNo(mobileNoApp);
		userApp.setEMail(eMailApp);
		userApp.setAddress(addressApp);
		userApp.setRoleId(Integer.parseInt(roleIdApp));
		userApp.setStatus(1);
		userApp.setCrtOptr(User.getUserId());
		userApp.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable userAppId = sysUserService.insertSysUser(userApp);
		
		//分配用户机构-操作人员
		
		SysUserOrg userInpOrg = new SysUserOrg();
		
		userInpOrg.setUserId(userInp.getUserId());
		userInpOrg.setOrgId(org.getOrgId());
		userInpOrg.setStatus(1);
		userInpOrg.setCrtOptr(User.getUserId());
		userInpOrg.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable userInpOrgId = sysUserOrgService.insertSysUserOrg(userInpOrg);
		
		//分配用户机构-审核人员
		
		SysUserOrg userAppOrg = new SysUserOrg();
		
		userAppOrg.setUserId(userApp.getUserId());
		userAppOrg.setOrgId(org.getOrgId());
		userAppOrg.setStatus(1);
		userAppOrg.setCrtOptr(User.getUserId());
		userAppOrg.setCrtTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		Serializable userAppOrgId = sysUserOrgService.insertSysUserOrg(userAppOrg);
		
		//企业信息
		Company company = companyService.getCompany(Integer.parseInt(request.getParameter("regId")));
		
		company.setStatus(3);
		company.setModOptr(User.getUserId());
		company.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		boolean result = companyService.updateCompany(company);
		
		if (orgId.equals(0) || custId.equals(0) || userInpId.equals(0) || userAppId.equals(0) || userInpOrgId.equals(0) || userAppOrgId.equals(0)) {
			resultMap.put("isSuc", false);
			resultMap.put("errMsg", "新增失败");
		} else {
			resultMap.put("isSuc", true);
			resultMap.put("errMsg", "新增成功");
		}
		
		return resultMap;
	}
}