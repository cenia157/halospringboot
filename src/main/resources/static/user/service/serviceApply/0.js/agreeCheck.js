document.addEventListener('DOMContentLoaded', function() {
	// 페이지가 로드되면 실행될 코드
	//		let agreeForm = 
	let checkBox = document.getElementById("terms-agree");
	let myForm = document.getElementById("agreeFrom");


	let applyCheck = document.querySelector("#apply")
	applyCheck.addEventListener('click', function(event) {

		if (!checkBox.checked) {
			alert("同意チェックボックスを選択お願いします。");
			return false; // 폼 제출을 막습니다.
		}
		// 실제로 서버로 데이터를 전송하도록 폼 제출 로직을 추가할 수 있습니다.
		alert("申し込みが完了しました。");
		myForm.submit();
	})


});