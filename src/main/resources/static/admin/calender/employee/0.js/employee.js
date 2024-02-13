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
let employeeList = new Array;

// 날짜 체크박스 클릭 배열
let dateArr = new Array(32).fill(0);

// 전월 현월 다음월 일정 배열
let arrayCalenderList = new Array();

// 일별 일정 배열
let employeeArrayDate = new Array();

// 연, 월 버튼 초기값
let clickButton = "";

let modalArrayNumber = '';

// 직원리스트 클릭
let employeerClickArray = '';

// 직원리스트 클릭 오브젝트
let employeerClickObject = '';

// 직원리스트 클릭 오브젝트 날짜
let employeerClickDates = '';

// 직원리스트 클릭 기존 근무일수
let employeerClickDatesLength = '';

// 직원리스트 클릭 후 달 이동
let employeerClickDatesLengthBool = false;

// 일정 상세 모달창 초기값
let dateModal = 0;

// 디테일 모달 초기
let deleteSiftModal = 0;

// 일정 렌더링을 위한 이전달 개수
let prevDateLength = 0;

// 모달생성시 해당날짜
let modalDivDate = '';

// 회사 일정 디테일창 객체
let selectDetailSchedule = new Array();

// 시프트 리스트
let employeeSiftList = new Array();

// 조인 시프트 리스트
let joinSiftList = new Array();

// 일정 삭제 이후 렌더시 필요 날짜
let prevDate = '';
let prevDay = '';

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
	fetch('employee/list')
		.then(response => response.json())
		.then(data => {

			// javascript배열에 ajax로 가져온 배열 입력
			employeeList = employeeList.concat(data);

			// 전체데이터 출력
			console.log(employeeList);

			// 페이지 입장 시 렌더링
			renderMonth(employeeList, clickButton);

			// 시프트 조회
			getAllSift();

			// 전년도로 이동
			document.querySelector('.go-year-prev').addEventListener('click', function() {
				let clickButton = 'yearPrev';
				dateArr = new Array(32).fill(0);
				renderMonth(employeeList, clickButton);
				employeerClickDatesLengthBool = true;
				joinSiftList = new Array();
				addToSift();
			});

			// 이전달로 이동
			document.querySelector('.go-prev').addEventListener('click', function() {
				let clickButton = 'monthPrev';
				dateArr = new Array(32).fill(0);
				renderMonth(employeeList, clickButton);
				employeerClickDatesLengthBool = true;
				joinSiftList = new Array();
				addToSift();
			});

			// 다음달로 이동
			document.querySelector('.go-next').addEventListener('click', function() {
				let clickButton = 'monthNext';
				dateArr = new Array(32).fill(0);
				renderMonth(employeeList, clickButton);
				employeerClickDatesLengthBool = true;
				joinSiftList = new Array();
				addToSift();
			});

			// 다음해로 이동
			document.querySelector('.go-year-next').addEventListener('click', function() {
				let clickButton = 'yearNext';
				dateArr = new Array(32).fill(0);
				renderMonth(employeeList, clickButton);
				employeerClickDatesLengthBool = true;
				joinSiftList = new Array();
				addToSift();
			});

			// 버튼클릭
			calendar.addEventListener("click", function(e) {
				if (e.target.classList.contains('dateCheckBox')) {
					checkDate(e);
				}
			});

			// 직원 리스트 클릭
			document.querySelector('.ins-tr-3-employee-content').addEventListener("click", function(e) {
				if (e.target.parentNode.className.includes('employee-data')) {
					employeerClick(e);
				}
			})

			// 직원시프트 삭제
			document.querySelector('.ins-tr-3-employee-content').addEventListener("dblclick", function(e) {
				if (e.target.parentNode.className.includes('employee-data')) {
					allSiftDelete();
				}
			})

			// ++건수 클릭
			calendar.addEventListener("click", function(e) {
				if (e.target.textContent.includes('++') && e.target.closest('.current')) {
					expandSchedule(e);
				}
			})

		})


		.catch(error => {
			console.error('데이터를 가져오는 중 오류 발생:', error);
		});
}

