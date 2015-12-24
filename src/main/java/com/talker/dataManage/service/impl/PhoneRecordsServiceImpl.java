package com.talker.dataManage.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talker.dataManage.dao.PhoneRecordsDao;
import com.talker.dataManage.pojo.PhoneRecords;
import com.talker.dataManage.service.PhoneRecordsService;

/**  
 * 创建时间 : 2015-12-24 下午4:19:11
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：PhoneRecordsServiceImpl.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */
@Service
public class PhoneRecordsServiceImpl implements PhoneRecordsService {
	
	@Autowired
	private PhoneRecordsDao phoneRecordsDao;

	public boolean addPhoneRecords(PhoneRecords phoneRecords) {
		boolean result = false;
		if(checkPhoneRecord(phoneRecords)){
			result = phoneRecordsDao.addPhoneRecords(phoneRecords);
		}
		return result;
	}

	public int getPhoneRecordsCountForCid(int cid) {
		return 0;
	}
	
	private boolean checkPhoneRecord(PhoneRecords phoneRecords) {
		if(phoneRecords==null){
			return false;
		}
		if(phoneRecords.getRequesterphone()==null){
			return false;
		}
		if(phoneRecords.getCid()==null){
			return false;
		}
		if(phoneRecords.getCreatedate()==null){
			phoneRecords.setCreatedate(new Date());
		}
		return true;
	}

}
