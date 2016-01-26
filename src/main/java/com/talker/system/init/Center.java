package com.talker.system.init;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talker.commodityManage.pojo.Commodity;
import com.talker.commodityManage.service.CommodityService;
import com.talker.system.controller.AbstractController;
import com.talker.userManage.service.UserLoginService;
import com.talker.util.CookieUtil;
import com.talker.util.ResponseModel;

@Controller
@RequestMapping(value="/center/")
public class Center extends AbstractController{
	
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private UserLoginService userLoginService;
	
	@RequestMapping("commodity")
	public String commodity(HttpServletRequest request,Model m){
		Commodity c = new Commodity();
		c.setUserid(CookieUtil.getCookieInteger(CookieUtil.CookieValue.COOKIE_USER_ID, request));
		List<Commodity> list = commodityService.getCommodity(request,c);
		m.addAttribute("list", list);
		return "commodity/commodity";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request,Model m){
		Integer userId = this.getUserId(request);
		if(userId!=null){
			ResponseModel responseModel = userLoginService.getUserForId(userId);
			m.addAttribute("rm", responseModel);
		}
		return "commodity/info";
	}
	
	@RequestMapping("news")
	public String news(){
		return "commodity/news";
	}
	
	@RequestMapping("release")
	public String release(){
		return "commodity/release";
	}

}
