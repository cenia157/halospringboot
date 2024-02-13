<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- font -->
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />

<!--css -->
<link rel="stylesheet" href="/user/0.css/index.css" />
<link rel="stylesheet" href="/user/0.css/index-menu.css" />
<link rel="stylesheet" href="/user/0.css/index-footer.css" />
<link rel="stylesheet" href="/user/0.css/sec.css" />

<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>

<!-- 헤더 js -->
<script src="/user/0.js/index-menu.js"></script>
<!-- 배경이미지 js -->
<script src="/user/0.js/background-img.js"></script>
<!-- 리모컨 js -->
<script src="/user/0.js/remote-control.js"></script>
<!-- 반응형 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>

	<div class="container">
		<!-- 헤더 html 시작 -->
		<div class="header-tbl">
			<div class="header-opmenu-back"></div>
			<div class="header-tr-1">
				<div class="header-br-logo btn-pointer" onclick="location.href='HC'"
					style="background-image: url('/user/upload_imgs/${hdto.h_logo_img}');">
					<%-- 					<img src="user/upload_imgs/${hdto.h_logo_img}"> --%>
				</div>
				<div class="header-br-space">
					<div class="mobileHamburg"> <img alt="" src="/user/0.img/icon _menu_.png"> </div>
				</div>
				<!-- 전화번호 수정 가능하도록, 회사정보(footer 어트리뷰트) -->
				<div class="header-br-call">Tel. ${hdto.h_tel_no}</div>
			</div>
			<div class="header-tr-2">
				<div class="header-td-menu">
					<div class="header-td-menu-title">
						<a href="/introduce/company" class="">紹介 <span
							class="header-td-menu-under"></span>
						</a>
					</div>
					<div class="header-td-menu-title">
						<a href="AnnouncedC" class="">情報 <span
							class="header-td-menu-under"></span>
						</a>
					</div>
					<div class="header-td-menu-title">
						<a href="ServiceInformationC" class="">サービス <span
							class="header-td-menu-under"></span>
						</a>
					</div>
					<div class="header-td-menu-title">
						<a href="FaqC" class="">QnA <span class="header-td-menu-under"></span>
						</a>
					</div>
				</div>
			</div>
			<div class="header-opmenu">
				<div class="header-opmenu-td">
					<a class="header-opmenu-a" href="/introduce/company">会社について</a> <a
						class="header-opmenu-a" href="/introduce/map">施設アクセス</a>
				</div>
				<div class="header-opmenu-td">
					<a class="header-opmenu-a" href="AnnouncedC">お知らせ</a> <a
						class="header-opmenu-a" href="AlbumC">アルバム</a> <a class="header-opmenu-a"
						href="EmploymentC">スタッフ募集</a>
				</div>
				<div class="header-opmenu-td">
					<a class="header-opmenu-a" href="ServiceInformationC">サービスの案内</a> <a
						class="header-opmenu-a" href="ServiceApplyC">サービスの申し込み</a>
				</div>
				<div class="header-opmenu-td">
					<a class="header-opmenu-a" href="FaqC">よくある質問</a> <a
						class="header-opmenu-a" href="QuestionC">お問い合わせ</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 헤더끝 -->

	<!-- - 배경이미지 - div -->
	<div id="background-img">
		<div class="background img-rightCloud">
			<img src="/user/0.img/rightCloud.PNG" alt="" />
		</div>
		<div class="background img-leftCloud">
			<img src="/user/0.img/leftCloud.PNG" alt="" />
		</div>
		<div class="background img-rightPink">
			<img src="/user/0.img/rightPinkCloud.PNG" alt="" />
		</div>
		<div class="background img-leftPink">
			<img src="/user/0.img/leftPinkCloud.PNG" alt="" />
		</div>
		<div class="background img-sunset">
			<img src="/user/0.img/sunset.PNG" alt="" />
		</div>
		<div class="background img-mountain">
			<img src="/user/0.img/mountain.PNG" alt="" />
		</div>
	</div>
	<!-- 배경이미지 끝 -->

	<!-- 콘텐츠 페이지 -->
	<div class="menu-sec">
		<jsp:include page="${menu  }"></jsp:include>
	</div>
	<!--  콘텐츠 페이지끝 -->

	<!-- 리모컨 -->
	<div class="remote-control-tbl">
		<div class="remote-control-tr">
			<div class="remote-control-td2 btn-pointer" id="goTop">
				<img src="/user/0.img/re-up.png" width="55%" alt="" />
			</div>
			<div class="remote-control-td">アップ</div>
		</div>
		<div class="remote-control-tr">
			<div class="remote-control-td2 btn-pointer">
				<img src="/user/0.img/line-icon22.png" width="60%" alt="" />
			</div>
			<div class="remote-control-td">1:1チャット</div>
		</div>
	</div>
	<!-- 리모컨 끝 -->

	<!-- Footer 시작 -->
	<div class="footer-tbl">
		<div class="footer-tr">
			<!-- admin페이지에서 업뎃 -->
			<div class="footer-item-td-1">
				Tel. ${hdto.h_tel_no} <br /> FAX : ${hdto.h_fax_no} <br />
				PhoneNumber : ${hdto.h_phone_no} <br /> email : ${hdto.h_email} <br />
				address : ${hdto.h_address} <br />
			</div>
			<div class="footer-item-td-2">
				<div>
					合同会社 <img src="/user/0.img/footerlogo.png" id="footer-logo-img" alt="" /><a
						href="/login">ハロー </a>
				</div>
				<div>
					代表社員 ： 大出 昭子 <img src="/user/0.img/footerinstaicon.png" id="footer-logo-img-sns" alt="" /> <img
						src="/user/0.img/footerlineicon.png" id="footer-logo-img-sns" alt="" />
				</div>
				<div>Copyright 2023. MGKD.All rights reserved</div>
			</div>
		</div>
	</div>
	<!-- Footer풋터 끝 -->
	</div>
</body>
</html>