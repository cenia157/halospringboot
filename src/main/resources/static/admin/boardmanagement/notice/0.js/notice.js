let viewData = null;

function openModal(modalId, tblId) {
	document.getElementById(modalId).style.display = 'flex';
	document.getElementById(tblId).style.display = 'flex';

	// 아래 6줄은 모달창 열 때 스크롤 감추기 & 터치, 휠 불가
	$('html, body').css({ 'overflow': 'hidden', 'height': '100%' });
	$('#element').on('scroll touchmove mousewheel', function(event) {
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
	titleInput.value = "";

	// 사진 input 삭제
	var imageInputs = document.querySelectorAll("#img-url");
	imageInputs.forEach(function(input) { input.parentNode.removeChild(input); });

	// #kategorie 안의 input(#select)과 그 안의 텍스트 둘 다 삭제 및 '카테고리' 재설정
	var kategorieInput = document.querySelector('#kategorie input');
	if (kategorieInput) {
		kategorieInput.remove();
		document.querySelector('#kategorie').textContent = '카테고리';
	}
	// CKEditor 초기화
	window.editor.setData(""); // CKEditor의 내용을 빈 문자열로 설정합니다.
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
	window.editorR.setData("");
	openModal('myModalNR', 'myModal-tblNR');
	closeModalOnOutsideClick('myModalNR');
	// 24-01-19 추가 등록버튼 여러번 반복시, 이미지아이콘 구분선 disabled되는 오류 추가 수정 
	$(".ck-button[data-cke-tooltip-text='パソコンから画像をアップロード']").removeClass("ck-disabled").prop("disabled", false);
	$(".ck-button[data-cke-tooltip-text='区切り']").removeClass("ck-disabled").prop("disabled", false);
}

function closeModalNR() {
	closeModal('myModalNR', 'myModal-tblNR');
}

function getNoticeViewData(an_seq) {
	console.log("getNoticeViewDataのan_seq確認　: ", an_seq);

	$.ajax({
		url: "/admin/boardManagement/notice/getNoticeDetail",
		method: "post",
		data: {
			an_seq: an_seq
		},

		success: function(data) {

			//			console.log("data: ", data);

			if (Array.isArray(data) && data.length > 0) {
				viewData = data;
				let an_seq = data[0].an_seq;
				let an_title = data[0].an_title;
				let an_content = data[0].an_content;
				let an_category = data[0].an_category;

				$('#modal-seq').val(an_seq);
				$('#real-title-V').html(an_title);
				$('#Display-Category').html(an_category);
				$('#modal-content-txt-in').html(an_content);

				openModalV();
			}
		},
		error: function(xhr, status, error) {
			console.log("getNOTICEDataV function 에러");
			console.log("error:", xhr, status, error);
		}
	})
}

document.getElementById('updataModalBtn').addEventListener("click", function() {

	let an_seq = viewData[0].an_seq;
	let an_title = viewData[0].an_title;
	let an_content = viewData[0].an_content;
	let an_writer = viewData[0].an_content;
	let an_reg_date = viewData[0].an_reg_date;
	let an_category = viewData[0].an_category;
	
	// HTML 엔티티를 디코딩하기 위한 임시 textarea 요소를 생성하고 an_title의 값을 설정
	let tempTextArea = document.createElement('textarea');
	tempTextArea.innerHTML = an_title;	
	
	// 임시 textarea 요소의 value 속성에서 디코딩된 텍스트를 가져옴
	let decodedTitle = tempTextArea.value;
	
	$('#real-title-editorN').val(decodedTitle);
	$('#classicR').html(an_content);
	window.editorR.setData(an_content);
	$('#kategorieR').html(an_category);
	$('#seq').val(an_seq);

	if (an_category == 'announcement') {
		$('#kategorieR').html('announcement');
	} else if (an_category == 'schedule') {
		$('#kategorieR').html('schedule');
	} else if (an_category == 'general') {
		$('#kategorieR').html('general');
	} else if (an_category == 'service') {
		$('#kategorieR').html('service');
	} else if (an_category == 'product') {
		$('#kategorieR').html('product');
	}

	let kategorieRInput = $("#kategorieR");
	let newInput = $("<input>");

	newInput.attr("type", "hidden");
	newInput.attr("value", an_category);
	newInput.attr("name", "select");
	newInput.attr("id", "myInputR");
	kategorieRInput.append(newInput);


	openModalR();
	document.querySelector('.view-modal-tbl').style.display = 'none';

	// 업데이트 모달창 이미지 순차정렬 안되는 문제 해결 
	let $ckFormRDiv = $('#ck-formR');
	let $ckContentDivs = $ckFormRDiv.find('.ck-content');

	for (let i = 0; i < $ckContentDivs.length; i++) {
		let $figures = $ckContentDivs.eq(i).find('figure');

		for (let j = 0; j < $figures.length; j++) {
			let $img = $figures.eq(j).find('img');
			let srcValue = $img.attr('src');

			$img.attr('data-check', srcValue);

			let $imgTemporaryRDiv = $('#img-temporaryR');
			let $inputElement = $('<input>');

			$inputElement.attr({ type: 'text', name: 'saveFname', id: 'img-url', 'data-check': srcValue, value: srcValue });

			$imgTemporaryRDiv.append($inputElement);
		} // inner for
	} // outer for

	$(".ck-content").click();

}); // addEventListener

function getNOTICEDataUpdateView(an_seq) {
	console.log("an_seq: ", an_seq);

	$.ajax({
		url: "/admin/boardManagement/notice/getNoticeDetail",
		method: "post",
		data: {
			an_seq: an_seq
		},

		success: function(data) {
			viewData = data;
			console.log("data: ", data);
//			alert("this is right")
			if (Array.isArray(data) && data.length > 0) {
				let an_seq = data[0].an_seq;
				let an_title = data[0].an_title;
				let an_content = data[0].an_content;
				let an_category = data[0].an_category;

				$('#modal-seq').val(an_seq);
				$('#real-title-V').html(an_title);
				$('#Display-Category').html(an_category);
				$('#modal-content-txt-in').html(an_content);
				$('#real-title-editor').val(an_title);

				openModalV();

			}
		}
	})
}

let updateSEQ = document.querySelector('#updateSEQ');
if (updateSEQ.value != 0) {
	getNOTICEDataUpdateView(updateSEQ.value);
}

function deleteNotice(seq) {
	let pageVal = document.querySelector('#pageNum').value;
	let checkVal = searchCheckBoxVal();
	let pageCheck = document.querySelector('.current-page').innerText;

	console.log('pageCheck :::' + pageCheck);

	// 괄호 안의 숫자만 추출
	let matches = pageCheck.match(/\d+/); // \d+ 정규식은 하나 이상의 숫자에 매칭됩니다.
	let pageNumber = matches ? parseInt(matches[0], 10) : null; // 추출된 숫자를 정수형으로 변환

	console.log('pageNumber :::', pageNumber);

	if (confirm('この投稿を削除しますか?')) {
		location.href = `/admin/boardManagement/notice/deleteNotice/${pageVal}/${checkVal}/${seq}/${pageNumber}`;
	} else {
		return;
	}
}

function searchCheckBoxVal() {
	let checkBoxArr = document.querySelectorAll('.noticeCheck');
	let checkVal = '';
	for (let i = 0; i < checkBoxArr.length; i++) {
		console.log(checkBoxArr[i]);
		console.log(checkBoxArr[i].checked);
		if (checkBoxArr[i].checked == true) {
			checkVal += checkBoxArr[i].value;
		}
	}
	return checkVal;
}

function noticeSearch() {
	let pageVal = document.querySelector('#pageNum').value;
	if (pageVal == '') {
		pageVal = 1;
	}

	let checkboxes = document.querySelectorAll('.noticeCheck:checked');
	let checkVal = '';

	checkboxes.forEach(function(checkbox) {
		checkVal += checkbox.value;
	});

	let seqVal = document.querySelector('#updateSEQ').value; // seq 값 가져오기

	if (checkVal !== '') {
		if (seqVal !== '0' && seqVal !== '') {
			seqVal = '0'; // seq가 null이나 빈 문자열이 아니면 0으로 설정
		}
		location.href = '/admin/boardManagement/notice/' + pageVal + '/' + checkVal + '/' + seqVal;
	} else {
		alert('一つ以上のチェックボックスにチェックを入れる必要があります。');
		history.go(0);
	}
}

function noticeSearchCheckBoxCheck() {
	let path = window.location.pathname;
	let parts = path.split("/");
	let checkVal = parts[parts.length - 2]; // 경로에서 두 번째로 마지막 요소를 가져옴

	for (let i = 0; i < checkVal.length; i++) {
		let check = checkVal.charAt(i);
		document.querySelectorAll('.noticeCheck')[check].checked = true;
	}
}

noticeSearchCheckBoxCheck();

function noValue(param) {
	
	let titleCheck;
	let kategorieCheck;
	let contentCheck;
	let titleLengthCheck
	let contentLengthCheck
	
	if(param == 'insert') {
		titleCheck = document.querySelector('#real-title-editor').value;
		kategorieCheck = document.querySelector('#kategorie').children[0];
		contentCheck = window.editor.getData();		
	} else if(param == 'update') {
		titleCheck = document.querySelector('#real-title-editorN').value;
		kategorieCheck = document.querySelector('#kategorieR').children[0];
		contentCheck = window.editorR.getData();	
	}
		titleLengthCheck = titleCheck.length;
		contentLengthCheck = contentCheck.length;	
	

	if (!titleCheck) {
		alert("タイトルを入力してください。");
		return false;
	} else if(titleCheck.length > 30) {
		alert("タイトルを30文字以内で入力してください。")
	} else if (kategorieCheck == null) {
		alert("カテゴリーを選択してください.");
		return false;
	} else if (contentCheck == "") {
		alert("コンテンツの内容を入力してください。");
		return false;
	} else if (titleLengthCheck > 100) {
		alert("タイトルの長さは100文字を超えることはできません.");
		return false;
	} else {
		return true;
	}
};

function toggle() {

	document.querySelector('#toggle-down').style.display = (document.querySelector('#toggle-down').style.display === 'flex') ? 'none' : 'flex';
};

document.querySelectorAll('.toggle-item').forEach(function(item) {
	item.addEventListener('click', function() {
		document.querySelector('#kategorie').innerHTML = item.innerHTML;
		document.querySelector('#toggle-down').style.display = 'none';
		document.querySelector('#toggle-down').style.display = (document.querySelector('#toggle-down').style.display === 'flex') ? 'none' : 'flex';
		document.querySelector('#kategorie').children[0].name = 'select';
	});
});

function toggleR() {

	document.querySelector('#toggle-downR').style.display = (document.querySelector('#toggle-downR').style.display === 'flex') ? 'none' : 'flex';
};

document.querySelectorAll('.toggle-item').forEach(function(item) {
	item.addEventListener('click', function() {
		document.querySelector('#kategorieR').innerHTML = item.innerHTML;
		document.querySelector('#toggle-downR').style.display = 'none';
		document.querySelector('#toggle-downR').style.display = (document.querySelector('#toggle-downR').style.display === 'flex') ? 'none' : 'flex';

		document.querySelector('#kategorieR').children[0].name = 'select';

	});
});

document.addEventListener('DOMContentLoaded', function() {
    let performanceEntries = performance.getEntriesByType("navigation");
    if (performanceEntries.length > 0 && performanceEntries[0].type === "reload") {
        let url = new URL(window.location.href);
        let pathSegments = url.pathname.split('/').filter(segment => segment); // 빈 문자열 제거

        // 마지막 세그먼트(부분) 가져오기
        let lastSegment = parseInt(pathSegments[pathSegments.length - 1], 10);

        // 마지막 세그먼트가 0이 아닐 경우 업데이트
        if (!isNaN(lastSegment) && lastSegment !== 0) {
            // 마지막 세그먼트를 0으로 변경
            pathSegments[pathSegments.length - 1] = '0';

            // 변경된 세그먼트를 기반으로 새로운 경로 생성
            let newPath = '/' + pathSegments.join('/');

            // 브라우저의 히스토리 상태를 업데이트하고, URL 변경
            window.history.replaceState(null, null, newPath);

            // 필요한 경우 모달 닫기 함수 호출
            closeModalV();
        }
    }
});

$(document).ready(function() {

	// 표기능, 외부 주소 첨부기능 비활성화
	$(".ck-button[data-cke-tooltip-text='画像挿入']").remove();
	$(".ck-button[data-cke-tooltip-text='メディアの挿入']").remove();
	$(".ck-button[data-cke-tooltip-text='表の挿入']").remove();

	$(".ck-content").on("click", function(e) {
		//		console.log('클릭 이벤트 발생')
		let figures = $(".ck-content figure img");
		let saveFnames = $("input[name='saveFname']");

		if ($("#myModal-tblR").css("display") !== "none") {
			//			console.log('신규 등록 모달창 -> none ***');
			//			console.log('업데이트  모달창 -> flex***');
			figures = $("#ck-formR .ck-content figure img")


		} else {
			//			console.log('신규 등록 모달창 -> flex');
			//			console.log('업데이트  모달창 -> none');
			figures = $("#ck-form .ck-content figure img")
		}

		figures.each(function(index) {
			$(this).attr("index", index);
		});

		saveFnames.each(function(index) {
			$(this).attr("index", index);
		});
	});

	// 이미지 다중 업로드 후 인덱스값 맞게 삭제
	$(".ck-content").on("keyup", function(e) {
		if (e.key === "Backspace" || e.key === "Delete") {
			$("input[name='saveFname']").each(function() {
				let inputIndex = $(this).attr("index"); // 클릭 이벤트로 할당된 인덱스 사용
				let correspondingFigure = $(".ck-content figure img").filter(function() {
					return $(this).attr("index") === inputIndex;
				});

				if (!correspondingFigure.length) {
					$(this).remove();
					alert(`${Number(inputIndex) + 1}番目の画像が削除されました。`);
				} // inner if
			});

			// 인덱스를 재할당
			$(".ck-content").click();
		} // outer if
	});

	// 이미지 추가후 seleted 즉 자동으로 선택될때 방어하는 코드	
	$(".ck-content").on("keydown", function(e) {
		//      console.log("누른키 :::test", e.key, e.code);

		let whiteList = ["Enter", "Delete", "Backspace", "ArrowUp", "ArrowDown"];
		//      let allowedKey = whiteList.includes(e.code); 

		let isSelectedFigureExists = $(".ck-content figure.ck-widget_selected").length > 0;
		let isBeforeCaretExists = $(".ck-content figure.ck-widget_type-around_show-fake-caret_before").length > 0;
		let isAfterCaretExists = $(".ck-content figure.ck-widget_type-around_show-fake-caret_after").length > 0;

		if (!whiteList.includes(e.code) && isSelectedFigureExists && !isBeforeCaretExists && !isAfterCaretExists) {
			console.log("허용되지 않는 키 입니다");
			e.preventDefault(); // 입력 방지
			this.blur(); // 입력 필드에서 포커스 제거
		} // if

		let count = $(".ck-content figure.ck-widget_selected").length;
		//	console.log("ck-widget_selected 클래스를 가진 figure 요소의 개수: " + count);

	}); // $('.ck-content').on("keydown", function(e) {

	// 이미지 드래그스타트 방지 
	$(".ck-content").on("dragstart", "img", function(e) {
		e.preventDefault();
	}); // $('.ck-content').on('dragstart', 'img', function(e) {

	// UI메뉴 셀렉티드 될때 방어 코드 
	$(".ck-content").on("click keydown", function(e) {
		let isSelectedFigureExists =
			$(".ck-content figure.ck-widget_selected").length > 0;

		let buttonsToDisable = ["区切り", "リンク (Ctrl+K)", "パソコンから画像を置換", "パソコンから画像をアップロード"];

		buttonsToDisable.forEach(buttonText => {
			let $button = $(".ck-button[data-cke-tooltip-text='" + buttonText + "']");
			if (isSelectedFigureExists && !(e.type === "keydown" && e.key === "Enter")) {
				$button.addClass("ck-disabled");
				$button.prop("disabled", true);
			} else {
				$button.removeClass("ck-disabled");
				$button.prop("disabled", false);
			}
		});
	}); //(".ck-content").on("click keydown", function (e) {

	// 관리자 공지사항 게시판 -> 조회, 등록, 수정 페이지에서 esc누르면 모달창 끄도록 수정
	$(document).keydown(function(event) {
		// ESC 키가 눌렸는지 확인
		if (event.key === "Escape") {
			console.log('ESC 키 감지');

			// 'view-modal-tbl' 클래스가 flex 상태인지 확인
			if ($('.view-modal-tbl').css('display') === 'flex') {
				console.log('view-modal-tbl이 flex 상태입니다. closeModalV() 실행');
				closeModalV();
				return; // 함수 실행 후 추가적인 검사를 방지
			}

			// 'closeRegModal' 클래스가 flex 상태인지 확인
			if ($('.closeRegModal').css('display') === 'flex') {
				console.log('closeRegModal이 flex 상태입니다. closeModalV() 실행');
				closeModalV();
				return; // 함수 실행 후 추가적인 검사를 방지
			}

			// 'myModal-tblNR' 아이디를 가진 요소의 display 상태 확인
			if ($('#myModal-tblNR').css('display') === 'flex') {
				console.log('myModal-tblNR이 flex 상태입니다. closeModalNR() 실행');
				closeModalNR();
				return; // 함수 실행 후 추가적인 검사를 방지
			}
		}
	});

	// 모달창에서 카테고리 input박스 닫히도록 잔처리 
	$(document).on('keydown click', function(event) {
		// ESC 키 누름 또는 문서의 어떤 부분 클릭
		if (event.key === "Escape" || event.type === "click") {
			// 클릭된 요소가 'toggleR' 또는 'toggle' 또는 그 하위 요소인지 확인
			if ($(event.target).closest('#toggleR').length || $(event.target).closest('#toggle').length) {
				return; // 'toggleR' 또는 'toggle' 또는 그 하위 요소에서의 클릭은 무시
			}

			// closeRegModal과 toggle-downR이 flex 상태인지 확인
			if ($('.closeRegModal').css('display') === 'flex' && $('#toggle-downR').css('display') === 'flex') {
				$('#toggle-downR').css('display', 'none');
			}

			// myModal-tblNR와 toggle-down이 flex 상태인지 확인
			if ($('#myModal-tblNR').css('display') === 'flex' && $('#toggle-down').css('display') === 'flex') {
				$('#toggle-down').css('display', 'none');
			}
		}
	});
}); 

document.addEventListener('DOMContentLoaded', function() {
    let containers = document.querySelectorAll('.ontent-m-td-2-chackbox-contain-txt');

    containers.forEach(function(container) {
        container.addEventListener('click', function() {
            let checkbox = this.previousElementSibling.querySelector('input[type="checkbox"]');
            checkbox.checked = !checkbox.checked;
            noticeSearch(); // 체크박스 상태 변경 후 noticeSearch() 함수 호출
        });
    });
});