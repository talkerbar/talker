package com.talker.sortManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.sortManage.pojo.Sort;
import com.talker.sortManage.pojo.SortParams;
import com.talker.sortManage.service.SortService;
import com.talker.system.controller.AbstractController;

@Controller
@RequestMapping("/sort/")
public class CommodityContraller extends AbstractController{
	
	//调用此controller需要操作的表
		private static final String SORT_TABLE = "sort";
		
		@Autowired
		private SortService sortService;
		
		@RequestMapping(value = "add")
		@ResponseBody
		public boolean addSort(SortParams sort){
			sort.setTable(SORT_TABLE);
			return sortService.addSort(sort);
		}
		
		@RequestMapping(value = "del")
		@ResponseBody
		public boolean delsort(SortParams sort){
			sort.setTable(SORT_TABLE);
			return sortService.delSort(sort);
		}
		
		@RequestMapping(value = "update")
		@ResponseBody
		public boolean updatesort(SortParams sort){
			sort.setTable(SORT_TABLE);
			return sortService.updateSort(sort);
		}
		
		@RequestMapping(value = "get")
		@ResponseBody
		public List<Sort> getsort(SortParams sort){
			sort.setTable(SORT_TABLE);
			return sortService.getSort(sort);
		}

}
