function fixedDate() {
	let date = new Date(); // 현재 날짜(로컬 기준) 가져오기
	let utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); // uct 표준시 도출
	let kstGap = 9 * 60 * 60 * 1000; // 한국 kst 기준시간 더하기
	let today = new Date(utc + kstGap); // 한국 시간으로 date 객체 만들기(오늘)

	return today.getDate();
}

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

// kst 기준 현재시간
// console.log(thisMonth);

// 전체 일정 배열리스트
let reservationScheduleList = new Array;

// 일정 스태프 리스트
let reservationStaffList = new Array;

// 예약 승인 리스트
let reservationAcceptList = new Array;

// 날짜 체크박스 클릭 배열
let dateArr = new Array(32).fill(0);

// 일별 일정 배열
let reservationArrayDate = new Array();

// 연, 월 버튼 초기값
let clickButton = "";

// 일정 상세 모달창 초기값
let dateModal = 0;

// 모달종류
let reservationModalValue = '';

// 디테일 모달 초기
let dateDetailModal = 0;

// 일정 렌더링을 위한 이전달 개수
let prevDateLength = 0;

// 모달생성시 해당날짜
let modalDivDate = '';

// 일정 삭제 이후 렌더시 필요 날짜
let prevDate = '';
let prevDay = '';

// 예약리스트 클릭
let reservationClickArray = '';

// 예약리스트 클릭시 날짜
let reservationClickDate = '';

// 예약리스트 선택 어레이번호
let reservationSelectArray = '';

// 예약 모달창 어레이정보
let arrayName = '';

// 예약리스트 모달 상태
let reservationModalStatus = 0;

// 예약리스트 셀렉트박스
let managerSelectValue = 0;

// 예약입력 셀렉트박스
let insertManagerSelectValue = 0;

// 예약삭제 확인 모달
let deleteScheduleModal = 0;

// 모달 드로그앤 드롭
let isDragging = false;
let modalOffsetX;
let modalOffsetY;

// 토글스위치
let toggle = '';

// 토글 리스트
let toggleList = [0, 1, 2];

// 일정 전체삭제 확인 모달
let confirmDeleteModal = 0;

function getAllSchedule() {

	// 전체 회사 일정 ajax 호출
	fetch('ReservationScheduleList')
		.then(response => response.json())
		.then(data => {

			// javascript배열에 ajax로 가져온 배열 입력
			reservationScheduleList = reservationScheduleList.concat(data);

			// 전체데이터 출력
			console.log(reservationScheduleList);

			// 스태프 조회
			getAllStaff();

			// 페이지 입장 시 렌더링
			renderMonth(reservationScheduleList, clickButton);

			// 전년도로 이동
			document.querySelector('.go-year-prev').addEventListener('click', function() {
				let clickButton = 'yearPrev';
				reservationClickArray = '';
				renderMonth(reservationScheduleList, clickButton);
			});

			// 이전달로 이동
			document.querySelector('.go-prev').addEventListener('click', function() {
				let clickButton = 'monthPrev';
				reservationClickArray = '';
				renderMonth(reservationScheduleList, clickButton);
			});

			// 다음달로 이동
			document.querySelector('.go-next').addEventListener('click', function() {
				let clickButton = 'monthNext';
				reservationClickArray = '';
				renderMonth(reservationScheduleList, clickButton);
			});

			// 다음해로 이동
			document.querySelector('.go-year-next').addEventListener('click', function() {
				let clickButton = 'yearNext';
				reservationClickArray = '';
				renderMonth(reservationScheduleList, clickButton);
			});

			// 버튼클릭
			calendar.addEventListener("click", function(e) {
				if (e.target.classList.contains('dateCheckBox')) {
					checkDate(e);
				}
			});

			// ++건수 클릭
			calendar.addEventListener("click", function(e) {
				if (e.target.textContent.includes('++') && e.target.closest('.current')) {
					expandReservationSchedule(e);
				}
			})

			// 달력에서 일정 클릭
			calendar.addEventListener("click", function(e) {
				if (e.target.className.includes('schedule') && e.target.children.length > 0 && e.target.closest('.current')) {

					reservationSelectArray = e.target.children[0].value;
					reservationModalValue = "direct";
					reservationDetailModal(e);
				}
			})

			// 예약 모달 내 수정 클릭
			document.querySelector('.reservation-modal-update').addEventListener("click", function(e) {
				reservationModalValue = "update";
				reservationDetailModal(e);
			})

			// 날짜 모달 내 세부사항 클릭
			document.querySelector('.date-modal-content').addEventListener("click", function(e) {
				if (e.target.classList.contains('getScheduleDetail')) {
					reservationSelectArray = e.target.previousSibling.previousSibling.value;
					reservationModalValue = "direct";
					reservationDetailModal(e);
				}
			})

			// 예약 리스트 클릭
			document.querySelector('.ins-tr-3-reservation-content').addEventListener("click", function(e) {
				if (e.target.parentNode.className.includes('reservation-data')) {
					reservationClick(e);
				}
			})

			// 예약 리스트 선택
			document.querySelector('.ins-tr-3-reservation-content').addEventListener("click", function(e) {
				if (e.target.className == 'reservation-select') {
					reservationSelectArray = e.target.closest('.reservation-data').previousSibling.value;
					reservationModalValue = "list";
					reservationDetailModal(e);
				}
			})

			// 예약 모달 닫기
			document.querySelector('.reservation-modal-close').addEventListener("click", function(e) {
				if (reservationModalStatus == 1) {
					reservationModalClose(e);
				}
			})

			// 신규 예약 등록
			document.querySelector('.reservation-button').addEventListener("click", function(e) {
				reservationInsertPageOn(e);
			})

			// 디테일창 드로그앤드롭
			reservationDetailDroDrop();

		})

		.catch(error => {
			console.error('데이터를 가져오는 중 오류 발생:', error);
		});
}

