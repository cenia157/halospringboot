<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/user/service/serviceApply/0.css/svcselect.css" />
</head>
<body>
	<form action="/service/apply/step2/calendar" class="content-form-box" method="post" >
		<div class="content-serviceselect-box-td">
			<div class="content-serviceoption-td">
			<label >
				<input type="radio" name="sa_service" value="nursingTaxi"
					id="service" checked> <br> 介護サービス & <br> 介護タクシーサービス</label><br>
			</div>
			<div class="content-serviceoption-td">
				<label>
				<input type="radio" name="sa_service" value="nursing" id="service">
				<br> 介護サービス</label>
			</div>

			<div class="content-serviceoption-td">
			<label>
				<input type="radio" name="sa_service" value="taxi" id="service"> <br> 介護タクシーサービス</label>
			</div>
		</div>
		<div class="content-servicebtn-box-td">
				<button class="content-servicebtn-td">次の申込みページへ</button>
		</div>
		<div class="content-reference-txt-td">※ご利用いただくサービス内容をお選びの上、お申し込みページのボタンを押してください。</div>
	</form>
</body>
</html>
