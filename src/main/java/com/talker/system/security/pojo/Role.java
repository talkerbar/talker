package com.talker.system.security.pojo;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String rolename;
	private Date createdate;
	private int createuser;
	private Date updatedate;
	private int updateuser;
	private String descript;
	private Boolean enable = null;
	public Role() {
		super();
	}
	public Role(String rolename, Date createdate, int createuser,
			Date updatedate, int updateuser, String descript, Boolean enable) {
		super();
		this.rolename = rolename;
		this.createdate = createdate;
		this.createuser = createuser;
		this.updatedate = updatedate;
		this.updateuser = updateuser;
		this.descript = descript;
		this.enable = enable;
	}
	public Role(String rolename, Date createdate, int createuser, String descript,
			Boolean enable) {
		super();
		this.rolename = rolename;
		this.createdate = createdate;
		this.createuser = createuser;
		this.descript = descript;
		this.enable = enable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getCreateuser() {
		return createuser;
	}
	public void setCreateuser(int createuser) {
		this.createuser = createuser;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public int getUpdateuser() {
		return updateuser;
	}
	public void setUpdateuser(int updateuser) {
		this.updateuser = updateuser;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public Boolean isEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", createdate="
				+ createdate + ", createuser=" + createuser + ", updatedate="
				+ updatedate + ", updateuser=" + updateuser + ", descript=" + descript
				+ ", enable=" + enable + "]";
	}
	
}
