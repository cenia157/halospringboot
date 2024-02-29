<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/popup/0.css/popupContent.css" />
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/popup/0.js/popup.js"></script>
</head>
<body>
	<div class="content-m-td-3">
		<div class="popup-content">
			<div class="popup-tbl">
			<div class="popup-tr">
			<div class="popup-title"><h1>現在popup</h1></div>
				<!-- ajax미리보기 이미지 박스 -->
				<div class="popup-td-img-box" id="popup_preview1" style="background-image: url('${pageContext.request.contextPath}/user/upload_imgs/popup/${pdto.p_img}');">
				</div>
				<div class="banner-td-3">
					<div>メニュー :&nbsp;</div>
					<input class="popup-input-line url-input" placeholder="${pdto.m_text}" id="banner_url1" name="banner_url1" type="text" readonly="readonly">
				</div>
				<div class="banner-td-3">
					<c:if test="${pdto.m_text=='URL' }">
					<div>url :&nbsp;</div>
					<input class="popup-input-line" placeholder="${pdto.p_url }" id="banner_url1" name="banner_url1" type="text" readonly="readonly">
					</c:if>
				</div>
				<form action="" id="onOffForm" method="post" enctype="multipart/form-data">
				<div class="banner-td-3">
					<div>Popup有無 :&nbsp;</div>
					<div class="radio">
					<input type="radio" onchange="checkPopupOnOff(0)" value="0" name="popup-radio" ${pdto.p_flag == '0' ? 'checked="checked"' : '' } > off 
					<input type="radio" onchange="checkPopupOnOff(1)" value="1" name="popup-radio" ${pdto.p_flag == '1' ? 'checked="checked"' : '' } > on
					</div>
				</div>
				</form>
			</div>
			<!-- 화살표 -->
			<div class="arrow">
				<img alt="" src="${pageContext.request.contextPath}/admin/0.img/Vector.png">
			</div>
				<div class="popup-tr">
				<div class="popup-title"><h1>プレビュー</h1></div>
				<!-- ajax미리보기 이미지 박스 -->
				<div class="popup-td-img-box" id="popup_preview2" style="background-image: url('${pageContext.request.contextPath}/admin/0.img/banner_preview_img.png');">
				</div>
				<!-- 빠른메뉴 설정(셀렉) -->
				<div class="popup-select-box">
				<div>メニュー :&nbsp;</div>
				<select class="popup-select popup-input-line" name="banner_menu1" id="popup_menu" onchange="changeInformBox()">
				<option value="info_com">会社について</option>
				<option value="info_map">施設アクセス</option>
				<option value="intro_announce">お知らせ</option>
				<option value="intro_album">アルバム</option>
				<option value="intro_employ">スタッフ募集</option>
				<option value="service_info">サービスの案内</option>
				<option value="service_apply">サービスの申し込み</option>
				<option value="faq">よくある質問</option>
				<option value="question">お問い合わせ</option>
				<option value="url">url</option>
				</select> 
				 </div>
				<!-- url 링크 -->
				<div class="sales-inform" id="informBox1">
				<div class="banner-td-2" id="urlBox">
				<div>url :&nbsp;</div>
				<input class="popup-input-line url-input" id="url-input" name="banner_url1" type="text">
				</div>
				<!-- 팝업(포스터) 이미지 설정 -->
				<div class="banner-td-2 upload-input-box">
				<div>イメージ :&nbsp;</div>
	<form action="BannerUploadC" id="fileUploadForm" method="post" enctype="multipart/form-data">
				<label for="popup_img">
				<div class="btn-upload popup-input-line">アップロード</div>
				</label>
				<input onchange="handleFileUpload()" hidden="" type="file" class="file_input" name="popup_img" id="popup_img">
				<input class="serverFileName" id="serverFileName" type="text" hidden="" value="empty">
			</form>
				</div>
				</div>
			</div>
		</div>
			<!-- 최종 변경 버튼 칸 -->
			<div class="content-button">
				<button onclick="submitBannerData()">変更</button>
			</div>
		</div>
	</div>
</body>
</html>