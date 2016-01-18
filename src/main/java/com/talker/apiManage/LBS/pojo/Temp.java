package com.talker.apiManage.LBS.pojo;

import java.io.Serializable;

/**  
 * 创建时间 : 2016-1-6 下午7:21:06
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：Temp.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class Temp implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String address;
	private String lng;
	private String lat;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}

}