// 스태프 조회
function getAllStaff() {
	fetch('ReservationStaffList')
		.then(response => response.json())
		.then(data => {
			// javascript배열에 ajax로 가져온 배열 입력
			reservationStaffList = data;

			// 전체데이터 출력
			console.log(reservationStaffList);

		})
		.catch(error => {
			getAllStaff()

			console.error('데이터를 가져오는 중 오류 발생:', error);
		});
}


// 수락일정 조회
function getAllReservationAccept() {
	fetch('ReservationScheduleAccept')
		.then(response => response.json())
		.then(data => {
			// javascript배열에 ajax로 가져온 배열 입력
			reservationAcceptList = data;

			// 전체데이터 출력
			console.log(reservationAcceptList);

			// 객체화
			renderReservationSchedule();
		})
		.catch(error => {
			getAllReservationAccept();

			console.error('데이터를 가져오는 중 오류 발생:', error);
		});
}


// 초기 및 클릭 렌더링
function renderMonth(reservationScheduleList, clickButton) {
	document.querySelectorAll('.reservation-data').forEach(function(reservationElement) {
		reservationElement.remove();
	});

	if (dateDetailModal == 1) {
		document.querySelector('.detail-schedule').style.visibility = 'hidden';
		dateDetailModal = 0;
	}

	if (dateModal == 1) {
		document.querySelector('.date-modal').style.visibility = 'hidden';
		dateModal = 0;
	}

	document.querySelector('.date-modal').style.visibility = 'hidden';
	dateModal = 0;

	if (clickButton == 'monthNext') {
		thisMonth = new Date(currentYear, currentMonth + 1, 1);

	} else if (clickButton == 'yearNext') {
		thisMonth = new Date(currentYear, currentMonth + 12, 1);

	} else if (clickButton == 'monthPrev') {
		thisMonth = new Date(currentYear, currentMonth - 1, 1);

	} else if (clickButton == 'yearPrev') {
		thisMonth = new Date(currentYear, currentMonth - 12, 1);
	}

	document.querySelector('.input-date').value = thisMonth.getFullYear() + '年 ' + (thisMonth.getMonth() + 1) + '月 ';
	dateArr = new Array(32).fill(0);

	renderCalender(reservationScheduleList);
}


function renderCalender() {

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

		if (today.getMonth() == currentMonth && today.getFullYear() == currentYear && fixedDate() == i) {

			// 오늘 날짜 표기
			calendar.innerHTML = calendar.innerHTML + '<div class="day current year' + currentYear + ' month' + currentCalenderMonth + ' date' + i + '"><div><div class="month-date">' + i + '</div><input type="checkbox" class="dateCheckBox" value=0><img src="user/0.img/logo.png"></div></div>'
			todayDate = today.getDate();
			let currentMonthDate = document.querySelectorAll('.dates .current');
			currentMonthDate[todayDate - 1].classList.add('today');
			document.querySelector('.current.today img').style.top = -(document.querySelector('.month-date').getBoundingClientRect().height / 1.5) + 'px';
		} else {
			//오늘 외 날짜
			calendar.innerHTML = calendar.innerHTML + '<div class="day current year' + currentYear + ' month' + currentCalenderMonth + ' date' + i + '"><div><div class="month-date">' + i + '</div><input type="checkbox" class="dateCheckBox" value=0></div></div>'

		}
	}

	document.querySelectorAll('.dateCheckBox').forEach(function(e) {
		e.disabled = true;
	})

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
					+ '</div><div><input type="hidden" value="' + reservationScheduleList[i].dates + '">' + reservationScheduleList[i].year.slice(2) + '-' + reservationScheduleList[i].month + '-' + reservationScheduleList[i].dates.split(',')[0] + '...' + '</div><div><a class="reservation-select">選択</a></div></div>'
				arrayCnt++;
			} else {
				document.querySelector('.ins-tr-3-reservation-content').innerHTML += '<input type="hidden" value="' + i + '"><div class="reservation-data array' + arrayCnt + '"><div>' + reservationScheduleList[i].userName + '</div><div>' + reservationScheduleList[i].service
					+ '</div><div><input type="hidden" value="' + reservationScheduleList[i].dates + '">' + reservationScheduleList[i].year.slice(2) + '-' + reservationScheduleList[i].month + '-' + reservationScheduleList[i].dates + '</div><div><a class="reservation-select">選択</a></div></div>'
				arrayCnt++;
			}
		}
	}
}

// 예약 리스트 클릭
function reservationClick(e) {

	if (reservationClickArray != '') {
		document.querySelector('.reservation-data.' + reservationClickArray).children[3].children[0].style.display = 'none';
		document.querySelector('.reservation-data.' + reservationClickArray).style.backgroundColor = '#FFF';
		for (let i = 0; i < reservationClickDate.length; i++) {
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].style.backgroundColor = '#FFF';
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].children[1].checked = false;
		}
	}

	e.target.parentNode.children[3].children[0].style.display = 'flex';
	e.target.parentNode.style.backgroundColor = 'rgba(138, 182, 255, 1)';

	for (let i = 0; i < reservationScheduleList[e.target.parentNode.previousSibling.value].dates.split(',').length; i++) {
		document.querySelector('.current.date' + reservationScheduleList[e.target.parentNode.previousSibling.value].dates.split(',')[i]).children[0].style.backgroundColor = 'rgba(138, 182, 255, 1)';
		document.querySelector('.current.date' + reservationScheduleList[e.target.parentNode.previousSibling.value].dates.split(',')[i]).children[0].children[1].checked = true;

		reservationClickDate = reservationScheduleList[e.target.parentNode.previousSibling.value].dates.split(',')
	}

	reservationClickArray = e.target.parentNode.classList[1];
}

