package com.talker.userManage.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserInfoParams extends UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date createdate;
	private Date updatedate;
	public UserInfoParams() {
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
}
