
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
	console.log(idx)
//	const fileInput = event.target; // 이벤트 발생한 대상(파일입력요소)
	let fileInput = document.getElementById("thumbnail" + idx);
	let selectedFile = fileInput.files; //파일입력요소에서 '선택된' 파일들
	let serverFileName = document.querySelectorAll(".serverFileName");
	
	if(selectedFile.length > 0){
			// 선택된 파일이 하나 이상일때
		console.log('선택된 파일:', selectedFile);

		var formData = new FormData();
		formData.append('banner_img', selectedFile[0]);
		formData.append('index', idx);
		
		fetch("/admin/homepage-update/banner/upload-file",{
			method: "post",
			body: formData

		})
		.then((response) => response.json())
		.then((data) => {
			var fileName = data.uploadedImg;
			//미리보기 이미지 띄우기
				let bannerPreview = document.querySelector("#banner_preview" + idx);
				let url = "url(\'/user/upload_imgs/banner/"+ fileName + "\')";
				
			console.log(url);
				bannerPreview.style.backgroundImage = url;
				serverFileName[idx-1].value = fileName;

			
		});
		
	}
	
		 //첫번째 선택된 파일
//		console.log('선택된 파일:', selectedFile);
		// 파일 업로드 위한 form객체 생성, formData 변수에 할당.
//	formData.append('thumbnail' + idx, selectedFile[0]);

	
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
	console.log("b_img_url: "+serverFileNameData[0].value)
	
	var data = [
		{b_index:1, b_m_name:selectData[0].value, b_url:urlData[0].value, b_m_text:pdNameData[0].value, b_img_url:serverFileNameData[0].value},
		{b_index:2, b_m_name:selectData[1].value, b_url:urlData[1].value, b_m_text:pdNameData[1].value, b_img_url:serverFileNameData[1].value},
		{b_index:3, b_m_name:selectData[2].value, b_url:urlData[2].value, b_m_text:pdNameData[2].value, b_img_url:serverFileNameData[2].value}
		];
		
		fetch("/admin/homepage-update/banner/update",{
			method: "post",
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(data)
		}).then((response) => response.json())
			.then((bottomBannerData) => {
				
				console.log("성공여부:"+bottomBannerData.isSuccess);
				if(bottomBannerData.isSuccess == "true"){
					location.href="/admin/homepage-update/banner"
				}else{
					alert("Update Fail")
				}
				
			})
	
}



