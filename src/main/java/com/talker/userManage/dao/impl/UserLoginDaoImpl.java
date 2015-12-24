package com.talker.userManage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.talker.userManage.dao.UserInfoDao;
import com.talker.userManage.dao.UserLoginDao;
import com.talker.userManage.pojo.UserLoginOut;
import com.talker.userManage.pojo.UserLoginParams;

@Repository
public class UserLoginDaoImpl implements UserLoginDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserInfoDao userInfoDao;

	public int regist(final UserLoginParams loginParams) {
		final String sql = "insert into userlogin(username,password,role,createdate,enable) values(?,?,?,?,?)";
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					
					ps.setString(1, loginParams.getUsername());
					ps.setString(2, loginParams.getPassword());
					ps.setInt(3, loginParams.getRole());
					ps.setTimestamp(4, new Timestamp(loginParams.getCreatedate().getTime()));
					ps.setInt(5, loginParams.getEnable());
					
					return ps;
				}
			}, keyHolder);
			return keyHolder.getKey().intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean login(String username, String password) {
		boolean result = false;
		UserLoginParams userLoginParams = new UserLoginParams();
		userLoginParams.setUsername(username);
		List<UserLoginOut> list = this.getUser(userLoginParams);
		if(list!=null && !list.isEmpty()){
			if(list.get(0).getPassword().equals(password)){
				result = true;
			}
		}
		return result;
	}

	public boolean updateUser(UserLoginParams loginParams) {
		boolean result = false;
		String sql = "update userlogin set password = ?,updatedate = ? where id = ?";
		Object[] params = {loginParams.getPassword(),loginParams.getUpdatedate(),loginParams.getId()};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}
	
	public List<UserLoginOut> getUser(UserLoginParams loginParams) {
		StringBuffer sql = new StringBuffer("select * from userlogin where 1=1");
		List<Object> params = new ArrayList<Object>();
		appendSql(loginParams, sql, params);
		return jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<UserLoginOut>(UserLoginOut.class));
	}

	private void appendSql(UserLoginParams loginParams, StringBuffer sql,
			List<Object> params) {
		if(loginParams!=null){
			if(loginParams.getId()!=0){
				sql.append(" and id = ?");
				params.add(loginParams.getId());
			}
			if(loginParams.getUsername()!=null){
				sql.append(" and username = ?");
				params.add(loginParams.getUsername());
			}
			if(loginParams.getRole()!=null){
				sql.append(" and role = ?");
				params.add(loginParams.getRole());
			}
			if(loginParams.getEnable()!=null){
				sql.append(" and enable = ?");
				params.add(loginParams.getEnable());
			}
		}
	}

	public UserLoginOut getUserForUserName(String userName) {
		String sql = "select * from userlogin where 1=1 and username ='"+userName+"'";
		List<UserLoginOut> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserLoginOut>(UserLoginOut.class));
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public UserLoginOut getUserForId(int id) {
		String sql = "select * from userlogin where 1=1 and id ="+id;
		final List<UserLoginOut> list = new ArrayList<UserLoginOut>();
		jdbcTemplate.query(sql,new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				UserLoginOut ulo = new UserLoginOut();
				ulo.setId(rs.getInt("id"));
				ulo.setUsername(rs.getString("username"));
				ulo.setPassword(rs.getString("password"));
				ulo.setRole(rs.getInt("role"));
				ulo.setEnable(rs.getInt("enable"));
				ulo.setCreatedate(rs.getDate("createdate"));
				ulo.setUpdatedate(rs.getDate("updatedate"));
				ulo.setUserInfoOut(userInfoDao.getUserInfoForLoginId(rs.getInt("id")));
				list.add(ulo);
			}
		});
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}


}
