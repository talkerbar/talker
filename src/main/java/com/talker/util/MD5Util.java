package com.talker.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * md5 加密
     * @param text
     * @return
     */
    public static String md5(String text) {
        MessageDigest msgDigest = null;
        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("System doesn't support MD5 algorithm.");
        }

        msgDigest.update(text.getBytes());

        byte[] bytes = msgDigest.digest();
        String md5Str = new String();
        for (byte t:bytes){
        	int i = t<0?t+256:t;
        	    String tmp = Integer.toHexString(i);
        	    tmp = tmp.length()==1?"0"+tmp:tmp;
        	    md5Str+=tmp.toUpperCase();
        }
        return md5Str;
    }

    /**
     * md5加密
     * @param str
     * @return
     */
    public static byte[] md5Byte(String str) {
        byte[] utfBytes;
        try {
            utfBytes = str.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(utfBytes);

            return mdTemp.digest();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
		System.out.println("123456===" + md5("123456"));
	}
    
}
