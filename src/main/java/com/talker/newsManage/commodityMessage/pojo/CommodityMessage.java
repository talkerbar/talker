package com.talker.newsManage.commodityMessage.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommodityMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");
	
	private Integer id;
	private Integer cid;
	private String content;
	private Date createDate;
	private Integer post_userid;
	private Integer received_userid;
	private Integer parentid;
	//附加数据
	private String nickname;
	private String icon;
	private String create_date;
	
	public CommodityMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		if(createDate!=null)
			this.create_date = sdf.format(createDate);
		this.createDate = createDate;
	}
	public Integer getPost_userid() {
		return post_userid;
	}
	public void setPost_userid(Integer post_userid) {
		this.post_userid = post_userid;
	}
	public Integer getReceived_userid() {
		return received_userid;
	}
	public void setReceived_userid(Integer received_userid) {
		this.received_userid = received_userid;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getCreate_date() {
		return create_date;
	}
	@Override
	public String toString() {
		return "CommodityMessage [id=" + id + ", cid=" + cid + ", content="
				+ content + ", createDate=" + createDate + ", post_userid="
				+ post_userid + ", received_userid=" + received_userid
				+ ", parentid=" + parentid + ", nickname=" + nickname
				+ ", icon=" + icon + ", create_date=" + create_date + "]";
	}
	
}
