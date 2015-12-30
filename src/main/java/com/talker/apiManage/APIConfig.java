package com.talker.apiManage;
/**  
 * 创建时间 : 2015-12-29 下午2:09:02
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：APIConfig.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class APIConfig {
	
	public static final String ak = "nqkA8pQ0wGuWyU9L36cIj3kG";
	/**
	 * geotable_id
	 */
	public static final String geotable_id = "130426";
	/**
	 * 创建数据（create poi）接口
	 */
	public static final  String create_poi = "http://api.map.baidu.com/geodata/v3/poi/create";
	
	
	public static String getAk() {
		return ak;
	}
	public static String getGeotableId() {
		return geotable_id;
	}
	public static String getCreatePoi() {
		return create_poi;
	}
	
}
