package com.talker.dataManage.service;

import com.talker.dataManage.pojo.Visits;

/**  
 * 创建时间 : 2015-12-24 下午1:53:21
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：VisitService.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public interface VisitService {
	
	boolean addVisit(Visits visits);
	int getVisitCountForCid(int cid); 

}
