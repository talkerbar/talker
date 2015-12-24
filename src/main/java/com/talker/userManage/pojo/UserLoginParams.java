package com.talker.userManage.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserLoginParams extends UserLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date createdate;
	private Date updatedate;
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
	@Override
	public String toString() {
		return "UserLoginParams [createdate=" + createdate + ", updatedate="
				+ updatedate + ", getId()=" + getId() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword()
				+ ", getRole()=" + getRole() + ", getEnable()=" + getEnable()
				+ "]";
	}
	
}
