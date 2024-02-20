<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 해당페이지 css -->
<link rel="stylesheet"
	href="/user/information/company/0.css/information.css" />
	<!-- 반응형 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="com-content-tbl">
	
		<div class="content-box-tbl">
			<div class="content-box-tr">
				<div class="content-box-td1 btn-pointer" onclick="location.href='/introduce/company'">
					<a href="InfoCompanyC">会社について</a>
				</div>
				<div class="content-box-td2 btn-pointer" onclick="location.href='/introduce/map'">
					<a href="InfoMapC">施設アクセス</a>
				</div>
			</div>

			<div class="introduce-tr-box">
				<div class="introduce-td1">
					<img src="${pageContext.request.contextPath}/user/0.img//home.png"
						 alt="" /> > 紹介 > 会社について
				</div>
				<div class="introduce-td2">挨拶言葉</div>
			</div>

			<div class="introduce-tbl">
				<div class="introduce-tr">
					<div class="introduce-td-img">
						<img src="${pageContext.request.contextPath}/user/0.img/hands.jpg"
							alt="" />
						<div class="introduce-txt-tbl">
							<div class="introduce-txt-tr">私たち 'ハロー'は...</div>
							<div class="introduce-txt-tr">
								“ハローの職員のみんなはハローをご利用くださる<br />すべての家族の皆様が幸せになりますように<br /> 
								世の中が暖かさでひとつになる日まで最善を尽くします。”
							</div>
							<div class="introduce-txt-tr">- 代表社員 ： 大出 昭子 -</div>
						</div>
						<div class="introduce-txt-tr2">
							<div class="introduce-txt-td">
								弊社は、お客様に合わせた訪問介護サービスと<br /> 介護タクシーサービスを運営しています。<br />
								より専門的な職員教育を通して、高齢者の方々に家族のような暖かさと<br /> クオリティの高いサービスを提供しています。<br />
								皆さんに信頼一筋で力を尽くします。<br /> ありがとうございます。
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>