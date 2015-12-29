package com.talker.apiManage.pojo;

import java.io.Serializable;

/**  
 * 创建时间 : 2015-12-29 下午2:45:02
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：Poi.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class Poi implements Serializable{

	
		
	/** 
	* @Fields serialVersionUID : TODO
	* @author zdd
	*/ 
	    
	private static final long serialVersionUID = 1L;
	
	private String geotable_id;
	private String school_name;
	private String address;
	private String longitude;
	private String latitude;
	private String school_id;
	public String getGeotable_id() {
		return geotable_id;
	}
	public void setGeotable_id(String geotable_id) {
		this.geotable_id = geotable_id;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getSchool_id() {
		return school_id;
	}
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	
}
