package com.talker.dataManage.service;

import com.talker.dataManage.pojo.PhoneRecords;

/**  
 * 创建时间 : 2015-12-24 下午4:18:30
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：PhoneRecordsService.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public interface PhoneRecordsService {
	
	boolean addPhoneRecords(PhoneRecords phoneRecords);
	int getPhoneRecordsCountForCid(int cid); 

}
