package com.talker.sortManage.dao;

import java.util.List;

import com.talker.sortManage.pojo.Sort;
import com.talker.sortManage.pojo.SortParams;

public interface SortDao {
	
	boolean addSort(SortParams sort);
	boolean delSort(SortParams sort);
	boolean updateSort(SortParams sort);
	List<Sort> getSort(SortParams sort);
	String getSortForId(String table,int id);

}
