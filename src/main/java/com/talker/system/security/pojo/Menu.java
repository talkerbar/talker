package com.talker.system.security.pojo;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String menuname;
	private String url;
	private String levellink;
	private int parentid;
	private Date createdate;
	private int createuser;
	private Date updatedate;
	private int updateuser;
	private String descript;
	private int enable;
	public Menu() {
		super();
	}
	
	public Menu(int parentid) {
		super();
		this.parentid = parentid;
	}

	public Menu(String menuname, String url, String levellink, int parentid,
			Date createdate, int createuser, Date updatedate, int updateuser,
			String descript, int enable) {
		super();
		this.menuname = menuname;
		this.url = url;
		this.levellink = levellink;
		this.parentid = parentid;
		this.createdate = createdate;
		this.createuser = createuser;
		this.updatedate = updatedate;
		this.updateuser = updateuser;
		this.descript = descript;
		this.enable = enable;
	}
	public Menu(String menuname, String url, String levellink, int parentid,
			Date createdate, int createuser, String descript, int enable) {
		super();
		this.menuname = menuname;
		this.url = url;
		this.levellink = levellink;
		this.parentid = parentid;
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
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLevellink() {
		return levellink;
	}
	public void setLevellink(String levellink) {
		this.levellink = levellink;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
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
	public int isEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuname=" + menuname + ", url=" + url
				+ ", levellink=" + levellink + ", parentid=" + parentid
				+ ", createdate=" + createdate + ", createuser=" + createuser
				+ ", updatedate=" + updatedate + ", updateuser=" + updateuser
				+ ", descript=" + descript + ", enable=" + enable + "]";
	}
	
}
