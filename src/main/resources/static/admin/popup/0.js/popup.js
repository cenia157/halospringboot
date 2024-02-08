document.addEventListener('DOMContentLoaded', function() {
//	changeInformBox();
//	submitBannerData(1);
//alert(11);
	

});
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
	let fileInput = document.getElementById("thumbnail1");
	let selectedFile = fileInput.files; //파일입력요소에서 '선택된' 파일들
	let serverFileName = document.getElementById("serverFileName");
	
	console.log('선택된 파일:', selectedFile);
//	selectedFile[0].name
	let formData = new FormData(document.querySelector("#fileUploadForm"));
	console.log("filenameForm : "+formData);
	
			//서버에 파일 업로드 요청 ↓
		$.ajax({
			type: "POST", // post 방식 요청
			/*enctype: 'multipart/form-data',	// 파일 업로드 위한 인코딩 방식*/
			url: 'PopupUpdateC', //서버로 요청 보낼 url
			data: formData,		// 서버로 보낼 데이터로 formData 객체 사용
			processData: false,	// 데이터 문자열로 변환하지 않도록
			contentType: false, 
			cache: false, // 캐시사용X
			success: function(fileName) { // 성공시 실행되는 콜백함수
				//미리보기 이미지 띄우기
				console.log(fileName);
				console.log('성공!');
				let popupPreview = document.querySelector("#banner_preview2");
				let url = "url(\'user/upload_imgs/popupImg/"+ fileName + "\')";
				popupPreview.style.backgroundImage = url;
				serverFileName.value = fileName;
			},
			error: function(e) {
				console.log('에러 : ' + e);
			}
		});
	
	
}

function submitBannerData(){
	let servletData = document.querySelector(".popup-select");
	let urlData = document.querySelector(".url-input");
	let popupImgData = document.querySelector("#serverFileName");
	
	let url = 'PopupUpdateC?popupMenu=' + servletData.value +
	'&popupUrl=' + urlData.value + '&popupImg=' + popupImgData.value;
//	console.log("popupImgData.value :"+popupImgData.value);
	location.href=url;
	
}

function checkPopupOnOff(index){
	let formData = new FormData(document.querySelector("#onOffForm"));
	console.log("폼 : " + formData);
	var popupState = 'Off';
	if(index == 1){
		popupState = 'On';
	} 
	$.ajax({
			type: "POST", // post 방식 요청
			url: 'PopupC', //서버로 요청 보낼 url
			data: formData,		// 서버로 보낼 데이터로 formData 객체 사용
			processData: false,	// 데이터 문자열로 변환하지 않도록
			contentType: false, 
			cache: false, // 캐시사용X
			success: function() { 
				alert("Popup " + popupState + " success");
			},
			error: function(e) {
				console.log('에러 : ' + e);
				alert("Popup " + popupState + " fail");
			}
		});
	
}


