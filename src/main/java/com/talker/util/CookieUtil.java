package com.talker.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	public static final Integer HOUR = 60 * 60 * 1000;
	public static final Integer DAY = 24 * 60 * 60 * 1000;
	public static final Integer WEEK = DAY * 7;
	public static final Integer MONTH = DAY * 30;
	
	
	public static Integer getCookieInteger(String cookieKey, HttpServletRequest request) {
		String val = getCookieString(cookieKey, request);
		try {
			return Integer.valueOf(val);
		} catch(Exception e) {
			return null;
		}
	}
	
	public static String getCookieString(String cookieKey, HttpServletRequest request) {
		Cookie cookie = getCookie(cookieKey, request);
		if(cookie != null) {
			return cookie.getValue();
		}
		
	    return "";
	}
    
    public static Cookie getCookie(String cookieKey, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		 }
		for (int i = 0; i < cookies.length; i++) {
			if (cookieKey.equals(cookies[i].getName())) {
			return cookies[i];
			}
	    }
	    return null;
	}
    
    public static void setCookie(String cookieKey, Object value, Integer time, HttpServletResponse response, HttpServletRequest request) {
		Cookie oldCookie = getCookie(cookieKey, request);
		if (oldCookie == null) {
			Cookie cookie = new Cookie(cookieKey, value.toString());
			cookie.setPath("/");
			if(time != null) {
				cookie.setMaxAge(time);
			}
			response.addCookie(cookie);
		} else {
			oldCookie.setValue(value.toString());
			oldCookie.setPath("/");
			if(time != null) {
				oldCookie.setMaxAge(time);
			}
			response.addCookie(oldCookie);
		}
	}

    public static void delCookie(String cookieKey, HttpServletResponse response, HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		Cookie c = null;
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				c = cookies[i];
				if (c.getName().equals(cookieKey)) {
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
				}
			}
		}
	}
    
    public static final class CookieValue {
		public static final String COOKIE_USER_ID = "talker_user_id";
		public static final String COOKIE_SESSION_ID = "talker_session_id";
		
	}
}
