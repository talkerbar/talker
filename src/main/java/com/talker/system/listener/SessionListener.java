package com.talker.system.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.talker.apiManage.cache.MemcachedPool;

/**  
 * 创建时间 : 2016-2-22 下午1:44:43
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：SessionListener.java  
 * 说明 :  统计在线人数
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class SessionListener implements HttpSessionListener{
	
	private Log log  = LogFactory.getLog(SessionListener.class);

	public void sessionCreated(HttpSessionEvent se) {
		log.debug("访客增加");
		MemcachedPool.set("talker_online", MemcachedPool.keyExists("talker_online")?(Integer)MemcachedPool.get("talker_online")+1:1);
		log.debug("目前在线人数："+MemcachedPool.get("talker_online"));
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		log.debug("访客减少");
		MemcachedPool.set("talker_online", MemcachedPool.keyExists("talker_online")?(Integer)MemcachedPool.get("talker_online")-1:0);
		log.debug("目前在线人数："+MemcachedPool.get("talker_online"));
	}

}
