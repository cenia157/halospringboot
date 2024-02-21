
// 셀렉 -> 상품판매 선택시 인풋박스 변화
function changeInformBox() {
	let selectedOption = document.getElementsByName("banner_menu1")[0].value;
	let urlBox = document.getElementById("urlBox");
	if (selectedOption === "url") {
		urlBox.style.display = "flex";
	} else {
		urlBox.style.display = "none";
	}
}

function handleFileUpload() {
	let fileInput = document.getElementById("popup_img");
	let selectedFile = fileInput.files; //파일입력요소에서 '선택된' 파일들
	let serverFileName = document.getElementById("serverFileName");

	console.log('선택된 파일:', selectedFile);

	if (selectedFile.length > 0) {
		// 선택된 파일이 하나 이상일때
		console.log('선택된 파일:', selectedFile);

		var formData = new FormData();
		formData.append('popup_img', selectedFile[0]);

		fetch("/admin/homepage-update/popup/upload-file", {
			method: "post",
			body: formData

		})
			.then((response) => response.json())
			.then((data) => {
				var fileName = data.uploadedImg;
				//미리보기 이미지 띄우기
				let popupPreview = document.querySelector("#popup_preview2");
				let url = "url(\'/user/upload_imgs/popup/" + fileName + "\')";

				console.log(url);
				popupPreview.style.backgroundImage = url;
				serverFileName.value = fileName;

			});

	}


}



function submitBannerData() {
    let popup_name = document.querySelector("#popup_menu");
    let urlData = document.querySelector("#url-input");
    let popupImgData = document.querySelector("#serverFileName");
    let url = "/admin/homepage-update/popup/update";
    console.log(popup_name.value + "  test " + popupImgData.value )
	if (!urlData.value || urlData.value === "") {
		urlData.value = 'empty';
		}
    var data = {
        p_img: popupImgData.value,
        p_url: urlData.value,
        b_m_name: popup_name.value
    };

    fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    }).then((response) => response.json())
        .then((res) => {
            console.log(res.isSuccess);
            if (res.isSuccess=="true") {
				location.href="/admin/homepage-update/popup"
            } else {
				alert("UpdateFail")
			}
        });
}


function checkPopupOnOff(index) {
	let formData = new FormData(document.querySelector("#onOffForm"));
	console.log("폼 : " + formData);
	var popupState = 'Off';
	if (index == 1) {
		popupState = 'On';
	}
	fetch("/admin/homepage-update/popup/upload-file",{
		method: "post",
		
	})
	
//	$.ajax({
//		type: "POST", // post 방식 요청
//		url: 'PopupC', //서버로 요청 보낼 url
//		data: formData,		// 서버로 보낼 데이터로 formData 객체 사용
//		processData: false,	// 데이터 문자열로 변환하지 않도록
//		contentType: false,
//		cache: false, // 캐시사용X
//		success: function() {
//			alert("Popup " + popupState + " success");
//		},
//		error: function(e) {
//			console.log('에러 : ' + e);
//			alert("Popup " + popupState + " fail");
//		}
//	});

}


