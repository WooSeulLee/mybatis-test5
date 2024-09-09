package com.mybatis.test.util;

public class CMDUtil {
	public static String getCmd(String uri) {
		int idx = uri.lastIndexOf("/");
		if(idx!=-1) {
			return uri.substring(idx+1);
			
		}
		return null;
		
	}
}
