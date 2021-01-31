package com.acikoleji.adminpanel.util;

import java.util.List;

public class CheckUtils {
	
	public static boolean isNotNull(Object o) {
		return o != null;
	}
	
	public static boolean isNotEmpty(List<? extends Object> list) {
		return !list.isEmpty();
	}

	public static boolean isNull(Object o) {
		return o == null;
	}

}