// 스태프 배정 셀렉트박스
function managerSelectBoxClick() {

	let kindOfSelectOption = '';
	let kindOfManagerSelect = '';
	let staffListRow = '';
	let columLength = '';
	if (insertManagerSelectValue == 'insert') {
		kindOfSelectOption = document.querySelector('.insert-manager-select-option');
		kindOfManagerSelect = document.querySelector('.select-insert');
		staffListRow = document.querySelector('.insert-select-list');
		columLength = 3;

	} else {
		kindOfSelectOption = document.querySelector('.manager-select-option');
		kindOfManagerSelect = document.querySelector('.reservation-modal-content-manager-select');
		staffListRow = document.querySelector('.manager-list');
		columLength = 4;
	}

	if (managerSelectValue == 0) {
		kindOfSelectOption.style.display = 'flex';
		kindOfSelectOption.style.height = staffListRow.getBoundingClientRect().height * columLength + 'px';
		kindOfSelectOption.style.bottom = '-' + kindOfSelectOption.getBoundingClientRect().height + 'px';
		kindOfManagerSelect.style.border = '3px solid rgb(138, 182, 255)';
		//		document.querySelector('.manager-select-option').classList.add('manager-select-arrowdown');

		managerSelectValue = 1;
	} else {
		kindOfSelectOption.style.display = 'none';
		kindOfSelectOption.style.bottom = 0 + 'px';
		kindOfManagerSelect.style.border = '3px solid #e5e5e5';
		//		document.querySelector('.manager-select-arrow').classList.remove('manager-select-arrowdown');

		managerSelectValue = 0;

	}

	kindOfSelectOption.style.width = kindOfManagerSelect.getBoundingClientRect().width + 'px';

}

// 스태프 셀렉트 선택
function managerSelect(e) {
	if (insertManagerSelectValue == 'insert') {
		document.querySelector('.select-insert').children[0].innerText = e.innerText;
	} else {
		document.querySelector('.reservation-modal-content-manager-select').children[0].innerText = e.innerText;
	}
	managerSelectBoxClick();
}

// 예약 디테일 승인
function reservationAccept(e) {

	if (e.innerText == '承認') {
		reservationScheduleList[reservationSelectArray].feedBack = document.querySelector('.reservation-modal-content-notice').children[0].value;
		reservationScheduleList[reservationSelectArray].staff = document.querySelector('.default-manager').innerText;

		var form = document.createElement('form');
		form.method = 'post'; // POST 방식 설정
		form.action = 'ReservationAgree'; // 서블릿의 URL로 설정

		// 입력 필드 생성 및 설정
		var input1 = document.createElement('input');
		input1.name = 'array'; // 서블릿에서 읽을 파라미터 이름
		input1.value = JSON.stringify(reservationScheduleList[reservationSelectArray]); // 전송할 값

		var input2 = document.createElement('input');
		input2.name = 'no';
		input2.value = reservationScheduleList[reservationSelectArray].no;

		var input3 = document.createElement('input');
		input3.name = 'status';
		input3.value = "accept";

		// 폼에 입력 필드 추가
		form.appendChild(input1);
		form.appendChild(input2);
		form.appendChild(input3);

		// 폼을 body에 추가하고 자동으로 제출
		document.body.appendChild(form);
		form.submit();

	} else {
		var form = document.createElement('form');
		form.method = 'post'; // POST 방식 설정
		form.action = 'ReservationAgree'; // 서블릿의 URL로 설정

		// 입력 필드 생성 및 설정
		var input1 = document.createElement('input');
		input1.name = 'array'; // 서블릿에서 읽을 파라미터 이름
		input1.value = JSON.stringify(reservationScheduleList[reservationSelectArray]); // 전송할 값

		var input2 = document.createElement('input');
		input2.name = 'no';
		input2.value = reservationScheduleList[reservationSelectArray].no;

		var input3 = document.createElement('input');
		input3.name = 'status';
		input3.value = "decline";

		// 폼에 입력 필드 추가
		form.appendChild(input1);
		form.appendChild(input2);
		form.appendChild(input3);

		// 폼을 body에 추가하고 자동으로 제출
		document.body.appendChild(form);
		form.submit();
	}
}


// 예약 디테일 모달 닫기
function reservationModalClose(e) {
	if (reservationModalValue == "direct") {
		for (let i = 0; i < reservationClickDate.length; i++) {
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].style.backgroundColor = '#FFF';
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].children[1].checked = false;
		}
	}
	
	if(deleteScheduleModal = 1) {
		reservationDeleteCancle()
	}

	document.querySelector('.reservation-modal').style.zIndex = '-1';
	document.querySelector('.backrop').style.display = 'none';

	if (managerSelectValue == 1) {
		managerSelectBoxClick();
	}
}

