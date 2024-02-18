<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Information</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/homepageSetting/information/0.css/informationContent.css" />
<body>
	<div class="content-m-td-2-wrap">
		<div class="content-m-td-2-wrap-contain">
	<!-- 폼태그 => 회사정보변경C -->
		<form action="/admin/homepage-update/company-info/update" method="post">
			<div class="CompanyInformation">
				<div class="CompanyInformation-large">
					<div class="CompanyInformation-info">会社住所</div>
					<div class="CompanyInformation-txt">
						<!-- 주소 인풋 -->
						<textarea name="h_address" class="CompanyInformation-textarea-big" rows="" cols=""
							>${hdto.h_address}</textarea>
					</div>
				</div>
				<div class="CompanyInformation-small">
					<div class="CompanyInformation-small-tr">
						<div class="CompanyInformation-small-td">
							<div class="CompanyInformation-info">会社電話番号</div>
							<div class="CompanyInformation-txt">
							<!-- 회사 전화번호 인풋 -->
								<textarea name="h_tel_no" class="CompanyInformation-textarea-mini" rows=""
									cols="">${hdto.h_tel_no }</textarea>
							</div>
						</div>
						<div class="CompanyInformation-small-td">
							<div class="CompanyInformation-info">会社携帯</div>
							<div class="CompanyInformation-txt">
							<!-- 휴대전화 인풋 -->
								<textarea name="h_phone_no" class="CompanyInformation-textarea-mini" rows=""
									cols="">${hdto.h_phone_no}</textarea>
							</div>
						</div>
					</div>
					<div class="CompanyInformation-small-tr">
						<div class="CompanyInformation-small-td">
							<div class="CompanyInformation-info">会社イーメール</div>
							<div class="CompanyInformation-txt">
							<!-- 이메일 인풋 -->
								<textarea name="h_email" class="CompanyInformation-textarea-mini" rows=""
									cols="">${hdto.h_email}</textarea>
							</div>
						</div>
						<div class="CompanyInformation-small-td">
							<div class="CompanyInformation-info">会社FAX</div>
							<div class="CompanyInformation-txt">
							<!-- FAX 인풋 -->
								<textarea name="h_fax_no" class="CompanyInformation-textarea-mini" rows=""
									cols="">${hdto.h_fax_no}</textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 하단 div박스 등록결과, 버튼 -->
			<div class="content-m-td-2-down">
				<div class="content-m-td-2-side-down-button">
				<div class="information-result">
				<h2 class="logo_result success">${param.success}</h2>
			<h2 class="logo_result error">${param.error}</h2>
			</div>
					<button class="content-button">変更</button>
				</div>
			</div>
			</form>
		</div>
	</div>
</body>

</html>