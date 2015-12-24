package com.talker.userManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.talker.userManage.pojo.UserLoginParams;
import com.talker.util.ResponseModel;

public interface UserLoginService {
	
	ResponseModel regist(HttpServletRequest request,HttpServletResponse response,UserLoginParams loginParams);
	
	ResponseModel login(HttpServletRequest request,HttpServletResponse response,String username,String password);
	
	ResponseModel updateUser(UserLoginParams loginParams,String repassword,String oldpassword);
	
	ResponseModel getUser(UserLoginParams loginParams);
	
	ResponseModel getUserForId(int id);

}