// 시프트 조회
function getAllSift() {
	fetch('employee/sift')
		.then(response => response.json())
		.then(data => {
			// javascript배열에 ajax로 가져온 배열 입력
			employeeSiftList = data;

			// 전체데이터 출력
			console.log(employeeSiftList);

			addToSift();
		})
		.catch(error => {

			console.error('데이터를 가져오는 중 오류 발생:', error);
		});
}

// 초기 및 클릭 렌더링
function renderMonth(employeeList, clickButton) {

	if (dateModal == 1) {
		document.querySelector('.date-modal').style.visibility = 'hidden';
		dateModal = 0;
	}

	document.querySelector('.date-modal').style.visibility = 'hidden';
	dateModal = 0;

	if (clickButton == 'monthNext') {
		thisMonth = new Date(currentYear, currentMonth + 1, 1);
		addToSift();
	} else if (clickButton == 'yearNext') {
		thisMonth = new Date(currentYear, currentMonth + 12, 1);
	} else if (clickButton == 'monthPrev') {
		thisMonth = new Date(currentYear, currentMonth - 1, 1);
	} else if (clickButton == 'yearPrev') {
		thisMonth = new Date(currentYear, currentMonth - 12, 1);
	}

	document.querySelector('.input-date').value = thisMonth.getFullYear() + '年 ' + (thisMonth.getMonth() + 1) + '月 ';


	renderCalender(employeeList);
}


function renderCalender(employeeList) {

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

		document.querySelectorAll('.dateCheckBox').forEach(function(e) {
			e.disabled = true;
		})
	}

	// 다음달
	for (let i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
		let nextCalenderMonth = (currentMonth + 2 === 13) ? 1 : currentMonth + 2;
		let prevClanederYear = (nextCalenderMonth == 1) ? (currentYear + 1) : currentYear;

		calendar.innerHTML = calendar.innerHTML + '<div class="day next disable year' + prevClanederYear + ' month' + nextCalenderMonth + ' date' + i + '"><div><div class="month-date">' + i + '</div></div>'
	}

	// 달력에 표시된 전월 현월 다음월 일 수 만큼 배열리스트 할당
	employeeArrayDate = new Array(prevDate - (prevDate - prevDay + 1) + (nextDate + 1) + (7 - nextDay == 7 ? 0 : 7 - nextDay));

	console.log(employeeArrayDate)
}

// 해당원 직원 일정 객체화
function addToSift() {

	for (let i = 0; i < employeeSiftList.length; i++) {
		let joinSift = {
			arrayNum: '',
			s_no: '',
			s_position: '',
			s_name: '',
			s_phone_num: '',
			s_entry_date: '',
			s_color: '',
			s_addr: '',
			f_no: '',
			f_year: '',
			f_month: '',
			f_dates: '',
			f_pk: ''
		};
		for (let j = 0; j < employeeList.length; j++) {
			if (employeeList[j].s_no == employeeSiftList[i].f_staffNo) {
				//			if (employeeList[j].s_no == employeeSiftList[i].f_staffNo && currentYear == employeeSiftList[i].f_year && (currentMonth + 1) == employeeSiftList[i].f_month) {
				joinSift.arrayNum = i;
				joinSift.s_no = employeeList[j].s_no;
				joinSift.s_position = employeeList[j].s_position;
				joinSift.s_name = employeeList[j].s_name;
				joinSift.s_phone_num = employeeList[j].s_phone_num;
				joinSift.s_entry_date = employeeList[j].s_entry_date;
				joinSift.s_color = employeeList[j].s_color;
				joinSift.s_addr = employeeList[j].s_addr;
				joinSift.f_no = employeeSiftList[i].f_staffNo;
				joinSift.f_year = employeeSiftList[i].f_year;
				joinSift.f_month = employeeSiftList[i].f_month;
				joinSift.f_dates = employeeSiftList[i].f_dates;
				joinSift.f_pk = employeeSiftList[i].f_no;
			}
		}
		joinSiftList.push(joinSift);
	}
	console.log(joinSiftList);

	document.querySelector('.ins-tr-3-employee-content').innerHTML = '';


	renderEmplyeerList();

	renderSift();

}


