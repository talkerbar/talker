package com.talker.dataManage.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talker.dataManage.dao.PhoneRecordsDao;
import com.talker.dataManage.pojo.PhoneRecords;

@Repository
public class PhoneRecordsDaoImpl implements PhoneRecordsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean addPhoneRecords(PhoneRecords phoneRecords) {
		boolean result = false;
		String sql = "insert into phonerecords(requesterid,requesterphone,cid,createdate) values(?,?,?,?)";
		Object[] parmas = {phoneRecords.getRequesterid(),phoneRecords.getRequesterphone(),phoneRecords.getCid(),phoneRecords.getCreatedate()};
		int i = jdbcTemplate.update(sql, parmas);
		if(i!=0)
			result = true;
		return result;
	}

	@SuppressWarnings("deprecation")
	public int getPhoneRecordsCountForCid(int cid) {
		String sql = "SELECT COUNT(*) FROM phonerecords WHERE 1=1 AND cid = ?";
		return jdbcTemplate.queryForInt(sql, cid);
	}

}
