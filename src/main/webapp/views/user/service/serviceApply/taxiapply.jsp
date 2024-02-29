<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
<link rel="stylesheet"
	href="/user/service/serviceApply/0.css/taxiapply.css" />
	<script src="/user/service/serviceApply/0.js/taxiDateOption.js">
    </script>
</head>
<body>

		<form action="/service/apply/step5/agree" method="post">
		<input type="hidden" name="selectedStart" value="${selectedStart }">
		<input type="hidden" name="selectedEnd" value="${selectedEnd }">
		<input type="hidden" name="selectedTime" value="${selectedTime }">
		<input type="hidden" name="addr" value="${addr }">
		<input type="hidden" name="niText" value="${niText }">
		<input type="hidden" id="getYear" value="${userYear }">
		<input type="hidden" id="getMonth" value="${userMonth }">
		<input type="hidden" id="getDay" value="${userDay }">
		
	<div class="content-applyform-td">
		<div class="content-applyform-tr-1">
			<div class="categotyselect" name="category" id="category">
				「介護タクシーサービス」申請に必要な情報を入力してください。</div>
		</div>
		<div class="content-applyform-td2">
			<div class="content-applyform-tr-2">
				<span class="content-applyform-tr-2-1">申込者の姓名* :</span> <input
					name="applicant" value="${applicant }" class="content-applyform-tr-2-2" type="text" required="required">
			</div>
			<div class="content-applyform-tr-2">
				<span class="content-applyform-tr-2-1">連絡先* :</span> <input
						name="phoneNum" value="${phoneNum }" class="content-applyform-tr-2-2" type="text" required="required">
				</div>
			<div class="content-applyform-tr-2">
				<span class="content-applyform-tr-2-1">介護対象者の姓名* :</span> <input
					name="userName" value="${userName }" class="content-applyform-tr-2-2" type="text" required="required">
			</div>
					<div class="content-applyform-tr-2">
					<span class="content-applyform-tr-2-1">介護対象者の性別* : 	</span> 
					<div class="content-applyform-tr-2-2">
					<input  class="content-applyform-tr-2-3" id="man" name="userGender" type="radio" value="m"  ${manChecked }>
					<label for="man"> 
							男
						</label>
					<input class="content-applyform-tr-2-3" id="woman" name="userGender" type="radio" value="w" ${womanChecked }>
						<label for="woman">
							女
						</label>
					</div>
				</div>
				<div class="content-applyform-tr-2">
				<span class="content-applyform-tr-2-1">介護対象者の生年月日 * :</span>
					<div class="content-applyform-tr-2-4">
					 <label for="userYear">
					<select id="userYear" name="userYear" value="${userYear }" required="required"> <option disabled selected>年</option></select>年</label>

					<label for="userMonth">
					<select id="userMonth" name="userMonth" value="${userMonth }" required="required"><option disabled selected>月</option></select>月</label>

					<label for="userDay">
					<select id="userDay" name="userDay" value="${userDay }" required="required"><option disabled selected>日</option></select>日</label>
					</div>
				</div>
			<div class="content-applyform-tr-2">
				<span class="content-applyform-tr-2-1">出発先* :</span> <input
					name="startAddr" class="content-applyform-tr-2-2" type="text" required="required">
			</div>
			<div class="content-applyform-tr-2">
				<span class="content-applyform-tr-2-1">目的地* :</span> <input
					name="endAddr" class="content-applyform-tr-2-2" type="text" required="required">
			</div>
			<div class="content-applyform-tr-2">
				<span class="content-applyform-tr-2-1">特異事項* :</span> <textarea
					 name="tiText" class="content-applyform-tr-2-2" ></textarea>
			</div>
		</div>
		<div class="content-cal-btn-box-td">
		<button class="content-cal-btn-td">次へ</button>
		</div>
	</div>
	</form>

</body>

</html>