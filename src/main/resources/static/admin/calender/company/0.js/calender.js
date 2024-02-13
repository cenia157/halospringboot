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
let CompanyScheduleList = new Array;

// 날짜 체크박스 클릭 배열
let dateArr = new Array(32).fill(0);

// 전월 현월 다음월 일정 배열
let arrayCalenderList = new Array();

// 일별 일정 배열
let arrayDate = new Array();

// 연, 월 버튼 초기값
let clickButton = "";

let modalArrayNumber = '';

// 일정 상세 모달창 초기값
let dateModal = 0;

// 디테일 모달 초기
let dateDetailModal = 0;

// 디테일 모달 생성 해당 pk
let dateDivValue = '';

// 일정 렌더링을 위한 이전달 개수
let prevDateLength = 0;

// 모달생성시 해당날짜
let modalDivDate = '';

// 회사 일정 디테일창 객체
let selectDetailSchedule = new Array();

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
	fetch('company/scheduleList')
		.then(response => response.json())
		.then(data => {

			// javascript배열에 ajax로 가져온 배열 입력
			CompanyScheduleList = CompanyScheduleList.concat(data);

			// 전체데이터 출력
			console.log(CompanyScheduleList);

			// 페이지 입장 시 렌더링
			renderMonth(CompanyScheduleList, clickButton);

			// 전년도로 이동
			document.querySelector('.go-year-prev').addEventListener('click', function() {
				let clickButton = 'yearPrev';
				renderMonth(CompanyScheduleList, clickButton);
			});

			// 이전달로 이동
			document.querySelector('.go-prev').addEventListener('click', function() {
				let clickButton = 'monthPrev';
				renderMonth(CompanyScheduleList, clickButton);
			});

			// 다음달로 이동
			document.querySelector('.go-next').addEventListener('click', function() {
				let clickButton = 'monthNext';
				renderMonth(CompanyScheduleList, clickButton);
			});

			// 다음해로 이동
			document.querySelector('.go-year-next').addEventListener('click', function() {
				let clickButton = 'yearNext';
				renderMonth(CompanyScheduleList, clickButton);
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
					expandSchedule(e);
				}
			})

			// 달력에서 일정 클릭
			calendar.addEventListener("click", function(e) {
				if (e.target.className.includes('schedule') && e.target.children.length > 0 && e.target.closest('.current')) {
					let directDetail = true;
					getScheduleDetailModal(e, directDetail);
				}
			})

			// 날짜 모달 내 세부사항 클릭
			document.querySelector('.date-modal-content').addEventListener("click", function(e) {
				if (e.target.classList.contains('getScheduleDetail')) {
					let directDetail = false;
					getScheduleDetailModal(e, directDetail)
				}
			})

			// 디테일창 드로그앤드롭
			scheduleDetailDroDrop();

		})


		.catch(error => {
			console.error('데이터를 가져오는 중 오류 발생:', error);
		});
}


// 초기 및 클릭 렌더링
function renderMonth(CompanyScheduleList, clickButton) {
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

	renderCalender(CompanyScheduleList);
}


function renderCalender(CompanyScheduleList) {

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

	// 다음달
	for (let i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
		let nextCalenderMonth = (currentMonth + 2 === 13) ? 1 : currentMonth + 2;
		let prevClanederYear = (nextCalenderMonth == 1) ? (currentYear + 1) : currentYear;

		calendar.innerHTML = calendar.innerHTML + '<div class="day next disable year' + prevClanederYear + ' month' + nextCalenderMonth + ' date' + i + '"><div><div class="month-date">' + i + '</div></div>'
	}

	// 달력에 표시된 전월 현월 다음월 일 수 만큼 배열리스트 할당
	arrayDate = new Array(prevDate - (prevDate - prevDay + 1) + (nextDate + 1) + (7 - nextDay == 7 ? 0 : 7 - nextDay));



	renderSchedule();

	writeSchedule();

	console.log(arrayDate)
}

