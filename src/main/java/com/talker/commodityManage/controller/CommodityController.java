package com.talker.commodityManage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.commodityManage.pojo.Commodity;
import com.talker.commodityManage.service.CommodityService;
import com.talker.sortManage.pojo.Sort;
import com.talker.system.controller.AbstractController;
import com.talker.util.ResponseModel;

/**
 * 创建时间 : 2015-12-24 上午11:24:55  
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：CommodityController.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 :
 */
@Controller
@RequestMapping("/commodity/")
public class CommodityController extends AbstractController {
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping(value="add")
	public String addCommodity(String[] file,Commodity c,HttpServletRequest request,Model m){
		// 设置用户ID
		c.setUserid(this.getUserId(request));
		ResponseModel rm = commodityService.addCommodity(file,c,request);
		m.addAttribute("ResponseModel", rm);
		return "commodity/success";
	}
	
	@RequestMapping(value="del")
	@ResponseBody
	ResponseModel delCommodity(int status,int id){
		return commodityService.delCommodity(status,id);
	}
	
	@RequestMapping(value="update")
	@ResponseBody
	boolean updateCommodity(String[] file,Commodity c,HttpServletRequest request){
		return commodityService.updateCommodity(file,c,request);
	}
	
	@RequestMapping(value="get")
	@ResponseBody
	List<Commodity> getCommodity(Commodity c){
		return commodityService.getCommodity(c);
	}
	
	@RequestMapping(value="cellnumber")
	@ResponseBody
	String getCellnumber(int id){
		return commodityService.getCellnumber(id);
	}
	
	@RequestMapping(value="allschoolname")
	@ResponseBody
	List<Sort> getAllSchoolName(){
		return commodityService.getAllSchoolName();
	}
	
	@RequestMapping(value="allsortname")
	@ResponseBody
	List<Sort> getAllSortName(){
		return commodityService.getAllSortName();
	}
}
