package com.talker.system.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.system.security.pojo.RoleMenu;
import com.talker.system.security.service.RoleMenuService;

@Controller
@RequestMapping("/system/rolemenu/")
public class RoleMenuController {
	
	@Autowired
	private RoleMenuService rmService;
	
	@RequestMapping(value="add")
	@ResponseBody
	public boolean addRoleMenu(int[] menuid,int roleid){
		return rmService.addRoleMenu(menuid, roleid);
	}
	
	@RequestMapping(value="update")
	@ResponseBody
	public boolean updateRoleMenu(int[] menuid,int roleid){
		return rmService.updateRoleMenu(menuid, roleid);
	}
	
	@RequestMapping(value="get")
	@ResponseBody
	public List<RoleMenu> getRoleMenu(RoleMenu rm){
		return rmService.getRoleMenu(rm);
	}

}
