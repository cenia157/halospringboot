<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/admin/dashboard/0.css/dashboard.css">
<script src="/admin/dashboard/0.js/dashboard.js"></script>
</head>
<body>

	<div class="deshboard-content">
		<div class="deshboard-content-box">
			<!-- 			<div class="deshboard-todo-box-1"> -->
			<!-- 				<div class="deshboard-todo-title-1">오늘의 할일</div> -->
			<!-- 				<div class="deshboard-todo-list-1 todayList"> -->
			<!-- 					안에 넣을 예시 -->
			<!-- 					<div class="deshboard-todo today">● 이것 저것</div> -->
			<!-- 				</div> -->
			<!-- 			</div> -->
			<div class="deshboard-todo-box-area">
				<div class="deshboard-todo-box-2">
					<div class="deshboard-todo-title-2">予約内容</div>
					<div class="deshboard-todo-list-2">
						<!-- List 목록-->
						<div class="deshboard-todo reservation">
							<div class="deshboard-todo-cell service">No</div>
							<div class="deshboard-todo-cell name">利用者</div>
							<div class="deshboard-todo-cell phonNum">連絡先</div>
							<div class="deshboard-todo-cell time">時間</div>
						</div>
						<div class="reservationList"></div>
					</div>
				</div>
				<div class="deshboard-todo-box-2">
					<div class="deshboard-todo-title-2 qa">未回答のお問い合わせ</div>
					<div class="deshboard-todo qa">
						<div class="deshboard-todo-cell service">No</div>
						<div class="deshboard-todo-cell title">タイトル</div>
						<div class="deshboard-todo-cell writer">投稿者</div>
						<div class="deshboard-todo-cell reg-date">投稿日</div>
					</div>
					<div class="deshboard-todo-list-2 qalist">
						<!-- 안에 넣을 예시 -->
					</div>
				</div>
			</div>
			<div class="deshboard-todo-box-area">
				<div class="deshboard-todo-box-2">
					<div class="deshboard-todo-title-2">今日の会社のスケジュール</div>
					<div class="deshboard-todo company">
						<div class="deshboard-todo-cell service">No</div>
						<div class="deshboard-todo-cell company-title">日程</div>
						<div class="deshboard-todo-cell company-txt">内容</div>
					</div>
					<div class="deshboard-todo-list-2 eventlist">
						<!-- 안에 넣을 예시 -->
					</div>
				</div>
				<div class="deshboard-todo-box-2">
					<div class="deshboard-todo-title-2">今日の勤務者</div>
					<div class="deshboard-todo staff">
						<div class="deshboard-todo-cell service">No</div>
						<div class="deshboard-todo-cell staff-name">勤務者</div>
						<div class="deshboard-todo-cell staff-position">ポジション</div>
						<div class="deshboard-todo-cell staff-phone">連絡先</div>
					</div>
					<div class="deshboard-todo-list-2 staffList">
						<!-- 안에 넣을 예시 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>