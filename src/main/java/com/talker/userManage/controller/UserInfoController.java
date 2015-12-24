package com.talker.userManage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.system.controller.AbstractController;
import com.talker.userManage.pojo.UserInfoOut;
import com.talker.userManage.pojo.UserInfoParams;
import com.talker.userManage.service.UserInfoService;
import com.talker.util.ResponseModel;

@Controller
@RequestMapping("/userinfo/")
public class UserInfoController extends AbstractController{
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 用户注册成功后走补充个人信息流程
	 * 性别-->学校-->专业-->
	 * 可跳过，除在第一步，其他两步点击跳过后直接进入添加方法
	 * @param userInfoParams
	 * @return
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public ResponseModel addUserInfo(UserInfoParams userInfoParams){
		return userInfoService.addUserInfo(userInfoParams);
	}
	
	@RequestMapping(value="update")
	@ResponseBody
	public ResponseModel updateUserInfo(HttpServletRequest request,UserInfoParams userInfoParams){
		userInfoParams.setUserloginid(this.getUserId(request));
		return userInfoService.updateUserInfo(userInfoParams);
	}
	
	@RequestMapping(value="get")
	@ResponseBody
	public List<UserInfoOut> getUserInfo(UserInfoParams userInfoParams){
		return userInfoService.getUserInfo(userInfoParams);
	}
	
	@RequestMapping(value="updateicon")
	@ResponseBody
	public ResponseModel updateUserIcon(String file, HttpServletRequest request){
		return userInfoService.updateUserIcon(file, this.getUserId(request), request);
	}
	
	@RequestMapping(value="geticon")
	@ResponseBody
	public String getIcon(HttpServletRequest request){
		return userInfoService.getUserIcon(this.getUserId(request));
	}

}
