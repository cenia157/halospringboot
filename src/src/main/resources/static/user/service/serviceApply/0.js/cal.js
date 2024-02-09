

let date = new Date();
let viewYear, viewMonth;
let isStartDateSelected = false;
let startOldDate = null;
let endOldDate = null;
const startDateInput = document.getElementById('start-date-sel');
const endDateInput = document.getElementById('end-date-sel');




const renderCalendar = () => {

	console.log('그리기 실행 ~~~~~~~~~~~~~~~~~~~~~~')
	viewYear = date.getFullYear();
	viewMonth = date.getMonth();
	const formattedMonth = viewMonth + 1 < 10 ? `0${viewMonth + 1}` : `${viewMonth + 1}`;
	// year-month 채우기

	document.querySelector(".year-month").textContent = `${viewYear}年 ${viewMonth + 1}月`;

	// 지난 달 마지막 Date, 이번 달 마지막 Date
	const prevLast = new Date(viewYear, viewMonth, 0);
	const thisLast = new Date(viewYear, viewMonth + 1, 0);

	const PLDate = prevLast.getDate();
	const PLDay = prevLast.getDay();

	const TLDate = thisLast.getDate();
	const TLDay = thisLast.getDay();

	// Dates 기본 배열들
	const prevDates = [];
	const thisDates = [...Array(TLDate + 1).keys()].slice(1);
	const nextDates = [];

	// prevDates 계산
	if (PLDay !== 6) {
		for (let i = 0; i < PLDay + 1; i++) {
			prevDates.unshift(PLDate - i);
		}
	}

	// nextDates 계산
	for (let i = 1; i < 7 - TLDay; i++) {
		nextDates.push(i);
	}

	// Dates 합치기
	const dates = prevDates.concat(thisDates, nextDates);

	// Dates 정리
	const firstDateIndex = dates.indexOf(1);
	const lastDateIndex = dates.lastIndexOf(TLDate);
	dates.forEach((day, i) => {
		let condition;
		let formattedDay = day < 10 ? `0${day}` : day;
		if (i >= firstDateIndex && i < lastDateIndex + 1) {
	condition = `<div class="date" id="${viewYear}-${formattedMonth}-${formattedDay}" style="cursor:pointer">
  <span class="this">${formattedDay}</span> </div>`;
		}else {
			condition = `<div class="date other"><span class="other"></span></div>`;
		}
		dates[i] = condition;
	});

	datesElement.innerHTML = dates.join("");


	//    const datesElement = document.querySelector(".dates");
	//
	//// 여기서 바꿔즘 2자리로
	//	datesElement.addEventListener("click", (e) => {
	//  const clickedElement = e.target;
	//  if (clickedElement.classList.contains('date')) {
	//    const formattedDay = clickedElement.textContent.trim();
	//    setDate(formattedDay, clickedElement);
	//  }
	//});
	
	
	const startInputCal = document.getElementById(startDateInput.value)
	const endInputCal = document.getElementById(endDateInput.value)
	if (startDateInput && startInputCal){
	startInputCal.style.backgroundColor = 'red';
	startInputCal.style.color = 'white';
	startInputCal.querySelector('.this').insertAdjacentHTML('beforeend', '<br>開始日');	
	}
	if (endDateInput && endInputCal){
	endInputCal.style.backgroundColor = 'blue';
	endInputCal.style.color = 'white';
	endInputCal.querySelector('.this').insertAdjacentHTML('beforeend', '<br>終了日');	
	
	}
	
	
	
}
//////////달력 생성 끝/////////////////


const datesElement = document.querySelector(".dates");
datesElement.addEventListener("click", (e) => {
    const clickedElement = e.target.closest('.date');
    if (clickedElement) {
        const formattedDay = clickedElement.textContent.trim();
        setDate(formattedDay, clickedElement);
    }
});

//	const datesElement = document.querySelector(".dates");
//	datesElement.addEventListener("click", (e) => {
//	const clickedElement = e.target;
//	if (clickedElement.classList.contains('date')) {
//		const formattedDay = clickedElement.textContent.trim();
//		setDate(formattedDay, clickedElement);
//	}
//});











