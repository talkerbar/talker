package com.talker.system.security.service;

import java.util.List;

import com.talker.system.security.pojo.Menu;
import com.talker.system.security.vo.AllRightMap;

public interface MenuService {
	
	boolean addMenu(Menu menu);
	boolean delMenu(Menu menu);
	boolean updateMenu(Menu menu);
	List<Menu> getMenu(Menu menu);
	AllRightMap getRightMap(AllRightMap arm);
}
