package com.talker.system.security.service;

import java.util.List;

import com.talker.system.security.pojo.RoleMenu;

public interface RoleMenuService {
	
	boolean addRoleMenu(int[] menuid,int roleid);
	boolean updateRoleMenu(int[] menuid,int roleid);
	List<RoleMenu> getRoleMenu(RoleMenu rm);

}
