package com.talker.system.security.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleMenu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer roleid;
	private Integer menuid;
	private Date createdate;
	private Integer createuser;
	private Date updatedate;
	private Integer updateuser;
	public RoleMenu() {
		super();
	}
	
	public RoleMenu(Integer roleid) {
		super();
		this.roleid = roleid;
	}

	public RoleMenu(Integer roleid, Integer menuid, Date createdate,
			Integer createuser) {
		super();
		this.roleid = roleid;
		this.menuid = menuid;
		this.createdate = createdate;
		this.createuser = createuser;
	}

	public List<RoleMenu> translateArray(int[] menuid){
		List<RoleMenu> result = new ArrayList<RoleMenu>();
		for (int menu : menuid) {
			result.add(new RoleMenu(null, menu, new Date(), 1));
		}
		return result;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getMenuid() {
		return menuid;
	}
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Integer getCreateuser() {
		return createuser;
	}
	public void setCreateuser(Integer createuser) {
		this.createuser = createuser;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public Integer getUpdateuser() {
		return updateuser;
	}
	public void setUpdateuser(Integer updateuser) {
		this.updateuser = updateuser;
	}
	@Override
	public String toString() {
		return "RoleMenu [id=" + id + ", roleid=" + roleid + ", menuid="
				+ menuid + ", createdate=" + createdate + ", createuser="
				+ createuser + ", updatedate=" + updatedate + ", updateuser="
				+ updateuser + "]";
	}
	
}
