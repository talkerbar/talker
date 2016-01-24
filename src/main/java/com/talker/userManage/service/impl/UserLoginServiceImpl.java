package com.talker.userManage.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talker.apiManage.cache.MemcachedPool;
import com.talker.system.security.service.impl.HandelMenuAndRight;
import com.talker.system.security.vo.UserSession;
import com.talker.userManage.dao.UserLoginDao;
import com.talker.userManage.pojo.UserInfoParams;
import com.talker.userManage.pojo.UserLoginOut;
import com.talker.userManage.pojo.UserLoginParams;
import com.talker.userManage.service.UserInfoService;
import com.talker.userManage.service.UserLoginService;
import com.talker.util.CookieUtil;
import com.talker.util.ResponseModel;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	// 用户状态1为正常
	private static final int USER_ENABLE_NORMAL = 1;
	// 用户角色1为顾客
	private static final int USER_ROLE_CUSTOMER = 1;
	
	@Autowired
	private UserLoginDao userLoginDao;
	@Autowired
	private HandelMenuAndRight handelMenuAndRight;
	@Autowired
	private UserInfoService userInfoService;

	@Transactional
	public ResponseModel regist(HttpServletRequest request,HttpServletResponse response,UserLoginParams loginParams) {
		boolean success = false;
		String message = "请求参数异常";
		if(checkRegist(loginParams)){
			UserLoginOut userLoginOut = userLoginDao.getUserForUserName(loginParams.getUsername());
			if(userLoginOut==null){
				int userId = userLoginDao.regist(loginParams);
				if(userId!=0){
					//添加用户基本信息
					UserInfoParams userInfoParams = new UserInfoParams();
					userInfoParams.setUserloginid(userId);
					//目前只支持电话形式的注册
					userInfoParams.setTelephone(loginParams.getUsername());
					ResponseModel userInfoResult = userInfoService.addUserInfo(userInfoParams);
					if(userInfoResult.isSuccess()){
						success= true;
						message= "恭喜您，注册成功";
						// 获取会话，不存在则会创建一个会话
						HttpSession session = request.getSession(true);
						// 得到权限
						UserSession userSession = handelMenuAndRight.prepareMenuAndRight4User(new UserSession(), userId);
						userSession.setSessionId(session.getId());
						userSession.setUserLogin(UserLoginOut.loginParamsToLoginOut(loginParams));
						// 用户信息存入memcached有效期为半个小时
						MemcachedPool.set(session.getId(), userSession, new Date(CookieUtil.HOUR/2));
						// 存储session,user
						CookieUtil.setCookie(CookieUtil.CookieValue.COOKIE_SESSION_ID, session.getId(), CookieUtil.HOUR/2, response, request);
						CookieUtil.setCookie(CookieUtil.CookieValue.COOKIE_USER_ID, String.valueOf(userId), CookieUtil.WEEK, response, request);
					}else{
						message = "添加用户信息出现了问题";
						//事务回滚
						throw new RuntimeException();
					}
				}else{
					message = "哎呀，发生了什么，注册失败了";
				}
			}else{
				message = "该用户已存在，请直接登陆";
			}
		}
		return ResponseModel.buildMessage(success, message);
	}

	public ResponseModel login(HttpServletRequest request,HttpServletResponse response,String username, String password) {
		boolean success = false;
		String message = "请求参数异常";
		if(isNotBanks(username, password)){
			UserLoginOut userLoginOut = userLoginDao.getUserForUserName(username);
			if(userLoginOut!=null){
				if(userLoginOut.getPassword().equals(password)){
					success= true;
					message= "登陆成功";
					// 获取会话，不存在则会创建一个会话
					HttpSession session = request.getSession(true);
					// 得到权限
					UserSession userSession = handelMenuAndRight.prepareMenuAndRight4User(new UserSession(), userLoginOut.getId());
					userSession.setSessionId(session.getId());
					userSession.setUserLogin(userLoginOut);
					// 用户信息存入memcached有效期为半个小时
					MemcachedPool.set(session.getId(), userSession, new Date(CookieUtil.HOUR/2));
					// 存储session,user
					CookieUtil.setCookie(CookieUtil.CookieValue.COOKIE_SESSION_ID, session.getId(), CookieUtil.HOUR/2, response, request);
					CookieUtil.setCookie(CookieUtil.CookieValue.COOKIE_USER_ID, String.valueOf(userLoginOut.getId()), CookieUtil.WEEK, response, request);
				}else{
					message = "密码不匹配";
				}
			}else{
				message = "该用户不存在，请确认用户名";
			}
		}
		return ResponseModel.buildMessage(success, message);
	}

	public ResponseModel updateUser(UserLoginParams loginParams,String repassword,String oldpassword) {
		boolean success = false;
		String message = "请求参数异常";
		if(checkUpdatelogin(loginParams,repassword,oldpassword)){
			if(repassword.equals(loginParams.getPassword())){
				UserLoginOut ulo = userLoginDao.getUserForId(loginParams.getId());
				if(oldpassword.equals(ulo.getPassword())){
					try {
						boolean result = userLoginDao.updateUser(loginParams);
						if(result){
							success = result;
							message = "密码修改成功";
						}else{
							message = "密码修改失败";
						}
					} catch (Exception e) {
						e.printStackTrace();
						message = "哎呀，出错啦";
					}
				}else{
					message = "旧密码输入错误";
				}
			}else{
				message = "两次密码不一致";
			}
		}
		return ResponseModel.buildMessage(success, message);
	}
	
	public ResponseModel getUser(UserLoginParams loginParams) {
		boolean success = false;
		List<UserLoginOut> list = userLoginDao.getUser(loginParams);
		return ResponseModel.buildList(success, list);
	}

	private boolean checkRegist(UserLoginParams loginParams) {
		if(loginParams==null){
			return false;
		}
		if(loginParams.getUsername()==null || loginParams.getPassword()==null||loginParams.getSecurity_code()==null||loginParams.getRepassword()==null){
			return false;
		}
		if(!loginParams.getPassword().equals(loginParams.getRepassword())){
			return false;
		}
		// 不等于空格判断
		if(!isNotBanks(loginParams.getUsername(),loginParams.getPassword())){
			return false;
		}
		if(loginParams.getRole()==null){
			loginParams.setRole(USER_ROLE_CUSTOMER);
		}
		if(loginParams.getEnable()==null){
			loginParams.setEnable(USER_ENABLE_NORMAL);
		}
		if(loginParams.getCreatedate()==null){
			loginParams.setCreatedate(new Date());
		}
		return true;
	}
	
	public ResponseModel getUserForId(int id) {
		boolean flag = false;
		String message = "用户不存在";
		UserLoginOut ulo = userLoginDao.getUserForId(id);
		if(ulo!=null){
			flag = true;
			message = "查询成功";
		}
		return ResponseModel.buildMessageObject(flag, message, ulo);
	}
	
	private boolean isNotBanks(String username,String password){
		return StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password);
	}
	
	private boolean checkUpdatelogin(UserLoginParams loginParams,String repassword,String oldpassword) {
		if(loginParams==null){
			return false;
		}
		if(loginParams.getId()==null){
			return false;
		}
		if(loginParams.getPassword()==null){
			return false;
		}
		if(loginParams.getUpdatedate()==null){
			loginParams.setUpdatedate(new Date());
		}
		if(repassword==null){
			return false;
		}
		//空格判断
		if(!isNotBanks(loginParams.getPassword(),repassword)){
			return false;
		}
		if(oldpassword==null||!StringUtils.isNotBlank(oldpassword)){
			return false;
		}
		return true;
	}
}
