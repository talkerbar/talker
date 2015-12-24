package com.talker.userManage.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserLoginOut extends UserLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	private String create_date;
	private String update_date;
	
	//个人信息
	private UserInfoOut userInfoOut;
	
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
	
	public UserInfoOut getUserInfoOut() {
		return userInfoOut;
	}
	public void setUserInfoOut(UserInfoOut userInfoOut) {
		this.userInfoOut = userInfoOut;
	}
	public static UserLoginOut loginParamsToLoginOut(UserLoginParams ulp){
		UserLoginOut ulo = new UserLoginOut();
		ulo.setId(ulp.getId());
		ulo.setUsername(ulp.getUsername());
		ulo.setPassword(ulp.getPassword());
		ulo.setRole(ulp.getRole());
		ulo.setEnable(ulp.getEnable());
		ulo.setCreatedate(ulp.getCreatedate());
		ulo.setUpdatedate(ulp.getUpdatedate());
		return ulo;
	}
}
