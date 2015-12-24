package com.talker.dataManage.pojo;

import java.io.Serializable;
import java.util.Date;

public class PhoneRecords implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String requesterphone;
	private String providephone;
	private Integer cid;
	private Date createdate;
	public PhoneRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRequesterphone() {
		return requesterphone;
	}
	public void setRequesterphone(String requesterphone) {
		this.requesterphone = requesterphone;
	}
	public String getProvidephone() {
		return providephone;
	}
	public void setProvidephone(String providephone) {
		this.providephone = providephone;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "Phonerecords [id=" + id + ", requesterphone=" + requesterphone
				+ ", providephone=" + providephone + ", cid=" + cid
				+ ", createdate=" + createdate + "]";
	}
	
}
