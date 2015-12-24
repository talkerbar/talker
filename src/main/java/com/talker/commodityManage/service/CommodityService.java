package com.talker.commodityManage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.talker.commodityManage.pojo.Commodity;
import com.talker.sortManage.pojo.Sort;
import com.talker.util.ResponseModel;

public interface CommodityService {
	
	ResponseModel addCommodity(String[] file,Commodity c,HttpServletRequest request);
	ResponseModel delCommodity(int status,int id);
	boolean updateCommodity(String[] file,Commodity c,HttpServletRequest request);
	List<Commodity> getCommodity(Commodity c);
	String getCellnumber(int id);
	/**
	 * 得到所有商品所在的学校
	 * @return
	 */
	List<Sort> getAllSchoolName();
	/**
	 * 得到所有商品分类
	 * @return
	 */
	List<Sort> getAllSortName();
	/**
	 * 根据商品ID查询商品
	 * @param id
	 * @return
	 */
	Commodity getCommodityForId(int id);
}
