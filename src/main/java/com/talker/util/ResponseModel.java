package com.talker.util;

import java.io.Serializable;
import java.util.List;

/**
 * 淘客吧统一返回实体
 * @author hp
 *
 */
public class ResponseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean success;
	private String message;
	private Object object;
	private List<?> list;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
	public static ResponseModel buildMessage(boolean success,String message){
		ResponseModel rm = new ResponseModel();
		rm.setSuccess(success);
		rm.setMessage(message);
		return rm;
	}
	
	public static ResponseModel buildObject(boolean success,Object object){
		ResponseModel rm = new ResponseModel();
		rm.setSuccess(success);
		rm.setObject(object);
		return rm;
	}
	
	public static ResponseModel buildMessageObject(boolean success,String message,Object object){
		ResponseModel rm = new ResponseModel();
		rm.setSuccess(success);
		rm.setMessage(message);
		rm.setObject(object);
		return rm;
	}
	
	public static ResponseModel buildList(boolean success,List<?> list){
		ResponseModel rm = new ResponseModel();
		rm.setSuccess(success);
		rm.setList(list);
		return rm;
	}
	
	public static ResponseModel buildMessageList(boolean success,String message,List<?> list){
		ResponseModel rm = new ResponseModel();
		rm.setSuccess(success);
		rm.setMessage(message);
		rm.setList(list);
		return rm;
	}
}
