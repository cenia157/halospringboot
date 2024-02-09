let regBtnR = document.querySelector("#reg-btnR");
regBtnR.addEventListener("click", function() {
	let ckFormR = document.querySelector("#ck-formR");
	let seq = document.querySelector('#seq').value;
	let pageNum = document.querySelector('#pageNum');
	var checkVal = document.getElementsByName('checkVal')[0];
	const content = window.editorR.getData();
	const formDataR = new FormData(ckFormR);
	formDataR.set("txt", content);
	formDataR.set("seq", seq);
	console.log("--------------------");
	console.log(content);
	console.log(formDataR);
	const payload = new URLSearchParams(formDataR);
	console.log(payload);
	for (var pair of formDataR.entries()) {
		console.log(pair[0] + ": " + pair[1]);
	}

	var isTitleValid = false;
	var isTxtValid = false;
	var iskategorieValid = false;

	for (var pair of formDataR.entries()) {

		if (pair[0] === 'title') {
			if (pair[1] !== '') {
				console.log('제목 O')
				isTitleValid = true;
			} else {
				console.log('제목 X')
			}
		} else if (pair[0] === 'txt') {
			if (pair[1] !== '') {
				console.log('내용 O');
				isTxtValid = true;
			} else {
				console.log('내용 X');
			}
		}
		if (pair[0] === 'select') {
			console.log('카테고리 O');
			var iskategorieValid = true;
		}
	}
	if (isTitleValid && isTxtValid && iskategorieValid) {
		closeModalNR();
	}

	let CkeditorC123 = fetch("UpdateNoticeC", {
		method: "POST",
		body: payload,
		headers: {
			"Content-Type": "application/x-www-form-urlencoded", // 헤더 설정
		},
	})
		.then((response) => {
			if (!response.ok) {
				throw new Error("Network response was not ok");
			}
			return response.text();
		})
		.then((data) => {
//			console.log("POST 요청 성공:", data);
//			console.log(CkeditorC123);
			location.href ='NoticePagingC?p='+pageNum.value+'&seq='+seq+"&checkVal="+checkVal.value;
			window.editor.setData("");
			window.editorR.setData("");
		})
		.catch((error) => {
			console.error("POST 요청 실패:", error);
		});
}); // regBtn.addEventListener("click", function(event) {
	
