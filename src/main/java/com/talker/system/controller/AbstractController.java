package com.talker.system.controller;

import javax.servlet.http.HttpServletRequest;

import com.talker.util.CookieUtil;

/**
 * 获取用户登录信息
 * @author zdd
 *
 */
public abstract class AbstractController {
	
	/**
	 * 获取当前用户ID
	 * @param request
	 * @return
	 */
	protected Integer getUserId(HttpServletRequest request){
		return CookieUtil.getCookieInteger(CookieUtil.CookieValue.COOKIE_USER_ID, request);
	}

}
