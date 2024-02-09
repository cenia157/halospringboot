package com.halo.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

public class HaloUtils {
	
	// 결과값 한글로 파람 넘길떄 인코딩, 자르기
	public static String setParam(HttpServletRequest request) {
		String param="";
		try {
			 param = request.getAttribute("paramName") +"="+ URLEncoder.encode( (String) request.getAttribute("param"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return param;
	}

}
