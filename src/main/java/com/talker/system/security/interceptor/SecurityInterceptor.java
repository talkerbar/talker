package com.talker.system.security.interceptor;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.talker.apiManage.cache.MemcachedPool;
import com.talker.system.security.vo.UserSession;
import com.talker.util.CookieUtil;

public class SecurityInterceptor extends HandlerInterceptorAdapter{
	
	Log log = LogFactory.getLog(SecurityInterceptor.class);
	
	private List<String> uncheckedUrl = new ArrayList<String>();
	private String login;
	
	public void setUncheckedUrl(String uncheckedUrl) {
		if(StringUtils.isNotBlank(uncheckedUrl)){
			String[] controller = uncheckedUrl.split(",");
			for (String string : controller) {
				if(StringUtils.isNotBlank(string)){
					this.uncheckedUrl.add(string);
				}
			}
		}
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
    
	private boolean needInterceptor(String uri){
		for (String string : uncheckedUrl) {
			if(uri.startsWith(string)){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg) throws Exception{
		String uri = request.getServletPath();
		if(needInterceptor(uri)){
			//需要检查权限的逻辑-检查是否登陆
			String sessionId = CookieUtil.getCookieString(CookieUtil.CookieValue.COOKIE_SESSION_ID, request);
			UserSession us = "".equals(sessionId)?null:(UserSession)MemcachedPool.get(sessionId);
			if(us==null || us.getUserLogin()==null){
				log.debug("user not login!");
				String contextPath = request.getContextPath();
				String params = request.getQueryString();
				params = (params==null?"":"?"+params);
				response.sendRedirect(contextPath+login+"?returnUrl="+URLEncoder.encode(request.getRequestURL()+params,"utf-8"));
				return false;
			}else{
				//检查是否有权限访问该链接
			}
		}
		return true;
	}
	
}