// 예약 일정 객체리스트화
function renderReservationSchedule() {

	for (let i = 0; i < reservationArrayDate.length; i++) {
		let divYear = calendar.children[i].className.match(/year(\d+)/);
		let divMonth = calendar.children[i].className.match(/month(\d+)/);
		let divDate = calendar.children[i].className.match(/date(\d+)/);

		prevDateLength = prevDate - (prevDate - prevDay + 1);

		// 일별 데이터에 해당 일 추가
		let dateData = {
			date: (divYear && divYear[1]) + '.' + (divMonth && divMonth[1]) + '.' + (divDate && divDate[1]),
			userName: '',
			userNameLength: ''
		};

		let foldingCnt = '';

		for (let j = 0; j < reservationAcceptList.length; j++) {
			if (reservationAcceptList[j].year == divYear[1] && reservationAcceptList[j].month == divMonth[1]) {
				// 해당월 일정안 date를 split
				let splitDates = reservationAcceptList[j].dates.split(',');
				// split한 데이터의 개수를 돌림	
				for (let k = 0; k < splitDates.length; k++) {
					// 일과 데이터의 값이 일치할경우 객체에 추가
					if (splitDates[k] == (divDate && divDate[1])) {
						dateData.userName += j + '.' + reservationAcceptList[j].userName + ',';
						foldingCnt++;
					}
				}
			}
		}

		dateData.userNameLength = foldingCnt;
		dateData.userName = dateData.userName.slice(0, -1);
		reservationArrayDate[i] = dateData;
	}

	writeReservationSchedule();
}

// 일정 추가를 위한 체크
function checkDate(e) {
	if (e.target.value == 0) {
		e.target.closest('.day.current').children[0].style.backgroundColor = 'rgba(138, 182, 255, 1)';
		dateArr[e.target.closest('.day.current').children[0].textContent] = 1;

		e.target.value = 1;
	} else {
		e.target.closest('.day.current').children[0].style.backgroundColor = '';
		dateArr[e.target.closest('.day.current').children[0].textContent] = 0;

		e.target.value = 0;
	}

	document.querySelector('.input-date').value = thisMonth.getFullYear() + '年 ' + (thisMonth.getMonth() + 1) + '月 ';

	for (let i = 1; i <= dateArr.length; i++) {
		if (dateArr[i] == 1) {
			document.querySelector('.input-date').value += i + ',';
		}
	}

	// 사용자가 보기위한 출력
	document.querySelector('.input-date').value = document.querySelector('.input-date').value.slice(0, -1);
}


// ++ 건수 펼치기
function expandReservationSchedule(e) {

	if (dateDetailModal == 1) {
		document.querySelector('.detail-schedule').style.visibility = 'hidden';
		dateDetailModal = 0;
	}


	if (dateModal == 0 || dateModal == 1) {
		// 클릭시 마우스 좌표에 모달창 visible
		document.querySelector('.date-modal').classList.add(e.target.classList[1]);
		document.querySelector('.date-modal').style.visibility = 'visible';
		document.querySelector('.date-modal').style.left = e.clientX + 'px';


		modalDivDate = e.target.closest('.current').className.match(/date(\d+)/);

		// 모달 title 해당 달력 연 월 표시
		document.querySelector('.date-modal-title').innerHTML = '<div>' + reservationArrayDate[parseInt(modalDivDate[1]) + prevDateLength].date + '</div>';


		// 모달 title 표시
		document.querySelector('.date-modal-content').innerHTML = '';
		let modalTitleData = reservationArrayDate[parseInt(modalDivDate[1]) + prevDateLength].userName.split(',');
		for (i = 2; i < modalTitleData.length; i++) {
			if (modalTitleData[0] != '') {
				document.querySelector('.date-modal-content').innerHTML += '<div class="modalTitleData"><input class="detailValue" value="' + (modalTitleData[i].split('.'))[0]
					+ '" type="hidden"><div>' + (modalTitleData[i].split('.'))[1] + '</div><a class="getScheduleDetail">詳細ページ</a></div>';
			}
		}

		if (e.target.getBoundingClientRect().y > window.innerHeight * 0.8) {
			document.querySelector('.date-modal').style.top = e.clientY - document.querySelector('.date-modal').getBoundingClientRect().height + 'px';
		} else {
			document.querySelector('.date-modal').style.top = e.clientY + 'px';
		}
		dateModal = 1;
	}

	if (dateModal == 1) {
		document.querySelector('.modal-close').addEventListener("click", function() {
			document.querySelector('.date-modal').style.visibility = 'hidden';
			dateModal = 0;
		});
	}
}

