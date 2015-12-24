package com.talker.system.security.service;

import java.util.List;

import com.talker.system.security.pojo.Role;

public interface RoleService {
	
	boolean addRole(Role role);
	boolean delRole(Role role);
	boolean updateRole(Role role);
	List<Role> getRole(Role role);

}
