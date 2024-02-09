<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/user/service/serviceApply/0.css/timeselect.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/user/service/serviceApply/0.css/seviceapply.css" />
</head>
<body>
	<form action="TimeselectC" method="post" class="content-form-box">
		<input type="hidden" name="selectedStart" value="${selectedStart }">
		<input type="hidden" name="selectedEnd" value="${selectedEnd }">
		<div class="content-time-select-box-td">
			<div class="content-time-option-td">
			<label >
				<input type="radio" name="selectedTime" value="AM,PM"
					id="selectedTime" checked> <br> 終日 <br> 08:00~18:00 </label><br>
			</div>
			<div class="content-time-option-td">
				<label>
				<input type="radio" name="selectedTime" value="AM" id="selectedTime">
				<br> 午前 <br> 08:00~12:00</label>
			</div>

			<div class="content-time-option-td">
			<label>
				<input type="radio" name="selectedTime" value="PM" id="selectedTime"> <br> 午後<br> 14:00~18:00</label>
			</div>
		</div>

		<div class="content-time-btn-box-td">
			<button class="content-time-btn">次へ</button>
		</div>
		<!-- step별 페이지  끝-->
	</form>

</body>

</html>