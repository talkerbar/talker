package com.talker.sortManage.pojo;

import java.io.Serializable;

public class SortParams extends Sort implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//分类需要操作的表（由于一些分类的表结构是一样的这里用同一个基本流程）
	private String table;
	//学校必要字段
	private String province;
	private String city;
	private String district;
	
	
	public SortParams() {
		super();
	}
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
}
