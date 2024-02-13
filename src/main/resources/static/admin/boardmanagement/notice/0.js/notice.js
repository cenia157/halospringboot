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
		url: "GetNoticeDetailC",
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

document.getElementById('updataModalBtn').addEventListener("click",function() {

	let an_seq = viewData[0].an_seq;
	let an_title = viewData[0].an_title;
	let an_content = viewData[0].an_content;
	let an_writer = viewData[0].an_content;
	let an_reg_date = viewData[0].an_reg_date;
	let an_category = viewData[0].an_category;
	$('#real-title-editorN').val(an_title);
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
	
	//	24.01.18 업데이트 모달창 이미지 순차정렬 안되는 문제 해결 
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

            $inputElement.attr({ type: 'text', name: 'saveFname', id: 'img-url', 'data-check': srcValue, value: srcValue});

            $imgTemporaryRDiv.append($inputElement);
        } // inner for
    } // outer for
	
	$(".ck-content").click();
	

//	$(".ck-button[data-cke-tooltip-text='パソコンから画像をアップロード']").addClass("ck-disabled").prop("disabled", true);
	//	24.01.18 수정끝 

}); // addEventListener

function getNOTICEDataUpdateView(an_seq) {
	console.log("an_seq: ", an_seq);

	$.ajax({
		url: "GetNoticeDetailC",
		method: "post",
		data: {
			an_seq: an_seq
		},

		success: function(data) {
			viewData = data;
			console.log("data: ", data);

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
if (updateSEQ.value != '') {
	getNOTICEDataUpdateView(updateSEQ.value);
}

function deleteNotice(seq) {

	let pageVal = document.querySelector('#pageNum').value;

	if (confirm('この投稿を削除しますか?')) {
		location.href = "DeleteNoticeC?an_seq=" + seq + "&p=" + pageVal +"&checkVal="+searchCheckBoxVal();
	} else {
		return;
	}
};

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

	if (searchCheckBoxVal()) {
		location.href = 'NoticePagingC?p=' + pageVal + '&checkVal=' + searchCheckBoxVal();
	} else {
		alert('一つ以上のチェックボックスにチェックを入れる必要があります。');
		history.go(0);
	}

}

function noticeSearchCheckBoxCheck() {
	let url = new URL(window.location.href);

	let searchParams = new URLSearchParams(url.search);

	let checkVal = searchParams.get("checkVal");

	for (let i = 0; i < checkVal.length; i++) {
		let check = checkVal.charAt(i);
		document.querySelectorAll('.noticeCheck')[check].checked = true;

	}
}

noticeSearchCheckBoxCheck();

function noValue() {
    let titleCheck = document.querySelector('#real-title-editor').value;
    let kategorieCheck = document.querySelector('#kategorie').children[0];
    let contentCheck = window.editor.getData();

    let titleLengthCheck = titleCheck.length;
    let contentLengthCheck = contentCheck.length;

    if (!titleCheck) {
        alert("タイトルを入力してください。");
        return false;
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

	document.querySelector('#toggle-down').style.display = (document.querySelector('#toggle-down').style.display === 'flex') ? 'none' : 'flex';};

	document.querySelectorAll('.toggle-item').forEach(function(item) {
		item.addEventListener('click', function() {
			document.querySelector('#kategorie').innerHTML = item.innerHTML;
			document.querySelector('#toggle-down').style.display = 'none';
			document.querySelector('#toggle-down').style.display = (document.querySelector('#toggle-down').style.display === 'flex') ? 'none' : 'flex';
			document.querySelector('#kategorie').children[0].name = 'select';
	});
});

function toggleR() {

	document.querySelector('#toggle-downR').style.display = (document.querySelector('#toggle-downR').style.display === 'flex') ? 'none' : 'flex';};

	document.querySelectorAll('.toggle-item').forEach(function(item) {
		item.addEventListener('click', function() {
			document.querySelector('#kategorieR').innerHTML = item.innerHTML;
			document.querySelector('#toggle-downR').style.display = 'none';
			document.querySelector('#toggle-downR').style.display = (document.querySelector('#toggle-downR').style.display === 'flex') ? 'none' : 'flex';

		document.querySelector('#kategorieR').children[0].name = 'select';

	});
});

// 관리자 공지사항 수정완료후 뷰 페이지가 나오는데, 모달창 닫고 새로고침해도 seq url때문에 여러번 새로고침해도 뷰 페이지 나오는 현상 수정
document.addEventListener('DOMContentLoaded', function() {
    let performanceEntries = performance.getEntriesByType("navigation");
    if (performanceEntries.length > 0 && performanceEntries[0].type === "reload") {
        let url = new URL(window.location.href);
        let params = new URLSearchParams(url.search);

        if (params.has('seq')) {
            params.delete('seq');
            window.history.replaceState(null, null, url.pathname + '?' + params.toString());
			closeModalV();
        }
    }
});

  $(document).ready(function () {
                     
	// 표기능, 외부 주소 첨부기능 비활성화
    $(".ck-button[data-cke-tooltip-text='画像挿入']").remove();
	$(".ck-button[data-cke-tooltip-text='メディアの挿入']").remove();
	$(".ck-button[data-cke-tooltip-text='表の挿入']").remove();
		
	 $(".ck-content").on("click", function (e) {
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
	
//	     console.log("figures의 갯수:", figures.length);
//	     console.log("saveFnames의 갯수:", saveFnames.length);
	
	     figures.each(function (index) {
	         $(this).attr("index", index); 
	     });
	
	     saveFnames.each(function (index) {
	         $(this).attr("index", index); 
	     });
	 });

     // 이미지 다중 업로드 후 인덱스값 맞게 삭제
	 $(".ck-content").on("keyup", function (e) {
	  if (e.key === "Backspace" || e.key === "Delete") {
	    $("input[name='saveFname']").each(function () {
	      let inputIndex = $(this).attr("index"); // 클릭 이벤트로 할당된 인덱스 사용
	      let correspondingFigure = $(".ck-content figure img").filter(function () {
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
    $(".ck-content").on("keydown", function (e) {
//      console.log("누른키 :::test", e.key, e.code);

      let whiteList = ["Enter", "Delete", "Backspace", "ArrowUp", "ArrowDown"];
//      let allowedKey = whiteList.includes(e.code); 

      let isSelectedFigureExists = $(".ck-content figure.ck-widget_selected").length > 0;
      let isBeforeCaretExists = $(".ck-content figure.ck-widget_type-around_show-fake-caret_before").length > 0;
      let isAfterCaretExists = $(".ck-content figure.ck-widget_type-around_show-fake-caret_after").length > 0;

      if ( !whiteList.includes(e.code) && isSelectedFigureExists && !isBeforeCaretExists && !isAfterCaretExists) {
        console.log("허용되지 않는 키 입니다");
        e.preventDefault(); // 입력 방지
        this.blur(); // 입력 필드에서 포커스 제거
      } // if

	let count = $(".ck-content figure.ck-widget_selected").length;
//	console.log("ck-widget_selected 클래스를 가진 figure 요소의 개수: " + count);
	
    }); // $('.ck-content').on("keydown", function(e) {

    // 이미지 드래그스타트 방지 
    $(".ck-content").on("dragstart", "img", function (e) {
      e.preventDefault(); 
    }); // $('.ck-content').on('dragstart', 'img', function(e) {

    // UI메뉴 셀렉티드 될때 방어 코드 
    $(".ck-content").on("click keydown", function (e) {
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

//	// 게시판 이름 바꾸기 	
//	$(".content-m-td-title").text("お知らせ").css('visibility', 'visible');
	
	
//	
//    // 'view-modal-tbl' 클래스를 가진 요소에 tabindex 설정
//    $('.view-modal-tbl').attr('tabindex', '0')
//    .on('focus', function() {
//        console.log('포커스 받음:', this);
//    })
//    .on('blur', function() {
//        console.log('포커스 잃음:', this);
//    })
//    .keydown(function(event) {
//        if (event.key === "Escape") {
//            console.log('ESC 키 감지 - view-modal-tbl');
//            closeModalV();
//        }
//    });

	// 뷰 페이지 esc로 끄기
//    $(document).keydown(function(event) {
//        // ESC 키가 눌렸는지 확인
//        if (event.key === "Escape") {
//            console.log('뷰 페이지에서 ESC 키 감지');
//
//            if ($('.view-modal-tbl').css('display') === 'flex') {
//                console.log('view-modal-tbl이 flex 상태입니다. closeModalV() 실행');
//                closeModalV();
//            } 
//        }
//    });
//
//	
//	// 수정 페이지 esc로 끄기
//    $(document).keydown(function(event) {
//        // ESC 키가 눌렸는지 확인
//        if (event.key === "Escape") {
//            // 'closeRegModal' 클래스가 flex 상태인지 확인
//            if ($('.closeRegModal').css('display') === 'flex') {
//                closeModalV();
//            }
//        }
//    });
//
//    $(document).keydown(function(event) {
//        // ESC 키가 눌렸는지 확인
//        if (event.key === "Escape") {
//            // 'myModal-tblNR' 아이디를 가진 요소의 display 상태 확인
//            if ($('#myModal-tblNR').css('display') === 'flex') {
//                closeModalNR();
//            }
//        }
//    });

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

//    $(document).on('keydown click', function(event) {
//        if (event.key === "Escape" || event.type === "click") {
//            if ($('.closeRegModal').css('display') === 'flex' && $('#toggle-downR').css('display') === 'flex') {
//                $('#toggle-downR').css('display', 'none');
//            }
//        }
//    });

//    $(document).on('keydown click', function(event) {
//        // ESC 키 누름 또는 문서의 어떤 부분 클릭
//        if (event.key === "Escape" || event.type === "click") {
//            // 클릭된 요소가 toggleR 또는 그 하위 요소인지 확인
//            if ($(event.target).closest('#toggleR').length) {
//                return; // toggleR 또는 그 하위 요소에서의 클릭은 무시
//            }
//
//            // closeRegModal과 toggle-downR이 flex 상태인지 확인
//            if ($('.closeRegModal').css('display') === 'flex' && $('#toggle-downR').css('display') === 'flex') {
//                $('#toggle-downR').css('display', 'none');
//            }
//        }
//    });

//    $(document).on('keydown click', function(event) {
//        // ESC 키 누름 또는 문서의 어떤 부분 클릭
//        if (event.key === "Escape" || event.type === "click") {
//            // 클릭된 요소가 'toggle-down' 또는 그 하위 요소인지 확인
//            if ($(event.target).closest('#toggle').length) {
//                return; // 'toggle-down' 또는 그 하위 요소에서의 클릭은 무시
//            }
//
//            // 'myModal-tblNR' id가 flex 상태이고 'toggle-down' 아이디가 flex 상태인지 확인
//            if ($('#myModal-tblNR').css('display') === 'flex' && $('#toggle-down').css('display') === 'flex') {
//                $('#toggle-down').css('display', 'none');
//            }
//        }
//    });

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