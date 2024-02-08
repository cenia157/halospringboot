<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous">
	
</script>
<script
	src="${pageContext.request.contextPath}/admin/calender/employee/0.js/employee.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/calender/employee/0.css/employee.css" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="company-padding">
		<div class="company-con">
			<div class="sec_cal">
				<div class="cal_nav">
					<a href="javascript:;" class="nav-btn go-year-prev"></a> <a
						href="javascript:;" class="nav-btn go-prev"></a>
					<div class="year-month"></div>
					<a href="javascript:;" class="nav-btn go-next"></a> <a
						href="javascript:;" class="nav-btn go-year-next"></a>
				</div>
				<div class="days">
					<div class="day">MON</div>
					<div class="day">TUE</div>
					<div class="day">WED</div>
					<div class="day">THU</div>
					<div class="day">FRI</div>
					<div class="day">SAT</div>
					<div class="day">SUN</div>
				</div>
				<div class="dates"></div>
				
				<div class="date-modal">
					<div class="date-modal-header">
						<div class="date-modal-title"></div>
						<div class="modal-close"></div>
					</div>
					<div class="date-modal-content"></div>
				</div>

				<div class="confirm-delete">
					<div class="confirm-delete-content">
						<div class="confirm-delete-content-announce">해당직원의 일정을 삭제하시겠습니까?</div>
						<div class="confirm-delete-content-accept">
							<div class="confirm-delete-agree"
								onclick="siftDelete()">確認</div>
							<div class="confirm-delete-disagree"
								onclick="siftDeleteClose()">取り消し</div>
						</div>
					</div>
				</div>

			</div>
			<form class="company-form" action="InsertCompanyC" method="post">
				<div class="sec-ins">
					<div class="ins-tr-1">
						<div class="ins-tr-td">
							<div class="ins-tr-td-btn">
								会社 <input type="checkbox" class="toggle" hidden> <label
									for="toggle" class="toggleSwitch"> <span
									class="toggleButton"></span>
								</label>
							</div>
						</div>
						<div class="ins-tr-td">
							<div class="ins-tr-td-btn">
								予約 <input type="checkbox" class="toggle" hidden> <label
									for="toggle" class="toggleSwitch"> <span
									class="toggleButton"></span>
								</label>
							</div>
						</div>
						<div class="ins-tr-td">
							<div class="ins-tr-td-btn">
								スタッフ <input type="checkbox" class="toggle" hidden> <label
									for="toggle" class="toggleSwitch"> <span
									class="toggleButton"></span>
								</label>
							</div>
						</div>
					</div>

					<div class="ins-tr-2">
						<div>スタッフリスト</div>
					</div>
					<div class="ins-tr-3">
						<div class="ins-tr-3-employee-header">
							<div>No</div>
							<div>名前</div>
							<div>出勤日数</div>
							<div>連絡先</div>
						</div>
						<div class="ins-tr-3-employee-content"></div>
						<div class="ins-tr-3-btn">
							<input class="input-date" type="hidden">
							<button type="button" class="company-button"
								onclick="insertSift()">割り当てる</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>