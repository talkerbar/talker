package com.talker.sortManage.pojo;

import java.io.Serializable;

public class Sort implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int parentid;
	
	public Sort() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	@Override
	public String toString() {
		return "SortOut [id=" + id + ", name=" + name + ", parentid="
				+ parentid + "]";
	}
	
}
