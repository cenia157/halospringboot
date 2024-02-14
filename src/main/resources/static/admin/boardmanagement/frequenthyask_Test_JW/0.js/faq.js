//모달 관련
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
		// CKEditor 초기화
				const element = document.querySelector('.ck-rounded-corners');
				ClassicEditor
				  .create(element)
				  .then(editor => {
				    // then 콜백 함수 내에서 editor 변수를 사용하여 데이터를 설정합니다.
				    editor.destroy();
				  })
				  .catch(error => {
				    // 에러 처리
				    console.error(error);
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
	titleInput.value = "";

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
				const element = document.querySelector('.ck-rounded-corners');
				ClassicEditor
				  .create(element)
				  .then(editor => {
				    // then 콜백 함수 내에서 editor 변수를 사용하여 데이터를 설정합니다.
				    editor.destroy();
				  })
				  .catch(error => {
				    // 에러 처리
				    console.error(error);
				  });

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
				const element = document.querySelector('.ck-rounded-corners');
				ClassicEditor
				  .create(element)
				  .then(editor => {
				    // then 콜백 함수 내에서 editor 변수를 사용하여 데이터를 설정합니다.
				    editor.destroy();
				  })
				  .catch(error => {
				    // 에러 처리
				    console.error(error);
				  });
	
	
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
	openModal('myModal', 'myModal-tblV');
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

//여기부터 FAQ function


//FAQ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

function getFAQData(qa_seq, qa_title, qa_content, qa_reg_date) {
   $.ajax({
        url: "/getFAQDetail",
        dataType: "json",
        type: "post",
        contentType: "application/json", // 데이터 형식 지정
        data: JSON.stringify({ // 데이터를 JSON 형식으로 변환하여 전송
            qa_seq: qa_seq,
            qa_title: qa_title,
            qa_content: qa_content,
            qa_reg_date: qa_reg_date
        }),
        success: function(data){
			console.log(data)
            let qa_seq = data[0].qa_seq;
            let qa_title = data[0].qa_title;
            let qa_content = data[0].qa_content;
            let qa_reg_date = data[0].qa_reg_date;

				$('.modal-content-txt').html();
				$('#modal-seq').val(qa_seq);
				$('#real-title-editor').val(qa_title);
				$('#classicNR').html(qa_content);



				// CKEditor에 데이터 설정
				const element = document.querySelector('#classicNR');
				ClassicEditor
				  .create(element)
				  .then(editor => {
				    // then 콜백 함수 내에서 editor 변수를 사용하여 데이터를 설정합니다.
				    editor.setData(qa_content);
				  })
				  .catch(error => {
				    // 에러 처리
				    console.error(error);
				  });

				//				let classicNR = document.getElementById("classicNR");
				//				classicNR.innerHTML = "나옴?";

				openModalF();
        },
        error: function(xhr, status, error){
            console.error("FAQ 상세 내용 로드 오류: ", status, error);
        }
    });



}

function deleteFAQ(qa_seq) {
	let ok = confirm("削除しますか?");
	if (ok) {
		$.ajax({
			url: 'DeleteFAQC',
			method: 'POST',
			data: {
				qa_seq: qa_seq
			},
			success: function() {
				console.log("FAQ 삭제성공");
				location.reload();
			},
			error: function(xhr, status, error) {
				console.log("삭제 error: ", xhr, status, error);
			}
		});
	}
}