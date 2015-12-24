package com.talker.userManage.pojo;

import java.io.Serializable;
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nickname;
	private String realname;
	private Integer gender;
	private Integer grade;
	private String telephone;
	private Integer schoolid;
	private Integer professionalid;
	private String icon;
	private Integer userloginid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(Integer schoolid) {
		this.schoolid = schoolid;
	}
	public Integer getProfessionalid() {
		return professionalid;
	}
	public void setProfessionalid(Integer professionalid) {
		this.professionalid = professionalid;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getUserloginid() {
		return userloginid;
	}
	public void setUserloginid(Integer userloginid) {
		this.userloginid = userloginid;
	}
}