// 직원 리스트화
function renderEmplyeerList() {

	let arrayCnt = 0;
	let workingDates = 0;
	let joinDataArray = '';
	for (let i = 0; i < employeeList.length; i++) {
		workingDates = 0;
		joinDataArray = '';
		for (let j = 0; j < joinSiftList.length; j++) {
			if (currentYear == joinSiftList[j].f_year && (currentMonth + 1) == joinSiftList[j].f_month && employeeList[i].s_no == joinSiftList[j].f_no) {
				workingDates = joinSiftList[j].f_dates.split(',').length;
				joinDataArray = j;
			}
		}


		document.querySelector('.ins-tr-3-employee-content').innerHTML += '<input type="hidden" value="' + i + '"><div class="employee-data array' + arrayCnt + '"><div class="employee-color"><div style="background-color:'
			+ employeeList[i].s_color + ';"></div></div><div>' + employeeList[i].s_name + '</div><div>' + workingDates + '</div><div>' + employeeList[i].s_phone_num + '</div><input type="hidden" value="' + joinDataArray + '">';

		arrayCnt++;
	}
}

// 달력 일정 렌더링
function renderSift() {

	for (let i = 0; i < employeeArrayDate.length; i++) {
		let divYear = calendar.children[i].className.match(/year(\d+)/);
		let divMonth = calendar.children[i].className.match(/month(\d+)/);
		let divDate = calendar.children[i].className.match(/date(\d+)/);

		prevDateLength = prevDate - (prevDate - prevDay + 1);

		// 일별 데이터에 해당 일 추가
		let dateData = {
			date: (divYear && divYear[1]) + '.' + (divMonth && divMonth[1]) + '.' + (divDate && divDate[1]),
			staff: '',
			staffLength: ''
		};

		let foldingCnt = '';

		for (let j = 0; j < joinSiftList.length; j++) {
			if (joinSiftList[j].f_year == divYear[1] && joinSiftList[j].f_month == divMonth[1]) {
				// 해당월 일정안 date를 split
				let splitDates = joinSiftList[j].f_dates.split(',');
				// split한 데이터의 개수를 돌림	
				for (let k = 0; k < splitDates.length; k++) {
					// 일과 데이터의 값이 일치할경우 객체에 추가
					if (splitDates[k] == (divDate && divDate[1])) {
						dateData.staff += joinSiftList[j].arrayNum + '.' + joinSiftList[j].s_name + ',';
						foldingCnt++;
					}
				}
			}
		}

		dateData.staffLength = foldingCnt;
		dateData.staff = dateData.staff.slice(0, -1);
		employeeArrayDate[i] = dateData;
	}
	writeSift();
}

// 직원 일정 렌더링 
function writeSift() {

	for (let i = 0; i < employeeArrayDate.length; i++) {
		let splitDates = employeeArrayDate[i].staff.split(',');

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
			calendar.children[i].children[3].textContent = '++' + (employeeArrayDate[i].staffLength - 2) + '件';
		}
	}
}

