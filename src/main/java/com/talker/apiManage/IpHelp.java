package com.talker.apiManage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**  
 * 创建时间 : 2015-12-24 下午2:59:45
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：IpHelp.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class IpHelp {
	
	/**
     * 根据IP获取所在省份
     * @param ip
     * @return
     */
    public static String convert(String ip){
		try {
			String sendurl = "http://ip.taobao.com/service/getIpInfo.php?ip="+ip;
		    URL url = new URL(sendurl);
		    URLConnection urlcon =  url.openConnection();
		    urlcon.setConnectTimeout(5000);   //设置连接超时时间
		    urlcon.setReadTimeout(3000);      //设置读取超时时间
		    urlcon.connect();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream(),"utf-8"));  //从服务器端以流的方式读取数据
		    StringBuffer str = new StringBuffer();
		    String line = "";
		    while((line=reader.readLine())!=null){
		    	str.append(line);
		    }
		    reader.close();
		    String resule = new String(str);
		    String s = new String(resule);
		    String[] temp = s.split(",");
		    if(temp.length<3){
		        return "0";        //无效IP，局域网测试
		    }
		    String region = (temp[5].split(":"))[1].replaceAll("\"", "");
		    StringBuilder sb = new StringBuilder();  
		    int i = -1;  
		    int pos = 0;  
		      
		    while((i=region.indexOf("\\u", pos)) != -1){  
		        sb.append(region.substring(pos, i));  
		        if(i+5 < region.length()){  
		            pos = i+6;  
		            sb.append((char)Integer.parseInt(region.substring(i+2, i+6), 16));  
		        }  
		    }  
		      
		    return sb.toString();
		} catch (Exception e) {

		}  
		return "0";
	} 

}