// 일정 디테일 모달 출력
function reservationDetailModal() {

	document.querySelector('.backrop').style.display = 'flex';
	document.querySelector('.reservation-modal-agree-btn').style.display = "none";
	document.querySelector('.reservation-modal-update-btn').style.display = "none";
	document.querySelector('.reservation-modal-detail-btn').style.display = "none";

	document.querySelectorAll('.update-time-checkBox').forEach(function(e) {
		e.checked = false;
	})

	// 달력 라벨 색
	if (reservationModalValue == "direct") {
		for (let i = 0; i < reservationClickDate.length; i++) {
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].style.backgroundColor = '#FFF';
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].children[1].checked = false;
		}
	}

	if (reservationModalValue == "list") {
		document.querySelector('.reservation-modal-agree-btn').style.display = "flex";

		document.querySelector('.manager-select-option').innerHTML = '<div class="manager-list" onclick="managerSelect(this)">選択なし</div>';
		document.querySelector('.reservation-modal-content-manager-select').children[0].innerText = 'スタッフ選び';
		document.querySelector('.manager-select-arrow').style.display = "flex";

		document.querySelectorAll('.update-time-checkBox').forEach(function(e) {
			e.disabled = true;
		})


		arrayName = reservationScheduleList[reservationSelectArray];

		let datesFolding = '';
		if (arrayName.dates.split(',').length > 15) {
			for (let i = 0; i < arrayName.dates.split(',').length; i++) {
				datesFolding += arrayName.dates.split(',')[i] + ',';
				if (i == 14) {
					datesFolding += '<br>';
				}
			}
			document.querySelector('.reservation-modal-content-book').innerHTML = arrayName.year + '-' + arrayName.month + '-' + datesFolding.slice(0, -1);
		} else {
			document.querySelector('.reservation-modal-content-book').innerHTML = arrayName.year + '-' + arrayName.month + '-' + arrayName.dates;
		}

		document.querySelector('.reservation-modal-content-notice').innerHTML = '<textarea>' + '介護問い合わせ内容: ' + arrayName.nurssingInfo + '\nタクシー問い合わせ内容 : ' + arrayName.taxiInfo + '</textarea>';

		console.log(reservationScheduleList[reservationSelectArray]);

		document.querySelector('.reservation-modal-content-manager-select').addEventListener("click", managerSelectBoxClick);
		insertManagerSelectValue = '';

	} else if (reservationModalValue == "direct") {
		if (reservationClickArray != '') {
			document.querySelector('.reservation-data.' + reservationClickArray).children[3].children[0].style.display = 'none';
			document.querySelector('.reservation-data.' + reservationClickArray).style.backgroundColor = '#FFF';
			for (let i = 0; i < reservationClickDate.length; i++) {
				document.querySelector('.current.date' + reservationClickDate[i]).children[0].style.backgroundColor = '#FFF';
				document.querySelector('.current.date' + reservationClickDate[i]).children[0].children[1].checked = false;
			}
		}

		// 달력 라벨 색
		for (let i = 0; i < reservationAcceptList[reservationSelectArray].dates.split(',').length; i++) {
			document.querySelector('.current.date' + reservationAcceptList[reservationSelectArray].dates.split(',')[i]).children[0].style.backgroundColor = 'rgba(138, 182, 255, 1)';
			document.querySelector('.current.date' + reservationAcceptList[reservationSelectArray].dates.split(',')[i]).children[0].children[1].checked = true;

			reservationClickDate = reservationAcceptList[reservationSelectArray].dates.split(',')
		}

		document.querySelector('.reservation-modal-update-btn').style.display = "flex";

		document.querySelector('.reservation-modal-content-manager-select').children[0].innerText = reservationAcceptList[reservationSelectArray].staff;
		document.querySelector('.manager-select-arrow').style.display = "none";

		document.querySelectorAll('.update-time-checkBox').forEach(function(e) {
			e.disabled = true;
		})

		arrayName = reservationAcceptList[reservationSelectArray];

		let datesFolding = '';
		if (arrayName.dates.split(',').length > 15) {
			for (let i = 0; i < arrayName.dates.split(',').length; i++) {
				datesFolding += arrayName.dates.split(',')[i] + ',';
				if (i == 14) {
					datesFolding += '<br>';
				}
			}
			document.querySelector('.reservation-modal-content-book').innerHTML = arrayName.year + '-' + arrayName.month + '-' + datesFolding.slice(0, -1);
		} else {
			document.querySelector('.reservation-modal-content-book').innerHTML = arrayName.year + '-' + arrayName.month + '-' + arrayName.dates;
		}
		document.querySelector('.reservation-modal-content-notice').innerHTML = '<textarea>' + arrayName.feedBack + '</textarea>';

		console.log(reservationAcceptList[reservationSelectArray]);

		document.querySelector('.reservation-modal-content-manager-select').removeEventListener("click", managerSelectBoxClick);

	}

	if (arrayName.time == 'AM,PM') {
		document.querySelectorAll('.update-time-checkBox').forEach(function(e) {
			e.checked = true;
		})
	} else if (arrayName.time == 'AM') {
		document.querySelectorAll('.update-time-checkBox')[0].checked = true;
	} else {
		document.querySelectorAll('.update-time-checkBox')[1].checked = true;
	}


	document.querySelector('.reservation-modal-title').innerHTML = arrayName.userName + ' - ' + arrayName.service;


	document.querySelector('.reservation-modal-content-name').innerHTML = arrayName.userName;
	document.querySelector('.reservation-modal-content-phone').innerHTML = arrayName.phoneNumber;
	document.querySelector('.reservation-modal-content-addr').innerHTML = arrayName.addr;

	document.querySelector('.reservation-modal-content-startpoint').innerHTML = arrayName.startPoint;
	document.querySelector('.reservation-modal-content-endpoint').innerHTML = arrayName.endPoint;


	if (reservationModalValue == "update") {
		document.querySelectorAll('.update-time-checkBox').forEach(function(e) {
			e.disabled = false;
		})

		arrayName = reservationAcceptList[reservationSelectArray];

		document.querySelector('.reservation-modal-title').innerHTML = '<input style="font-size:2rem; width:100%;"  value="' + arrayName.service + '">';
		document.querySelector('.reservation-modal-detail-btn').style.display = "flex";

		document.querySelector('.manager-select-option').innerHTML = '<div class="manager-list" onclick="managerSelect(this)">選択なし</div>';
		document.querySelector('.reservation-modal-content-manager-select').children[0].innerText = arrayName.staff;
		document.querySelector('.manager-select-arrow').style.display = "flex";

		document.querySelector('.reservation-modal-content-manager-select').addEventListener("click", managerSelectBoxClick);
		insertManagerSelectValue = '';

		document.querySelector('.reservation-modal-content-name').innerHTML = '<input style="font-size:1.5rem; width:100%;" value="' + arrayName.userName + '">';
		document.querySelector('.reservation-modal-content-phone').innerHTML = '<input style="font-size:1.5rem; width:100%;" value="' + arrayName.phoneNumber + '">';
		document.querySelector('.reservation-modal-content-addr').innerHTML = '<input style="font-size:1.5rem; width:100%;" value="' + arrayName.addr + '">';

		let datesFolding = '';
		if (arrayName.dates.split(',').length > 15) {
			for (let i = 0; i < arrayName.dates.split(',').length; i++) {
				datesFolding += arrayName.dates.split(',')[i] + ',';
				if (i == 14) {
					datesFolding += '<br>';
				}
			}
			document.querySelector('.reservation-modal-content-book').innerHTML = arrayName.year + '-' + arrayName.month + '-' + '<input style="font-size:1.5rem; width:100%;" value="' + datesFolding.slice(0, -1) + '">';
		} else {
			document.querySelector('.reservation-modal-content-book').innerHTML = arrayName.year + '-' + arrayName.month + '-' + '<input style="font-size:1.5rem; width:100%;" value="' + reservationAcceptList[reservationSelectArray].dates + '">';
		}

		document.querySelector('.reservation-modal-content-startpoint').innerHTML = '<input style="font-size:1.5rem; width:100%;" value="' + arrayName.startPoint + '">';
		document.querySelector('.reservation-modal-content-endpoint').innerHTML = '<input style="font-size:1.5rem; width:100%;" value="' + arrayName.endPoint + '">';
		document.querySelector('.reservation-modal-content-notice').innerHTML = '<textarea>' + arrayName.feedBack + '</textarea>';
	}

	// 직원 리스트 생성
	for (let i = 0; i < reservationStaffList.length; i++) {
		document.querySelector('.manager-select-option').innerHTML += '<input type="hidden" value="' + i + '"><div class="manager-list" onclick="managerSelect(this)">' + reservationStaffList[i].name + '</div>';
	}

	document.querySelector('.reservation-modal').style.zIndex = '3';

	reservationModalStatus = 1;
}

