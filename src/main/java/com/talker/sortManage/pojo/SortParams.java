package com.talker.sortManage.pojo;

import java.io.Serializable;

public class SortParams extends Sort implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//分类需要操作的表（由于一些分类的表结构是一样的这里用同一个基本流程）
	private String table;
	
	
	public SortParams() {
		super();
	}
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
	
}
