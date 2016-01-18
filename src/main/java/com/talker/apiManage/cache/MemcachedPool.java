package com.talker.apiManage.cache;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.whalin.MemCached.MemCachedClient;

public class MemcachedPool {
	
 private static final Log log = LogFactory.getLog(MemcachedPool.class);
	 
	 private static MemCachedClient cachedClient;
     
	    static {
	    	if (cachedClient == null){
	    		cachedClient = new MemCachedClient("memcachedPool"); 
	    		log.debug("Memcache初始化success");
	    	}
	    }
	     
	    private MemcachedPool(){}
	     /**
	      * 不允许key重复，如果key已经存在则会出错,expire为缓存时间（毫秒-最长为30天）
	      */
	    public static boolean add(String key, Object value) {
	        return cachedClient.add(key, value);
	    }
	     
	    public static boolean add(String key, Object value, Date expire) {
	        return cachedClient.add(key, value, expire);
	    }
	     /**
	      * 如果key已经存在替换,expire为缓存时间（毫秒-最长为30天）
	      */
	    public static boolean set(String key, Object value) {
	        return cachedClient.set(key, value);
	    }
	     
	    public static boolean set(String key, Object value, Date expire) {
	        return cachedClient.set(key, value, expire);
	    }
	     /**
	      * 替换缓存中的key及value
	      */
	    public static boolean replace(String key, Object value) {
	        return cachedClient.replace(key, value);
	    }
	     
	    public static boolean replace(String key, Object value, Date expire) {
	        return cachedClient.replace(key, value, expire);
	    }
	    /**
	     * 根据key获取value
	     */
	    public static Object get(String key) {
	        return cachedClient.get(key);
	    }
	    /**
	     * 判断key是否存在
	     */
	    public static boolean keyExists(String key){
	    	return cachedClient.keyExists(key);
	    }
	    /**
	     * 删除缓存中的key
	     */
	    public static boolean delete(String key){
	    	 return cachedClient.delete(key);
	    }
}
