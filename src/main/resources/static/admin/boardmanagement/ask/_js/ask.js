// 공통 함수: 모달 열기
function openModal(modalId, tblId) {
	document.getElementById(modalId).style.display = 'flex';
	document.getElementById(tblId).style.display = 'flex';

	// 아래 6줄은 모달창 열 때 스크롤 감추기 & 터치, 휠 불가
	$('html, body').css({ 'overflow': 'hidden', 'height': '100%' }); // 모달팝업 중 html,body의 scroll을 hidden시킴
	$('#element').on('scroll touchmove mousewheel', function(event) { // 터치무브와 마우스휠 스크롤 방지
		event.preventDefault();
		event.stopPropagation();
		return false;
	});
}

// 공통 함수: 모달 닫기
function closeModal(modalId, tblId) {
	document.getElementById(modalId).style.display = 'none';
	document.getElementById(tblId).style.display = 'none';

	// 아래 2줄은 모달창 닫을 때 스크롤 보여주기 & 터치, 휠 가능
	$('html, body').css({ 'overflow': 'auto', 'height': '100%' }); //scroll hidden 해제
	$('#element').off('scroll touchmove mousewheel'); // 터치무브 및 마우스휠 스크롤 가능


	// input 초기화
	var titleInput = document.getElementById("real-title-editor");
	if (titleInput != null) {
		titleInput.value = null;
	}

	// 사진 input 삭제
	var imageInputs = document.querySelectorAll("#img-url");
	imageInputs.forEach(function(input) {
		input.parentNode.removeChild(input);
	});

	// #kategorie 안의 input(#select)과 그 안의 텍스트 둘 다 삭제 및 '카테고리' 재설정
	var kategorieInput = document.querySelector('#kategorie input');
	if (kategorieInput) {
		kategorieInput.remove();
		document.querySelector('#kategorie').textContent = '카테고리';
	}
	// CKEditor 초기화
	if (window.editor != null) {
		window.editor.setData(""); // CKEditor의 내용을 빈 문자열로 설정합니다.
	}

}


function closeModalR2(modalId, tblId) {
	document.getElementById(modalId).style.display = 'none';
	document.getElementById(tblId).style.display = 'none';

	// 아래 2줄은 모달창 닫을 때 스크롤 보여주기 & 터치, 휠 가능
	$('html, body').css({ 'overflow': 'auto', 'height': '100%' }); //scroll hidden 해제
	$('#element').off('scroll touchmove mousewheel'); // 터치무브 및 마우스휠 스크롤 가능



	// input 초기화
	var titleInputR = document.getElementById("real-title-editorN");
	titleInputR.value = "";

	// 사진 input 삭제
	var imageInputsR = document.querySelectorAll("#img-url");
	imageInputsR.forEach(function(input) {
		input.parentNode.removeChild(input);
	});

	// #kategorie 안의 input(#select)과 그 안의 텍스트 둘 다 삭제 및 '카테고리' 재설정
	var kategorieInputR = document.querySelector('#kategorieR input');
	if (kategorieInputR) {
		kategorieInputR.remove();
		document.querySelector('#kategorieR').textContent = '카테고리';
	}
	// CKEditor 초기화
	window.editor.setData(""); // CKEditor의 내용을 빈 문자열로 설정합니다.













}

// 공통 함수: 모달 외부 클릭 시 닫기
function closeModalOnOutsideClick(modalId) {
	window.onclick = function(event) {
		if (event.target == document.getElementById(modalId)) {
			closeModal(modalId, getTblId(modalId));
		}
	};
}

// 공통 함수: 모달의 tbl 아이디 가져오기
function getTblId(modalId) {
	return modalId.replace('myModal', 'myModal-tbl');
}

// 자주묻는질문(frequenthyask) 모달
function openModalF() {
	openModal('myModalF', 'myModal-tblF');
	closeModalOnOutsideClick('myModalF');
}

function closeModalF() {
	closeModal('myModalF', 'myModal-tblF');
}

// 문의사항(ask) 모달
// 미답변 모달
function openModalN() {
	openModal('myModalN', 'myModal-tblN');
	closeModalOnOutsideClick('myModalN');
}