// 달력 일정 렌더링
function renderSchedule() {
	for (let i = 0; i < arrayDate.length; i++) {
		let divYear = calendar.children[i].className.match(/year(\d+)/);
		let divMonth = calendar.children[i].className.match(/month(\d+)/);
		let divDate = calendar.children[i].className.match(/date(\d+)/);

		prevDateLength = prevDate - (prevDate - prevDay + 1);

		// 일별 데이터에 해당 일 추가
		let dateData = {
			date: (divYear && divYear[1]) + '.' + (divMonth && divMonth[1]) + '.' + (divDate && divDate[1]),
			title: '',
			titleLength: ''
		};

		let foldingCnt = '';

		for (let j = 0; j < CompanyScheduleList.length; j++) {
			if (CompanyScheduleList[j].cs_year == divYear[1] && CompanyScheduleList[j].cs_month == divMonth[1]) {
				// 해당월 일정안 date를 split
				let splitDates = CompanyScheduleList[j].cs_date.split(',');
				// split한 데이터의 개수를 돌림	
				for (let k = 0; k < splitDates.length; k++) {
					// 일과 데이터의 값이 일치할경우 객체에 추가
					if (splitDates[k] == (divDate && divDate[1])) {
						dateData.title += CompanyScheduleList[j].cs_no + '.' + CompanyScheduleList[j].cs_title + ',';
						foldingCnt++;
					}
				}
			}
		}

		dateData.titleLength = foldingCnt;
		dateData.title = dateData.title.slice(0, -1);
		arrayDate[i] = dateData;
	}
}

