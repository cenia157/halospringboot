<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous">
</script>
<script src="${pageContext.request.contextPath}/admin/0.js/test.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/0.css/test copy.css" />
<body>
<!--
본 파일은 임시로 만든 파일이며 /admin/index.jsp 의 인클루드를 테스트하기 위해 임시로 만든 페이지다
따라서 나중에 본 파일은 삭제해도 무방하며 인클루드를 통해 해당폴더의 /admin/XXXXX/XXXXXContent.jsp를 연결하면 된다
 -->
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
							<img src="${pageContext.request.contextPath}/admin/0.img/admintble2-1.png" alt="">大出 昭子
						</div>
						<div>
							<img src="${pageContext.request.contextPath}/admin/0.img/admintble2-2.png" alt=""><a href="">사이트
								바로가기</a>
						</div>
					</div>
				</div>
				<div class="menu-td-3">
					<div class="menu-td-3-td-1">사이트관리</div>
					<div class="menu-td-3-td-2">
						<div class="menu-td-3-td-open-td-1">
							<img src="${pageContext.request.contextPath}/admin/0.img/admintble3-1.png" alt=""><a href="">대시보드</a>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="${pageContext.request.contextPath}/admin/0.img/admintble3-2.png" alt=""><span>홈페이지수정</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">로고변경</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">주요메뉴설정</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">하단배너설정</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">회사정보변경</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="${pageContext.request.contextPath}/admin/0.img/admintble3-3.png" alt=""><span>게시판관리</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">공지사항</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">문의사항</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">자주묻는질문</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="${pageContext.request.contextPath}/admin/0.img/admintble3-4.png" alt=""><span>일정</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">회사의일정</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">고객의예약</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">직원근무일정</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="${pageContext.request.contextPath}/admin/0.img/admintble3-5.png" alt=""><span>고객관리</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">통계</a>
									</div>
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">고객정보관리</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="${pageContext.request.contextPath}/admin/0.img/admintble3-6.png" alt=""><span>관리자전용</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">직원등록</a>
									</div>
								</div>
							</div>
						</div>
						<div class="menu-td-3-td-open-td-2">
							<div class="menu-td-3-td-open-td-2-td-1">
								<img src="${pageContext.request.contextPath}/admin/0.img/admintble3-7.png" alt=""><span>팝업관리</span>
							</div>
							<div class="menu-td-3-td-open-td-2-con">
								<div class="menu-td-3-td-open-td-2-con-td-2">
									<div class="menu-td-3-td-open-td-2-con-td-2-select">
										<img src="${pageContext.request.contextPath}/admin/0.img/admintble-select.png" alt=""><a href="">팝업설정</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="menu-td-4">
					<div class="menu-td-4-td">
						<div>
							<img src="${pageContext.request.contextPath}/admin/0.img/adminfootericon.png" alt="">日本語
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="right-tbl">
			<!-- 오른쪽 테이블 open -->
			<div class="header-tr">
				<div class="header-td">
					<div class="header-td-user">
						<div>大出 昭子</div>
					</div>
					<div class="header-td-button">
						<div>
							<a href="">나가기</a>
						</div>
						<div>
							<a href="">시간연장</a>
						</div>
					</div>
				</div>
			</div>
			<div class="content-tr">
				<div class="content-main-td">
					<div class="content-m-td-1">
						<!-- *************** 수정 *************** -->
						<div class="content-m-td-title">팝업설정</div>
					</div>
					<div class="content-m-td-2">
						<jsp:include page="/admin/homepageSetting/banner/bannerContent.jsp"></jsp:include>
					</div>
				</div>
				<!-- *************** 수정 *************** -->
			</div>
		</div>
		<!-- 오른쪽 테이블 close -->
	</div>
	<!-- 최상위 콘테이너 close-->
</body>

</html>