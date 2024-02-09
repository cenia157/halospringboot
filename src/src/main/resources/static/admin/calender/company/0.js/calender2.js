function fixedDate() {
	let date = new Date(); // 현재 날짜(로컬 기준) 가져오기
	let utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); // uct 표준시 도출
	let kstGap = 9 * 60 * 60 * 1000; // 한국 kst 기준시간 더하기
	let today = new Date(utc + kstGap); // 한국 시간으로 date 객체 만들기(오늘)

	return today.getDate();
}



window.onload = function() {
	let dateArr = new Array(32).fill(0);

	// console.log(new Date()); // 현재 날짜(로컬 기준) 객체 만들기
	// console.log(new Date(2021, 11, 6)); // 지정한 날짜 객체 만들기
	// console.log(new Date('2021-12-06T03:24:00')); // 지정한 날짜 객체 만들기

	let date = new Date(); // 현재 날짜(로컬 기준) 가져오기
	let utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); // uct 표준시 도출
	let kstGap = 9 * 60 * 60 * 1000; // 한국 kst 기준시간 더하기
	let today = new Date(utc + kstGap); // 한국 시간으로 date 객체 만들기(오늘)

	let thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate());
	// 달력에서 표기하는 날짜 객체


	let currentYear = thisMonth.getFullYear(); // 달력에서 표기하는 연
	let currentMonth = thisMonth.getMonth(); // 달력에서 표기하는 월
	let currentDate = thisMonth.getDate(); // 달력에서 표기하는 일



	// kst 기준 현재시간
	// console.log(thisMonth);

	// 캘린더 렌더링
	renderCalender(thisMonth);

	function renderCalender(thisMonth) {

		// 렌더링을 위한 데이터 정리
		currentYear = thisMonth.getFullYear();
		currentMonth = thisMonth.getMonth();
		currentDate = thisMonth.getDate();

		// 이전 달의 마지막 날 날짜와 요일 구하기
		let startDay = new Date(currentYear, currentMonth, 0);
		let prevDate = startDay.getDate();
		let prevDay = startDay.getDay();

		// 이번 달의 마지막날 날짜와 요일 구하기
		let endDay = new Date(currentYear, currentMonth + 1, 0);
		let nextDate = endDay.getDate();
		let nextDay = endDay.getDay();

		// console.log(prevDate, prevDay, nextDate, nextDay);

		// 현재 월 표기
		document.querySelector('.year-month').textContent = currentYear + '.' + (currentMonth + 1);

		// 렌더링 html 요소 생성
		calendar = document.querySelector('.dates')
		calendar.innerHTML = '';

		// 지난달
		for (let i = prevDate - prevDay + 1; i <= prevDate; i++) {
			calendar.innerHTML = calendar.innerHTML + '<div class="day prev disable">' + i + '</div>'
		}

		// 이번달
		for (let i = 1; i <= nextDate; i++) {

			if (today.getMonth() == currentMonth && today.getFullYear() == currentYear && fixedDate() == i) {
				calendar.innerHTML = calendar.innerHTML + '<div class="day current">' + i + '<img src="user/0.img/logo.png">' + '</div>'
				todayDate = today.getDate();
				let currentMonthDate = document.querySelectorAll('.dates .current');
				currentMonthDate[todayDate - 1].classList.add('today');
			} else {
				calendar.innerHTML = calendar.innerHTML + '<div class="day current">' + i + '</div>'
			}
		}

		// 다음달
		for (let i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
			calendar.innerHTML = calendar.innerHTML + '<div class="day next disable">' + i + '</div>'
		}

	}


	// 전년도로 이동
	document.querySelector('.go-year-prev').addEventListener('click', function() {
		thisMonth = new Date(currentYear, currentMonth - 12, 12);
		renderCalender(thisMonth);
	});

	// 이전달로 이동
	document.querySelector('.go-prev').addEventListener('click', function() {
		thisMonth = new Date(currentYear, currentMonth - 1, 1);
		renderCalender(thisMonth);
	});

	// 다음달로 이동
	document.querySelector('.go-next').addEventListener('click', function() {
		thisMonth = new Date(currentYear, currentMonth + 1, 1);
		renderCalender(thisMonth);
	});

	// 다음해로 이동
	document.querySelector('.go-year-next').addEventListener('click', function() {
		thisMonth = new Date(currentYear, currentMonth + 12, 12);
		renderCalender(thisMonth);
	});


	//클릭
	calendar.addEventListener("click", function(e) {
		if (e.target.className.includes("current")) {
			if (!e.target.style.backgroundColor) {
				e.target.style.backgroundColor = '#ACF6B3';


				//document.querySelector('.input-date').value += e.target.textContent;

				dateArr[e.target.textContent] = 1;

			} else {
				e.target.style.backgroundColor = '';

				dateArr[e.target.textContent] = 0;
			}

		}
		document.querySelector('.input-date').value = "";
		for (let i = 1; i <= dateArr.length; i++) {
			if (dateArr[i] == 1) {
				document.querySelector('.input-date').value += i + ',';
			}
		}
		
		document.querySelector('.input-date').value = document.querySelector('.input-date').value.slice(0,-1);
		
	});






	//스위치 토글
	let toggleList = document.querySelectorAll(".toggleSwitch");

	toggleList.forEach(function($toggle) {
		$toggle.onclick = function() {
			$toggle.classList.toggle('active');
		}
	});


};
