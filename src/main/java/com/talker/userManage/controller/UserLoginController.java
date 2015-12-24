package com.talker.userManage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.system.controller.AbstractController;
import com.talker.userManage.pojo.UserLoginParams;
import com.talker.userManage.service.UserLoginService;
import com.talker.util.ResponseModel;

@Controller
@RequestMapping("/userlogin/")
public class UserLoginController extends AbstractController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@RequestMapping(value="regist")
	@ResponseBody
	public ResponseModel regist(HttpServletRequest request,HttpServletResponse response,UserLoginParams loginParams){
		return userLoginService.regist(request,response,loginParams);
	}
	
	@RequestMapping(value="login")
	@ResponseBody
	public ResponseModel login(String username,String password,HttpServletRequest request,HttpServletResponse response){
		return userLoginService.login(request,response,username, password);
	}
	
	@RequestMapping(value="update")
	@ResponseBody
	public ResponseModel updateUser(HttpServletRequest request,UserLoginParams loginParams,String repassword,String oldpassword){
		//获取当前登陆ID
		loginParams.setId(this.getUserId(request));
		return userLoginService.updateUser(loginParams,repassword,oldpassword);
	}
	
	@RequestMapping(value="get")
	@ResponseBody
	public ResponseModel getUser(UserLoginParams loginParams){
		return userLoginService.getUser(loginParams);
	}
}
