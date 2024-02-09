<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getCookie.jsp</title>
</head>
<body>

	<%
	String cookieCheck = request.getHeader("Cookie");
	if (cookieCheck != null) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookie.getName(); // key 값 
			cookie.getValue(); // value 값
		}
	}
	%>
</body>
</html>