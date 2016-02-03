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
	/**
	 * 方法名: getHotCommodity
	 * 说明 :  得到点击率最高的商品、手机号获取次数最多
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-1-21 下午4:53:12 
	 * 返回值  : List<Commodity>
	 */
	List<Commodity> getHotCommodity();
	/**
	 * 方法名: getCount
	 * 说明 :  得到符合条件的总行数
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-2-3 下午3:55:02 
	 * 返回值  : int
	 */
	int getCount(Commodity c);
}
