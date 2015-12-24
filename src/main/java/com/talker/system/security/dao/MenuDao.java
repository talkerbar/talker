package com.talker.system.security.dao;

import java.util.List;

import com.talker.system.security.pojo.Menu;

public interface MenuDao {
	
	int addMenu(Menu menu);
	boolean delMenu(Menu menu);
	boolean updateMenu(Menu menu);
	List<Menu> getMenu(Menu menu);
	String getLevelForParentId(int parentId);

}
