package com.talker.dataManage.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talker.dataManage.dao.VisitDao;
import com.talker.dataManage.pojo.Visits;

@Repository
public class VisitDaoImpl implements VisitDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean addVisit(Visits visits) {
		boolean result = false;
		String sql = "insert into visits(ip,city,visitdate,cid) values(?,?,?,?)";
		Object[] parmas = {visits.getIp(),visits.getCity(),visits.getVisitDate(),visits.getcId()};
		int i = jdbcTemplate.update(sql, parmas);
		if(i!=0)
			result = true;
		return result;
	}

	@SuppressWarnings("deprecation")
	public int getVisitCountForCid(int cid) {
		String sql = "SELECT COUNT(*) FROM visits WHERE 1=1 AND cid = ?";
		return jdbcTemplate.queryForInt(sql, cid);
	}
}