// 일정 추가를 위한 체크
function checkDate(e) {
	if (e.target.value == 0) {
		e.target.closest('.day.current').children[0].style.backgroundColor = '#ACF6B3';
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

function insertTrouble(input) {
	input.style.background = '#3B82F6';
	input.style.color = '#FFF';
	if (input == document.querySelector('.input-date')) {
		input.value = input.value = '日付を選択してください！！！';
	} else {
		input.value = input.value = '入力必要！！！';
	}
	setTimeout(function() {
		input.style.backgroundColor = "#FFF";
		if (input == document.querySelector('.input-date')) {
			input.value = input.value = thisMonth.getFullYear() + '年 ' + (thisMonth.getMonth() + 1) + '月 ';
		} else {
			input.value = input.value = '';
		}
		input.style.color = '#000';
	}, 1000);
}

// 일정 추가
function insertCompanyC() {
	if (document.querySelector('.input-title').value == '') {
		insertTrouble(document.querySelector('.input-title'));
		return;
	}

	if (document.querySelector('.input-date').value.split('月 ')[1] == '') {
		insertTrouble(document.querySelector('.input-date'));
		return;
	}

	if (document.querySelector('.input-txt').value == '') {
		insertTrouble(document.querySelector('.input-txt'));
		return;
	}

	let insertScheduleData = {
		cs_title: document.querySelector('.input-title').value,
		cs_date: document.querySelector('.input-date').value.split('月 ')[1],
		cs_txt: document.querySelector('.input-txt').value,
		cs_year: thisMonth.getFullYear(),
		cs_month: thisMonth.getMonth() + 1,
		cs_update: currentYear + '/' + currentMonth + '/' + currentDate + ' ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds(),
	}

	fetch('company/insert', {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(insertScheduleData),
	})
		.then(response => response.text())
		.then(data => {
			if (data == 1) {
				location.href = '/company';
			}
		})
		.catch(error => {
			console.error('데이터를 가져오는 중 오류 발생:', error);
		});
}


// ++ 건수 펼치기
function expandSchedule(e) {

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
		document.querySelector('.date-modal-title').innerHTML = '<div>' + arrayDate[parseInt(modalDivDate[1]) + prevDateLength].date + '</div>';


		// 모달 title 표시
		document.querySelector('.date-modal-content').innerHTML = '';
		let modalTitleData = arrayDate[parseInt(modalDivDate[1]) + prevDateLength].title.split(',');
		for (i = 2; i < modalTitleData.length; i++) {
			if (modalTitleData[0] != '') {
				document.querySelector('.date-modal-content').innerHTML += '<div class="modalTitleData"><input class="detailValue" value="' + (modalTitleData[i].split('.'))[0]
					+ '" type="hidden"><div>' + (modalTitleData[i].split('.'))[1] + '</div><a class="getScheduleDetail">상세보기</a></div>';
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
function getScheduleDetailModal(e, directDetail) {
	let addLeft = '';
	let zIndex = 0;

	if (directDetail) {
		addLeft = (e.target.getBoundingClientRect().width / 2);
		dateDivValue = e.target.children[0].value
		arrayNumber = e.target.className.match(/array(\d+)/)[1];
	} else {
		addLeft = (document.querySelector('.getScheduleDetail').getBoundingClientRect().width / 2);
		dateDivValue = e.target.previousSibling.previousSibling.value;
		arrayNumber = e.target.closest('.date-modal').className.match(/array(\d+)/)[1];
	}

	document.querySelector('.detail-schedule').style.left = e.target.getBoundingClientRect().left + addLeft + 'px';

	document.querySelector('.detail-schedule').style.zIndex = 2;

	// 모달 title 해당 일정 표시 설계의 문제가 나타남.
	for (let i = 0; i < CompanyScheduleList.length; i++) {
		if (CompanyScheduleList[i].cs_no == dateDivValue) {
			document.querySelector('.detail-schedule-title').textContent = CompanyScheduleList[i].cs_title;

			selectDetailSchedule = CompanyScheduleList[i];
			selectDetailSchedule.arrayNo = i;
		}
	}

	document.querySelector('.detail-schedule-content').innerHTML = '';

	// 일정
	for (i = 0; i < selectDetailSchedule.cs_date.split(',').length; i++) {
		if (i == 0) {
			document.querySelector('.detail-schedule-content').innerHTML += '<div class="datail-schedule-txt show" style="padding-bottom : 10%"><span>' + selectDetailSchedule.cs_txt + '</span><a onclick="updateAtagClick(this)">修正</a></div>'
			document.querySelector('.detail-schedule-content').innerHTML += '<div class="datail-schedule-txt" style="padding-bottom : 10%"><input value="' + selectDetailSchedule.cs_txt + '"><a onclick="updateTxt(this)" >保存</a><a onclick="updateAtagClick(this)" class="update-txt-cancel">取り消し</a></div>'
		}

		document.querySelector('.detail-schedule-content').innerHTML += '<div class="datail-schedule-data ' + (selectDetailSchedule.cs_date.split(','))[i] + '"><div>' + selectDetailSchedule.cs_year + '.' + selectDetailSchedule.cs_month + '.' + (selectDetailSchedule.cs_date.split(','))[i] + '</div><a onclick="deleteScheduleDateClick(this)" class="delete-detail-data">削除</a><a onclick="deleteScheduleDate(this)" class="delete-detail-data">削除確認</a><a onclick="deleteScheduleDateClick(this)" class="delete-detail-data">取り消し</a></div>';

		if (i == selectDetailSchedule.cs_date.split(',').length - 1) {
			document.querySelector('.detail-schedule-content').innerHTML += '<div class="delete-all-detail-data" style="padding-top : 10%"><a onclick="rowScheduleDeleteClick(this)">全部削除</a></div>'
		}

		document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].style.backgroundColor = '#ACF6B3';
		document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].children[1].checked = true;

	}


	document.querySelector('.detail-schedule').style.top = e.target.getBoundingClientRect().top - document.querySelector('.detail-schedule').getBoundingClientRect().height + (e.target.getBoundingClientRect().height / 2) + 'px';
	document.querySelector('.detail-schedule').style.visibility = 'visible';
	dateDetailModal = 1;


	for (let i = 0; i < document.querySelectorAll('.datail-schedule-data').length; i++) {
		document.querySelectorAll('.datail-schedule-data')[i].children[1].style.display = 'flex';
		document.querySelectorAll('.datail-schedule-data')[i].children[2].style.display = 'none';
		document.querySelectorAll('.datail-schedule-data')[i].children[3].style.display = 'none';
		document.querySelectorAll('.datail-schedule-data')[i].children[3].style.marginLeft = '-30%';
	}

	if (dateDetailModal == 1) {
		document.querySelector('.detail-schedule-close').addEventListener("click", function() {
			document.querySelector('.detail-schedule').style.visibility = 'hidden';

			for (i = 0; i < selectDetailSchedule.cs_date.split(',').length; i++) {
				document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].style.backgroundColor = '#FFF';
				document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].children[1].checked = false;
			}

			dateDetailModal = 0;
		})
	}
}


// 일정 렌더링을 위한 
function writeSchedule() {

	for (let i = 0; i < arrayDate.length; i++) {
		let splitDates = arrayDate[i].title.split(',');

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
			calendar.children[i].children[3].textContent = '++' + (arrayDate[i].titleLength - 2) + '件';
		}
	}
}

