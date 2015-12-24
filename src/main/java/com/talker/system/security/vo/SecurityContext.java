package com.talker.system.security.vo;

public class SecurityContext {
	
	private static ThreadLocal<UserSession> userSession = new ThreadLocal<UserSession>();

	public static void setUserSession(UserSession uv) {
		userSession.set(uv);
	}
	
	public static String getSessionId() {
		UserSession uv = userSession.get();
		if(uv != null) {
			return uv.getSessionId();
		}
		return "noSession";
	}

}
