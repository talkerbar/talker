package com.talker.userManage.dao;

import java.util.List;

import com.talker.userManage.pojo.UserInfoOut;
import com.talker.userManage.pojo.UserInfoParams;

/**
 * 创建时间 : 2015-12-20 下午3:32:30  
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：UserInfoDao.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 :
 */
public interface UserInfoDao {
	
	boolean addUserInfo(UserInfoParams userInfoParams);
	
	boolean updateUserInfo(UserInfoParams userInfoParams);
	
	List<UserInfoOut> getUserInfo(UserInfoParams userInfoParams);
	
	UserInfoOut getUserInfoForLoginId(int userloginid);
	
	boolean updateUserIcon(String icon,int id);
	
	String getUserIcon(Integer userloginid);
	/**
	 * 方法名: updateUserInfoComplete
	 * 说明 :  判断部分更新
	 * 创建人 :   zdd       
	 * 创建时间 : 2016-1-20 下午3:34:33 
	 * 返回值  : boolean
	 */
	boolean updateUserInfoComplete(UserInfoParams userInfoParams);

}