function closeModalN() {
	closeModal('myModalN', 'myModal-tblN');
}

//	답변 모달
function openModalA() {
	openModal('myModalA', 'myModal-tblA');
	closeModalOnOutsideClick('myModalA');
}

function closeModalA() {
	closeModal('myModalA', 'myModal-tblA');
}

// 공지사항(notice) 모달
// ViewPage를 띄우기 위한 모달
function openModalV() {
	openModal('myModalV', 'myModal-tblV');
	closeModalOnOutsideClick('myModalV');
}

function closeModalV() {
	closeModal('myModalV', 'myModal-tblV');
	closeModal('myModalR', 'myModal-tblR');
}

// RegPage를 띄우기 위한 모달
function openModalR() {
	openModal('myModalR', 'myModal-tblR');
}

function closeModalR() {
	closeModalR2('myModalR', 'myModal-tblR');
}

// NEWRegPage를 띄우기 위한 모달
function openModalNR() {
	openModal('myModalNR', 'myModal-tblNR');
	closeModalOnOutsideClick('myModalNR');
}

function closeModalNR() {
	closeModal('myModalNR', 'myModal-tblNR');
}

//여기까지 모달 관련 function

//여기부터 ask 관련 function


let updateCategory = '';
document.querySelector('.ontent-m-td-2-mid').addEventListener("click", function(e) {
	if (e.target.parentNode.className == 'ontent-m-td-2-content-txt-title-in') {
		updateCategory = e.target.parentNode.previousSibling.previousSibling;
	}
});

//문의사항@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
function getData(q_seq, e, q_title, q_content, q_reg_date, q_contact_number, q_email, q_name, q_password, q_category) {

	// 첫 번째 Ajax 요청
	$.ajax({
		url: "/admin/boardManagement/questiondetail/" + q_seq,
		type: "post",
		dataType: "json",
		data: {
			q_seq: q_seq,
			q_title: q_title,
			q_content: q_content,
			q_reg_date: q_reg_date,
			q_contact_number: q_contact_number,
			q_email: q_email,
			q_name: q_name,
			q_password: q_password,
			q_category: q_category
		},
		success: function(data) {
			try {

				if (Array.isArray(data) && data.length > 0) {
					let qSeq = data[0].q_seq;
					let qTitle = data[0].q_title;
					let qContent = data[0].q_content;
					let qRegDate = new Date(data[0].q_reg_date);
					let formattedDate = formatDate(qRegDate);
					let qCN = data[0].q_contact_number;
					let qEmail = data[0].q_email;
					let qName = data[0].q_name;
					let qPW = data[0].q_password;
					let qCategory = data[0].q_category;


					// A questions 데이터 표시
					$('#A_QUESTION_TITLE').html(qTitle);
					$('#A_QUESTION_DATE').html(formattedDate);
					$('#A_QUESTION_NAME').html(qName);
					$('#A_QUESTION_CONTENT').html(qContent);
					$('#A_QUESTION_PHONE').html(qCN);
					$('#A_QUESTION_EMAIL').html(qEmail);
					$('#A_QUESTION_CATEGORY').html(qCategory);

					// N questions 데이터 표시
					$('#N_QUESTION_TITLE').html(qTitle);
					$('#N_QUESTION_DATE').html(formattedDate);
					$('#N_QUESTION_NAME').html(qName);
					$('#N_QUESTION_CONTENT').html(qContent);
					
					$('#N_QUESTION_PHONE').html(qCN);
					$('#N_QUESTION_EMAIL').html(qEmail);
					$('#N_QUESTION_CATEGORY').html(qCategory);
					$('#q_seq').val(qSeq);
					//확인
					$('#QUESTION_SEQ').html(qSeq);


					// comments 데이터를 가져와서 표시
					getComments(q_seq);

				} else {
					console.error("No Data");
				}

			} catch (error) {
				console.error("Data Error:", error);
			}
		},
		error: function(xhr, status, error) {
			console.log("Error:", xhr, status, error);
		}
	});
}

