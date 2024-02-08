<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="admin/_js/ckeditor.js"></script>
<script src="admin/_js/ckeditor/ckeditor.js"></script>

<title>Frequenthyask</title>


<link rel="stylesheet" href="/admin/0.css/test copy.css" />
<link rel="stylesheet"
	href="/admin/boardmanagement/frequenthyask/_css/frequenthyask.css"/>

<script src="/admin/boardmanagement/frequenthyask/_js/faq.js"></script>
<script src="/admin/_js/test.js"></script>





<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
</head>
<body>
	<div class="ontent-m-td-2-chackbox"></div>
	<div class="ontent-m-td-2-content">
		<div class="ontent-m-td-2-content-container">
			<div class="ontent-m-td-2-content-txt">
				<div class="ontent-m-td-2-content-txt-no">No</div>
				<div class="ontent-m-td-2-content-txt-title" id="Title_css">タイトル</div>
				<div class="ontent-m-td-2-content-txt-date">更新日</div>
				<div class="ontent-m-td-2-content-txt-delete"></div>
			</div>
		</div>
		<div class="ontent-m-td-2-mid">
			<c:forEach items="${FAQs}" var="qa" varStatus="loop">
				<div class="ontent-m-td-2-content-txt-in">
					<input hidden="1" name="qa_seq" value="${qa.qa_seq }">
					<div class="ontent-m-td-2-content-txt-no-in"> ${(loop.index + 1) + (curPageNo -1) * 8 } </div>
					<div class="ontent-m-td-2-content-txt-title-in" id="Title_css"> <a onclick="getFAQData('${qa.qa_seq}')">● ${qa.qa_title } </a> </div>
					<div class="ontent-m-td-2-content-txt-date-in">${qa.qa_reg_date}</div>
				</div>
			</c:forEach>
		</div>
		<div class="ontent-m-td-2-bottom">
			<div class="ontent-m-td-2-page-side"></div>
			<div class="ontent-m-td-2-page-center"></div>
			<div class="ontent-m-td-2-page-side"></div>
		</div>
		<!-- 여기는 모달을 띄워주는 곳, 
			자주묻는 질문의 내용을 변경하기 위한 곳(frequenthyaskEditPage.jsp)-->
		<jsp:include page="frequenthyaskEditPage2.jsp"></jsp:include>
	</div>
</body>
</html>