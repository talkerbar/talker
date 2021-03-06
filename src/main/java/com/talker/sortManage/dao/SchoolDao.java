package com.talker.sortManage.dao;

import java.util.List;

import com.talker.sortManage.pojo.SortParams;

/**  
 * 创建时间 : 2015-12-30 下午4:04:27
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：SchoolDao.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public interface SchoolDao {
	/**
	 * 方法名: getSchool
	 * 说明 :  根据条件查询学校
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-1-6 下午7:59:31 
	 * 返回值  : boolean
	 */
	public List<SortParams> getSchool(SortParams sortParams);

}
