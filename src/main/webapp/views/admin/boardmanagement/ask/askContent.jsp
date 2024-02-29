<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Ask</title>

<link rel="stylesheet"
	href="/admin/boardmanagement/ask/_css/ask.css" />
<link rel="stylesheet" href="/admin/0.css/test copy.css" />

</head>
<body>
	<input type="hidden" id="pageNum" value="${pageNum}">
	<div class="ontent-m-td-2-chackbox">
		<div class="ontent-m-td-2-chackbox-contain">
				<div class="ontent-m-td-2-chackbox-contain-input">
					<input type="checkbox" class="filter" id="checkbox1" name="completed" value="0" checked="checked" onclick="questionCheckbox()">
				</div>
				<label for="checkbox1" class="ontent-m-td-2-chackbox-contain-txt">完</label>
				<div class="ontent-m-td-2-chackbox-contain-input">
					<input type="checkbox" class="filter" id="checkbox2" name="uncompleted" value="1" checked="checked" onclick="questionCheckbox()">
				</div>
				<label for="checkbox2" class="ontent-m-td-2-chackbox-contain-txt">未</label>
			<div class="ontent-m-td-2-chackbox-contain-input"></div>
			<div class="ontent-m-td-2-chackbox-contain-txt"></div>
			<div class="ontent-m-td-2-chackbox-contain-input"></div>
			<div class="ontent-m-td-2-chackbox-contain-txt"></div>
			<div class="ontent-m-td-2-chackbox-contain-input"></div>
			<div class="ontent-m-td-2-chackbox-contain-txt"></div>
		</div>
	</div>
	
	<!-- 아래의 include는 for Each를 써서 게시판을 나타내는 용도다 시작 -->
	<jsp:include page="/views/admin/boardmanagement/ask/askBoard.jsp"></jsp:include>
	<!-- 아래의 include는 for Each를 써서 게시판을 나타내는 용도다 끝 -->
	<!-- 고객의 문의에 미답변 내용을 보여주는 곳 -->
	<jsp:include page="/views/admin/boardmanagement/ask/askRespone.jsp"></jsp:include>
	<!-- 고객의 문의에 답변 내용을 편집하는 곳 -->
	<jsp:include page="/views/admin/boardmanagement/ask/askEditPage.jsp"></jsp:include>
	
	
</body>
</html>