// 일정 내용 업데이트 전 클릭
function updateAtagClick(atag) {
	const atagParent = atag.parentNode;
	atagParent.classList.remove('show');


	if (atag.innerText == '修正') {
		atagParent.nextSibling.classList.add('show');
	} else {
		atagParent.previousSibling.classList.add('show');
	}
}

// 일정 내용 업데이트
function updateTxt(atag) {
	if (atag.previousSibling.value == '') {
		atag.previousSibling.style.background = '#3B82F6';
		atag.previousSibling.style.color = '#FFF';
		atag.previousSibling.value = atag.previousSibling.value = '入力必要！！！';
		setTimeout(function() {
			atag.previousSibling.style.backgroundColor = "#FFF";
			atag.previousSibling.value = atag.previousSibling.value = '';
			atag.previousSibling.style.color = '#000';
		}, 1000);
		return;
	}

	let inputUpdateTxt = atag.previousSibling.value;

	let params = {
		cs_txt: inputUpdateTxt,
		cs_no: selectDetailSchedule.cs_no
	}

	fetch('company/update', {
		method: 'PUT',
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(params),
	})
		.then(response => response.text())
		.then(data => {
			if (data == 1) {
				selectDetailSchedule.txt = atag.previousSibling.value;

				atag.parentNode.previousSibling.children[0].innerText = selectDetailSchedule.txt;

				atag.parentNode.classList.remove('show');
				atag.parentNode.previousSibling.classList.add('show');
			} else {

			}
		})
}

// 일정 데이터 한개삭제 전 클릭
function deleteScheduleDateClick(atag) {

	if (atag.innerText == '削除') {
		if (document.querySelectorAll('.datail-schedule-data').length == 1) {

			rowScheduleDeleteClick(atag);

		} else {
			atag.parentNode.children[1].style.display = 'none';
			atag.parentNode.children[2].style.display = 'flex';
			atag.parentNode.children[3].style.display = 'flex';
		}

	} else {
		atag.parentNode.children[1].style.display = 'flex';
		atag.parentNode.children[2].style.display = 'none';
		atag.parentNode.children[3].style.display = 'none';
	}

}