/////////////////Input으로 날짜 선택 ///////////////////////////////////






// 시작일 input에서 날짜 선택
startDateInput.addEventListener('change', function(select) {

	const selectedDate = event.target.value; // 선택한 날짜
	const startDateCal = document.getElementById(selectedDate);
	const old = document.getElementById(startOldDate);


	if (endDateInput.value && endDateInput.value < selectedDate) {
		alert('종료일 이후 날짜는 선택할 수 없습니다.')
		if (old) {
			startDateInput.style.backgroundColor = 'gray';
			startDateInput.style.color = 'white';
		}
		startDateInput.value = startOldDate;
		console.log('startOldDate' + startOldDate);
		return;
	}


	startDateInput.style.backgroundColor = 'gray';
	startDateInput.style.color = 'white';

	//	시작일과 종료일 같을때 당일로 표시
	if (endDateInput.value && endDateInput.value == selectedDate) {
		if (startOldDate && old) {
			old.style.backgroundColor = '';
			old.style.color = '';
			old.querySelector('.this').innerHTML = old.querySelector('.this').innerHTML.replace('<br>開始日', '');
		}

		startDateCal.style.backgroundColor = 'purple';
		startDateCal.style.color = 'white';
		startDateCal.querySelector('.this').innerHTML = startDateCal.querySelector('.this').innerHTML.replace('<br>終了日', '');
		startDateCal.querySelector('.this').insertAdjacentHTML('beforeend', '<br>当日');
		startOldDate = selectedDate;
		return;
	}


	// 시작일
	console.log("endOldDate: ??????????" + endOldDate);
	console.log("startOldDate: ??????????" + startOldDate);
	if (startOldDate && endOldDate && startOldDate == endOldDate) {

		// 시작일에 스타일 넣기
		console.log('스타트과거 값 : ' + startOldDate);
		console.log('과거 값 : ' + old);
		old.querySelector('.this').innerHTML = old.querySelector('.this').innerHTML.replace('<br>当日', '');
		endDateInput.style.backgroundColor = 'gray';
		endDateInput.style.color = 'white';
		old.style.backgroundColor = 'blue';
		old.style.color = 'white';
		old.querySelector('.this').insertAdjacentHTML('beforeend', '<br>終了日');

	} else if (startOldDate) {
		old.style.backgroundColor = '';
		old.style.color = '';
		old.querySelector('.this').innerHTML = old.querySelector('.this').innerHTML.replace('<br>開始日', '');
	} 
	
	if(startDateCal){
	startDateCal.style.backgroundColor = 'red';

	startDateCal.style.color = 'white';
	startDateCal.querySelector('.this').insertAdjacentHTML('beforeend', '<br>開始日');
	startOldDate = selectedDate;
	}
	
	
});