// 예약 리스트 클릭
function employeerClick(e) {
	dateArr = Array(32).fill(0);
	document.querySelector('.input-date').value = thisMonth.getFullYear() + '年 ' + (thisMonth.getMonth() + 1) + '月 ';

	if (deleteSiftModal = 1) {
		siftDeleteClose()
	}

	// 리스트와 달력 초기화식
	if (employeerClickArray != '') {
		document.querySelector('.employee-data.' + employeerClickArray).style.backgroundColor = '#FFF';
		document.querySelector('.employee-data.' + employeerClickArray).style.color = 'Black';
		if (!employeerClickDatesLengthBool) {
			document.querySelector('.employee-data.' + employeerClickArray).children[2].innerText = employeerClickDatesLength;
		} else {
			employeerClickDatesLengthBool = false;
		}
	}

	document.querySelectorAll('.dateCheckBox').forEach(function(e) {
		e.disabled = false;
	})

	if (employeerClickDates != '') {
		for (let i = 0; i < employeerClickDates.length; i++) {
			document.querySelector('.current.date' + employeerClickDates[i]).children[0].style.backgroundColor = '#FFF';
			document.querySelector('.current.date' + employeerClickDates[i]).children[0].children[1].checked = false;
			document.querySelector('.current.date' + employeerClickDates[i]).children[0].children[1].value = 0;
		}
	}

	employeerClickObject = employeeList[e.target.parentNode.previousSibling.value];

	e.target.parentNode.style.backgroundColor = employeerClickObject.s_color;
	e.target.parentNode.style.color = '#FFF';


	for (let i = 0; i < joinSiftList.length; i++) {
		if (joinSiftList[i].s_no == employeerClickObject.s_no && currentYear == joinSiftList[i].f_year && (currentMonth + 1) == joinSiftList[i].f_month) {
			document.querySelector('.dateCheckBox').style.accentColor = employeerClickObject.s_color;
			for (let j = 0; j < joinSiftList[i].f_dates.split(',').length; j++) {
				document.querySelector('.current.date' + joinSiftList[i].f_dates.split(',')[j]).children[0].style.backgroundColor = employeerClickObject.s_color;
				document.querySelector('.current.date' + joinSiftList[i].f_dates.split(',')[j]).children[0].children[1].checked = true;
				document.querySelector('.current.date' + joinSiftList[i].f_dates.split(',')[j]).children[0].children[1].value = 1;
				dateArr[(joinSiftList[i].f_dates.split(',')[j])] = 1;

				employeerClickDates = joinSiftList[i].f_dates.split(',');
			}
			document.querySelector('.input-date').value = document.querySelector('.input-date').value.slice(0, -1) + ' ' + joinSiftList[i].f_dates;
		}
	}

	document.querySelectorAll('.dateCheckBox').forEach(dateCheckBox => {
		dateCheckBox.style.accentColor = employeerClickObject.s_color;
	});

	employeerClickArray = e.target.parentNode.classList[1];
	employeerClickDatesLength = document.querySelector('.employee-data.' + employeerClickArray).children[2].innerText;
	console.log(employeerClickArray)
}

// 일정 추가를 위한 체크
function checkDate(e) {
	document.querySelector('.input-date').value = thisMonth.getFullYear() + '年 ' + (thisMonth.getMonth() + 1) + '月 ';
	console.log(employeerClickDates)

	if (e.target.value == 0) {
		e.target.closest('.day.current').children[0].style.backgroundColor = employeerClickObject.s_color;
		dateArr[e.target.closest('.day.current').children[0].textContent] = 1;

		e.target.value = 1;
	} else {
		e.target.closest('.day.current').children[0].style.backgroundColor = '';
		dateArr[e.target.closest('.day.current').children[0].textContent] = 0;
		e.target.value = 0;
	}

	let siftCnt = 0;
	for (let i = 1; i <= dateArr.length; i++) {
		if (dateArr[i] == 1) {
			document.querySelector('.input-date').value += i + ',';
			employeerClickDates = document.querySelector('.input-date').value.split('月 ')[1].slice(0, -1).split(',');
			siftCnt = document.querySelector('.input-date').value.split('月 ')[1].slice(0, -1).split(',').length;
		}
	}

	console.log(employeerClickDates);

	// 사용자가 보기위한 출력
	document.querySelector('.input-date').value = document.querySelector('.input-date').value.slice(0, -1);
	document.querySelector('.employee-data.' + employeerClickArray).children[2].innerText = siftCnt;

	console.log(dateArr)
}

