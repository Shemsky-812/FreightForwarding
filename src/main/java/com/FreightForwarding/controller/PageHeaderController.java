package com.FreightForwarding.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FreightForwarding.model.SysUser;
import com.FreightForwarding.service.SysUserService;
import com.FreightForwarding.utils.ChangeImage;
import com.FreightForwarding.utils.UsersConfigUtils;

@Controller
@RequestMapping("/pageHeader")
public class PageHeaderController {
	private final static Logger log = Logger.getLogger(PageHeaderController.class);
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 更新用户信息
	 * 
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody Object updateUser(HttpServletRequest request,HttpSession session){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		SysUser user = sysUserService.getSysUser(Integer.parseInt(request.getParameter("userId")));
		
		user.setUserCode(request.getParameter("HuserCode"));
		user.setUserName(request.getParameter("HuserName"));
		user.setMobileNo(request.getParameter("HmobileNo"));
		user.setAddress(request.getParameter("Haddress"));
		user.setEMail(request.getParameter("HeMail"));
		user.setModOptr(Integer.parseInt(request.getParameter("userId")));
		user.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		boolean result = sysUserService.updateSysUser(user);
		
		if (result) {
			session.setAttribute("User", user);
			map.put("isSuc", true);
		} else {
			map.put("isSuc", false);
		}
		
		return map;
		
	}
	
	/**
	 * 修改头像
	 * 
	 */
	@RequestMapping(value = "/updUserPic", method = RequestMethod.POST)
	public @ResponseBody Object updUserPic(HttpServletRequest request,HttpSession session) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		SysUser User = (SysUser) session.getAttribute("User");
		
		
		if(User != null){
			UsersConfigUtils config = new UsersConfigUtils();
			//图片(base64)
			String userPic = request.getParameter("userPic").toString().replace("data:image/jpeg;base64,", "");
			//项目路径
//			String dir = request.getServletContext().getRealPath("") ;
			String dir = "/var/lib/tomcat9/webapps/";
			log.info(dir);
			//图片路径
			String path = config.GetUsersConfig("USER-IMG-PATH")+User.getUserId()+"/";
			//文件名
			String name = config.GetUsersConfig("USER-IMG-NAME");
			//保存图片(base64)到相对路径
			boolean fileStatus = ChangeImage.GenerateImage(userPic,dir+path,name);
			//更新图片路径
			if (fileStatus) {
				SysUser sysUser = sysUserService.getSysUser(User.getUserId());
	    		
				sysUser.setPicPath(path+name);
				sysUser.setModOptr(User.getUserId());
				sysUser.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	    		
	    		boolean updateStatus = sysUserService.updateSysUser(sysUser);
	    		
	    		if (updateStatus) {
	    			map.put("isSuc", true);
	    			session.setAttribute("User", sysUser);
	    		} else {
	    			map.put("isSuc", false);
	    		}
			} else {
				map.put("isSuc", false);
			}

		} else {
				map.put("noLogin", true);
			}
			return map;
		}
	
	
	/**
	 * 检查用户密码
	 * 
	 */
	@RequestMapping(value = "/checkPass", method = RequestMethod.GET)
	public @ResponseBody Object checkPass(HttpServletRequest request,HttpSession session){
		
		SysUser user = sysUserService.getSysUser(Integer.parseInt(request.getParameter("userId")));
		
		if (request.getParameter("passwd").equals(user.getPasswd())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 更新用户密码
	 * 
	 */
	@RequestMapping(value = "/updatePass", method = RequestMethod.POST)
	public @ResponseBody Object updatePass(HttpServletRequest request,HttpSession session){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		SysUser user = sysUserService.getSysUser(Integer.parseInt(request.getParameter("userId")));
		
		user.setPasswd(request.getParameter("NewPassword"));
		user.setModOptr(Integer.parseInt(request.getParameter("userId")));
		user.setModTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		boolean result = sysUserService.updateSysUser(user);
		if(result){
			session.setAttribute("User", user);
		}
		map.put("isSuc", result);
		
		return map;
		
	}
}