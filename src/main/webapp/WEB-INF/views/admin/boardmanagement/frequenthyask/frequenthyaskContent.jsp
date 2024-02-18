<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Frequenthyask</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/0.css/test copy.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/boardmanagement/frequenthyask/0.css/frequenthyask.css" />

<script src="${pageContext.request.contextPath}/admin/boardmanagement/frequenthyask/0.js/faq.js"></script>
<script src="${pageContext.request.contextPath}/admin/_js/test.js"></script>
<!-- ckeditor 스크립트인가? -->
<script src="/admin/_js/ckeditor/ckeditor.js"></script>
</head>

<body>
	<div class="ontent-m-td-2-chackbox"></div>
	<div class="ontent-m-td-2-content">
		<div class="ontent-m-td-2-content-container">
			<div class="ontent-m-td-2-content-txt">
				<div class="ontent-m-td-2-content-txt-no">No</div>
				<div class="ontent-m-td-2-content-txt-title">タイトル</div>
				<div class="ontent-m-td-2-content-txt-date">更新日</div>
				<div class="ontent-m-td-2-content-txt-delete"></div>
			</div>
		</div>
		<div class="ontent-m-td-2-mid">
			<c:forEach items="${FAQs}" var="qa" varStatus="loop">
				<div class="ontent-m-td-2-content-txt-in">
					<input type="hidden" name="qa_seq" value="${qa.qa_seq }">
					<div class="ontent-m-td-2-content-txt-no-in">${(loop.index + 1)}
					</div>
					<div class="ontent-m-td-2-content-txt-title-in" id="Title_css">
						<a onclick="getFAQData('${qa.qa_seq}')">● ${qa.qa_title } </a>
					</div>
					<div class="ontent-m-td-2-content-txt-date-in"><fmt:formatDate value="${qa.qa_reg_date}" pattern="yyyy-MM-dd"/></div>
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
		<jsp:include page="frequenthyaskEditPage.jsp"></jsp:include>
	</div>
	<!--  여기는 게시글이 업로드되면 자동으로 게시글을 새로고침하기 위한 ajax 적용하는 곳 -->
</body>
</html>