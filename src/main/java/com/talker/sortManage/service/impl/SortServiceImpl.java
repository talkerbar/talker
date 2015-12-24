package com.talker.sortManage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talker.sortManage.dao.SortDao;
import com.talker.sortManage.pojo.Sort;
import com.talker.sortManage.pojo.SortParams;
import com.talker.sortManage.service.SortService;

@Service
public class SortServiceImpl implements SortService {
	
	@Autowired
	private SortDao sortDao;

	public boolean addSort(SortParams sort) {
		return sortDao.addSort(sort);
	}

	public boolean delSort(SortParams sort) {
		return sortDao.delSort(sort);
	}

	public boolean updateSort(SortParams sort) {
		return sortDao.updateSort(sort);
	}

	public List<Sort> getSort(SortParams sort) {
		return sortDao.getSort(sort);
	}

}