// 예약일정 삭제
function reservationDeleteConfirm() {
	document.querySelector('.confirm-delete').style.display = 'flex';
	document.querySelector('.confirm-delete').style.left = document.querySelector('.reservation-modal').getBoundingClientRect().x + document.querySelector('.reservation-modal').getBoundingClientRect().width / 4 + 'px';
	document.querySelector('.confirm-delete').style.top = document.querySelector('.reservation-modal').getBoundingClientRect().y + document.querySelector('.reservation-modal').getBoundingClientRect().height * 0.4 + 'px';
	deleteScheduleModal = 1;
}

// 예약일정 삭제 취소
function reservationDeleteCancle() {
	deleteScheduleModal = 0;
	document.querySelector('.confirm-delete').style.display = 'none';
}

// 예약일정 수정확인
function reservationConfirm(e) {
	let time = '';

	if (document.querySelector('.reservation-modal-content-time input[value="AM"]').checked && document.querySelector('.reservation-modal-content-time input[value="PM"]').checked) {
		time = document.querySelector('.reservation-modal-content-time input[value="AM"]').value + ',' + document.querySelector('.reservation-modal-content-time input[value="PM"]').value;
	} else if (document.querySelector('.reservation-modal-content-time input[value="AM"]').checked) {
		time = document.querySelector('.reservation-modal-content-time input[value="AM"]').value;
	} else if (document.querySelector('.reservation-modal-content-time input[value="PM"]').checked) {
		time = document.querySelector('.reservation-modal-content-time input[value="PM"]').value;
	}

	arrayName.title = document.querySelector('.reservation-modal-title').children[0].value;
	arrayName.time = time;
	arrayName.userName = document.querySelector('.reservation-modal-content-name').children[0].value;
	arrayName.addr = document.querySelector('.reservation-modal-content-addr').children[0].value;
	arrayName.dates = document.querySelector('.reservation-modal-content-book').children[0].value;
	arrayName.startPoint = document.querySelector('.reservation-modal-content-startpoint').children[0].value;
	arrayName.endPoint = document.querySelector('.reservation-modal-content-endpoint').children[0].value;
	arrayName.feedBack = document.querySelector('.reservation-modal-content-notice').children[0].value;
	arrayName.staff = document.querySelector('.default-manager').innerText;

	let params = {
		object: JSON.stringify(arrayName)
	}

	fetch('ReservationUpdate', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
		},
		body: new URLSearchParams(params)
	})
		.then(response => response.text())
		.then(data => {
			reservationModalValue = "";

			document.querySelectorAll('.schedule').forEach(function(scheduleElement) {
				scheduleElement.remove();
			});

			renderReservationSchedule();

			reservationModalValue = "direct"

			reservationDetailModal();
		})
}

function reservationCancel() {
	reservationModalValue = "direct";

	reservationDetailModal();
}

