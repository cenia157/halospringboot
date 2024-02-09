<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<title>Document</title>
<!-- font -->
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />

<!-- jquery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous">
	
</script>

<!-- 메뉴 js -->
<script src="admin/_js/test.js"></script>

<!-- 메뉴 css -->
<link rel="stylesheet" href="admin/0.css/test copy.css" />
<body>
	<!-- 최상위 콘테이너 -->
	<div class="container">

		<!-- 왼쪽 테이블 -->
		<div class="left-tbl">
			<div class="menu-tr">
				<div class="menu-td-1">
					<a href="">ハロー</a>
				</div>
				<div class="menu-td-2">
					<div class="menu-td-2-td">
						<div>
							<img src="admin/0.img/admintble2-1.png" alt="">${login_name }
						</div>
						<!-- 메인홈페이지 바로가기 -->
						<div>
							<img src="admin/0.img/admintble2-2.png" alt=""><a href="HC">サイトへの移動</a>
						</div>
					</div>
				</div>
				<div class="menu-td-3">
					<div class="menu-td-3-td-1">サイト管理</div>
					<div class="menu-td-3-td-2">
						<div class="menu-td-3-td-open-td-1">
							<img src="admin/0.img/admintble3-1.png" alt=""><a
								href="DashboardC">ダッシュボード</a>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="admin/0.img/admintble3-2.png" alt=""><span>ホームページ修正</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<!-- TODO 서효원 기능 서블렛 만들때마다 연결시키고 컨트롤러 if문 지우기! -->
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="LogoUploadC">ロゴ変更</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="MainBannerUpdateC">クイックメニュー設定</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="BannerUploadC">下のバナー設定</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="InformUpdateC">会社情報変更</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="admin/0.img/admintble3-3.png" alt=""><span>掲示板の管理</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="NoticeMainC?checkVal=01234">お知らせ</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="AskContentC?p=1">お問い合わせ</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="AdminFAQC">よくある質問</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="admin/0.img/admintble3-4.png" alt=""><span>スケジュール</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="CompanyC">会社のスケジュール</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="ReservationC">顧客の予約</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="EmployeeC">スタッフのスケジュール</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="admin/0.img/admintble3-5.png" alt=""><span>顧客管理</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="CustomerInfoMgmtC">顧客情報の管理</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="admin/0.img/admintble3-6.png" alt=""><span>管理者専用</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt=""><a
											href="StaffC">スタッフの管理</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="admin/0.img/admintble3-7.png" alt=""><span>ポップアップ</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="admin/0.img/admintble-select.png" alt="">
										<a href="PopupC">ポップアップの設定</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="menu-td-4">
					<div class="menu-td-4-td">
						<div>
							<img src="admin/0.img/adminfootericon.png" alt="">日本語
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 오른쪽테이블 -->
		<div class="right-tbl">

			<!-- 헤더 -->
			<div class="header-tr">
				<div class="header-td">
					<div class="header-td-user">
						<div>${login_name }</div>
					</div>
					<input type="hidden" id="sessionTimeoutVal"
						value="${sessionTimeout }">
					<div class="header-td-login">
						<p id="sessionTimeout" class="sessionTimeout">
							<img alt="" src="admin/0.img/timer.png"> <span id="timer"></span>
						</p>
						<div>
							<a href="#" id="extendTime">時間の延長</a>
						</div>
						<div>
							<a onclick="location.href='LogoutC'">ログアウト</a>
						</div>
					</div>
				</div>
			</div>

			<!-- 오른쪽 테이블 컨텐츠 -->
			<div class="content-tr">
				<div class="content-main-td">
					<div class="content-m-td-1">
						<div class="content-m-td-title">${menuname }</div>
					</div>
					<div class="content-m-td-2">
						<jsp:include page="${menu }"></jsp:include>
					</div>
				</div>
			</div>


		</div>

	</div>
</body>
<script src="admin/_js/loginSession.js"></script>
</html>