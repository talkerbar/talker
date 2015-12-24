package com.talker.newsManage.commodityMessage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.newsManage.commodityMessage.pojo.CommodityMessage;
import com.talker.newsManage.commodityMessage.service.CommodityMessageService;
import com.talker.system.controller.AbstractController;
import com.talker.util.ResponseModel;

@Controller
@RequestMapping(value="/commoditymessage/")
public class CommodityMessageController extends AbstractController{
	
	@Autowired
	private CommodityMessageService commodityMessageService;
	
	@RequestMapping("add")
	@ResponseBody
	public ResponseModel addCommodityMessage(HttpServletRequest request,CommodityMessage cm){
		//设置用户ID
		cm.setPost_userid(this.getUserId(request));
		return commodityMessageService.addCommodityMessage(cm);
	}
	
	@RequestMapping("get")
	@ResponseBody
	public ResponseModel getCommodityMessageForCid(int cid){
		return commodityMessageService.getCommodityMessageForCid(cid);
	}
	
	@RequestMapping("getReceivedMessage")
	@ResponseBody
	public ResponseModel getReceivedMessage(HttpServletRequest request){
		return commodityMessageService.getReceivedMessage(this.getUserId(request));
	}
	
	@RequestMapping("getPostMessage")
	@ResponseBody
	public ResponseModel getPostMessage(HttpServletRequest request){
		return commodityMessageService.getPostMessage(this.getUserId(request));
	}

}