// 일정 데이터 한개 삭제
function deleteScheduleDate(atag) {

	console.log(selectDetailSchedule.cs_date);
	let remainDate = selectDetailSchedule.cs_date.split(',');
	console.log(document.querySelector('.detail-schedule-title').innerText)

	if (remainDate.indexOf(atag.parentNode.classList[1]) != -1) {
		console.log(remainDate.indexOf(atag.parentNode.classList[1]));
		remainDate.splice(remainDate.indexOf(atag.parentNode.classList[1]), 1);
	}

	remainDate = remainDate.join(',');
	console.log(remainDate);
	let params = {
		cs_date: remainDate,
		cs_no: selectDetailSchedule.cs_no
	}

	fetch('company/delete', {
		method: 'PUT',
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(params),
	})
		.then(response => response.text())
		.then(data => {
			if (data == 1) {

				let remainDates = '';

				for (i = 0; i < selectDetailSchedule.cs_date.split(',').length; i++) {
					document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].style.backgroundColor = '#FFF';
					document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].children[1].checked = false;
				}

				for (let i = 0; i < arrayDate.length; i++) {
					if (arrayDate[i].date == atag.parentNode.children[0].innerText) {
						remainDates = arrayDate[i].title.split(',');
						for (let j = 0; j < arrayDate[i].title.split(',').length; j++) {
							if (arrayDate[i].title.split(',')[j].split('.')[0] == selectDetailSchedule.cs_no) {
								remainDates.splice(j, 1);
							}
						}
						remainDates = remainDates.join(',');
						arrayDate[i].title = remainDates;
					}
				}

				atag.parentNode.remove();
				selectDetailSchedule.cs_date = remainDate;

				document.querySelectorAll('.schedule').forEach(function(scheduleElement) {
					scheduleElement.remove();
				});

				writeSchedule();

				for (i = 0; i < selectDetailSchedule.cs_date.split(',').length; i++) {
					document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].style.backgroundColor = '#ACF6B3';
					document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].children[1].checked = true;
				}
			} else {
			}
		})
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

// 일정데이터 삭제
function rowScheduleDelete(a) {
	if (a == 'disagree') {
		document.querySelector('.confirm-delete').style.display = "none";
		confirmDeleteModal = 0;
	} else {

		let params = {
			cs_no: dateDivValue
		}

		fetch('company/deleterow', {
			method: 'DELETE',
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(params),
		})
			.then(response => response.text())
			.then(data => {
				if (data) {

					for (let i = 0; i < CompanyScheduleList.length; i++) {
						if (CompanyScheduleList[i].cs_no == dateDivValue) {
							CompanyScheduleList.splice(CompanyScheduleList[i].arrayNo, 1);
						}
					}

					document.querySelectorAll('.schedule').forEach(function(scheduleElement) {
						scheduleElement.remove();
					});

					renderSchedule();

					writeSchedule();

					for (i = 0; i < selectDetailSchedule.cs_date.split(',').length; i++) {
						document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].style.backgroundColor = '#FFF';
						document.querySelector('.current.date' + selectDetailSchedule.cs_date.split(',')[i]).children[0].children[1].checked = false;
					}

					document.querySelector('.confirm-delete').style.display = "none";
					confirmDeleteModal = 0;

					document.querySelector('.detail-schedule').style.visibility = 'hidden';
					dateDetailModal = 0;

					document.querySelector('.date-modal').style.visibility = 'hidden';
					dateModal = 0;
				} else {
				}
			})
	}
}

// 디테일창 드래그앤 드롭
function scheduleDetailDroDrop() {
	document.querySelector('.detail-schedule-title').addEventListener("mousedown", function(e) {
		isDragging = true;
		modalOffsetX = e.offsetX;
		modalOffsetY = e.offsetY;
	})

	// 모달창 드래그 중
	document.querySelector('.detail-schedule-title').addEventListener("mousemove", function(e) {
		if (isDragging) {
			const x = e.clientX - modalOffsetX;
			const y = e.clientY - modalOffsetY;
			document.querySelector('.detail-schedule').style.left = x + 'px';
			document.querySelector('.detail-schedule').style.top = y + 'px';
		}

	})

	// 모달창 드래그 중
	document.querySelector('.detail-schedule-title').addEventListener("mousereave", function() {
		if (isDragging) {
			isDragging = false;
		}
	})

	// 모달창 드래그 종료
	document.querySelector('.detail-schedule-title').addEventListener("mouseup", function() {
		isDragging = false;
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

	if (window.location.pathname.includes('company')) {
		toggle[0].classList.toggle('active');
		toggleInfo.active = true;
		toggleList[0] = toggleInfo;
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