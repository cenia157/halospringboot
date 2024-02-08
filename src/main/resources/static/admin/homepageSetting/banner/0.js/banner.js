document.addEventListener('DOMContentLoaded', function() {
	changeInformBox(1);
//	submitBannerData(1);
	

});
// 셀렉 -> 상품판매 선택시 인풋박스 변화
function changeInformBox(indexNo) {
	let selectedOption = document.getElementsByName("banner_menu" + indexNo)[0].value;
	let informBox = document.getElementById("informBox" + indexNo);
	if (selectedOption === "sales") {
		informBox.style.display = "block";
	} else {
		informBox.style.display = "none";
	}
}

// 파일 선택시 ajax -> img 미리보기	
function handleFileUpload(idx) {
//	const fileInput = event.target; // 이벤트 발생한 대상(파일입력요소)
	let fileInput = document.getElementById("thumbnail" + idx);
	let selectedFile = fileInput.files; //파일입력요소에서 '선택된' 파일들
	let serverFileName = document.querySelectorAll(".serverFileName");
	console.log('선택된 파일:', selectedFile);
	
	if(selectedFile.length === 0){
		alert("파일을 선택해주세요");
		return;
	}
	
	if (selectedFile.length > 0) {	// 선택된 파일이 하나 이상일때
		 //첫번째 선택된 파일
//		console.log('선택된 파일:', selectedFile);

		// 파일 업로드 위한 form객체 생성, formData 변수에 할당.
	let formData = new FormData(document.querySelector("#bannerUploadForm" + idx));
//	formData.append('thumbnail' + idx, selectedFile[0]);

		//서버에 파일 업로드 요청 ↓
		$.ajax({
			type: "POST", // post 방식 요청
			/*enctype: 'multipart/form-data',	// 파일 업로드 위한 인코딩 방식*/
			url: 'BannerUploadC', //서버로 요청 보낼 url
			data: formData,		// 서버로 보낼 데이터로 formData 객체 사용
			processData: false,	// 데이터 문자열로 변환하지 않도록
			contentType: false, 
			cache: false, // 캐시사용X
			success: function(fileName) { // 성공시 실행되는 콜백함수
				//미리보기 이미지 띄우기
				console.log(fileName + fileName[0]);
				let bannerPreview = document.querySelector("#banner_preview" + idx);
				let url = "url(\'user/upload_imgs/banner/"+ fileName + "\')";
				bannerPreview.style.backgroundImage = url;
				serverFileName[idx-1].value = fileName;
			},
			error: function(e) {
				console.log('에러 : ' + e);
			}
		});
	}
}


//버튼 클릭했을때, 전체 폼 데이터 들고 컨트롤러로 가기
function submitBannerData(){
	let selectData = document.querySelectorAll(".banner-select");
	let urlData = document.querySelectorAll(".banner-url");
	let pdNameData = document.querySelectorAll(".banner-pdNameData");
	let serverFileNameData = document.querySelectorAll(".serverFileName");
	let selectValues="";
	let urlValues="";
	let pdNameValues="";
	let fileNameValues="";
	for(let i = 0; i < 3; i++){
		if(selectData[i].value==null || selectData[i].value== '' ){
			selectData[i].value="empty";
		}
		if(urlData[i].value==null || urlData[i].value== '' ){
			urlData[i].value="empty";
		}
		if(pdNameData[i].value==null || pdNameData[i].value== '' ){
			pdNameData[i].value="empty";
		}
		if(serverFileNameData[i].value==null || serverFileNameData[i].value== '' ){
			serverFileNameData[i].value="empty";
		}
	}	
	
	
	for(let i = 0; i < 3; i++){
		selectValues += 'selectValues='+encodeURIComponent(selectData[i].value)+'&';
		urlValues += 'urlValues='+encodeURIComponent(urlData[i].value)+'&';
		pdNameValues += 'pdNameValues='+encodeURIComponent(pdNameData[i].value)+'&';
		fileNameValues += 'fileNameValues=' + encodeURIComponent(serverFileNameData[i].value) + '&';		
	}
	
	let url = 'BannerUpdateC?'+ selectValues + urlValues + pdNameValues + fileNameValues;
	
	console.log(url);
	
    location.href = url;
}


