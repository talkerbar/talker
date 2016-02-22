package com.talker.system.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.talker.apiManage.cache.MemcachedPool;

/**  
 * 创建时间 : 2016-2-22 下午1:40:34
 * 项目名称 : talker  
 * 创建人 : zdd
 * 文件名称 ：ContextListener.java  
 * 说明 :  TODO
 * 修改时间:
 * 修改人 :
 * 修改原因 : 
 */

public class ContextListener implements ServletContextListener{
	
	private Log log = LogFactory.getLog(ContextListener.class);

	public void contextInitialized(ServletContextEvent sce) {
		log.debug("监听项目启动事件");
		//初始化在线人数
		MemcachedPool.set("talker_online", 0);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		log.debug("监听项目停止事件");
	}

}
