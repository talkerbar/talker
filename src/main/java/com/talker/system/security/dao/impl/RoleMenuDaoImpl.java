package com.talker.system.security.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talker.system.security.dao.RoleMenuDao;
import com.talker.system.security.pojo.RoleMenu;

@Repository
public class RoleMenuDaoImpl implements RoleMenuDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean addRoleMenu(final List<RoleMenu> rm,final int roleid) {
		boolean result = false;
		String sql = "insert into rolemenu(roleid,menuid,createdate,createuser) values(?,?,?,?)";
		int[] i = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				RoleMenu r = rm.get(i);
				ps.setInt(1, roleid);
				ps.setInt(2, r.getMenuid());
				ps.setTimestamp(3, new Timestamp(new Date().getTime()));
				ps.setInt(4, r.getCreateuser());
			}
			
			public int getBatchSize() {
				return rm.size();
			}
		});
		if(i.length!=0)
			result = true;
		return result;
	}

	public boolean delRoleMenu(RoleMenu rm) {
		boolean result = false;
		StringBuffer sql = new StringBuffer("delete from rolemenu where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(rm!=null){
			if(rm.getId()!=null){
				sql.append(" and id = ?");
				params.add(rm.getId());
			}
			if(rm.getRoleid()!=null){
				sql.append(" and roleid = ?");
				params.add(rm.getRoleid());
			}
		}
		int i = jdbcTemplate.update(sql.toString(), params.toArray());
		if(i!=0)
			result = true;
		return result;
	}

	public List<RoleMenu> getRoleMenu(RoleMenu rm) {
		StringBuffer sql = new StringBuffer("select * from rolemenu where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(rm!=null){
			if(rm.getId()!=null){
				sql.append(" and id = ?");
				params.add(rm.getId());
			}
			if(rm.getRoleid()!=null){
				sql.append(" and roleid = ?");
				params.add(rm.getRoleid());
			}
		}
		return jdbcTemplate.query(sql.toString(),params.toArray(), new BeanPropertyRowMapper<RoleMenu>(RoleMenu.class));
	}

}
