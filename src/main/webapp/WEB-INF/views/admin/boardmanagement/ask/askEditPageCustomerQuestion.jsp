<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.halo.user.qa.question.Question" %>
<%@ page import="com.halo.user.qa.question.QuestionDAO" %>
<% request.getAttribute("questions"); %>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />







<title>Ask</title>





<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />

</head>


<body>



<!-- 여기는 고객의 문의를 띄우는 곳 -->
		<div id="N_QUESTION_CONTENT"></div>






</body>
</html>