package com.talker.util;

import java.util.UUID;

public class StringHelper {
	
	public static String getUUID(){
		UUID onlyId = UUID.randomUUID();
		return onlyId.toString();
	}
}
