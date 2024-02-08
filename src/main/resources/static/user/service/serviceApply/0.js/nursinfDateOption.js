window.onload=function(){
	
	// 년도 선택 옵션 생성
	var yearSelect = document.getElementById("userYear");
	var currentYear = new Date().getFullYear();
	for (var year = currentYear; year >= 1900; year--) {
		var option = document.createElement("option");
		option.text = year;
		option.value = year;
		yearSelect.appendChild(option);
	}

	// 월 선택 옵션 생성
	var monthSelect = document.getElementById("userMonth");
	for (var month = 1; month <= 12; month++) {
		var option = document.createElement("option");
		option.text = month;
		option.value = month;
		monthSelect.appendChild(option);
	}

	// 일 선택 옵션 생성 (1일부터 31일까지)
	var daySelect = document.getElementById("userDay");
	for (var day = 1; day <= 31; day++) {
		var option = document.createElement("option");
		option.text = day;
		option.value = day;
		daySelect.appendChild(option);
	}
}