// 댓글 불러오기
function getComments(q_seq, c_commenter_name, c_comment_content, c_reg_date, c_answer, c_seq) {

	$.ajax({
		url: "/admin/boardManagement/commentdetail/" + q_seq,
		type: "post",
		dataType: "json",
		data: {
			q_seq: q_seq,
			c_seq: c_seq,
			c_commenter_name: c_commenter_name,
			c_comment_content: c_comment_content,
			c_reg_date: c_reg_date,
			c_answer: c_answer
		},
		success: function(commentData) {
			try {

				if (Array.isArray(commentData) && commentData.length > 0) {
					let cSeq = commentData[0].c_seq;
					let c_commenter_name = commentData[0].c_commenter_name;
					let CRegDate = new Date(commentData[0].c_reg_date);
					let formattedDate = formatDate(CRegDate);
					let c_comment_content = commentData[0].c_comment_content;
					let c_answer = commentData[0].c_answer;
					let qSeq = commentData[0].q_seq;

					$('#COMMENT_CONTENT').val(c_comment_content);
					$('#COMMENT_NAME').html(c_commenter_name);
					$('#hidden_c_seq').val(cSeq);


					//모달창 열기
					if (c_comment_content != null) {
						openModalA();
					}else if (c_comment_content == null) {
						openModalN(q_seq);
					}
					else{
						console.log("Answer Modal Error")
					}

				} else {
					console.log("No Comment");
					//모달창 열기
					if (c_comment_content == null) {
						openModalN(q_seq);
					}
				}
			} catch (error) {
				console.error("Comment Error:", error);
			}
		},
		error: function(xhr, status, error) {
			console.log("Comment Error:", xhr, status, error);
		}
	});
}





//<<<<<<< HEAD


//날짜 바꾸기
function formatDate(date) {
	const pad = (num) => (num < 10 ? '0' + num : num);

	const year = date.getFullYear();
	const month = pad(date.getMonth() + 1);
	const day = pad(date.getDate());

	return `${year}-${month}-${day}`;
}
//=======
//};

function updateModalContent(questionJson) {
	$('#myModal-tblA #q_seq').html(`<div>${questionJson.q_seq}</div>`);
	$('#myModal-tblA #q_title').html(`<div>${questionJson.q_title}</div>`);
	$('#myModal-tblA #q_content').html(`<div>${questionJson.q_content}</div>`);
	$('#myModal-tblA #q_reg_date').html(`<div>${questionJson.q_reg_date}</div>`);
	$('#myModal-tblA #q_contact_number').html(`<div>${questionJson.q_contact_number}</div>`);
	$('#myModal-tblA #q_email').html(`<div>${questionJson.q_email}</div>`);
	$('#myModal-tblA #q_name').html(`<div>${questionJson.q_name}</div>`);
	$('#myModal-tblA #q_password').html(`<div>${questionJson.q_password}</div>`);
	$('#myModal-tblA #q_category').html(`<div>${questionJson.q_category}</div>`);
};

//>>>>>>> 36e0fd5048773fd508dc36122a0cc5d8316894cf



//CRUD: update
function updateComments() {

	let p = document.querySelector('#pageNum').value;
	let checkVal = '';
	let checkboxes = document.querySelectorAll('.filter:checked');
	checkboxes.forEach(function(checkbox) {
    	checkVal += checkbox.value;
	});
	

	let c_seq = $('#hidden_c_seq').val();
	let c_comment_content = $('#COMMENT_CONTENT').val();

	$.ajax({
		url: '/admin/boardManagement/commentupdate/'+p+'/'+checkVal,
		method: 'post',
		data: {
			c_seq: c_seq,
			c_comment_content: c_comment_content
		},

		success: function() {
			console.log("Update")
		},
		error: function(xhr, status, error) {
			console.log("Update Error:", xhr, status, error);
		}
	});

}

//작성자명 넘기기
$(document).ready(function (){
	let c_writer = $('#regBtnHiddeninput').val();
});


