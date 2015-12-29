package com.talker.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**  
 * 创建时间 : 2015-12-29 下午2:12:56
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：HttpRequestUtil.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class HttpRequestUtil {
	
	/**
	 * 方法名: get
	 * 说明 :  GET请求
	 * 创建人 :   zdd       
	 * 创建时间 : 2015-12-29 下午2:23:35 
	 * 返回值  : JSONObject
	 */
	public static JSONObject get(String url) {  
        HttpGet get = new HttpGet(url);
        JSONObject json = null;  
        CloseableHttpClient  s  = null;
        try {
        	s = HttpClients.createDefault();
        	HttpResponse res = s.execute(get);
            if (res.getStatusLine().getStatusCode() == 200) {
            	String result=EntityUtils.toString(res.getEntity(),"utf-8");
                json = JSONObject.fromObject(result);  
            }
        } catch (Exception e) {  
            e.printStackTrace(); 
        } 
        finally{
        	if (s!=null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        }
        return json;  
    }
	
	/**
	 * 方法名: postHttp
	 * 说明 :  POST请求
	 * 创建人 :   zdd       
	 * 创建时间 : 2015-12-29 下午2:21:38 
	 * 返回值  : JSONObject
	 */
	public static JSONObject postHttp(String url,Map<String, String> map){
		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse res=null;
		try {  
	    	HttpPost httppost=new HttpPost(url);
	    	httppost.setHeader("X-Forwarded-For","120.9.208.40");
	    	httppost.setHeader("X-Forwarded-Port","8090");
	    	List<NameValuePair> params=new ArrayList<NameValuePair>();
	    	for(Map.Entry<String, String> entry:map.entrySet()){    
	    	     params.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
	    	}   
	    	httppost.setEntity(new UrlEncodedFormEntity(params,"utf-8"));
	        res = client.execute(httppost);  
	        if(res.getStatusLine().getStatusCode()==200){
				String result=EntityUtils.toString(res.getEntity());
				JSONObject rs = JSONObject.fromObject(result);
				return rs;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();  
	    }finally{
	    	try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		return null;
	}

}
