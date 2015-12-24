package com.talker.system.security.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talker.system.security.dao.MenuDao;
import com.talker.system.security.pojo.Menu;
import com.talker.system.security.service.MenuService;
import com.talker.system.security.vo.AllRightMap;
import com.talker.system.security.vo.Node;
import com.talker.system.security.vo.UserSession;

@Component
public class HandelMenuAndRight {
	
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private MenuService menuService;
	
	public UserSession prepareMenuAndRight4User(UserSession uv, Integer userId) {
		//1 根据userId 的到用户权限
		List<Menu> userMenu = menuDao.getMenu(null);
		//2 创建用户菜单集合节点
		List<Node> menus = new ArrayList<Node>();
		//3 创建一个权限Map
		Map<Integer, Menu> menusMap = new HashMap<Integer, Menu>();
		//4 创建用户权限MapNode辅助Map
		Map<Integer, Node> nodesMap = new HashMap<Integer, Node>();
		//5 得到所有权限
		AllRightMap arm = menuService.getRightMap(new AllRightMap());
		for (Menu menu : userMenu) {
			travelSecurityRight(menu,menus,arm,menusMap,nodesMap);
		}
		uv.setMenu(menus);
		uv.setMenuMap(menusMap);
		return uv;
	}
	
	private void travelSecurityRight(Menu menu, List<Node> menus,
			AllRightMap arm, Map<Integer, Menu> menusMap,
			Map<Integer, Node> nodesMap) {
		String levelLink = menu.getLevellink();
		if (levelLink != null) {
			String[] ids = levelLink.split("_");
			if (ids != null && ids.length > 0) {
				for (int i = 0; i < ids.length; i++) {
					Integer id = Integer.valueOf(ids[i]);
					if(i == 0) {
						if(!nodesMap.containsKey(id) && arm.getRightMap().containsKey(id)) {
							Node mn = new Node(arm.getRight(id));
							
							nodesMap.put(id, mn);
							menusMap.put(id, arm.getRight(id));
							
							menus.add(mn);
						}
					} else {
						if(!nodesMap.containsKey(id) && arm.getRightMap().containsKey(id)) {
							Node mn = new Node(arm.getRight(id));
							
							nodesMap.put(id, mn);
							menusMap.put(id, arm.getRight(id));
							
							Integer pid = Integer.valueOf(ids[i - 1]);
							if(nodesMap.containsKey(pid)) {
								nodesMap.get(pid).addChild(mn);
							}
						}
					}
				}
			}
		}
	}

}
