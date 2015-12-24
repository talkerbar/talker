package com.talker.system.security.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.system.security.pojo.Role;
import com.talker.system.security.service.RoleService;

@Controller
@RequestMapping("/system/role/")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="add")
	@ResponseBody
	public boolean addRole(Role role){
		role.setRolename("超级管理员");
		role.setCreatedate(new Date());
		role.setCreateuser(1);
		role.setDescript("测试");
		return roleService.addRole(role);
	}
	
	@RequestMapping(value="del")
	@ResponseBody
	public boolean delRole(Role role){
		return roleService.delRole(role);
	}
	
	@RequestMapping(value="update")
	@ResponseBody
	public boolean updateRole(Role role){
		return roleService.updateRole(role);
	}
	
	@RequestMapping(value="get")
	@ResponseBody
	public List<Role> getRole(Role role){
		return roleService.getRole(role);
	}

}
