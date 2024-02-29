<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 해당페이지 css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/user/information/map/0.css/map.css" />
<!-- Google Map API-->
<script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCoJHgg3IE796b40XaiM6M7cTjkbPWbYDo&callback=console.debug&libraries=maps,marker&v=beta">

</script>

<!-- 반응형 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="map-content-sec">
		<div class="content-box-tbl">
			<div class="content-box-tr">
				<div class="content-box-td1 btn-pointer" onclick="location.href='/introduce/company'">
					<a href="/introduce/company">会社について</a>
				</div>
				<div class="content-box-td2 btn-pointer" onclick="location.href='/introduce/map'">
					<a href="location.href='/introduce/map">施設アクセス</a>
				</div>
			</div>

			<div class="introduce-tr-box">
				<div class="introduce-td1">
					<img src="${pageContext.request.contextPath}/user/0.img//home.png"
					 alt="" /> > 紹介 > 施設アクセス
				</div>
				<div class="introduce-td2">施設アクセス</div>
			</div>
			<div class="introduce-tbl">
				<div class="introduce-tr">
					<!-- 구글맵 박스 -->
					<div class="map-tbl">
						<!-- (지도API) 들어올 자리  -->
						<div id="map" class="map-tr">
<!-- 							<gmp-map center="34.725521087646484,135.56072998046875" zoom="14" -->
<!-- 								map-id="DEMO_MAP_ID"> <gmp-advanced-marker -->
<!-- 								position="34.725521087646484,135.56072998046875" -->
<!-- 								title="My location"> </gmp-advanced-marker> </gmp-map> -->
								<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d243.7276948376925!2d135.56083939750414!3d34.72545567378211!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6000e1803b163eff%3A0x63157d2c53eb5a5a!2z44Oh44K-44OzIOOCqOODn-ODvOODqw!5e0!3m2!1sko!2skr!4v1705184709627!5m2!1sko!2skr"
								width="100%" height="100%" style="border: 0;" allowfullscreen=""
								loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
						</div>
						<div class="map-tr1">
							<div class="map-tr2">
								<div class="map-td">郵便番号 : 570-0062</div>
								<div class="map-td">住所 : 大阪府守口市馬場町3-14-6メゾンエミール701号</div>
								<div class="map-td">他のお問い合わせはお問い合わせ掲示板をご利用いただきます。</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>


