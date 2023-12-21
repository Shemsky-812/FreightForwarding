package com.FreightForwarding.aspect;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.FreightForwarding.service.SysRoleMenuService;

import com.FreightForwarding.annotation.PrivilegeAnnotationParse;
import com.FreightForwarding.model.SysUser;

/**
 * 权限检查切面
 */
@SuppressWarnings({ "rawtypes" })
public class PrivilegeAspect {
	
	private final static Logger log = Logger.getLogger(PrivilegeAspect.class);
	@Resource
	private SysRoleMenuService sysRoleMenuService;
	
    /**
     * aop中的环绕通知
     */
    public Object isAccessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        
        Object result = new Object();
    	boolean isAccessed = false;
        Class targetClass = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        String methodAccess = PrivilegeAnnotationParse.parse(targetClass, methodName);
        if ("".equals(methodAccess)) {
            isAccessed = true;
        }else {
        	SysUser sysUser = (SysUser) session.getAttribute("User");
        	if (sysUser==null) {
        		isAccessed = false;
    		} else {
    	        for (Map<String, Object> privilege : sysRoleMenuService.rolePrivilege(sysUser.getRoleId())) {
    	            if (privilege.get("menuId") != null && privilege.get("menuId").toString().equalsIgnoreCase(methodAccess)) {
    	                isAccessed = true;
    	                break;
    	            }
    	        }
    		}
		}
        if (isAccessed) {
        	result = joinPoint.proceed();
        	log.info("权限正确");
        } else {
    		ModelAndView mav = new ModelAndView();
    		mav.setViewName("error");
        	result = mav ;
        	log.info("权限错误");
        }
        return result;
    }
}