package com.talker.system.security.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.talker.apiManage.IpHelp;
import com.talker.dataManage.pojo.PhoneRecords;
import com.talker.dataManage.pojo.Visits;
import com.talker.dataManage.service.PhoneRecordsService;
import com.talker.dataManage.service.VisitService;
import com.talker.userManage.pojo.UserLoginOut;
import com.talker.userManage.service.UserLoginService;
import com.talker.util.CookieUtil;
import com.talker.util.ResponseModel;

/**  
 * 创建时间 : 2015-12-24 下午3:05:34
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：VisitInterceptor.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class VisitInterceptor extends HandlerInterceptorAdapter {
	
	Log log = LogFactory.getLog(VisitInterceptor.class);
	
	@Autowired
	private VisitService visitService;
	@Autowired
	private PhoneRecordsService phoneRecordsService;
	@Autowired
	private UserLoginService userLoginService;
	
	/**
     * @discription 目前拦截器只拦截商品浏览、电话号码获取链接
     * 1、/item
     * 2、/commodity/cellnumber
     * @author zdd       
     * @created 2015-12-24 下午3:06:45
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getServletPath();
		if("/item".equals(uri)){
			//记录商品浏览记录
			String cid = request.getParameter("id");
			if(cid!=null){
				Visits visits = new Visits();
				visits.setIp(getIpAddr(request));
				visits.setCity(IpHelp.convert(visits.getIp()));
				visits.setcId(Integer.parseInt(cid));
				boolean result = visitService.addVisit(visits);
				log.debug("增加商品浏览记录：" + result);
			}
		}else if("/commodity/cellnumber".equals(uri)){
			//记录手机号获取记录
			//目前获取上传者联系方式需要登录，后期会改成不是会员的情况下也能获取
			String cid = request.getParameter("id");
			String userid = CookieUtil.getCookieString(CookieUtil.CookieValue.COOKIE_USER_ID, request);
			if(userid!=null && cid!=null){
				ResponseModel rmUserInfo = userLoginService.getUserForId(Integer.parseInt(userid));
				if(rmUserInfo.isSuccess()){
					PhoneRecords phoneRecords = new PhoneRecords();
					phoneRecords.setRequesterid(Integer.parseInt(userid));
					phoneRecords.setRequesterphone(((UserLoginOut)rmUserInfo.getObject()).getUserInfoOut().getTelephone());
					phoneRecords.setCid(Integer.parseInt(cid));
					boolean result = phoneRecordsService.addPhoneRecords(phoneRecords);
					log.debug("增加商品电话获取记录：" + result);
				}
			}
			
		}
		return true;
	}
	/**
	 * 方法名: getIpAddr
	 * 说明 :  获取IP
	 * 创建人 :   zdd       
	 * 创建时间 : 2015-12-24 下午3:30:10 
	 * 返回值  : String
	 */
	public  String getIpAddr(HttpServletRequest request)  {  
	      String ip  =  request.getHeader( " x-forwarded-for " );  
	       if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {  
	          ip  =  request.getHeader( " Proxy-Client-IP " );  
	      }   
	       if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {  
	          ip  =  request.getHeader( " WL-Proxy-Client-IP " );  
	      }   
	       if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {  
	         ip  =  request.getRemoteAddr();  
	     }   
	      return  ip;  
	 }

}
