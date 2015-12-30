package com.talker.apiManage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.apiManage.LBS;
import com.talker.apiManage.pojo.Poi;
import com.talker.sortManage.pojo.Sort;
import com.talker.util.HttpRequestUtil;

/**  
 * 创建时间 : 2015-12-29 下午4:21:42
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：APIController.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

@Controller
@RequestMapping("/poi/")
public class APIController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("create")
	@ResponseBody
	public void createLBSPoi(){
		
		String sql = "SELECT * from area t where t.parentid = 410000";
		List<Sort> listArea = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sort>(Sort.class));
		Map<String, String> params = new HashMap<String, String>();
		int total_num = 0;
		for (Sort sort : listArea) {
			String url = "http://api.map.baidu.com/place/v2/search?ak=nqkA8pQ0wGuWyU9L36cIj3kG&output=json&query=大学&page_size=10&page_num=0&scope=1&region="+sort.getName();
			JSONObject result = HttpRequestUtil.postHttp(url, params);
			if(result!=null && result.getString("message").equals("ok")){
				JSONArray dataArray = result.getJSONArray("results");
				for (int i = 0; i < dataArray.size(); i++) {
					Poi poi = new Poi();
					if(dataArray.getJSONObject(i).containsKey("name"))
						poi.setSchool_name(dataArray.getJSONObject(i).getString("name"));
					if(dataArray.getJSONObject(i).containsKey("address"))
						poi.setAddress(dataArray.getJSONObject(i).getString("address"));
					if(dataArray.getJSONObject(i).containsKey("location")){
						poi.setLongitude(dataArray.getJSONObject(i).getJSONObject("location").getString("lng"));
						poi.setLatitude(dataArray.getJSONObject(i).getJSONObject("location").getString("lat"));
						if(dataArray.getJSONObject(i).containsKey("uid"))
							poi.setSchool_id(dataArray.getJSONObject(i).getString("uid"));
						System.out.println(LBS.createLbsPoi(poi));
						total_num++;
					}else{
						System.out.println(sort.getName()+" 无经纬度");
					}
				}
				int total = result.getInt("total");
				int num = total/20;
				int nums = total%20;
				if(nums!=0)
					num++;
				for (int i = 0; i < num; i++) {
					String url_ = "http://api.map.baidu.com/place/v2/search?ak=nqkA8pQ0wGuWyU9L36cIj3kG&output=json&query=大学&page_size=20&page_num="+(i+1)+"&scope=1&region="+sort.getName();
					JSONObject result_ = HttpRequestUtil.postHttp(url_, params);
					if(result_!=null && result_.getString("message").equals("ok")){
						JSONArray dataArray_ = result_.getJSONArray("results");
						for (int y = 0; y < dataArray_.size(); y++) {
							Poi poi = new Poi();
							if(dataArray_.getJSONObject(y).containsKey("name"))
								poi.setSchool_name(dataArray_.getJSONObject(y).getString("name"));
							if(dataArray_.getJSONObject(y).containsKey("address"))
								poi.setAddress(dataArray_.getJSONObject(y).getString("address"));
							if(dataArray_.getJSONObject(y).containsKey("location")){
								poi.setLongitude(dataArray_.getJSONObject(y).getJSONObject("location").getString("lng"));
								poi.setLatitude(dataArray_.getJSONObject(y).getJSONObject("location").getString("lat"));
								if(dataArray_.getJSONObject(y).containsKey("uid"))
									poi.setSchool_id(dataArray_.getJSONObject(y).getString("uid"));
								System.out.println(LBS.createLbsPoi(poi));
								total_num++;
							}else{
								System.out.println(sort.getName()+" 无经纬度");
							}
						}
					}
				}
			}
		}
		System.out.println("----------:"+total_num);
	}

}
