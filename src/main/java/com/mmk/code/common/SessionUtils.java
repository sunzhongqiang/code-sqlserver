package com.mmk.code.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtils {
	
	public static HttpSession getSession(){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
	    HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();  
	    return request.getSession();
	}

}
