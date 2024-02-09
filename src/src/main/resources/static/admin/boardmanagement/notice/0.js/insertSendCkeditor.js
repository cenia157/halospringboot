let regBtn = document.querySelector("#reg-btn");

regBtn.addEventListener("click", function() {
	
	if(!noValue()){
		return false;
	}
	
	let ckForm = document.querySelector("#ck-form");
	let writer = document.querySelector("#regBtnHiddenInput").value;
	const content = window.editor.getData();
	const formData = new FormData(ckForm);
	formData.set("txt", content);
	formData.set("writer", writer)
	const payload = new URLSearchParams(formData); 
	
	for (var pair of formData.entries()) {
		console.log(pair[0] + ": " + pair[1]);
	}

	var isTitleValid = false;
	var isTxtValid = false;
	var iskategorieValid = false;

	for (var pair of formData.entries()) {

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

	console.log("--------------------");
	    fetch("CkEditorC", {
			method: "POST",
			body: payload,
			headers: {"Content-Type": "application/x-www-form-urlencoded", // 헤더 설정
		},
	})
		.then((response) => {
			if (!response.ok) {
				throw new Error("Network response was not ok");
			}
			return response.text();
		})
		.then((data) => {
			console.log("POST 요청 성공: 이거맞음?????", data);
			ckForm.submit();
			window.editor.setData("");
			window.editorR.setData("");
			console.log('여기까지 도달하는지 확인')
		})
		.catch((error) => {
			console.error("POST 요청 실패:", error);
		});
}); // regBtn.addEventListener("click", function(event) {