// 예약 삭제
function reservationDelete(e) {
	console.log(reservationSelectArray);
	console.log(reservationAcceptList[reservationSelectArray].pkNo);

	var form = document.createElement('form');
	form.method = 'post'; // POST 방식 설정
	form.action = 'ReservationDelete'; // 서블릿의 URL로 설정

	// 입력 필드 생성 및 설정
	var input1 = document.createElement('input');
	input1.name = 'no'; // 서블릿에서 읽을 파라미터 이름
	input1.value = reservationAcceptList[reservationSelectArray].pkNo; // 전송할 값

	var input2 = document.createElement('input');
	input2.name = 'status'; // 서블릿에서 읽을 파라미터 이름
	input2.value = 'delete'; // 전송할 값

	var input3 = document.createElement('input');
	input3.name = 'array'; // 서블릿에서 읽을 파라미터 이름
	input3.value = JSON.stringify(reservationAcceptList[reservationSelectArray]); // 전송할 값

	// 폼에 입력 필드 추가
	form.appendChild(input1);
	form.appendChild(input2);
	form.appendChild(input3);

	// 폼을 body에 추가하고 자동으로 제출
	document.body.appendChild(form);
	form.submit();
}


// 일정 렌더링을 위한 
function writeReservationSchedule() {

	for (let i = 0; i < reservationArrayDate.length; i++) {
		let splitDates = reservationArrayDate[i].userName.split(',');

		for (let j = 0; j < splitDates.length; j++) {
			if (splitDates[j].split('.')[1]) {
				if (calendar.children[i] && calendar.children[i].children.length < 4) {
					// 5글자 이상인경우 폴딩
					if (splitDates[j].split('.')[1].length >= 5) {
						calendar.children[i].innerHTML += '<div class="schedule array' + i + '"><input class="detailValue" value=' + splitDates[j].split('.')[0] + ' type="hidden">' + splitDates[j].split('.')[1].slice(0, -1) + '...' + '</div>';

					}
					else {
						calendar.children[i].innerHTML += '<div class="schedule array' + i + '"><input class="detailValue" value=' + splitDates[j].split('.')[0] + ' type="hidden">' + splitDates[j].split('.')[1] + '</div>';
					}
				}
			}
		}
		// 3개부터 폴딩
		if (calendar.children[i].children.length > 3) {
			calendar.children[i].children[3].textContent = '++' + (reservationArrayDate[i].userNameLength - 2) + '件';
		}
	}
}

// 일정데이터 삭제 모달 오픈
function rowScheduleDeleteClick(atag) {
	if (confirmDeleteModal == 0) {
		document.querySelector('.confirm-delete').style.top = (document.querySelector('.detail-schedule').getBoundingClientRect().top) + document.querySelector('.detail-schedule').getBoundingClientRect().height / 7 + 'px';
		document.querySelector('.confirm-delete').style.left = document.querySelector('.detail-schedule').getBoundingClientRect().left + document.querySelector('.detail-schedule').getBoundingClientRect().width / 8 + 'px';
		document.querySelector('.confirm-delete').style.display = "flex";


		confirmDeleteModal = 1;
	} else {
		document.querySelector('.confirm-delete').style.display = "none";
		confirmDeleteModal = 0;
	}
}

// 예약 신규 등록 온
function reservationInsertPageOn() {
	if (reservationClickArray != '') {
		document.querySelector('.reservation-data.' + reservationClickArray).children[3].children[0].style.display = 'none';
		document.querySelector('.reservation-data.' + reservationClickArray).style.backgroundColor = '#FFF';
		for (let i = 0; i < reservationClickDate.length; i++) {
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].style.backgroundColor = '#FFF';
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].children[1].checked = false;
		}
	}

	document.querySelectorAll('.dateCheckBox').forEach(function(e) {
		e.disabled = false;
	})

	document.querySelector('.insert-manager-select-option').innerHTML = '<div class="manager-list" onclick="managerSelect(this)">選択なし</div>';
	// 직원 리스트 생성
	for (let i = 0; i < reservationStaffList.length; i++) {
		document.querySelector('.insert-manager-select-option').innerHTML += '<input type="hidden" value="' + i + '"><div class="manager-list insert-select-list" onclick="managerSelect(this)">' + reservationStaffList[i].name + '</div>';
	}

	document.querySelector('.reservation-title').style.display = 'none';
	document.querySelector('.ins-tr-3-reservation-header').style.display = 'none';
	document.querySelector('.ins-tr-3-reservation-content').style.display = 'none';
	document.querySelector('.ins-tr-3-btn').style.display = 'none';

	document.querySelector('.reservation-insert').style.display = 'flex';
	document.querySelector('.ins-tr-3-btn-insert').style.display = 'flex';
	document.querySelector('.reservation-insert-service').style.display = 'flex';
	document.querySelector('.reservation-insert-time').style.display = 'flex';


	document.querySelector('.select-insert').addEventListener("click", function() {
		insertManagerSelectValue = "insert";
		managerSelectBoxClick();
	});

	document.querySelector('.ins-tr-3-btn-insert-accept').addEventListener("click", function() {
		reservationInsert();
	});

	document.querySelector('.ins-tr-3-btn-insert-cancel').addEventListener("click", function() {
		reservationInsertPageClose();
	});


}

