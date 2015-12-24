package com.talker.newsManage.commodityMessage.dao;

import java.util.List;

import com.talker.newsManage.commodityMessage.pojo.CommodityMessage;

public interface CommodityMessageDao {
	/**
	 * 增加商品留言
	 * @param cm
	 * @return
	 */
	boolean addCommodityMessage(CommodityMessage cm);
	/**
	 * 根据商品ID查询商品留言
	 */
	List<CommodityMessage> getCommodityMessageForCid(int id);
	/**
	 * 根据留言ID查询留言信息
	 * @param id
	 * @return
	 */
	CommodityMessage getCommodityMessageForId(int id);
	/**
	 * 我收到的留言
	 * @param userid
	 * @return
	 */
	List<CommodityMessage> getReceivedMessage(int userid);
	/**
	 * 我发布的留言
	 * @param userid
	 * @return
	 */
	List<CommodityMessage> getPostMessage(int userid);

}
