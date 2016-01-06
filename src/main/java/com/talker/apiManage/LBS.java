package com.talker.apiManage;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.talker.apiManage.pojo.Poi;
import com.talker.util.HttpRequestUtil;

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
		Poi poi = new Poi();
		poi.setSchool_name("郑州轻工业学院");
		poi.setAddress("河南省郑州市中原区枫香街");
		poi.setLongitude("113.515832");
		poi.setLatitude("34.817152");
		poi.setSchool_id("13");
		System.out.println(LBS.createLbsPoi(poi));
//		String sql = "http://api.map.baidu.com/geodata/v3/poi/list?geotable_id="+APIConfig.getGeotableId()+"&ak=nqkA8pQ0wGuWyU9L36cIj3kG&page_size=200&city=周口市";
//		System.out.println(HttpRequestUtil.get(sql));
	}

}