//CRUD: insert
function submitComments() {
	
	let p = document.querySelector('#pageNum').value;
	let checkVal = '';
	let checkboxes = document.querySelectorAll('.filter:checked');
	checkboxes.forEach(function(checkbox) {
    	checkVal += checkbox.value;
	});
	
	let c_comment_content = $('#c_comment_content').val();
	let q_seq = $('#q_seq').val();
	let c_writer = document.querySelector('#regBtnHiddeninput').value;


	$.ajax({
		url: '/admin/boardManagement/commentsubmit/'+p+'/'+checkVal,
		method: 'post',
		data: {
			q_seq: q_seq,
			c_comment_content: c_comment_content,
			c_writer : c_writer
			
		},

		success: function() {
			console.log("Submit");
			updateCategory.innerText = "完";
		},
		error: function(xhr, status, error) {
			console.log("Submit Error: ", xhr, status, error);
		}

	});
}

//CRUD: delete
function deleteQuestion(q_seq) {
	
	
	let p = document.querySelector('#pageNum').value;
	let pageCheck = document.querySelector('.current-page').innerText;
	let checkboxes = document.querySelectorAll('.filter:checked');
	let matches = pageCheck.match(/\d+/); // \d+ 정규식은 하나 이상의 숫자에 매칭됩니다.
	let pageNumber = matches ? parseInt(matches[0], 10) : null; // 추출된 숫자를 정수형으로 변환
	let checkVal = '';

	checkboxes.forEach(function(checkbox) {
    	checkVal += checkbox.value;
	});
	
	let ok = confirm("削除しますか?");

	if (ok) {
		$.ajax({
			url: '/admin/boardManagement/deletequestion/' + p +'/' + checkVal + '/' + q_seq + '/' + pageNumber,
			method: 'post',
			data: {
				q_seq: q_seq
			},
			success: function() {
				console.log("Delete");
				location.reload();
//				e.closest('.ontent-m-td-2-content-txt-in').remove();
			},
			error: function(xhr, status, error) {
				console.log("Delete Error: ", xhr, status, error);
			}


		});
	}
}

//체크박스 시작@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

$(document).ready(function() {
	// 페이지가 로드되면 체크박스의 값을 저장합니다.
	var checked = $('.filter').is(':checked');

	// 폼 제출 이벤트 리스너를 추가합니다.
	$('.filter').submit(function() {
		// 폼이 제출되기 전에 체크박스의 값을 검사합니다.
		if (checked) {
			// 체크박스가 체크되어 있으면 폼을 제출합니다.
			return true;
		} else {
			// 체크박스가 체크되어 있지 않으면 폼을 제출하지 않습니다.
			return false;
		}
	});
});

$(document).ready(function() {
	checkboxSubmit();
});


// 체크박스 제출
function checkboxSubmit() {
	// 체크박스의 change 이벤트를 감지
	$('input[type="checkbox"]').change(function() {
		// 체크박스가 변경되면 바로 폼을 제출
		$('.filter').submit();
	});

	// 폼 제출 시의 동작을 처리하는 함수
	$('.filter').submit(function() {
		// 폼이 제출될 때 수행할 동작 추가
		var checkboxData = [];
		$('input[type="checkbox"]').each(function() {
			checkboxData.push({
				value: $(this).val(),
				checked: $(this).prop('checked')
			});
		});
		fetchData(checkboxData);
		saveCheckBoxData();
	});
};


// 체크박스 상태 저장 함수
function saveCheckBoxData() {
	var checkboxData = {};

	// 각 체크박스의 상태를 checkboxData에 저장
	$('input[type="checkbox"]').each(function() {
		checkboxData[$(this).attr('name')] = $(this).prop('checked');
	});

	// checkboxData를 문자열로 변환하여 localStorage에 저장
	localStorage.setItem('checkboxData', JSON.stringify(checkboxData));
}

// 페이지 로딩 시 저장된 체크박스 상태 불러오기
$(document).ready(function() {
	var storedData = localStorage.getItem('checkboxData');

	if (storedData) {
		// 저장된 데이터가 있다면 파싱하여 체크박스 상태 설정
		storedData = JSON.parse(storedData);
		for (var key in storedData) {
			var checkbox = $('input[name="' + key + '"]');
			if (checkbox.length > 0) {
				checkbox.prop('checked', storedData[key]);

				//				fetchData(storedData);
			}
		}
	}
});

