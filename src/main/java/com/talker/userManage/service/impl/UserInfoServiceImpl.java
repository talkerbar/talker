package com.talker.userManage.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talker.system.file.Upload4Base64;
import com.talker.userManage.dao.UserInfoDao;
import com.talker.userManage.dao.UserLoginDao;
import com.talker.userManage.pojo.UserInfoOut;
import com.talker.userManage.pojo.UserInfoParams;
import com.talker.userManage.pojo.UserLoginOut;
import com.talker.userManage.service.UserInfoService;
import com.talker.util.ResponseModel;
import com.talker.util.SystemString;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private UserLoginDao userLoginDao;
	@Autowired
	private Upload4Base64 upload4Base64;

	public ResponseModel addUserInfo(UserInfoParams userInfoParams) {
		boolean success = false;
		String message = "请求参数异常";
		if(checkInfoParams(userInfoParams)){
			// 检测用户是否存在
			UserLoginOut userLoginOut = userLoginDao.getUserForId(userInfoParams.getUserloginid());
			if(userLoginOut!=null){
				// 检测该用户是否已经完善过信息，该方法只有在注册的时候才会走一次
				UserInfoOut existsInfo = userInfoDao.getUserInfoForLoginId(userInfoParams.getUserloginid());
				if(existsInfo==null){
					boolean result = userInfoDao.addUserInfo(userInfoParams);
					if(result){
						success = result;
						message = "信息已完善";
					}else{
						message = "哎呀，什么情况，信息完善失败";
					}
				}else{
					message = "非法请求";
				}
			}else{
				message = "用户不存在";
			}
		}
		return ResponseModel.buildMessage(success, message);
	}

	public ResponseModel updateUserInfo(UserInfoParams userInfoParams) {
		boolean success = false;
		String message = "参数不合法";
		if(checkUpdateInfo(userInfoParams)){
			try {
				success = userInfoDao.updateUserInfo(userInfoParams);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(success){
				message = "信息已更新";
			}else{
				message = "信息更新失败";
			}
		}
		return ResponseModel.buildMessage(success, message);
	}

	public List<UserInfoOut> getUserInfo(UserInfoParams userInfoParams) {
		return userInfoDao.getUserInfo(userInfoParams);
	}

	public ResponseModel updateUserIcon(String file, Integer userloginid,HttpServletRequest request) {
		boolean success = false;
		String message = "请求参数异常";
		if(file!=null&&userloginid!=null){
			String[] iconName = upload4Base64.upload(new String[]{file}, "head", request);
			if(iconName!=null){
				boolean result = userInfoDao.updateUserIcon(iconName[0], userloginid);
				if(result){
					success = result;
					message = "头像上传成功";
				}else{
					message = "头像上传失败";
				}
			}else{
				message = "解析头像时出错了";
			}
		}
		return ResponseModel.buildMessage(success, message);
	}
	
	private boolean checkInfoParams(UserInfoParams userInfoParams){
		if(userInfoParams==null){
			return false;
		}
		if(userInfoParams.getUserloginid()==null){
			return false;
		}
		if(userInfoParams.getNickname()==null){
			userInfoParams.setNickname(SystemString.REALNME);
		}
		if(userInfoParams.getIcon()==null){
			userInfoParams.setIcon(SystemString.USER_PIC);
		}
		if(userInfoParams.getCreatedate()==null){
			userInfoParams.setCreatedate(new Date());
		}
		return true;
	}
	
	private boolean checkUpdateInfo(UserInfoParams userInfoParams) {
		if(userInfoParams==null){
			return false;
		}
		if(userInfoParams.getUserloginid()==null){
			return false;
		}
		if(userInfoParams.getNickname()==null){
			return false;
		}
		if(userInfoParams.getRealname()==null){
			return false;
		}
		if(userInfoParams.getGender()==null){
			return false;
		}
		if(userInfoParams.getTelephone()==null){
			return false;
		}
		if(userInfoParams.getSchoolid()==null){
			return false;
		}
		if(userInfoParams.getUpdatedate()==null){
			userInfoParams.setUpdatedate(new Date());
		}
		return true;
	}

	public String getUserIcon(Integer userloginid) {
		if(userloginid!=null){
			return userInfoDao.getUserIcon(userloginid);
		}
		return null;
	}

	public ResponseModel updateUserInfoComplete(UserInfoParams userInfoParams) {
		boolean success = false;
		String message = "哎呀，信息完善失败了";
		if(userInfoParams!=null){
			boolean result = userInfoDao.updateUserInfoComplete(userInfoParams);
			if(result){
				success = true;
				message = "信息已完善";
			}else{
				message = "信息完善途中遇到了问题";
			}
		}
		return ResponseModel.buildMessage(success, message);
	}
}
