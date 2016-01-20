package com.talker.userManage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.talker.sortManage.dao.SortDao;
import com.talker.userManage.dao.UserInfoDao;
import com.talker.userManage.pojo.UserInfoOut;
import com.talker.userManage.pojo.UserInfoParams;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	
	Log log = LogFactory.getLog(UserInfoDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SortDao sortDao;

	public boolean addUserInfo(UserInfoParams userInfoParams) {
		boolean result = false;
		String sql = "insert into userinfo(nickname,telephone,icon,createdate,userloginid) values(?,?,?,?,?)";
		Object[] params = {userInfoParams.getNickname(),userInfoParams.getTelephone(),userInfoParams.getIcon(),userInfoParams.getCreatedate(),userInfoParams.getUserloginid()};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}

	public boolean updateUserInfo(UserInfoParams userInfoParams) {
		boolean result = false;
		String sql = "update userinfo set nickname = ?,realname = ?,schoolid = ?,professionalid = ?," +
				"gender = ?,grade = ?,telephone = ?,updatedate = ? where userloginid = ?";
		Object[] params = {userInfoParams.getNickname(),userInfoParams.getRealname(),userInfoParams.getSchoolid(),
				userInfoParams.getProfessionalid(),userInfoParams.getGender(),userInfoParams.getGrade(),
				userInfoParams.getTelephone(),userInfoParams.getUpdatedate(),userInfoParams.getUserloginid()};
		int i = jdbcTemplate.update(sql, params);
		if(i!=0)
			result = true;
		return result;
	}

	public List<UserInfoOut> getUserInfo(UserInfoParams userInfoParams) {
		StringBuffer sql = new StringBuffer("select * from userinfo where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(userInfoParams!=null){
			if(userInfoParams.getNickname()!=null){
				sql.append(" and nickname = ?");
				params.add("%"+userInfoParams.getNickname()+"%");
			}
			if(userInfoParams.getRealname()!=null){
				sql.append(" and realname = ?");
				params.add("%"+userInfoParams.getRealname()+"%");
			}
			if(userInfoParams.getSchoolid()!=0){
				sql.append(" and schoolid = ?");
				params.add(userInfoParams.getSchoolid());
			}
			if(userInfoParams.getProfessionalid()!=0){
				sql.append(" and professionalid = ?");
				params.add(userInfoParams.getProfessionalid());
			}
			if(userInfoParams.getTelephone()!=null){
				sql.append(" and telephone = ?");
				params.add(userInfoParams.getTelephone());
			}
		}
		return jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<UserInfoOut>(UserInfoOut.class));
	}

	public UserInfoOut getUserInfoForLoginId(int userloginid) {
		String sql = "select * from userinfo where 1=1 and userloginid ="+userloginid;
		final List<UserInfoOut> list = new ArrayList<UserInfoOut>();
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				UserInfoOut uio = new UserInfoOut();
				uio.setId(rs.getInt("id"));
				uio.setNickname(rs.getString("nickname"));
				uio.setRealname(rs.getString("realname"));
				uio.setGender(rs.getInt("gender"));
				uio.setGrade(rs.getInt("grade"));
				uio.setSchoolid(rs.getInt("schoolid"));
				uio.setProfessionalid(rs.getInt("professionalid"));
				uio.setTelephone(rs.getString("telephone"));
				uio.setIcon(rs.getString("icon"));
				uio.setCreatedate(rs.getDate("createdate"));
				uio.setUpdatedate(rs.getDate("updatedate"));
				uio.setUserloginid(rs.getInt("userloginid"));
				if(rs.getInt("schoolid")!=0)
					uio.setSchoolName(sortDao.getSortForId("school", rs.getInt("schoolid")));
				if(rs.getInt("professionalid")!=0)
				uio.setProfessionalName(sortDao.getSortForId("professional", rs.getInt("professionalid")));
				list.add(uio);
			}
		});
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public boolean updateUserIcon(String icon, int id) {
		boolean result = false;
		String sql = "update userinfo set icon = ? where userloginid = ?";
		int i = jdbcTemplate.update(sql, icon,id);
		if(i!=0)
			result = true;
		return result;
	}

	public String getUserIcon(Integer userloginid) {
		String sql = "select icon from userinfo where userloginid ="+userloginid;
		try {
			return jdbcTemplate.queryForObject(sql, String.class);
		} catch (Exception e) {
			log.error("获取头像时出错啦", e);
		}
		return null;
	}

}
