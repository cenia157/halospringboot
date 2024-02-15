let regBtn = document.querySelector('#reg-btn');
regBtn.addEventListener("click", function(event) {
    let ckForm = document.querySelector('#ck-form');
    const title = document.querySelector('.real-title-editor').value;
    const content = document.querySelector('.ck-content').innerText;
    const seq = document.querySelector('#modal-seq').value;

    // JavaScript 객체로 데이터 준비
    const requestData = {
        txt: content,
        title: title,
        seq: seq
    };

    // JavaScript 객체를 JSON 문자열로 변환
    const jsonData = JSON.stringify(requestData);

    fetch('/admin/boardManagement/CkeditorC_Frequenthyask', {
        method: 'POST',
        body: jsonData,
        headers: {
            'Content-Type': 'application/json' // JSON 형식으로 전달한다는 헤더 설정
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(data => {
        // 리로드 추가
        location.reload();
    })
    .catch(error => {
        console.error('POST 요청 실패:', error);
    });
});



let imgIdx = 0;

$(document).ready(function() {
	$('.ck-content').on('click', 'figure', function(e) {
		imgIdx = $(this).index();
	});

	$('.ck-content').on('keydown', function(e) {
		if (e.key === 'Delete' && $('figure').length > 0) {
			$('[name=saveFname]').eq(imgIdx).attr('disabled', 'disabled');
			$('[name=saveFname]').eq(imgIdx).hide();
		}
	});
});

function ErrorAlarm(e){
	if(e=="title"){
		alert("タイトルを入力してください")
	} else if(e=="content"){
		alert("内容を入力してください")
	}
}
