package com.talker.system.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talker.system.security.dao.RoleDao;
import com.talker.system.security.pojo.Role;
import com.talker.system.security.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	public boolean addRole(Role role) {
		return roleDao.addRole(role);
	}

	public boolean delRole(Role role) {
		return roleDao.delRole(role);
	}

	public boolean updateRole(Role role) {
		return roleDao.updateRole(role);
	}

	public List<Role> getRole(Role role) {
		return roleDao.getRole(role);
	}

}
