package com.talker.userManage.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserLoginParams extends UserLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date createdate;
	private Date updatedate;
	//验证码
	private String security_code;
	//重复密码
	private String repassword;
	public UserLoginParams() {
		super();
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getSecurity_code() {
		return security_code;
	}
	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	@Override
	public String toString() {
		return "UserLoginParams [createdate=" + createdate + ", updatedate="
				+ updatedate + ", getId()=" + getId() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword()
				+ ", getRole()=" + getRole() + ", getEnable()=" + getEnable()
				+ "]";
	}
	
}
