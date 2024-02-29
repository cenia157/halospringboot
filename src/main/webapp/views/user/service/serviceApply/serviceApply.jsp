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
	href="${pageContext.request.contextPath}/user/service/serviceApply/0.css/seviceapply.css" />
</head>
<body>
	<div class="content-box-tr">
		<div class="content-box-td">
			<div class="content-tabbox-td">
				 <a href="/service/info" class="content-tab1-td tab1-pos"> サービスの案内</a>
				<a href="/service/apply/step1/svc" class="content-tab2-td tab2-pos"> サービスの申込み</a>
			</div>
			<div class="content-subtab-td">
						<img src="${pageContext.request.contextPath}/user/0.img//home.png"
						width="1.7%" alt="" /> > サービス > サービスの申込み
			</div>
			<div class="content-procedure-box-td">
				<!-- 서비스 신청 순서 -->
				<div class="content-title-box-td">サービス申込みの手順</div>
				<ul class="content-procedure-box-ul">
					<li class="content-box-li" style="background-color: ${step1Pos}">

						<div class="content-service-step-box-td">
							<a>Step1.</a>
						</div>
						<div class="content-service-txt-box-td">必要なサービスを選んでください。</div>
					</li>
					<li class="content-box-li" style="background-color: ${step2Pos}">

						<div class="content-service-step-box-td">
							<a>Step2.</a>
						</div>
						<div class="content-service-txt-box-td">ご利用いただく期間をカレンダーからお選びください。</div>

					</li>
					<li class="content-box-li" style="background-color: ${step3Pos}">

						<div class="content-service-step-box-td">
							<a>Step3.</a>
						</div>
						<div class="content-service-txt-box-td">ご利用いただく時間をお選びください。</div>

					</li>
					<li class="content-box-li" style="background-color: ${step4Pos}">

						<div class="content-service-step-box-td">
							<a>Step4.</a>
						</div>
						<div class="content-service-txt-box-td">情報を入力してください。</div>

					</li>

					<li class="content-box-li" style="background-color: ${step5Pos}">

						<div class="content-service-step-box-td">
							<a>Step5.</a>
						</div>
						<div class="content-service-txt-box-td">利用規約に同意してください。</div>

					</li>
					<li class="content-box-li" style="background-color: ${step6Pos}">
						<div class="content-service-step-box-td">
							<a>Step6.</a>
						</div>
						<div class="content-service-txt-box-td">申し込みが完了します。</div>
				</ul>
			</div>
			<jsp:include page="${serviceStep }"></jsp:include>
		</div>
	</div>
</body>

</html>
