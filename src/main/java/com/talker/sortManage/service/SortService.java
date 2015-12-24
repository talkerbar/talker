package com.talker.sortManage.service;

import java.util.List;

import com.talker.sortManage.pojo.Sort;
import com.talker.sortManage.pojo.SortParams;

public interface SortService {
	
	boolean addSort(SortParams sort);
	boolean delSort(SortParams sort);
	boolean updateSort(SortParams sort);
	List<Sort> getSort(SortParams sort);

}
