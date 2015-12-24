package com.talker.system.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talker.system.security.dao.RoleMenuDao;
import com.talker.system.security.pojo.RoleMenu;
import com.talker.system.security.service.RoleMenuService;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
	
	@Autowired
	private RoleMenuDao rmDao;

	public boolean addRoleMenu(int[] menuid, int roleid) {
		return rmDao.addRoleMenu(new RoleMenu().translateArray(menuid),roleid);
	}
	
	@Transactional(rollbackForClassName="RuntimeException",propagation=Propagation.REQUIRED)
	public boolean updateRoleMenu(int[] menuid, int roleid) {
		rmDao.delRoleMenu(new RoleMenu(roleid));
		rmDao.addRoleMenu(new RoleMenu().translateArray(menuid),roleid);
		return true;
	}

	public List<RoleMenu> getRoleMenu(RoleMenu rm) {
		return rmDao.getRoleMenu(rm);
	}

}
