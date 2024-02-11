<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- <link -->
<!-- 	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular" -->
<!-- 	rel="stylesheet" /> -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous">
	
</script>
<script
	src="${pageContext.request.contextPath}/admin/calender/reservation/0.js/reservation.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/calender/reservation/0.css/reservation.css" />
</head>

<head>
<meta charset="UTF-8">
<title>Document</title>
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

				<div class="reservation-modal">
					<div class="reservation-modal-header">
						<div class="reservation-modal-title">タイプ</div>
						<div class="reservation-modal-content-time">
							午前 <input type="checkbox" class="update-time-checkBox" name="update-time" value="AM">
							午後 <input type="checkbox" class="update-time-checkBox" name="update-time" value="PM">
						</div>
						<div class="reservation-modal-close"></div>
					</div>
					<div class="reservation-modal-content">
						<div class="reservation-modal-content-name">名前</div>
						<div class="reservation-modal-content-phone">連作先</div>
						<div class="reservation-modal-content-addr">住所</div>
						<div class="reservation-modal-content-book">日付</div>
						<div class="reservation-modal-content-start">出発先</div>
						<div class="reservation-modal-content-startpoint">出発住所</div>
						<div class="reservation-modal-content-end">目的先</div>
						<div class="reservation-modal-content-endpoint">目的住所</div>
						<div class="reservation-modal-content-notice">予約内容</div>
						<div class="reservation-modal-content-manager">
							<div class="reservation-modal-content-manager-select">
								<div class="default-manager">スタッフ選び</div>
								<div class="manager-select-arrow"></div>
							</div>
							<div class="manager-select-option"></div>
						</div>
					</div>

					<div class="reservation-modal-agree-btn">
						<div class="reservation-modal-agree"
							onclick="reservationAccept(this)">承認</div>
						<div class="reservation-modal-disagree"
							onclick="reservationAccept(this)">拒否</div>
					</div>

					<div class="reservation-modal-update-btn">
						<div class="reservation-modal-update">修正</div>
						<div class="reservation-modal-delete"
							onclick="reservationDeleteConfirm()">削除</div>
					</div>

					<div class="reservation-modal-detail-btn">
						<div class="reservation-modal-update"
							onclick="reservationConfirm(this)">確認</div>
						<div class="reservation-modal-delete"
							onclick="reservationCancel(this)">取り消し</div>
					</div>
				</div>
				
				<div class="confirm-delete">
					<div class="confirm-delete-content">
						<div class="confirm-delete-content-announce">この予約を削除しますか</div>
						<div class="confirm-delete-content-accept">
							<div class="confirm-delete-agree"
								onclick="reservationDelete()">確認</div>
							<div class="confirm-delete-disagree"
								onclick="reservationDeleteCancle()">取り消し</div>
						</div>
					</div>
				</div>

				<div class="date-modal">
					<div class="date-modal-header">
						<div class="date-modal-title"></div>
						<div class="modal-close"></div>
					</div>
					<div class="date-modal-content"></div>
				</div>
				<div class="backrop"></div>

				<div class="detail-schedule">
					<div class="detail-schedule-header">
						<div class="detail-schedule-title"></div>
						<div class="detail-schedule-close modal-close"></div>
					</div>
					<div class="detail-schedule-content"></div>
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
						<div class="reservation-title">予約リスト</div>
						<input class="reservation-insert-input reservation-insert-service"
							style="width: 50%;" value="タイプ">
						<div class="reservation-insert-input reservation-insert-time">
							午前 <input type="checkbox" name="insert-time" value="AM">
							午後 <input type="checkbox" name="insert-time" value="PM">
							<div class="time-trouble-modal">時間を選択してください！</div>
						</div>

					</div>
					<div class="ins-tr-3">
						<div class="ins-tr-3-reservation-header">
							<div>利用者</div>
							<div>タイプ</div>
							<div>日付</div>
							<div></div>
						</div>
						<div class="ins-tr-3-reservation-content"></div>

						<div class="reservation-insert">
							<div class="reservation-insert-name">
								利用者 <input class="reservation-insert-input" style="width: 80%;">
							</div>
							<div class="reservation-insert-phone">
								連絡先 <input class="reservation-insert-input" style="width: 80%;">
							</div>
							<div class="reservation-insert-addr">
								住所 <input class="reservation-insert-input" style="width: 80%;">
							</div>
							<div class="reservation-insert-book">
								日付 <input class="reservation-insert-input input-date"
									style="width: 80%;" readonly="readonly">
							</div>
							<div class="reservation-insert-start">出発先</div>
							<div class="reservation-insert-startpoint">
								<input class="reservation-insert-input" style="width: 100%;">
							</div>
							<div class="reservation-insert-end">目的先</div>
							<div class="reservation-insert-endpoint">
								<input class="reservation-insert-input" style="width: 100%;">
							</div>
							<div class="reservation-insert-notice">
								<textarea class="reservation-insert-input" placeholder="予約内容"></textarea>
							</div>
							<div class="reservation-modal-content-manager">
								<div
									class="reservation-modal-content-manager-select select-insert">
									<div class="default-manager">スタッフ選び</div>
									<div class="manager-select-arrow"></div>
								</div>
								<div class="insert-manager-select-option"></div>
							</div>
						</div>
						<div class="ins-tr-3-btn">
							<button type="button" class="reservation-button">新規</button>
						</div>

						<div class="ins-tr-3-btn-insert">
							<div class="ins-tr-3-btn-insert-accept">登録</div>
							<div class="ins-tr-3-btn-insert-cancel">取り消し</div>
						</div>

					</div>
				</div>
			</form>
		</div>
	</div>
</body>

</html>