package com.talker.system.security.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talker.system.security.dao.RoleDao;
import com.talker.system.security.pojo.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean addRole(Role role) {
		boolean result = false;
		String sql = "insert into role(rolename,createdate,createuser,descript,enable) values(?,?,?,?,?)";
		Object[] params = {role.getRolename(),role.getCreatedate(),role.getCreateuser(),role.getDescript(),role.isEnable()};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}

	public boolean delRole(Role role) {
		boolean result = false;
		String sql = "update role set updatedate = ?,updateuser = ?,enable = ? where id = ?";
		Object[] params = {role.getUpdatedate(),role.getUpdateuser(),role.isEnable(),role.getId()};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}

	public boolean updateRole(Role role) {
		boolean result = false;
		String sql = "update role set rolename = ?,updatedate = ?,updateuser = ?,deacript = ?,enable = ? where id = ?";
		Object[] params = {role.getRolename(),role.getUpdatedate(),role.getUpdateuser(),role.getDescript(),role.isEnable(),role.getId()};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}

	public List<Role> getRole(Role role) {
		StringBuffer sql = new StringBuffer("select * from role where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(role != null){
			if(role.getId()!=0){
				sql.append(" and id = ?");
				params.add(role.getId());
			}
			if(role.getRolename()!=null){
				sql.append(" and rolename = ?");
				params.add(role.getRolename());
			}
			if(role.isEnable()!=null){
				sql.append(" and enable = ?");
				params.add(role.isEnable());
			}
		}
		return jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<Role>(Role.class));
	}

}
