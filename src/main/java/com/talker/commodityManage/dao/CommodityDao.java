package com.talker.commodityManage.dao;

import java.util.List;

import com.talker.commodityManage.pojo.Commodity;
import com.talker.sortManage.pojo.Sort;

public interface CommodityDao {
	/**
	 * 添加商品
	 * @param c
	 * @return
	 */
	int addCommodity(Commodity c);
	/**
	 * 下架商品，上架商品，删除商品
	 * @param status
	 * @param id
	 * @return
	 */
	boolean delCommodity(int status,int id);
	/**
	 * 更新商品信息
	 * @param c
	 * @return
	 */
	boolean updateCommodity(Commodity c);
	/**
	 * 查询商品
	 * @param c
	 * @return
	 */
	List<Commodity> getCommodity(Commodity c);
	/**
	 * 根据商品ID获取联系方式
	 * @param id
	 * @return
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
}
