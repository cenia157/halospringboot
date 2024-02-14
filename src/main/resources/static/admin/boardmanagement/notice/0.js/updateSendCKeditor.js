let regBtnR = document.querySelector("#reg-btnR");
regBtnR.addEventListener("click", function() {
	let ckFormR = document.querySelector("#ck-formR");
	let seq = document.querySelector('#seq').value;
//	let pageNum = document.querySelector('#pageNum');
//	let checkVal = document.getElementsByName('checkVal')[0];
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

	fetch("/admin/boardManagement/notice/updateNotice", {
		method: "Put",
		body: payload,
		headers: {
			"Content-Type": "application/x-www-form-urlencoded", 
		},
	})
		.then((response) => {
			if (!response.ok) {
				throw new Error("Network response was not ok");
			}
			return response.text();
		})
		.then((data) => {

			window.editor.setData("");
			window.editorR.setData("");
			
			let url = window.location.href; 
			let parts = url.split('/');
			
			// 끝에서 두 번째 값 (String checkVal)
			let checkVal = parts[parts.length - 2];
			// 끝에서 세 번째 값 (int p)
			let p = parseInt(parts[parts.length - 3], 10);
			
			console.log('p ::: ' + p); 
			console.log('checkVal :::' + checkVal);
			console.log('seq :::' + seq)
			
			location.href = `/admin/boardManagement/notice/${p}/${checkVal}/${seq}`;
		})
		.catch((error) => {
			console.error("POST 요청 실패:", error);
		});
}); // regBtn.addEventListener("click", function(event) {
	
