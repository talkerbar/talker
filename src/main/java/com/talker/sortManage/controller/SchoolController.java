package com.talker.sortManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.sortManage.pojo.SortParams;
import com.talker.sortManage.service.SchoolService;
import com.talker.system.controller.AbstractController;

@Controller
@RequestMapping("/school/")
public class SchoolController extends AbstractController{
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping(value = "get")
	@ResponseBody
	public List<SortParams> getSchool(SortParams sortParams){
		return schoolService.getSchool(sortParams);
	}

}
