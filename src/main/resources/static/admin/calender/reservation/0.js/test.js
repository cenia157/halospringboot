/////////////////////////////////////////날짜/////////////////////////////////////////////

let date = new Date(); // 현재 날짜(로컬 기준) 가져오기
let utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); // uct 표준시 도출
let kstGap = 9 * 60 * 60 * 1000; // 한국 kst 기준시간 더하기
let today = new Date(utc + kstGap); // 한국 시간으로 date 객체 만들기(오늘)

// 달력에서 표기하는 날짜 객체
let thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate());


let currentYear = thisMonth.getFullYear(); // 달력에서 표기하는 연
let currentMonth = thisMonth.getMonth(); // 달력에서 표기하는 월
let currentDate = thisMonth.getDate(); // 달력에서 표기하는 일

function asd() {
	document.querySelectorAll('.reservation-data').forEach(function(reservationElement) {
		reservationElement.remove();
	});

//	if (dateDetailModal == 1) {
//		document.querySelector('.detail-schedule').style.visibility = 'hidden';
//		dateDetailModal = 0;
//	}
//
//	if (dateModal == 1) {
//		document.querySelector('.date-modal').style.visibility = 'hidden';
//		dateModal = 0;
//	}
//
//	document.querySelector('.date-modal').style.visibility = 'hidden';
//	dateModal = 0;

//	if (clickButton == 'monthNext') {
//		thisMonth = new Date(currentYear, currentMonth + 1, 1);
//
//	} else if (clickButton == 'yearNext') {
//		thisMonth = new Date(currentYear, currentMonth + 12, 1);
//
//	} else if (clickButton == 'monthPrev') {
//		thisMonth = new Date(currentYear, currentMonth - 1, 1);
//
//	} else if (clickButton == 'yearPrev') {
//		thisMonth = new Date(currentYear, currentMonth - 12, 1);
//	}

	document.querySelector('.input-date').value = thisMonth.getFullYear() + '年 ' + (thisMonth.getMonth() + 1) + '月 ';
//	dateArr = new Array(32).fill(0);

	// 렌더링을 위한 데이터 정리
	currentYear = thisMonth.getFullYear();
	currentMonth = thisMonth.getMonth();
	currentDate = thisMonth.getDate();

	// 이전 달의 마지막 날 날짜와 요일 구하기
	let startDay = new Date(currentYear, currentMonth, 0);
	prevDate = startDay.getDate();
	prevDay = startDay.getDay();

	// 이번 달의 마지막날 날짜와 요일 구하기
	let endDay = new Date(currentYear, currentMonth + 1, 0);
	let nextDate = endDay.getDate();
	let nextDay = endDay.getDay();

	prevDateLength = prevDate - (prevDate - prevDay + 1);

	// console.log(prevDate, prevDay, nextDate, nextDay);

	// 현재 월 표기
	document.querySelector('.year-month').textContent = currentYear + '.' + (currentMonth + 1);

	// 렌더링 html 요소 생성
	calendar = document.querySelector('.dates');
	calendar.innerHTML = '';

	// 지난달
	for (let i = prevDate - prevDay + 1; i <= prevDate; i++) {
		let prevCalenderMonth = (currentMonth === 0) ? 12 : currentMonth
		let prevClanederYear = (prevCalenderMonth === 12) ? currentYear - 1 : currentYear;

		calendar.innerHTML = calendar.innerHTML + '<div class="day prev disable year' + prevClanederYear + ' month' + prevCalenderMonth + ' date' + i + '"><div><div class="month-date">' + i + '</div></div>'
	}

	// 이번달 1일부터 next date까지 돌림
	for (let i = 1; i <= nextDate; i++) {
		let currentCalenderMonth = currentMonth + 1 == 13 ? 1 : currentMonth + 1;

//		if (today.getMonth() == currentMonth && today.getFullYear() == currentYear && fixedDate() == i) {
//
//			// 오늘 날짜 표기
//			calendar.innerHTML = calendar.innerHTML + '<div class="day current year' + currentYear + ' month' + currentCalenderMonth + ' date' + i + '"><div><div class="month-date">' + i + '</div><input type="checkbox" class="dateCheckBox" value=0><img src="user/0.img/logo.png"></div></div>'
//			todayDate = today.getDate();
//			let currentMonthDate = document.querySelectorAll('.dates .current');
//			currentMonthDate[todayDate - 1].classList.add('today');
//			document.querySelector('.current.today img').style.top = -(document.querySelector('.month-date').getBoundingClientRect().height / 1.5) + 'px';
//		} else {
			//오늘 외 날짜
			calendar.innerHTML = calendar.innerHTML + '<div class="day current year' + currentYear + ' month' + currentCalenderMonth + ' date' + i + '"><div><div class="month-date">' + i + '</div><input type="checkbox" class="dateCheckBox" value=0></div></div>'

//		}
	}

	// 다음달
	for (let i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
		let nextCalenderMonth = (currentMonth + 2 === 13) ? 1 : currentMonth + 2;
		let prevClanederYear = (nextCalenderMonth == 1) ? (currentYear + 1) : currentYear;

		calendar.innerHTML = calendar.innerHTML + '<div class="day next disable year' + prevClanederYear + ' month' + nextCalenderMonth + ' date' + i + '"><div><div class="month-date">' + i + '</div></div>'
	}

	// 달력에 표시된 전월 현월 다음월 일 수 만큼 배열리스트 할당
	reservationArrayDate = new Array(prevDate - (prevDate - prevDay + 1) + (nextDate + 1) + (7 - nextDay == 7 ? 0 : 7 - nextDay));

	renderReservationScheduleList();

	getAllReservationAccept();

	console.log(reservationArrayDate)
}

// 예약 일정 렌더링
function renderReservationScheduleList() {
	let arrayCnt = 0;

	for (let i = 0; i < reservationScheduleList.length; i++) {
		if (reservationScheduleList[i].year == currentYear && reservationScheduleList[i].month == currentMonth + 1) {
			let datesLength = reservationScheduleList[i].dates.split(',').length;
			if (datesLength > 1) {
				document.querySelector('.ins-tr-3-reservation-content').innerHTML += '<input type="hidden" value="' + i + '"><div class="reservation-data array' + arrayCnt + '"><div>' + reservationScheduleList[i].userName + '</div><div>' + reservationScheduleList[i].service
					+ '</div><div><input type="hidden" value="' + reservationScheduleList[i].dates + '">' + reservationScheduleList[i].year.slice(2) + '-' + reservationScheduleList[i].month + '-' + reservationScheduleList[i].dates.split(',')[0] + '...' + '</div><div><a class="reservation-select">선택</a></div></div>'
				arrayCnt++;
			} else {
				document.querySelector('.ins-tr-3-reservation-content').innerHTML += '<input type="hidden" value="' + i + '"><div class="reservation-data array' + arrayCnt + '"><div>' + reservationScheduleList[i].userName + '</div><div>' + reservationScheduleList[i].service
					+ '</div><div><input type="hidden" value="' + reservationScheduleList[i].dates + '">' + reservationScheduleList[i].year.slice(2) + '-' + reservationScheduleList[i].month + '-' + reservationScheduleList[i].dates + '</div><div><a class="reservation-select">선택</a></div></div>'
				arrayCnt++;
			}
		}
	}

}
