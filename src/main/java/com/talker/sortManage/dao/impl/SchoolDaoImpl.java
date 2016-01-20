package com.talker.sortManage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talker.sortManage.dao.SchoolDao;
import com.talker.sortManage.pojo.SortParams;

/**  
 * 创建时间 : 2016-1-6 下午8:00:19
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：SchoolDaoImpl.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */
@Repository
public class SchoolDaoImpl implements SchoolDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<SortParams> getSchool(SortParams sortParams) {
		StringBuffer sql = new StringBuffer("select * from school where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(sortParams!=null){
			if(sortParams.getId()!=0){
				sql.append(" and id = ?");
				params.add(sortParams.getId());
			}
			if(sortParams.getName()!=null){
				sql.append(" and name like ?");
				params.add("%"+sortParams.getName()+"%");
			}
			if(sortParams.getProvince()!=null){
				sql.append(" and province = ?");
				params.add(sortParams.getProvince());
			}
			if(sortParams.getCity()!=null){
				sql.append(" and city = ?");
				params.add(sortParams.getCity());
			}
			if(sortParams.getDistrict()!=null){
				sql.append(" and district = ?");
				params.add(sortParams.getDistrict());
			}
		}
		return jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<SortParams>(SortParams.class));
	}

}
