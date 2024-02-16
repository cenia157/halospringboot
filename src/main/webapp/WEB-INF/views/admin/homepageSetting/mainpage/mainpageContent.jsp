<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Mainpage</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/homepageSetting/mainpage/0.css/mainpage.css" />

<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
<!-- js -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/homepageSetting/mainpage/0.js/mainpage.js"></script>

<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>

</head>

<body>
	<div class="content-m-td-3">
		<form action="/admin/homepage-update/quick-menu/update" method="post">
			<div class="content-m-td-3-up">
				<!-- 여긴 공간채움용 빈공간 -->
			</div>
			<div class="content-m-td-3-mid-1">
				<div class="content-m-td-3-mid-1-tr">
					<c:forEach var="bannerInform" items="${topBanners}">
					<div class="content-m-td-3-mid-1-td">
						<div class="content-m-td-3-mid-1-td-box">${bannerInform.m_text }</div>
					</div>
					</c:forEach>
				</div>
			</div>

			<div class="content-m-td-3-mid-2">

				<div class="content-m-td-3-mid-2-tr">

					<div class="content-m-td-3-mid-2-tr-underbar">
						<select class="main-banner-select" name="m_name4">
							<option value="info_com">会社について</option>
							<option value="info_map">施設アクセス</option>
							<option value="intro_announce">お知らせ</option>
							<option value="intro_album">アルバム</option>
							<option value="intro_employ">スタッフ募集</option>
							<option value="service_info">サービスの案内</option>
							<option value="service_apply">サービスの申し込み</option>
							<option value="faq">よくある質問</option>
							<option value="question">お問い合わせ</option>
						</select>
					</div>
					<div class="content-m-td-3-mid-2-tr-underbar">
						<select class="main-banner-select" name="m_name5">
							<option value="info_com">会社について</option>
							<option value="info_map">施設アクセス</option>
							<option value="intro_announce">お知らせ</option>
							<option value="intro_album">アルバム</option>
							<option value="intro_employ">スタッフ募集</option>
							<option value="service_info">サービスの案内</option>
							<option value="service_apply">サービスの申し込み</option>
							<option value="faq">よくある質問</option>
							<option value="question">お問い合わせ</option>
						</select>
					</div>
					<div class="content-m-td-3-mid-2-tr-underbar">
						<select class="main-banner-select" name="m_name6">
							<option value="info_com">会社について</option>
							<option value="info_map">施設アクセス</option>
							<option value="intro_announce">お知らせ</option>
							<option value="intro_album">アルバム</option>
							<option value="intro_employ">スタッフ募集</option>
							<option value="service_info">サービスの案内</option>
							<option value="service_apply">サービスの申し込み</option>
							<option value="faq">よくある質問</option>
							<option value="question">お問い合わせ</option>
						</select>
					</div>
				</div>
			</div>
			<div class="content-button">
				<button>変更</button>
			</div>
		</form>
	</div>

</body>

</html>