<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nursing Apply</title>
<link rel="stylesheet"
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/user/service/serviceApply/0.css/nursingapply.css" />
		<script src="${pageContext.request.contextPath}/user/service/serviceApply/0.js/nursinfDateOption.js">
    </script>
</head>
<body>
	<!-- 신청폼 -->
	<form action="${nextStep}" method="post">
		<input type="hidden" name="selectedStart" value="${selectedStart }">
		<input type="hidden" name="selectedEnd" value="${selectedEnd }">
		<input type="hidden" name="selectedTime" value="${selectedTime }">
		<div class="na-content-applyform-td">
			<div class="na-content-applyform-tr-1">
				<div class="categotyselect" name="category" id="category">介護申請に必要な情報を入力してください。</div>
			</div>
			<div class="na-content-applyform-td2">
				<div class="na-content-applyform-tr-2">
					<span class="na-content-applyform-tr-2-1">申込者の姓名* :</span> <input
						name="applicant" class="na-content-applyform-tr-2-2" type="text"
						required="required">
				</div>
				<div class="na-content-applyform-tr-2">
					<span class="na-content-applyform-tr-2-1">連絡先* :</span> <input
						name="phoneNum" class="na-content-applyform-tr-2-2" type="text"
						pattern="[0-9]+" required="required">
				</div>
				<div class="na-content-applyform-tr-2">
					<span class="na-content-applyform-tr-2-1">介護対象者の姓名* :</span> <input
						name="userName" class="na-content-applyform-tr-2-2" type="text"
						required="required">
				</div>
				<div class="na-content-applyform-tr-2">
					<span class="na-content-applyform-tr-2-1">介護対象者の性別* : </span>
					<div class="na-content-applyform-tr-2-2">
						<input class="na-content-applyform-tr-2-3" id="man"
							name="userGender" type="radio" value="m" checked> <label
							for="man"> 男 </label> <input class="na-content-applyform-tr-2-3"
							id="woman" name="userGender" type="radio" value="w"> <label
							for="woman"> 女 </label>
					</div>
				</div>
				<div class="na-content-applyform-tr-2">
					<span class="na-content-applyform-tr-2-1">介護対象者の生年月日 * :</span>
					<div class="na-content-applyform-tr-2-4">
						<label for="userYear"> <select id="userYear"
							name="userYear" required="required">
								<option disabled selected>年</option>
						</select>年
						</label> <label for="userMonth"> <select id="userMonth"
							name="userMonth" required="required"><option disabled
									selected>月</option></select>月
						</label> <label for="userDay"> <select id="userDay" name="userDay"
							required="required"><option disabled selected>日</option></select>日
						</label>
					</div>
				</div>
				<div class="na-content-applyform-tr-2">
					<span class="na-content-applyform-tr-2-1">地域(訪問する住所)* :</span> <input
						name="addr" class="na-content-applyform-tr-2-2" type="text"
						required="required">
				</div>
				<div class="na-content-applyform-tr-2">
					<span class="na-content-applyform-tr-2-1">特異事項* :</span>
					<textarea name="niText" class="na-content-applyform-tr-2-2"></textarea>
				</div>
			</div>
			<div class="na-content-next-btn-box-td">
				<button class="na-content-next-btn-td">次へ</button>
				>
			</div>
		</div>
	</form>
</body>

</html>