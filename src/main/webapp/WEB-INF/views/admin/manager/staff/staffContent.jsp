<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous">
	
</script>
<script
	src="/admin/manager/staff/0.js/staffContent.js" defer="defer"></script>
<link rel="stylesheet"
	href="/admin/manager/staff/0.css/staffContent.css" />
</head>

<head>
<meta charset="UTF-8">
<title>Document</title>
</head>

<body>
	<div class="staff-padding">
		<div class="staff-con">
			<!-- 			<div class="sec_cal"> -->
			<div class="ins-tr-1">
				<div id="staffList" class="staff-list">
					<div class="table-header">
						<div class="cell steff-num">No</div>
						<div class="cell steff-pos">ポジション</div>
						<div class="cell steff-name">名前</div>
						<div class="cell steff-callnum">連絡先</div>
						<div class="cell steff-addr">住所</div>
						<div class="cell steff-entryDate">入社日</div>
					</div>
					<div class="staff-table"></div>

				</div>
			</div>
			<!-- 			</div> -->
			<div class="staff-form">
				<div class="sec-ins">

					<div class="ins-tr-2">
						<div id="reg-title">職員登録</div>
						<div style="display: none" id="update-title">情報変更</div>
					</div>
					<div class="ins-tr-3">
						<div class="ins-tr-3-title">
							<div class="ins-tr-title-title">名前</div>
							<input type="text" class="ins-tr-3-td-input input-title"
								name="s_name" id="s_name"
								required="required">
						</div>
						<div class="ins-tr-3-title">
							<div class="ins-tr-title-title">ポジション</div>
							<input type="text" class="ins-tr-3-td-input input-title"
								name="s_position" id="s_position" required="required">
						</div>
						<div class="ins-tr-3-title">
							<div class="ins-tr-title-title">連絡先</div>
							<input type="text" class="ins-tr-3-td-input input-title"
								name="s_phone_num" id="s_phone_num"
								required="required">
						</div>
						<div class="ins-tr-3-title">
							<div class="ins-tr-title-title">入社日</div>
							<input type="date" class="ins-tr-3-td-input input-title"
								name="s_entry_date" id="s_entry_date"
								required="required">
						</div>

						<div class="ins-tr-3-title">
							<div class="ins-tr-title-color">カレンダー</div>
							<input type="color" list="colors"
								class="ins-tr-3-td-input input-color" name="s_color"
								id="s_color" value="#FFD700">
							<datalist id="colors">
								<option>#FFD700</option>
								<option>#DAA520</option>
								<option>#FF6347</option>
								<option>#FF4500</option>
								<option>#FF69B4</option>
								<option>#8A2BE2</option>
								<option>#4B0082</option>
								<option>#483D8B</option>
								<option>#0000FF</option>
								<option>#00BFFF</option>
								<option>#00FFFF</option>
								<option>#32CD32</option>
								<option>#008000</option>
								<option>#ADFF2F</option>
								<option>#FFC0CB</option>
								<option>#800000</option>
								<option>#F5DEB3</option>
							</datalist>

						</div>
						<div class="ins-tr-3-txt">
							<div class="ins-tr-txt-tr-title">住所</div>
							<textarea class="ins-tr-3-td-txt" name="s_addr"
								id="s_addr" required="required"></textarea>
						</div>
						<input type="hidden" id="s_no" name="s_no">
						<div class="ins-tr-3-btn">
							<button type="button" class="staff-button" id="staff-reg">登録</button>
							<button style="display: none;" type="button"
								class="staff-click-button" id="staff-update">変更</button>
							<button style="display: none;" type="button"
								class="staff-click-button" id="staff-update-c">帰る</button>
							<button style="display: none;" type="button"
								class="staff-click-button" id="staff-delete">削除</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>