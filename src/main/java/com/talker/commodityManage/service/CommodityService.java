package com.talker.commodityManage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.talker.commodityManage.pojo.Commodity;
import com.talker.commodityManage.pojo.Page;
import com.talker.sortManage.pojo.Sort;
import com.talker.util.ResponseModel;

public interface CommodityService {
	
	ResponseModel addCommodity(String[] file,Commodity c,HttpServletRequest request);
	ResponseModel delCommodity(int status,int id);
	boolean updateCommodity(String[] file,Commodity c,HttpServletRequest request);
	/**
	 * 方法名: getCommodity
	 * 说明 :  查询商品主方法
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-1-26 上午11:25:14 
	 * 返回值  : List<Commodity>
	 */
	List<Commodity> getCommodity(HttpServletRequest request,Commodity c);
	/**
	 * 方法名: getCommodityPage
	 * 说明 :  分页查询
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-2-3 下午4:02:31 
	 * 返回值  : Page
	 */
	Page getCommodityPage(HttpServletRequest request,Commodity c);
	/**
	 * 方法名: getCellnumber
	 * 说明 :  根据商品ID得到手机号
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-1-26 上午11:24:49 
	 * 返回值  : String
	 */
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
	/**
	 * 方法名: getHotCommodity
	 * 说明 :  得到点击率最高的商品、手机号获取次数最多
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-1-21 下午4:53:12 
	 * 返回值  : List<Commodity>
	 */
	List<Commodity> getHotCommodity(HttpServletRequest request);
}