// 종료일 input에서 날짜 선택
endDateInput.addEventListener('change', function(event) {

	const selectedDate = event.target.value; // 선택한 날짜
	console.log('선택된 종료 날짜:', selectedDate);
	const endDateCal = document.getElementById(selectedDate);
	console.log('달력 종료 날짜:', endDateCal);
	const old = document.getElementById(endOldDate);

	console.log('시작일 날짜:', startDateInput.value);

// 시작일 보다 작은 날짜 선택했을때
	if (startDateInput.value && startDateInput.value > selectedDate) {
		alert('시작일 이전 날짜는 선택할 수 없습니다.')
		if (old) {
			endDateInput.style.backgroundColor = 'gray';
			endDateInput.style.color = 'white';
		}
		endDateInput.value = endOldDate;
		return;
	}

	endDateInput.style.backgroundColor = 'gray';
	endDateInput.style.color = 'white';

	//	종료일과 시작일 같을때 당일로 표시	
	
	if (startDateInput.value && startDateInput.value == selectedDate) {
		if (endOldDate && old) {
			old.style.backgroundColor = '';
			old.style.color = '';
			old.querySelector('.this').innerHTML = old.querySelector('.this').innerHTML.replace('<br>終了日', '');
		}
		endDateCal.style.backgroundColor = 'purple';
		endDateCal.style.color = 'white';
		endDateCal.querySelector('.this').innerHTML = endDateCal.querySelector('.this').innerHTML.replace('<br>開始日', '');
		endDateCal.querySelector('.this').insertAdjacentHTML('beforeend', '<br>当日');
		endOldDate = selectedDate;
		return;
	}

	// 선택한 종료일에 스타일 넣기
	// input값에 해당하는 값이 달력에 없는 경우

	//	종료일
		console.log("endOldDate: ??????????" + endOldDate);
	console.log("startOldDate: ??????????" + startOldDate);
	if (startOldDate && endOldDate && startOldDate == endOldDate) {

		// 종료일에 스타일 넣기
		old.querySelector('.this').innerHTML = old.querySelector('.this').innerHTML.replace('<br>当日', '');
		startDateInput.style.backgroundColor = 'gray';
		startDateInput.style.color = 'white';
		old.style.backgroundColor = 'red';
		old.style.color = 'white';
		old.querySelector('.this').insertAdjacentHTML('beforeend', '<br>開始日');
		endOldDate = selectedDate;

	} else if (endOldDate) {
		old.style.backgroundColor = '';
		old.style.color = '';
		old.querySelector('.this').innerHTML = old.querySelector('.this').innerHTML.replace('<br>終了日', '');
		endOldDate = selectedDate;
	} else {
		endOldDate = selectedDate;
	}
	if(endDateCal){
	endDateCal.style.backgroundColor = 'blue';
	endDateCal.style.color = 'white';
	endDateCal.querySelector('.this').insertAdjacentHTML('beforeend', '<br>終了日');
	endOldDate = selectedDate;
	}
});



/////////////////Input으로 날짜 선택 끝///////////////////////////////////








// 초기에 기본 힌트를 설정
const startInput = document.getElementById('start-date-sel');
const endInput = document.getElementById('end-date-sel');
startInput.value = ''; // 빈 값으로 초기화
endInput.value = ''; // 빈 값으로 초기화
startInput.addEventListener('focus', function() {
	this.setAttribute('placeholder', '날짜를 선택해주세요');
});
endInput.addEventListener('focus', function() {
	this.setAttribute('placeholder', '날짜를 선택해주세요');
});



// setDate 초기화 함수

document.getElementById('prev-button').addEventListener('click', function(event) {
    event.preventDefault(); // 이벤트의 기본 동작을 막음
    changeMonth(-1); // 기존 기능 실행
});

document.getElementById('next-button').addEventListener('click', function(event) {
    event.preventDefault(); // 이벤트의 기본 동작을 막음
    changeMonth(1); // 기존 기능 실행
});
//document.getElementById('prev-button').addEventListener('click', () => changeMonth(-1));
//document.getElementById('next-button').addEventListener('click', () => changeMonth(1));
const changeMonth = (change) => {
	resetSetDate();
	date.setMonth(date.getMonth() + change);
	viewYear = date.getFullYear();
	viewMonth = date.getMonth() + 1;
	const formattedMonth = viewMonth < 10 ? `0${viewMonth}` : viewMonth;
	console.log('챈지의 formattedMonth : ' + formattedMonth);
	isStartDateSelected = false; // 달 변경 시 선택 상태 초기화
	console.log('~~~~~~~~~~')
	renderCalendar();

	// 이후에 날짜를 렌더링하거나 필요한 처리를 수행할 수 있습니다.
	// ...
};


