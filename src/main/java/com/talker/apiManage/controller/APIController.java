package com.talker.apiManage.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talker.apiManage.APIConfig;
import com.talker.apiManage.LBS;
import com.talker.apiManage.pojo.Poi;
import com.talker.apiManage.pojo.Temp;
import com.talker.sortManage.pojo.SortParams;
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
	
	/**
	 * 方法名: createLBSPoi
	 * 说明 :  根据数据库地区-->从百度地图拉取数据-->存向LBS
	 * 创建人 :   zdd       
	 * 创建时间 : 2015-12-30 下午2:19:01 
	 * 返回值  : void
	 */
	@RequestMapping("create")
	@ResponseBody
	public void createLBSPoi(){
		String sql = "select * from temp";
		List<Temp> temp =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<Temp>(Temp.class));
		for (Temp temp2 : temp) {
			Poi poi = new Poi();
			poi.setSchool_name(temp2.getTitle());
			poi.setAddress(temp2.getAddress());
			poi.setLongitude(temp2.getLng());
			poi.setLatitude(temp2.getLat());
			poi.setSchool_id(temp2.getId()+"");
			System.out.println(LBS.createLbsPoi(poi));
		}
	}
	
	@RequestMapping("createSchool")
	@ResponseBody
	public void createSchoolToMySql(){
		String createSql = "insert into school(id,name,province,city,district) values(?,?,?,?,?)";
		String sql = "http://api.map.baidu.com/geodata/v3/poi/list?geotable_id="+APIConfig.getGeotableId()+"&ak=nqkA8pQ0wGuWyU9L36cIj3kG&page_size=200";
		JSONObject result = HttpRequestUtil.get(sql);
		JSONArray jsonArray = result.getJSONArray("pois");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			SortParams sortParams = new SortParams();
			sortParams.setId(Integer.parseInt(jsonObject.getString("school_id")));
			sortParams.setName(jsonObject.getString("title"));
			sortParams.setProvince(jsonObject.getString("province"));
			sortParams.setCity(jsonObject.getString("city"));
			sortParams.setDistrict(jsonObject.getString("district"));
			Object[] parmas = {sortParams.getId(),sortParams.getName(),sortParams.getProvince(),sortParams.getCity(),sortParams.getDistrict()};
			int result_i = jdbcTemplate.update(createSql, parmas);
			System.out.println(result_i);
		}
	}

}
