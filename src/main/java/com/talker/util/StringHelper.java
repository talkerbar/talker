package com.talker.util;

import java.util.UUID;

public class StringHelper {
	
	public static String getUUID(){
		UUID onlyId = UUID.randomUUID();
		return onlyId.toString();
	}
	public static StringBuffer removeLast(String str){
	    return new StringBuffer(str.substring(0, str.length() - 1));
	}
}
