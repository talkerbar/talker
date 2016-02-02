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
@RequestMapping(value="/public")
public class Common extends AbstractController{
	
	@Autowired
	private CommodityService commodityService;
	
	// 首页初始化
	@RequestMapping("index")
	public String index(){
		return "commodity/index";
	}
	// 商品列表初始化（全部）
	@RequestMapping("list")
	public String commodityList(Model m){
		m.addAttribute("sortidmore", "");
		return "commodity/list";
	}
	// 商品列表初始化（手机电脑电脑配件）
	@RequestMapping("mobile-computers")
	public String commodityListForMC(Model m){
		m.addAttribute("sortidmore", "30,31,40,41,42,43,44,45,46");
		return "commodity/list";
	}
	// 商品列表初始化（摩托车电动车自行车）
	@RequestMapping("car")
	public String commodityListForCar(Model m){
		m.addAttribute("sortidmore", "79,80,81,82,83,84");
		return "commodity/list";
	}
	// 商品列表初始化（数码3C产品）
	@RequestMapping("digital-3c")
	public String commodityListFor3C(Model m){
		m.addAttribute("sortidmore", "48,49,50,51,52,53,54");
		return "commodity/list";
	}
	// 商品列表初始化（书籍音像文体用品）
	@RequestMapping("books")
	public String commodityListForBooks(Model m){
		m.addAttribute("sortidmore", "71,72,73,74,75,76,77");
		return "commodity/list";
	}
	// 商品列表初始化（相机/摄像机）
	@RequestMapping("camera")
	public String commodityListForCamera(Model m){
		m.addAttribute("sortidmore", "33,34,35,36,37,38");
		return "commodity/list";
	}
	// 商品列表初始化（其他）
	@RequestMapping("other")
	public String commodityListForOther(Model m){
		m.addAttribute("sortidmore", "87,89");
		return "commodity/list";
	}
	// 商品详情初始化
	@RequestMapping("item")
	public String commodityItem(HttpServletRequest request,Commodity c,Model m){
		List<Commodity> list = commodityService.getCommodity(request,c);
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
