package com.talker.system.security.dao;

import java.util.List;

import com.talker.system.security.pojo.RoleMenu;

public interface RoleMenuDao {
	
	boolean addRoleMenu(List<RoleMenu> rm,int id);
	boolean delRoleMenu(RoleMenu rm);
	List<RoleMenu> getRoleMenu(RoleMenu rm);

}
