package com.talker.system.security.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.apiManage.cache.MemcachedPool;
import com.talker.system.security.pojo.Menu;
import com.talker.system.security.service.MenuService;
import com.talker.system.security.service.impl.HandelMenuAndRight;
import com.talker.system.security.vo.UserSession;
import com.talker.util.CookieUtil;
import com.talker.util.ResponseModel;

@Controller
@RequestMapping("/menu/")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private HandelMenuAndRight hmar;
	
	@RequestMapping(value="add")
	@ResponseBody
	public boolean addMenu(Menu menu){
		menu.setMenuname("订单管理");
		menu.setUrl("/talker/order");
		menu.setCreatedate(new Date());
		menu.setCreateuser(1);
		menu.setDescript("这是一个一级菜单");
		menu.setEnable(1);
		return menuService.addMenu(menu);
	}
	
	@RequestMapping(value="del")
	@ResponseBody
	public boolean delMenu(Menu menu){
		return menuService.delMenu(menu);
	}
	
	@RequestMapping(value="update")
	@ResponseBody
	public boolean updateMenu(Menu menu){
		return menuService.updateMenu(menu);
	}
	
	@RequestMapping(value="get")
	@ResponseBody
	public List<Menu> getMenu(Menu menu){
		return menuService.getMenu(menu);
	}
	
	@RequestMapping(value="right")
	@ResponseBody
	public UserSession getTestMenuRight(HttpServletRequest request){
		String sessionId = CookieUtil.getCookieString(CookieUtil.CookieValue.COOKIE_SESSION_ID, request);
		UserSession us = (UserSession)MemcachedPool.get(sessionId);
		return us;
	}
	
	@RequestMapping(value="islogin")
	@ResponseBody
	public ResponseModel idLogin(HttpServletRequest request){
		boolean success = false;
		String message = "用户未登陆";
		String sessionId = CookieUtil.getCookieString(CookieUtil.CookieValue.COOKIE_SESSION_ID, request);
		UserSession us = (UserSession)MemcachedPool.get(sessionId);
		if(sessionId!=null && us!=null){
			success = true;
			message = "用户已登陆";
		}
		return ResponseModel.buildMessage(success, message);
	}

}
