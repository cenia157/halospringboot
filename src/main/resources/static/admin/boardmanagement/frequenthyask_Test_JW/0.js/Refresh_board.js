/**
 * 여기는 게시글이 업로드되면 자동으로 게시글을 새로고침하기 위한 ajax 적용하는 곳
 */








var aaa = document.getElementById('#reg-btn')

var fd = new FormData($("#reviewForm")[0]);

$.ajax({
	url: "ajax_insert_review_v2.php",
	type: "POST",
	data: fd,
	async: false,
	cache: false,
	contentType: false,
	processData: false,
}).success(function(data) {
	if (data == "SUCCESS") {
		alert("리뷰가 등록되었습니다.");
		location.reload();
	} else {
		var arrTmp = data.split("||");
		if (arrTmp[0] === "FAIL") {
			alert(arrTmp[1]);
		} else {
			alert("리뷰가 등록이 실패하였습니다.");
		}
	}
});



