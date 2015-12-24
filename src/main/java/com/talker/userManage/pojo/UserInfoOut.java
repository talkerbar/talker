package com.talker.userManage.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoOut extends UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	private String create_date;
	private String update_date;
	private String schoolName;
	private String professionalName;
	public UserInfoOut() {
		super();
	}
	
	public String getCreate_date() {
		return create_date;
	}
	public void setCreatedate(Date createdate) {
		if(createdate!=null)
			this.create_date = sdf.format(createdate);
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdatedate(Date updatedate) {
		if(updatedate!=null)
			this.update_date = sdf.format(updatedate);
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getProfessionalName() {
		return professionalName;
	}
	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}
	
}
