package com.talker.apiManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.talker.apiManage.pojo.Poi;
import com.talker.sortManage.pojo.Sort;
import com.talker.util.HttpRequestUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**  
 * 创建时间 : 2015-12-29 下午2:42:29
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：LBS.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class LBS {
	
	public static JSONObject createLbsPoi(Poi poi){
		
		if(poi!=null){
			Map<String, String> params = new HashMap<String, String>();
			//请求接口条件
			params.put("geotable_id", APIConfig.getGeotableId());
			params.put("ak", APIConfig.getAk());
			params.put("coord_type", "3");
			//字段
			params.put("title", poi.getSchool_name());
			params.put("address", poi.getAddress());
			params.put("longitude", poi.getLongitude());
			params.put("latitude", poi.getLatitude());
			params.put("school_id", poi.getSchool_id());
			//POST请求
			JSONObject result = HttpRequestUtil.postHttp(APIConfig.getCreatePoi(), params);
			if (result!=null) {
				if (result.getInt("status")!=0) {
					return result;
				}else {
					return result;
				}
			}
		}
		return null;
		
	}
	
	public static void main(String[] args) {
//		String del = "http://api.map.baidu.com/geodata/v3/geotable/delete";
//		Map<String, String> params = new HashMap<String, String>();
//		//请求接口条件
//		params.put("id", APIConfig.getGeotableId());
//		params.put("ak", APIConfig.getAk());
//		JSONObject result = HttpRequestUtil.postHttp(del, params);
//		System.out.println(result);
//		Map<String, String> params = new HashMap<String, String>();
//		int total_num = 0;
//		String url = "http://api.map.baidu.com/place/v2/search?ak=nqkA8pQ0wGuWyU9L36cIj3kG&output=json&query=%E5%A4%A7%E5%AD%A6&page_size=20&page_num=0&scope=1&region=郑州市";
//		JSONObject result = HttpRequestUtil.postHttp(url, params);
//		if(result!=null && result.getString("message").equals("ok")){
//			JSONArray dataArray = result.getJSONArray("results");
//			for (int i = 0; i < dataArray.size(); i++) {
//				Poi poi = new Poi();
//				if(dataArray.getJSONObject(i).containsKey("name"))
//					poi.setSchool_name(dataArray.getJSONObject(i).getString("name"));
//				if(dataArray.getJSONObject(i).containsKey("address"))
//					poi.setAddress(dataArray.getJSONObject(i).getString("address"));
//					poi.setLongitude(dataArray.getJSONObject(i).getJSONObject("location").getString("lng"));
//					poi.setLatitude(dataArray.getJSONObject(i).getJSONObject("location").getString("lat"));
//					poi.setSchool_id(dataArray.getJSONObject(i).getString("uid"));
//				System.out.println(LBS.createLbsPoi(poi));
//				total_num++;
//			}
//			int total = result.getInt("total");
//			int num = total/20;
//			int nums = total%20;
//			if(nums!=0)
//				num++;
//			for (int i = 0; i < num; i++) {
//				String url_ = "http://api.map.baidu.com/place/v2/search?ak=nqkA8pQ0wGuWyU9L36cIj3kG&output=json&query=%E5%A4%A7%E5%AD%A6&page_size=20&page_num="+(i+1)+"&scope=1&region=郑州市";
//				JSONObject result_ = HttpRequestUtil.postHttp(url_, params);
//				if(result_!=null && result_.getString("message").equals("ok")){
//					JSONArray dataArray_ = result_.getJSONArray("results");
//					for (int y = 0; y < dataArray_.size(); y++) {
//						Poi poi = new Poi();
//						if(dataArray.getJSONObject(y).containsKey("name"))
//							poi.setSchool_name(dataArray_.getJSONObject(y).getString("name"));
//						if(dataArray.getJSONObject(y).containsKey("address"))
//							poi.setAddress(dataArray_.getJSONObject(y).getString("address"));
//							poi.setLongitude(dataArray_.getJSONObject(y).getJSONObject("location").getString("lng"));
//							poi.setLatitude(dataArray_.getJSONObject(y).getJSONObject("location").getString("lat"));
//							poi.setSchool_id(dataArray_.getJSONObject(y).getString("uid"));
//						System.out.println(LBS.createLbsPoi(poi));
//						total_num++;
//					}
//				}
//			}
//		}
//		System.out.println("----------:"+total_num);
		Poi poi = new Poi();
		poi.setSchool_name("河南科技学院新科学院");
		poi.setAddress("河南省新乡市洪门镇华兰大道东段");
		poi.setLongitude("113.940342");
		poi.setLatitude("35.287724");
		poi.setSchool_id("baf627f6c2bf9cf4a8059d8c");
		System.out.println(LBS.createLbsPoi(poi));
	}

}
