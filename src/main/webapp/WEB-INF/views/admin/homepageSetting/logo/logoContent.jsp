<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>logo</title>
<!-- 해당 컨텐트 css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/homepageSetting/logo/0.css/logo.css" />
<!-- 폰트 css -->
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
<!-- js연결 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/homepageSetting/logo/0.js/logo.js"
	defer="defer"></script>
</head>
<body>
	<div class="content-m-td-3">
		<!-- 		왼쪽 (현재로고) 큰 div -->

		<div class="content-m-td-2-side">
			<div class="content-m-td-2-side-up">
				<div class="content-m-td-2-side-up-title">現在ロゴ</div>
			</div>
			<div class="content-m-td-2-side-mid">

				<div class="content-m-td-2-side-mid-logo"
					style="background-image: url('${pageContext.request.contextPath}/user/upload_imgs/${hdto.h_logo_img}');">
					<!-- 현재(기존)이미지 보여주기 (기존 이미지 경로 EL태그) -->
				</div>
			</div>
			<div class="content-m-td-2-side-down">
				<h2 class="logo_result success">${param.success}</h2>
				<h2 class="logo_result error">${param.error}</h2>
			</div>
		</div>
		<div class="content-m-td-2-mid">
			<div class="content-m-td-2-mid-Play">
				<img alt=""
					src="${pageContext.request.contextPath}/admin/0.img/Vector.png">
			</div>
		</div>
		<!-- 		오른쪽(변경로고) 큰 div   form태그 감싸기, logoUpdateC, post로 img경로값 보내기 -->
		<div class="content-m-td-2-side2">
			<div class="content-m-td-2-side-up">
				<div class="content-m-td-2-side-up-title">変更ロゴ</div>
			</div>

			<div class="content-m-td-2-side-mid2">
				<!-- 변경할 로고 파일 업로드 인풋 & 이미지미리보기 -->
				<div class="content-m-td-2-side-mid-logo2">
						<div class="logo_upload">
							<!-- 바뀔 이미지 미리보기(Ajax) -->
					<label for="logo_img">
						<div id="logo_preview" style="background-image: url('${pageContext.request.contextPath}/admin/0.img/fileUpload_pre.png');"></div>
					</label>
							<!-- 변경할 로고이미지 인풋 -->
							<form action="/admin/homepage-update/logo/upload-file"
								id="fileUploadForm" method="post" enctype="multipart/form-data">
								<input type="file" id="logo_img" name="logo_img">
							</form>
				</div>
			</div>
		</div>
		<div class="content-m-td-2-side-down">
			<!-- 로고변경 버튼  -->
			<div class="content-m-td-2-side-down-button">
				<!-- 변경완료버튼, 실제DB에 업뎃되면서 대기이미지로 바뀜 -->
				<button type="button" class="content-button" id="logo_btn_submit"
					onclick="#">変更完了</button>
			</div>
		</div>
	</div>
	</div>
</body>
</html>