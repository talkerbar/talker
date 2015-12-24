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
		return false;
	}

	@SuppressWarnings("deprecation")
	public int getPhoneRecordsCountForCid(int cid) {
		String sql = "SELECT COUNT(*) FROM phonerecords WHERE 1=1 AND cid = ?";
		return jdbcTemplate.queryForInt(sql, cid);
	}

}
