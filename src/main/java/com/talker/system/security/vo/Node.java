package com.talker.system.security.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.talker.system.security.pojo.Menu;

public class Node implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int parentid;
	private String label;
	private String url;
	private List<Node> items = new ArrayList<Node>();
	public Node(Menu menu) {
		this.id = menu.getId();
		if(menu.getParentid()!=0)
			this.parentid = menu.getParentid();
		this.label = menu.getMenuname();	
		this.url = menu.getUrl();
	}
	
	public void addChild(Node node) {
		if(!items.contains(node)) {
			items.add(node);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", parentid=" + parentid + ", label=" + label
				+ ", url=" + url + ", items=" + items + "]";
	}
}
