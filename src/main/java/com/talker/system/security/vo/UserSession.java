package com.talker.system.security.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.talker.system.security.pojo.Menu;
import com.talker.userManage.pojo.UserLoginOut;

public class UserSession implements Serializable{

	private static final long serialVersionUID = 1L;
	private UserLoginOut userLogin;       // 当前用户登录信息
	private List<Node> menu;              // 当前用户菜单
	private Map<Integer, Menu> menuMap;   // 当前用户权限
	private String sessionId;             // 当前对话唯一标示
	
	public boolean hasRight(Menu menu) {
		for(Integer id : menuMap.keySet()) {
			if(id.equals(menu.getId())) {
				return true;
			}
		}
		return false;
	}

	public UserLoginOut getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLoginOut userLogin) {
		this.userLogin = userLogin;
	}

	public List<Node> getMenu() {
		return menu;
	}

	public void setMenu(List<Node> menu) {
		this.menu = menu;
	}

	public Map<Integer, Menu> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(Map<Integer, Menu> menuMap) {
		this.menuMap = menuMap;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "UserSession [userLogin=" + userLogin + ", menu=" + menu
				+ ", menuMap=" + menuMap + ", sessionId=" + sessionId + "]";
	}
}