//AskContentC가 들어가면 무조건 둘다 체크된 상태로 만들기
$(document).ready(function() {
	// 현재 페이지의 URL을 가져옵니다.
	const currentUrl = window.location.href;

	// 현재 페이지의 URL에 AskContentC가 포함되어 있으면 체크박스를 모두 체크합니다.
	if (currentUrl.includes("AskContentC")) {
		$('input[type="checkbox"]').prop('checked', true);
		saveCheckBoxData();
	}
});


function fetchData(data) {
	$.ajax({
		url: "CheckboxC",
		method: "POST",
		data: {
			completed: data.some(item => item.value === 'completed' && item.checked),
			uncompleted: data.some(item => item.value === 'uncompleted' && item.checked)
		},
		success: function(responseData) {
			refreshData(responseData);
		},
		error: function(xhr, status, error) {
			console.log("Error: ", xhr, status, error)
		}
	});
}
//저장된 storedData의 값을 가져오도록 하는 function
function storedfetchData(data) {
	$.ajax({
		url: "CheckboxC",
		method: "POST",
		data: {
			completed: data.some(item => item.value === 'completed' && item.checked),
			uncompleted: data.some(item => item.value === 'uncompleted' && item.checked)
		},
		success: function(responseData) {
			refreshData(responseData);
		},
		error: function(xhr, status, error) {
			console.log("Error: ", xhr, status, error)
		}
	});
}

