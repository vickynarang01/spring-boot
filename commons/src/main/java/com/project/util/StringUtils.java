package com.project.util;

public class StringUtils {
	
	public static boolean isStringAvailable(String str) {
		if(str!=null && str.length()>0) {
			return true;
		}
		return false;
	}

}
