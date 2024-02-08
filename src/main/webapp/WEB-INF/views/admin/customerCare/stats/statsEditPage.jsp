
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>stats.jsp</title>

<script>
	function onPageLoad() {
		const currentTime = new Date().toLocaleString();
		localStorage.setItem('lastVisitTime', currentTime);

		// AJAX를 사용하여 서블릿에 데이터 전송
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/your-context-root/SaveVisitTimeServlet', true);
		xhr.send();
	}

	window.onload = onPageLoad;
</script>
</head>

<body>
	<h1>쿠키 생성</h1>

	<p></p>
	<button>지우기</button>
	<input type="text" name="" id="">







</body>

</html>