function refreshData(QnCs) {
	var container = document.getElementById("FOREACH_ASK");
	container.innerHTML = ""; // 기존 내용 비우기
	const urlParams = new URL(location.href).searchParams;
	const page = parseInt(urlParams.get("p"));
	let curPageNo = page;
	let itemsPerPage = 8;

	// JSON 데이터 파싱
	var QnCs = JSON.parse(QnCs);

	// QnCs가 배열이 아니면 배열로 변환
	if (!Array.isArray(QnCs)) {
		QnCs = [];
	}

	// q_seq를 기준으로 DESC로 정렬
	QnCs.sort((a, b) => {
		return b.q_seq - a.q_seq;
	});

	// 페이징을 위한 변수 계산
	let totalItems = QnCs.length;
	let pageCount = Math.ceil(totalItems / itemsPerPage);
	if (curPageNo > pageCount) {
		curPageNo = pageCount;
	}

	// 현재 페이지에 표시할 아이템들을 가져옴
	let startIndex = (curPageNo - 1) * itemsPerPage;
	let endIndex = Math.min(startIndex + itemsPerPage, totalItems);
	let displayedItems = QnCs.slice(startIndex, endIndex);

	// QnCs 데이터를 이용하여 화면 갱신
	displayedItems.forEach(function(item, index) {
		let qRegDate = new Date(item.q_reg_date);
		let formattedDate = qRegDate.toLocaleDateString('ja-JP', { year: 'numeric', month: '2-digit', day: '2-digit' }).replace(/\//g, '-');

		var newElement = document.createElement("div");
		newElement.className = "ontent-m-td-2-content-txt-in";

		newElement.innerHTML = `
            <input type="hidden" name="q_seq" value="${item.q_seq}">
            <div class="ontent-m-td-2-content-txt-no-in">
                ${(index + 1) + (curPageNo - 1) * itemsPerPage}
            </div>
            <div class="ontent-m-td-2-content-txt-kategorie-in">
                ${item.c_answer === '1' ? '完' : '未'}
            </div>
            <div class="ontent-m-td-2-content-txt-title-in">
                <a href="#" onclick="getData('${item.q_seq}');">${item.q_title}</a>
            </div>
            <div class="ontent-m-td-2-content-txt-writer-in">${item.q_name}</div>
            <div class="ontent-m-td-2-content-txt-date-in">${formattedDate}</div>
            <div class="ontent-m-td-2-content-txt-delete-in">
                <a href="#" onclick="deleteQuestion('${item.q_seq}', this)">削除</a>
            </div>
        `;
		container.appendChild(newElement);
	});

	// 페이징 추가 시도
	var pagingElement = document.createElement("div");
	pagingElement.className = "paging-div";
	var pagingcontainer = document.getElementById("PAGING_ASK");
	pagingcontainer.innerHTML = ""; // 기존 내용 비우기	

	// 처음으로 가는 버튼
	var firstButton = createPageButton("<<", 1, curPageNo > 1);
	if (curPageNo <= 1)  {
		firstButton.disabled = !firstButton.enabled; // disabled 속성 추가
	}
	pagingElement.appendChild(firstButton);

	// 이전 페이지로 가는 버튼
	var prevButton = createPageButton("이전", curPageNo - 1, curPageNo > 1);
	if (curPageNo <= 1) {
		prevButton.disabled = !prevButton.enabled; // disabled 속성 추가
	}
	pagingElement.appendChild(prevButton);

	// 페이지 번호 생성
	for (var i = Math.max(1, curPageNo - 2); i <= Math.min(curPageNo + 2, pageCount); i++) {
		var pageButton = createPageNoBtn("[ " + i + " ]", i, i === curPageNo);
		pagingElement.appendChild(pageButton);
	}

	// 다음 페이지로 가는 버튼
	var nextButton = createPageButton("다음", curPageNo + 1, curPageNo < pageCount);
	if (curPageNo >= pageCount) {
		nextButton.disabled = !nextButton.enabled; // disabled 속성 추가
	}
	pagingElement.appendChild(nextButton);

	// 마지막으로 가는 버튼
	var lastButton = createPageButton(">>", pageCount, curPageNo < pageCount);
	if (curPageNo >= pageCount) {
		lastButton.disabled = !lastButton.enabled; // disabled 속성 추가
	}
	pagingElement.appendChild(lastButton);

	// 페이징 끝에 추가
	pagingcontainer.appendChild(pagingElement);

	//reload 추가해서 새로고침 되긴 하는데, current-page에 준 css가 먹게 됨
	//location의 url을 바꾸는 것을 통해서 AskContent의 오류를 잡아냄
	if (window.location.href.includes("AskContent")) {
		window.location.replace(window.location.href.replace("AskContentC", "CheckboxPagingC"));
	} else {
		//리로드
	location.reload();

	}
}




// 페이지 버튼 생성 함수
function createPageButton(text, pageNo, isEnabled) {
	var button = document.createElement("button");
	button.textContent = text;
	button.addEventListener("click", function() {
		// 페이지 번호에 해당하는 URL로 이동
		window.location.href = "CheckboxPagingC?p=" + pageNo;
	});
	if (!isEnabled) {
		button.disabled = true;
	}
	return button;
}

function createPageNoBtn(text, pageNo, isEnabled) {
	var button = document.createElement("a");
	var link = document.createElement("a");

	link.href = "CheckboxPagingC?p=" + pageNo;
	link.textContent = text;
	button.appendChild(link);
	if (!isEnabled) {
		button.disabled = true;
		link.disabled = true;
	}
	return button;
}


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//spring boot checkbox 값 가져오기

function questionCheckbox(){
   let pageVal = document.querySelector('#pageNum').value;
   if (pageVal == '') {
      pageVal = 1;
   }

   let checkboxes = document.querySelectorAll('.filter:checked');
   let checkVal = '';

   checkboxes.forEach(function(checkbox) {
      checkVal += checkbox.value;
   });

//   let seqVal = document.querySelector('#updateSEQ').value; // seq 값 가져오기

   if (checkVal !== '') {
//      if (seqVal !== '0' && seqVal !== '') {
//         seqVal = '0'; // seq가 null이나 빈 문자열이 아니면 0으로 설정
//      }
      location.href = '/admin/boardManagement/question/' + pageVal + '/' + checkVal;
   } else {
      alert('一つ以上のチェックボックスにチェックを入れる必要があります。');
      history.go(0);
   }

}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//체크박스 라벨링
//document.addEventListener('DOMContentLoaded', function() {
//    let texts = document.querySelectorAll('.ontent-m-td-2-chackbox-contain-txt');
//
//    texts.forEach(function(text) {
//        text.addEventListener('click', function() {
//            let checkbox = this.previousElementSibling.querySelector('input[type="checkbox"]');
//            checkbox.checked = !checkbox.checked;
//            questionCheckbox(); // 체크박스 상태 변경 후 함수 호출
//        });
//    });
//});
