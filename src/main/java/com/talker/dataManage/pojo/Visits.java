package com.talker.dataManage.pojo;

import java.io.Serializable;
import java.util.Date;

public class Visits implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String ip;
	private String city;
	private Date visitDate;
	private Integer cId;
	public Visits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	@Override
	public String toString() {
		return "Visits [id=" + id + ", ip=" + ip + ", city=" + city
				+ ", visitDate=" + visitDate + ", cId=" + cId + "]";
	}
}
