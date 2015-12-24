package com.talker.dataManage.dao;

import com.talker.dataManage.pojo.Visits;

public interface VisitDao {
	
	boolean addVisit(Visits visits);
	int getVisitCountForCid(int cid);
}
