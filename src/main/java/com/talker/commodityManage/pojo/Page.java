package com.talker.commodityManage.pojo;

import java.io.Serializable;
import java.util.List;

/**  
 * 创建时间 : 2016-2-3 下午3:44:28
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：Page.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class Page implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Integer pageNum;		 // 当前页码
    private Integer pageCount;		 // 总页数
    private List<?> data;
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	/**
	 * 方法名: buildPage
	 * 说明 :  TODO
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-2-3 下午3:52:37 
	 * 返回值  : Page
	 */
	public static Page buildPage(Integer pageNum,Integer pageCount,List<?> data){
		Page page = new Page();
		page.setPageNum(pageNum);
		page.setPageCount(pageCount);
		page.setData(data);
		return page;
	}
    
}
