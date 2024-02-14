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
<link rel="stylesheet" href="user/service/serviceApply/0.css/agree.css" />
	

</head>
<body>

	<!-- step별 페이지  시작 -->
	<form action="/service/apply/step6/complet" method="post" id="agreeFrom">

		<input type="hidden" name="selectedStart" value="${selectedStart }">
		<input type="hidden" name="selectedEnd" value="${selectedEnd }">
		<input type="hidden" name="sa_time" value="${selectedTime }">
		<input type="hidden" name="sa_applicant" value="${applicant }"> <input
			type="hidden" name="sa_phone_number" value="${phoneNum }"> <input
			type="hidden" name="sa_user_name" value="${userName }"> <input
			type="hidden" name="sa_gender" value="${userGender }"> <input
			type="hidden" name="sa_year" value="${userYear }"> <input
			type="hidden" name="sa_month" value="${userMonth }"> <input
			type="hidden" name="sa_days" value="${userDay }"> <input
			type="hidden" name="sa_addr" value="${addr }"> <input
			type="hidden" name="sa_start_place" value="${startAddr }"> <input
			type="hidden" name="sa_end_place" value="${endAddr }"> <input
			type="hidden" name="sa_nursing_info" value="${niText }"> <input
			type="hidden" name="sa_taxi_info" value="${tiText }">


		<!-- 여기에 약관 내용을 삽입합니다 -->
		<div class="content-step-page-td">
			<h2>介護コールタクシーサービス規約</h2>
			<p>
				<strong>サービス概要:</strong>
				本サービスは、移動が困難なお客様を対象とした介護コールタクシーサービスです。車椅子を利用される方や歩行支援を必要とするお客様に最適なサービスを提供いたします。
			</p>
			<p>
				<strong>利用料金:</strong>
				料金は、ご利用になる距離と時間に基づいて算出されます。予約時に予想される料金を事前にお伝えいたします。
			</p>
			<p>
				<strong>予約方法:</strong>
				お客様は、電話または当社ウェブサイトを通じてサービスを予約することができます。ご利用希望日の最低24時間前にご予約ください。
			</p>
			<p>
				<strong>キャンセルポリシー:</strong>
				ご予約のキャンセルは、サービス開始予定時間の12時間前までにお願いいたします。それ以降のキャンセルについては、予約金の50%をキャンセル料として申し受けます。
			</p>
			<p>
				<strong>安全と保険:</strong>
				当社は全ての車両に対し、定期的な安全検査を実施しております。また、乗客と運転手を保護するための保険にも加入しています。
			</p>

			<h2>訪問介護サービス規約</h2>
			<p>
				<strong>サービス内容:</strong>
				当社の介護士がお客様の自宅を訪問し、日常生活の支援、身体活動の援助、食事の準備、及び基本的な家事を行います。
			</p>
			<p>
				<strong>サービス時間:</strong> 本サービスは、週に最大7日間、1日に最大8時間まで提供されます。
			</p>
			<p>
				<strong>料金体系:</strong> サービス料金は、提供時間に応じて設定されます。料金の詳細については、お問い合わせください。
			</p>
			<p>
				<strong>契約とキャンセル:</strong>
				サービス契約は、最低1ヶ月単位で締結されます。契約のキャンセルは、サービス開始予定日の1週間前までにご連絡ください。
			</p>
			<p>
				<strong>個人情報保護:</strong> お客様の個人情報は厳格に保護され、サービス提供の目的以外では一切使用されません。
			</p>
			<!-- 약관 내용 끝 -->

			<!-- 추가사항 1: 이용약관 동의 체크박스 -->
			<div class="checkbox-container">
				<label for="terms-agree">上記の事項に同意しました</label> <input type="checkbox"
					id="terms-agree" name="terms-agree" />
			</div>

			<!-- 추가사항 2: 신청 버튼 -->
			<div class="button-container">
				<button onclick="submitForm3()" type="button" id="apply">申し込み</button>

			</div>

			<!-- step별 페이지  끝-->
		</div>
	</form>

</body>
<script src="/user/service/serviceApply/0.js/agreeCheck.js"></script>

</html>