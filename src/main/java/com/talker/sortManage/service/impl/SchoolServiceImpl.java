package com.talker.sortManage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talker.sortManage.dao.SchoolDao;
import com.talker.sortManage.pojo.SortParams;
import com.talker.sortManage.service.SchoolService;

/**  
 * 创建时间 : 2016-1-6 下午8:09:24
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：SchoolServiceImpl.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */
@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolDao schoolDao;

	public List<SortParams> getSchool(SortParams sortParams) {
		return schoolDao.getSchool(sortParams);
	}

}
