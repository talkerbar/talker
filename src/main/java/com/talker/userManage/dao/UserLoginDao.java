package com.talker.userManage.dao;

import java.util.List;

import com.talker.userManage.pojo.UserLoginOut;
import com.talker.userManage.pojo.UserLoginParams;

public interface UserLoginDao {
	
	int regist(UserLoginParams loginParams);
	
	boolean login(String username,String password);
	
	boolean updateUser(UserLoginParams loginParams);
	
	List<UserLoginOut> getUser(UserLoginParams loginParams);
	
	UserLoginOut getUserForUserName(String userName);
	
	UserLoginOut getUserForId(int id);
	
}