// 예약 신규 등록 취소
function reservationInsertPageClose() {
	if (reservationClickArray != '') {
		document.querySelector('.reservation-data.' + reservationClickArray).children[3].children[0].style.display = 'none';
		document.querySelector('.reservation-data.' + reservationClickArray).style.backgroundColor = '#FFF';
		for (let i = 0; i < reservationClickDate.length; i++) {
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].style.backgroundColor = '#FFF';
			document.querySelector('.current.date' + reservationClickDate[i]).children[0].children[1].checked = false;
		}
	}

	document.querySelectorAll('.dateCheckBox').forEach(function(e) {
		e.disabled = true;
	})

	document.querySelector('.reservation-title').style.display = 'flex';
	document.querySelector('.ins-tr-3-reservation-header').style.display = 'flex';
	document.querySelector('.ins-tr-3-reservation-content').style.display = 'block';
	document.querySelector('.ins-tr-3-btn').style.display = 'flex';

	document.querySelector('.reservation-insert').style.display = 'none';
	document.querySelector('.ins-tr-3-btn-insert').style.display = 'none';
	document.querySelector('.reservation-insert-service').style.display = 'none';
	document.querySelector('.reservation-insert-time').style.display = 'none';
}

// 예약 신규 등록
function reservationInsert() {
	let time = '';

	if (document.querySelector('.reservation-insert-time input[value="AM"]').checked && document.querySelector('.reservation-insert-time input[value="PM"]').checked) {
		time = document.querySelector('.reservation-insert-time input[value="AM"]').value + ',' + document.querySelector('.reservation-insert-time input[value="PM"]').value;
	} else if (document.querySelector('.reservation-insert-time input[value="AM"]').checked) {
		time = document.querySelector('.reservation-insert-time input[value="AM"]').value;
	} else if (document.querySelector('.reservation-insert-time input[value="PM"]').checked) {
		time = document.querySelector('.reservation-insert-time input[value="PM"]').value;
	}

	let newReservation = {
		service: document.querySelector('.reservation-insert-service').value,
		time: time,
		userName: document.querySelector('.reservation-insert-name').children[0].value,
		phoneNum: document.querySelector('.reservation-insert-phone').children[0].value,
		addr: document.querySelector('.reservation-insert-addr').children[0].value,
		year: currentYear + '',
		month: currentMonth + 1 + '',
		dates: document.querySelector('.reservation-insert-book').children[0].value.split('月 ')[1],
		startPoint: document.querySelector('.reservation-insert-startpoint').children[0].value,
		endPoint: document.querySelector('.reservation-insert-endpoint').children[0].value,
		feedBack: document.querySelector('.reservation-insert-notice').children[0].value,
		staff: document.querySelector('.select-insert').children[0].innerText
	};

	console.log(newReservation);

	var form = document.createElement('form');
	form.method = 'post'; // POST 방식 설정
	form.action = 'ReservationInsert'; // 서블릿의 URL로 설정

	// 입력 필드 생성 및 설정
	var input1 = document.createElement('input');
	input1.name = 'array'; // 서블릿에서 읽을 파라미터 이름
	input1.value = JSON.stringify(newReservation); // 전송할 값

	// 폼에 입력 필드 추가
	form.appendChild(input1);

	// 폼을 body에 추가하고 자동으로 제출
	document.body.appendChild(form);
	form.submit();
}

// 디테일창 드로그앤드롭
function reservationDetailDroDrop() {

	document.querySelector('.reservation-modal-header').addEventListener("mousedown", function(e) {
		if (e.target.tagName !== 'INPUT' && e.target.className == 'reservation-modal-title') {
			isDragging = true;
			modalOffsetX = e.offsetX;
			modalOffsetY = e.offsetY;
		}
	})

	// 모달창 드래그 중
	document.querySelector('.reservation-modal-header').addEventListener("mousemove", function(e) {
		if (isDragging) {
			const x = e.clientX - modalOffsetX;
			const y = e.clientY - modalOffsetY;
			document.querySelector('.reservation-modal').style.left = x + 'px';
			document.querySelector('.reservation-modal').style.top = y + 'px';
		}
	})

	// 모달창 드래그 종료
	document.querySelector('.reservation-modal-header').addEventListener("mouseup", function() {
		isDragging = false;
	});
}

// 온 로드
window.onload = function() {
	// 모달창 이동 추후 펑션화
	document.querySelector('.reservation-modal').style.top = document.querySelector('.content-main-td').getBoundingClientRect().top + document.querySelector('.content-m-td-1').getBoundingClientRect().height / 2 + 'px';
	document.querySelector('.reservation-modal').style.right = document.querySelector('.content-main-td').getBoundingClientRect().right / 25 + 'px';

	getAllSchedule();

	toggleSwutch();

};


function toggleSwutch() {
	toggle = document.querySelectorAll(".toggleSwitch");

	let toggleInfo = {
		active: ''
	};

	if (window.location.pathname.includes('CompanyC')) {
		toggle[0].classList.toggle('active');
		toggleInfo.active = true;
		toggleList[0] = toggleInfo;
	} else if (window.location.pathname.includes('ReservationC')) {
		toggle[1].classList.toggle('active');
		toggleInfo.active = true;
		toggleList[1] = toggleInfo;
	}

	for (let i = 0; i < toggle.length; i++) {
		toggle[i].onclick = function() {
			toggle[i].classList.toggle('active');

			if (toggleList[i].active) {

				document.querySelectorAll('.schedule').forEach(function(scheduleElement) {
					scheduleElement.style.display = 'none';
				});

				toggleInfo.active = false;
				toggleList[i] = toggleInfo;

			} else {

				toggleInfo.active = true;
				toggleList[i] = toggleInfo;

				document.querySelectorAll('.schedule').forEach(function(scheduleElement) {
					scheduleElement.style.display = 'flex';
				});
			}
		};
	}
}


function insertCompanyC(e) {
	document.querySelector('.company-form').submit();
}