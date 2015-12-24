package com.talker.userManage.dao;

import java.util.List;

import com.talker.userManage.pojo.UserInfoOut;
import com.talker.userManage.pojo.UserInfoParams;

public interface UserInfoDao {
	
	boolean addUserInfo(UserInfoParams userInfoParams);
	
	boolean updateUserInfo(UserInfoParams userInfoParams);
	
	List<UserInfoOut> getUserInfo(UserInfoParams userInfoParams);
	
	UserInfoOut getUserInfoForLoginId(int userloginid);
	
	boolean updateUserIcon(String icon,int id);
	
	String getUserIcon(Integer userloginid);

}
