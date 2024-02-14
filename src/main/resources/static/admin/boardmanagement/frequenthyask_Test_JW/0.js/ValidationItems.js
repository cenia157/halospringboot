function noValue() {

	let titleCheck = document.querySelector('#real-title-editor').value;
	let contentCheck = window.editor.getData();
	//	여기에 추가로 제목, 내용의 길이가 최대값을 넘어갈 시 alart을 띄우는 곳이다
	let titleLengthCheck = titleCheck.length;
	let contentLengthCheck = contentCheck.length;

	if (!titleCheck) {
		alert("제목의 값을 입력하세요");
	} else if (contentCheck == "") {
		alert("내용을 입력하세요");
	} else if (titleLengthCheck > 50) {
		alert('제목의 길이는 50자를 넘을 수 없습니다.\n현재 글자 수 : ' + titleLengthCheck);
	} else if (contentLengthCheck > 10000) {
		alert('내용의 길이는 10,000 넘을 수 없습니다.\n현재 내용의 길이 : ' + contentLengthCheck);
	} else {

	}


};