/////////////setDate시작
const setDate = (day, clickedElement) => {
	const formattedMonth = `${viewMonth + 1}`.padStart(2, '0');
	const formattedDay = `${day}`.padStart(2, '0');
	const selectedDate = `${viewYear}-${formattedMonth}-${formattedDay}`;
	console.log('setDate의 formattedMonth : ' + formattedMonth);
	const startDateInput = document.getElementById('start-date-sel');
	const endDateInput = document.getElementById('end-date-sel');

	const startOld = document.getElementById(startOldDate);
	const endOld = document.getElementById(endOldDate);


	const oldEndDate = document.getElementById(endOldDate);
	const oldStartDate = document.getElementById(startOldDate);
	let styleInput = 1;

	console.log('clickedElement :' + clickedElement.style.backgroundColor);
	if (clickedElement.style.backgroundColor) {
		if (endOld) {
			console.log('엔드 데이터 없음')
			resetColorAndValue(endOld, clickedElement);
		} else if(startOld){
			console.log('스타트데이터')
			resetColorAndValue(startOld, clickedElement);
		} else {
			console.log('이전 데이터 없음')
			resetColorAndValue(clickedElement, clickedElement);
			
		}
		styleInput = 0;
	} else if (!startDateInput.value && !endDateInput.value) {
		// 시작값이 없고 선택일에 색이 없을때 시작값을 넣어준다
		console.log('시작값 넣어주기');
		startDateInput.value = selectedDate;
		startOldDate = selectedDate;
		styleInput = 1;
	}else if(!startDateInput.value && endDateInput.value && selectedDate < endDateInput.value){
		// 시작값이 없고 종료값이 있고 선택한 값이 종료일 보다 작을때
		startDateInput.value = selectedDate;
		startOldDate = selectedDate;
		styleInput = 1;
	}else if(!startDateInput.value && endDateInput.value && !startOld && selectedDate < endDateInput.value){
		// 시작값이 없고 종료값이 있는데 이전 시작값이 없고 선택한 값이 종료일 보다 작을때
		startDateInput.value = selectedDate;
		startOldDate = selectedDate;
		styleInput = 1;
	}else if(startDateInput.value && endDateInput.value && selectedDate == startDateInput.value){
		resetColorAndValue(oldStartDate, clickedElement)
		startDateInput.value = selectedDate;
		startOldDate = null;
		styleInput = 1;
	}else if(startDateInput.value && !endDateInput.value && selectedDate == startDateInput.value){
		resetColorAndValue(oldStartDate, clickedElement)
		startDateInput.value = selectedDate;
		startOldDate = selectedDate;
		styleInput = 1;
	} else if (selectedDate < startDateInput.value) {
		if(startOldDate || !endOldDate){
		resetColorAndValue(oldStartDate, clickedElement);
		}
		startDateInput.value = selectedDate;
		startOldDate = selectedDate;
		styleInput = 1;
	} else if (startDateInput.value && startDateInput.value != endDateInput.value) {
		// 시작값이 있고 종료값이 없고 선택일에 색이 없으면 종료값 넣어준다
		if (endDateInput.value && endOld ) {
		console.log('endOld'+endOld.value);
			resetColorAndValue(oldEndDate, clickedElement);
		}
		endDateInput.value = selectedDate;
		endOldDate = selectedDate;
		styleInput = 1;
	} else if (startDateInput.value && endDateInput.value && clickedElement.id == endDateInput.value) {
		// 시작값이 있고 종료값이 있고 선택일 값과 종료일 값이 같을때 종료,과거,색상 초기화
		resetColorAndValue(oldEndDate, clickedElement);
		styleInput = 0;
	}
	
	


	console.log('start : ' + startDateInput.value);
	console.log('end : ' + endDateInput.value);
	console.log('selected date : ' + selectedDate);
	console.log(startDateInput.style.backgroundColor);
	console.log(endDateInput.style.backgroundColor);
	console.log('clickedElement123 :' + clickedElement.style.backgroundColor);

	const clickedText = clickedElement.textContent.trim(); // 클릭된 요소의 텍스트 값

	// 텍스트를 숫자로 변환하여 비교
	const clickedNumber = parseInt(clickedText, 10); // 숫자로 변환 (10진수 기준)

	// 스타일 넣어주는 기능
	if (styleInput == 1) {
		console.log('styleInput : ' + styleInput);
		if (selectedDate < endDateInput.value || !clickedElement.style.backgroundColor && !endDateInput.value) {
			console.log('시작 스타일 넣어주기');
			startDateInput.style.backgroundColor = 'gray';
			startDateInput.style.color = 'white';
			clickedElement.style.backgroundColor = 'red';
			clickedElement.style.color = 'white';
			clickedElement.querySelector('.this').innerHTML += '<br>開始日';
		} else if (endDateInput.value === clickedElement.id && !clickedElement.style.backgroundColor) {
			endDateInput.style.backgroundColor = 'gray';
			endDateInput.style.color = 'white';
			clickedElement.style.backgroundColor = 'blue';
			clickedElement.style.color = 'white';
			clickedElement.querySelector('.this').innerHTML += '<br>終了日';
		}
	}
	
	
	
};
//////////setDate 끝

