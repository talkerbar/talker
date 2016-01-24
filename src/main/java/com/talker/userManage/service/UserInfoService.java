package com.talker.userManage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.talker.userManage.pojo.UserInfoOut;
import com.talker.userManage.pojo.UserInfoParams;
import com.talker.util.ResponseModel;

public interface UserInfoService {
	
	ResponseModel addUserInfo(UserInfoParams userInfoParams);
	
	ResponseModel updateUserInfo(UserInfoParams userInfoParams);
	
	List<UserInfoOut> getUserInfo(UserInfoParams userInfoParams);
	
	ResponseModel updateUserIcon(String file,Integer userloginid,HttpServletRequest request);
	
	public String getUserIcon(Integer userloginid);
	
	ResponseModel updateUserInfoComplete(UserInfoParams userInfoParams);

}
