package com.talker.system.security.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talker.system.security.dao.MenuDao;
import com.talker.system.security.pojo.Menu;
import com.talker.system.security.service.MenuService;
import com.talker.system.security.vo.AllRightMap;

@Service
public class MenuServiceImpl implements MenuService {
	
	private static final int NOT_CHILD = -1;
	
	@Autowired
	private MenuDao menuDao;

	@Transactional(rollbackForClassName="RuntimeException",propagation=Propagation.REQUIRED)
	public boolean addMenu(Menu menu) {
		int id = menuDao.addMenu(menu);
		if(menu.getParentid()!=0){
			String levelLink = menuDao.getLevelForParentId(menu.getParentid());
			menu.setLevellink(levelLink+"_"+id);
		}else{
			menu.setParentid(NOT_CHILD);
			menu.setLevellink(id+"");
		}
		menu.setId(id);
		menu.setUpdatedate(new Date());
		menu.setUpdateuser(1);
		menuDao.updateMenu(menu);
		return true;
	}

	public boolean delMenu(Menu menu) {
		return menuDao.delMenu(menu);
	}

	public boolean updateMenu(Menu menu) {
		return menuDao.updateMenu(menu);
	}

	public List<Menu> getMenu(Menu menu) {
		return menuDao.getMenu(menu);
	}

	public AllRightMap getRightMap(AllRightMap arm) {
		List<Menu> allMenu = menuDao.getMenu(null);
		Map<Integer, Menu> allMenuMap = new HashMap<Integer, Menu>();
		if(allMenu!=null){
			for (Menu menu : allMenu) {
				allMenuMap.put(menu.getId(), menu);
			}
			arm.setRightMap(allMenuMap);
		}
		return arm;
	}

}
