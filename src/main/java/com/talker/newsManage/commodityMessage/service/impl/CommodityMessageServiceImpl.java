package com.talker.newsManage.commodityMessage.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talker.commodityManage.pojo.Commodity;
import com.talker.commodityManage.service.CommodityService;
import com.talker.newsManage.commodityMessage.dao.CommodityMessageDao;
import com.talker.newsManage.commodityMessage.pojo.CommodityMessage;
import com.talker.newsManage.commodityMessage.service.CommodityMessageService;
import com.talker.util.ResponseModel;

@Service
public class CommodityMessageServiceImpl implements CommodityMessageService {
	
	@Autowired
	private CommodityMessageDao commodityMessageDao;
	@Autowired
	private CommodityService commodityService;

	public ResponseModel addCommodityMessage(CommodityMessage cm) {
		boolean success = false;
		String message = "请求参数异常";
		if(checkCMessage(cm)){
			Commodity commodity = commodityService.getCommodityForId(cm.getCid());
			if(commodity!=null){
				if(commodity.getStatus()==1){
					boolean result = false;
					if(cm.getParentid()==-1){
						//一级评论，回复者对象为商品上传者
						cm.setReceived_userid(commodity.getUserid());
						result = commodityMessageDao.addCommodityMessage(cm);
					}else{
						//非一级评论，回复者对象为上级留言发布者
						CommodityMessage commodityMessage = commodityMessageDao.getCommodityMessageForId(cm.getParentid());
						if(commodityMessage!=null){
							//父ID不为-1，无上级ID评论失败
							cm.setReceived_userid(commodityMessage.getPost_userid());
							result = commodityMessageDao.addCommodityMessage(cm);
						}
					}
					if(result){
						success = result;
						message = "留言成功";
					}else{
						message = "留言失败";
					}
				}else{
					if(commodity.getStatus()==2){
						message = "该用户已下架该商品，留言失败";
					}else if(commodity.getStatus()==3){
						message = "该用户已删除该商品，留言失败";
					}
				}
			}else{
				message = "该商品不存在，留言失败";
			}
		}
		return ResponseModel.buildMessage(success, message);
	}

	public ResponseModel getCommodityMessageForCid(int cid) {
		boolean success = false;
		List<CommodityMessage> list = null;
		if(cid!=0){
			success = true;
			list = commodityMessageDao.getCommodityMessageForCid(cid);
		}
		return ResponseModel.buildList(success, list);
	}
	
	//检测留言参数是否合法
	private boolean checkCMessage(CommodityMessage cm) {
		if(cm==null){
			return false;
		}
		if(cm.getCid()==null){
			return false;
		}
		if(cm.getContent()==null||"".equals(cm.getContent())||!StringUtils.isNotBlank(cm.getContent())){
			return false;
		}
		if(cm.getCreateDate()==null){
			cm.setCreateDate(new Date());
		}
		if(cm.getPost_userid()==null){
			return false;
		}
		if(cm.getParentid()==null){
			return false;
		}
		return true;
	}

	public ResponseModel getReceivedMessage(int userid) {
		boolean success = false;
		List<CommodityMessage> list = null;
		if(userid!=0){
			success = true;
			list = commodityMessageDao.getReceivedMessage(userid);
		}
		return ResponseModel.buildList(success, list);
	}

	public ResponseModel getPostMessage(int userid) {
		boolean success = false;
		List<CommodityMessage> list = null;
		if(userid!=0){
			success = true;
			list = commodityMessageDao.getPostMessage(userid);
		}
		return ResponseModel.buildList(success, list);
	}

}
