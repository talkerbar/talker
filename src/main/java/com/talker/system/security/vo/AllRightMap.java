package com.talker.system.security.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.talker.system.security.pojo.Menu;

public class AllRightMap implements Serializable{

	private static final long serialVersionUID = 1L;
	private Map<Integer, Menu> rightMap = new HashMap<Integer, Menu>();
	
	public Menu getRightByUrl(String url) {
		for(Menu sr : rightMap.values()) {
			if(StringUtils.isNotBlank(sr.getUrl()) && url.startsWith(sr.getUrl())) {
				return sr;
			}
		}
		return null;
	}
	public Menu getRight(Integer rightId) {
		return rightMap.get(rightId);
	}
	
	public AllRightMap removeRight(Integer rightId) {
		rightMap.remove(rightId);
		return this;
	}
	
	public AllRightMap updateRight(Menu sr) {
		rightMap.put(sr.getId(), sr);
		return this;
	}

	public Map<Integer, Menu> getRightMap() {
		return rightMap;
	}

	public void setRightMap(Map<Integer, Menu> rightMap) {
		this.rightMap = rightMap;
	}
}
