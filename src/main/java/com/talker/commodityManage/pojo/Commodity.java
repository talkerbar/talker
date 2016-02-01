package com.talker.commodityManage.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.talker.userManage.pojo.UserInfoOut;

public class Commodity implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private int id;
	private String title;
	private Integer sortid;
	private Integer newandold;
	private Double newprice;
	private Double oldprice;
	private Integer dicker;
	private String cellnumber;
	private String callname;
    private Integer	schoolid;
    private String description;
    private Integer userid;
    private Date createdate;
    private Date updatedate;
    private Integer status;
    // 辅助字段
    private String createTime;
    private String updateTime;
    private String starcellnumber;   // 加密后的手机号
    private List<Images> images;     // 图片集
    private UserInfoOut userInfoOut; // 用户基本信息
    private Integer visits;          // 商品浏览量
    private String schoolName;       // 商品所在学校
    private Integer phoneRecords;    // 获取电话次数
    private Integer pageSize;        // 每页数据条数
    private Integer pageNum;		 // 当前页码
    private boolean cutSmallImg;     // 是否需要剪切小图
    // 需要查询多个分类的字段
    private String sortidmore;       // 多个id用|分割
    
	public Commodity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSortid() {
		return sortid;
	}

	public void setSortid(Integer sortid) {
		this.sortid = sortid;
	}

	public Integer getNewandold() {
		return newandold;
	}

	public void setNewandold(Integer newandold) {
		this.newandold = newandold;
	}

	public Double getNewprice() {
		return newprice;
	}

	public void setNewprice(Double newprice) {
		this.newprice = newprice;
	}

	public Double getOldprice() {
		return oldprice;
	}

	public void setOldprice(Double oldprice) {
		this.oldprice = oldprice;
	}

	public Integer getDicker() {
		return dicker;
	}

	public void setDicker(Integer dicker) {
		this.dicker = dicker;
	}

	public String getCellnumber() {
		return cellnumber;
	}

	public void setCellnumber(String cellnumber) {
		if(cellnumber!=null){
			starcellnumber = cellnumber.substring(0, 3)+"****"+cellnumber.substring(7, 11);
		}
		this.cellnumber = cellnumber;
	}

	public String getCallname() {
		return callname;
	}

	public void setCallname(String callname) {
		this.callname = callname;
	}

	public Integer getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(Integer schoolid) {
		this.schoolid = schoolid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		if(createdate!=null)
			this.createTime = sdf.format(createdate);
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		if(updatedate!=null)
			this.updateTime = sdf.format(updatedate);
		this.updatedate = updatedate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getCreateTime() {
		return createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}
	
	public UserInfoOut getUserInfoOut() {
		return userInfoOut;
	}

	public void setUserInfoOut(UserInfoOut userInfoOut) {
		this.userInfoOut = userInfoOut;
	}

	public Integer getVisits() {
		return visits;
	}

	public void setVisits(Integer visits) {
		this.visits = visits;
	}
	
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public Integer getPhoneRecords() {
		return phoneRecords;
	}

	public void setPhoneRecords(Integer phoneRecords) {
		this.phoneRecords = phoneRecords;
	}
	public String getStarcellnumber() {
		return starcellnumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public boolean isCutSmallImg() {
		return cutSmallImg;
	}

	public void setCutSmallImg(boolean cutSmallImg) {
		this.cutSmallImg = cutSmallImg;
	}
	public String getSortidmore() {
		return sortidmore;
	}

	public void setSortidmore(String sortidmore) {
		this.sortidmore = sortidmore;
	}

	/**
	 * 方法名: beginIndex
	 * 说明 :  得到分页的起始位置
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-1-26 上午11:21:22 
	 * 返回值  : Integer
	 */
	public Integer beginIndex() {
		if(this.pageNum==0)
			return 0;
		else
			return (pageNum-1)*pageSize;
	}
	
}