function insertSift() {
	if (document.querySelector('.employee-data.' + employeerClickArray).children[4].value == '') {
		let insertSiftDate = {
			f_staffNo : employeerClickObject.s_no,
			f_year : thisMonth.getFullYear(),
			f_month : thisMonth.getMonth() + 1,
			f_dates : employeerClickDates.toString()
		}
		
		fetch('employee/insert', {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(insertSiftDate),
		})
			.then(response => response.text())
			.then(data => {
				if (data == 1) {
					location.href = '/employee';
				}
			})
			.catch(error => {
				console.error('데이터를 가져오는 중 오류 발생:', error);
			});

	} else {
		let updateSiftDate = {
			f_no : joinSiftList[document.querySelector('.employee-data.' + employeerClickArray).children[4].value].f_pk,
			f_dates : employeerClickDates.toString()
		}
		
		fetch('employee/update', {
			method: "PUT",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(updateSiftDate),
		})
			.then(response => response.text())
			.then(data => {
				if (data == 1) {
					location.href = '/employee';
				}
			})
			.catch(error => {
				console.error('데이터를 가져오는 중 오류 발생:', error);
			});
	}
}

// ++ 건수 펼치기
function expandSchedule(e) {

	if (dateModal == 0 || dateModal == 1) {
		// 클릭시 마우스 좌표에 모달창 visible
		document.querySelector('.date-modal').classList.add(e.target.classList[1]);
		document.querySelector('.date-modal').style.visibility = 'visible';
		document.querySelector('.date-modal').style.left = e.clientX + 'px';


		modalDivDate = e.target.closest('.current').className.match(/date(\d+)/);

		// 모달 title 해당 달력 연 월 표시
		document.querySelector('.date-modal-title').innerHTML = '<div>' + employeeArrayDate[parseInt(modalDivDate[1]) + prevDateLength].date + '</div>';


		// 모달 title 표시
		document.querySelector('.date-modal-content').innerHTML = '';
		let modalTitleData = employeeArrayDate[parseInt(modalDivDate[1]) + prevDateLength].staff.split(',');
		for (i = 2; i < modalTitleData.length; i++) {
			if (modalTitleData[0] != '') {
				document.querySelector('.date-modal-content').innerHTML += '<div class="modalTitleData"><input class="detailValue" value="' + (modalTitleData[i].split('.'))[0]
					+ '" type="hidden"><div>' + (modalTitleData[i].split('.'))[1] + '</div></div>';
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

function allSiftDelete(e) {
	if (document.querySelector('.employee-data.' + employeerClickArray).children[4].value != '') {
		document.querySelector('.confirm-delete-content-announce').innerText = employeeList[document.querySelector('.employee-data.' + employeerClickArray).previousSibling.value].s_name + 'のシフトを全部削除しますか';
		document.querySelector('.confirm-delete').style.display = 'flex';
		document.querySelector('.confirm-delete').style.left = document.querySelector('.sec-ins').getBoundingClientRect().x + document.querySelector('.sec-ins').getBoundingClientRect().width / 6 + 'px';
		deleteSiftModal = 1;
	}
}

function siftDeleteClose() {
	deleteSiftModal = 0;
	document.querySelector('.confirm-delete').style.display = 'none';
}

function siftDelete() {
	
	let deleteSiftData = {
		f_no : joinSiftList[document.querySelector('.employee-data.' + employeerClickArray).children[4].value].f_pk
	}
	
	fetch('employee/delete', {
			method: "DELETE",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(deleteSiftData),
		})
			.then(response => response.text())
			.then(data => {
				if (data == 1) {
					location.href = '/employee';
				}
			})
			.catch(error => {
				console.error('데이터를 가져오는 중 오류 발생:', error);
			});
}

window.onload = function() {

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
	} else {
		toggle[2].classList.toggle('active');
		toggleInfo.active = true;
		toggleList[2] = toggleInfo;
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


function insertCompanyC() {
	document.querySelector('.company-form').submit();
}