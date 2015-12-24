package com.talker.sortManage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talker.sortManage.dao.SortDao;
import com.talker.sortManage.pojo.Sort;
import com.talker.sortManage.pojo.SortParams;

@Repository
public class SortDaoimpl implements SortDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 

	public boolean addSort(SortParams sort) {
		boolean result = false;
		StringBuffer sql = new StringBuffer("insert into ");
		sql.append(sort.getTable());
		sql.append(" (name,parentid) values(?,?)");
		Object[] params = {sort.getName(),sort.getParentid()};
		int i = jdbcTemplate.update(sql.toString(), params);
		if(i!=0)
			result = true;
		return result;
	}

	public boolean delSort(SortParams sort) {
		boolean result = false;
		StringBuffer sql = new StringBuffer("delete from ");
		sql.append(sort.getTable());
		sql.append(" where 1=1");
		List<Object> param = new ArrayList<Object>();
		appendSql(sort, sql, param);
		int i = jdbcTemplate.update(sql.toString(), param.toArray());
		if(i!=0)
			result = true;
		return result;
	}

	public boolean updateSort(SortParams sort) {
		boolean resule = false;
		StringBuffer sql = new StringBuffer("update ");
		sql.append(sort.getTable());
		sql.append(" set name = ?,parentid = ? where id = ?");
		Object[] param = {sort.getName(),sort.getParentid(),sort.getId()};
		int i = jdbcTemplate.update(sql.toString(), param);
		if(i!=0)
			resule = true;
		return resule;
	}

	public List<Sort> getSort(SortParams sort) {
		StringBuffer sql = new StringBuffer("select id,name,parentid from ");
		sql.append(sort.getTable());
		sql.append(" where 1=1");
		List<Object> param = new ArrayList<Object>();
		appendSql(sort, sql, param);
		return jdbcTemplate.query(sql.toString(), param.toArray(), new BeanPropertyRowMapper<Sort>(Sort.class));
	}

	/**
	 * 拼接SQL条件
	 * @param sort
	 * @param sql
	 * @param param
	 */
	private void appendSql(SortParams sort, StringBuffer sql, List<Object> param) {
		if(sort!=null){
			if(sort.getId()!=0){
				sql.append(" and id = ?");
				param.add(sort.getId());
			}
			if(sort.getName()!=null&&!"".equals(sort.getName())){
				sql.append(" and name = ?");
				param.add(sort.getName());
			}
			if(sort.getParentid()!=0){
				sql.append(" and parentid = ?");
				param.add(sort.getParentid());
			}
		}
	}

	public String getSortForId(String table,int id) {
		String sql = "select name from "+table+" where 1=1 and id ="+id;
		try {
			return jdbcTemplate.queryForObject(sql, String.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
