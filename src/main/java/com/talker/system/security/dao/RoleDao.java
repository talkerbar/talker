package com.talker.system.security.dao;

import java.util.List;

import com.talker.system.security.pojo.Role;

public interface RoleDao {
	
	boolean addRole(Role role);
	boolean delRole(Role role);
	boolean updateRole(Role role);
	List<Role> getRole(Role role);

}
