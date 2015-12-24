package com.talker.dataManage.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talker.dataManage.dao.VisitDao;
import com.talker.dataManage.pojo.Visits;

/**  
 * 创建时间 : 2015-12-24 下午2:18:16
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：VisitServiceImpl.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */
@Service
public class VisitServiceImpl implements VisitService {
	
	@Autowired
	private VisitDao visitDao;

	public boolean addVisit(Visits visits) {
		boolean result = false;
		if(checkVisits(visits)){
			result = visitDao.addVisit(visits);
		}
		return result;
	}

	public int getVisitCountForCid(int cid) {
		if(cid==0){
			return visitDao.getVisitCountForCid(cid);
		}
		return cid;
	}
	
	private boolean checkVisits(Visits visits) {
		if(visits==null){
			return false;
		}
		if(visits.getIp()==null){
			return false;
		}
		if(visits.getVisitDate()==null){
			visits.setVisitDate(new Date());
		}
		if(visits.getcId()==null){
			return false;
		}
		return true;
	}

}
