package com.talker.system.security.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.talker.system.security.dao.MenuDao;
import com.talker.system.security.pojo.Menu;

@Repository
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addMenu(final Menu menu) {
		final String sql = "insert into menu(menuname,url,levellink,parentid,createdate,createuser,descript,enable)"
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			KeyHolder keyHoder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, menu.getMenuname());
					ps.setString(2, menu.getUrl());
					ps.setString(3, menu.getLevellink());
					ps.setInt(4, menu.getParentid());
					ps.setTimestamp(5, new Timestamp(new Date().getTime()));
					ps.setInt(6, menu.getCreateuser());
					ps.setString(7, menu.getDescript());
					ps.setInt(8, menu.isEnable());
					return ps;
				}
			},keyHoder);
			return keyHoder.getKey().intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean delMenu(Menu menu) {
		boolean result = false;
		String sql = "update menu set updatedate = ?,updateuser = ?,enable = ? where id = ?";
		Object[] params = {menu.getUpdatedate(),menu.getUpdateuser(),menu.isEnable(),menu.getId()};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}

	public boolean updateMenu(Menu menu) {
		boolean result = false;
		StringBuffer sql = new StringBuffer("update menu set");
		List<Object> params = new ArrayList<Object>();
		if(menu!=null){
			if(menu.getMenuname()!=null){
				if(params.size()>0)
					sql.append(",");
				sql.append(" menuname = ?");
				params.add(menu.getMenuname());
			}
			if(menu.getUrl()!=null){
				if(params.size()>0)
					sql.append(",");
				sql.append(" url = ?");
				params.add(menu.getUrl());
			}
			if(menu.getLevellink()!=null){
				if(params.size()>0)
					sql.append(",");
				sql.append(" levellink = ?");
				params.add(menu.getLevellink());
			}
			if(menu.getParentid()!=0){
				if(params.size()>0)
					sql.append(",");
				sql.append(" parentid = ?");
				params.add(menu.getParentid());
			}
			if(menu.getUpdatedate()!=null){
				if(params.size()>0)
					sql.append(",");
				sql.append(" updatedate = ?");
				params.add(menu.getUpdatedate());
			}
			if(menu.getUpdateuser()!=0){
				if(params.size()>0)
					sql.append(",");
				sql.append(" updateuser = ?");
				params.add(menu.getUpdateuser());
			}
			if(menu.getDescript()!=null){
				if(params.size()>0)
					sql.append(",");
				sql.append(" descript = ?");
				params.add(menu.getDescript());
			}
			if(menu.isEnable()!=0){
				if(params.size()>0)
					sql.append(",");
				sql.append(" enable = ?");
				params.add(menu.isEnable());
			}
		}
		sql.append(" where id = ?");
		params.add(menu.getId());
		int i = jdbcTemplate.update(sql.toString(), params.toArray());
		if(i!=0)
			result = true;
		return result;
	}

	public List<Menu> getMenu(Menu menu) {
		StringBuffer sql = new StringBuffer("select * from menu where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(menu!=null){
			if(menu.getId()!=0){
				sql.append(" and id = ?");
				params.add(menu.getId());
			}
			if(menu.getMenuname()!=null){
				sql.append(" and menuname = ?");
				params.add(menu.getMenuname());
			}
			if(menu.getUrl()!=null){
				sql.append(" and url = ?");
				params.add(menu.getUrl());
			}
			if(menu.getParentid()!=0){
				sql.append(" and parentid = ?");
				params.add(menu.getParentid());
			}
			if(menu.getDescript()!=null){
				sql.append(" descript = ?");
				params.add(menu.getDescript());
			}
			if(menu.isEnable()!=0){
				sql.append(" enable = ?");
				params.add(menu.isEnable());
			}
		}
		return jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<Menu>(Menu.class));
	}

	public String getLevelForParentId(int parentId) {
		String sql = "select levellink from menu where 1=1 and id = ?";
		return (String)jdbcTemplate.queryForObject(sql, new Object[]{parentId}, String.class);
	}

}
