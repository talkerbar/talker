package com.talker.newsManage.commodityMessage.service;

import com.talker.newsManage.commodityMessage.pojo.CommodityMessage;
import com.talker.util.ResponseModel;

public interface CommodityMessageService {
	
	ResponseModel addCommodityMessage(CommodityMessage cm);
	ResponseModel getCommodityMessageForCid(int id);
	/**
	 * 我收到的留言
	 * @param userid
	 * @return
	 */
	ResponseModel getReceivedMessage(int userid);
	/**
	 * 我发布的留言
	 * @param userid
	 * @return
	 */
	ResponseModel getPostMessage(int userid);

}
