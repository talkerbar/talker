package com.talker.system.init;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talker.commodityManage.pojo.Commodity;
import com.talker.commodityManage.service.CommodityService;
import com.talker.system.controller.AbstractController;
import com.talker.util.SystemString;

@Controller
@RequestMapping(value="/")
public class Common extends AbstractController{
	
	@Autowired
	private CommodityService commodityService;
	
	// 首页初始化
	@RequestMapping("index")
	public String index(){
		return "commodity/index";
	}
	// 商品列表初始化
	@RequestMapping("list")
	public String commodityList(){
		return "commodity/list";
	}
	// 商品详情初始化
	@RequestMapping("item")
	public String commodityItem(HttpServletRequest request,Commodity c,Model m){
		List<Commodity> list = commodityService.getCommodity(c);
		if(list!=null&&!list.isEmpty()){
			m.addAttribute("commodity", list.get(0));
		}
		return "commodity/item";
	}
	// 登陆
	@RequestMapping("login")
	public String login(HttpServletRequest request,String returnUrl,Model m){
		if(returnUrl!=null){
			try {
				returnUrl = URLDecoder.decode(returnUrl, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else{
			//没有参数的返回主页面
			returnUrl = SystemString.URL+"talker";
		}
		m.addAttribute("returnUrl", returnUrl);
		return "commodity/login";
	}
	// 注册
	@RequestMapping("regist")
	public String resist(Model m){
		m.addAttribute("returnUrl", SystemString.URL+"talker/userinfo/completeinfo");
		return "commodity/regist";
	}

}
