package com.FreightForwarding.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.FreightForwarding.model.SysUser;
import com.FreightForwarding.utils.EasyDateUtils;

@Controller
@RequestMapping("/upload")
public class UploadFileController {
	
	private static Logger logger = Logger.getLogger(UploadFileController.class);
	
	@RequestMapping(value="/file",method=RequestMethod.POST)  
    private @ResponseBody Object fildUpload(@RequestParam(value="file",required=false) MultipartFile[] file,  
            				HttpServletRequest request ,
            				HttpSession session,
            				HttpServletResponse actioncontext
            )throws Exception{
		Map<String, Object> resultMap = new HashMap<>();  
		SysUser User = (SysUser) session.getAttribute("User");
		if(User != null){
	        for (MultipartFile mf : file) {  
	            if(!mf.isEmpty()){
	            	String fileName = request.getParameter("filename");
//	            	String dir = request.getServletContext().getRealPath("");
					String dir = "/var/lib/tomcat9/webapps/";
	            	String path = "Upload/"+User.getUserId()+"/"+EasyDateUtils.timeToStr(new Date()).replace(":", "-")+"/";
	            	logger.info(path);
	            	File targetFile = new File(dir+path, fileName);  
					if (!targetFile.exists()) {
						targetFile.mkdirs();
					}else{
						targetFile.delete();
						targetFile.mkdirs();
					}
	                mf.transferTo(targetFile);
	                
	                resultMap.put("isSuc", true);
	        		resultMap.put("filePath", path+fileName);
	            }  
	        }  
		}
		
		return resultMap;
    }
}
