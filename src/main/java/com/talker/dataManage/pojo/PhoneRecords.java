package com.talker.dataManage.pojo;

import java.io.Serializable;
import java.util.Date;

public class PhoneRecords implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer requesterid;
	private String requesterphone;
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
	public Integer getRequesterid() {
		return requesterid;
	}
	public void setRequesterid(Integer requesterid) {
		this.requesterid = requesterid;
	}
	public String getRequesterphone() {
		return requesterphone;
	}
	public void setRequesterphone(String requesterphone) {
		this.requesterphone = requesterphone;
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
		return "PhoneRecords [id=" + id + ", requesterid=" + requesterid
				+ ", requesterphone=" + requesterphone + ", cid=" + cid
				+ ", createdate=" + createdate + "]";
	}
	
}
