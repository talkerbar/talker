package com.talker.dataManage.dao;

import com.talker.dataManage.pojo.PhoneRecords;

public interface PhoneRecordsDao {
	
	boolean addPhoneRecords(PhoneRecords phoneRecords);
	int getPhoneRecordsCountForCid(int cid); 

}