const resetColorAndValue = (e , clickedElement) => {
const startInputCal = document.getElementById(startDateInput.value);
const endInputCal = document.getElementById(endDateInput.value);

console.log('clickedElement.style.backgroundColor :' + clickedElement.style.backgroundColor);
console.log('startDateInput.value' + startDateInput.value);
console.log('endDateInput' + endDateInput.value);

//		if (e.style.backgroundColor == 'red' && !endDateInput.value && e == clickedElement) {
		if(!endDateInput.value && startDateInput.value == clickedElement.id){
			
			endDateInput.value = clickedElement.id;
			clickedElement.querySelector('.this').innerHTML = clickedElement.querySelector('.this').innerHTML.replace('<br>開始日', '');
			endDateInput.style.backgroundColor = 'gray';
			endDateInput.style.color = 'white';
			clickedElement.style.backgroundColor = 'purple';
			clickedElement.style.color = 'white';
			clickedElement.querySelector('.this').innerHTML += '<br>当日';
		}else if (startDateInput.value == clickedElement.id && clickedElement.style.backgroundColor == 'red' ) {
			startDateInput.value = '';
			startDateInput.style.removeProperty('background-color');
			startDateInput.style.removeProperty('color');
			clickedElement.style.backgroundColor = '';
			clickedElement.style.color = '';
			clickedElement.querySelector('.this').innerHTML = clickedElement.querySelector('.this').innerHTML.replace('<br>開始日', '');
		}else if (e.style.backgroundColor == 'red' && e != clickedElement) {
			startDateInput.value = '';
			startDateInput.style.removeProperty('background-color');
			startDateInput.style.removeProperty('color');
			e.style.backgroundColor = '';
			e.style.color = '';
			e.querySelector('.this').innerHTML = e.querySelector('.this').innerHTML.replace('<br>開始日', '');
		} else if (e.style.backgroundColor == 'purple') {
			startDateInput.value = '';
			startDateInput.style.removeProperty('background-color');
			startDateInput.style.removeProperty('color');
			endDateInput.value = '';
			endDateInput.style.removeProperty('background-color');
			endDateInput.style.removeProperty('color');
			e.style.backgroundColor = '';
			e.style.color = '';
			e.querySelector('.this').innerHTML = e.querySelector('.this').innerHTML.replace('<br>当日', '');

		} else if (e.style.backgroundColor == 'blue') {
			endDateInput.value = '';
			endDateInput.style.removeProperty('background-color');
			endDateInput.style.removeProperty('color');
			e.style.backgroundColor = '';
			e.style.color = '';
			e.querySelector('.this').innerHTML = e.querySelector('.this').innerHTML.replace('<br>終了日', '');
			endOldDate = '';
		}
	};






const resetSetDate = () => {
	console.log('~~~~~~ reset called')
	const dates = document.querySelectorAll('.date');
	dates.forEach(dateElement => {
		dateElement.removeEventListener('click', setDate); // click 이벤트 제거
	});
	const datesElement = document.querySelectorAll(".dates");
	dates.forEach(dateElement => {
    dateElement.removeEventListener('click', (e) => {
		console.log('제거 완료')
    });
});
//	datesElement.forEach.removeEventListener("click", (e)=>{
//	});
	
	document.getElementById('prev-button').removeEventListener('click', changeMonth);
	document.getElementById('next-button').removeEventListener('click', changeMonth);
};


window.onload = function() {
	renderCalendar();

	// 이동 버튼 이벤트 리스너 설정

}

