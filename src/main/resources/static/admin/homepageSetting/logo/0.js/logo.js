function handleFileUpload(event) {
	event.preventDefault();
	const fileInput = event.target;
	const files = fileInput.files;


	if (files.length > 0) {
		const selectedFile = files[0];
		console.log('선택된 파일:', selectedFile);

		var formData = new FormData();
		formData.append('logo_img', files[0]);
		const serverLogoName = document.querySelector("#serverLogoName");
		
		fetch("/admin/homepage-update/logo/upload-file",{
			method: "post",
			body: formData

		})
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
			var fileName = data.uploadedImg;
			//미리보기 이미지 띄우기
				let logoPreview = document.querySelector("#logo_preview");
				let url = "url(\'/user/upload_imgs/logo/"+ fileName + "\')";
				logoPreview.style.backgroundImage = url;
				serverLogoName.value = fileName;
				//버튼 누를때 파라미터 (수정할 이미지 이름) 넘기기
//				$('#logo_btn_submit').attr('onclick', "location.href='/admin/homepage-update/logo/update?newFileName=" + fileName +"'")
//				console.log("img이름:"+fileName);
			
		});
		
		
	}
}

function submitLogoData(){
	let logoImgName = document.querySelector("#serverLogoName").value;
	let url = "/admin/homepage-update/logo/update";
	console.log("로고: "+logoImgName.value);
	
	var data = {
		h_logo_img : logoImgName,
	}
	fetch(url,{
		method: "post",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
	})
		.then((response) => response.json())
		.then((data) => {
			console.log("성공?: "+data.isSuccess);
			if(data.isSuccess == "true"){
				location.href="/admin/homepage-update/logo"
			}else{
				alert("UpdateFail")
			}
		});
}


document.addEventListener('DOMContentLoaded', function() {
	
	document.getElementById('logo_img').addEventListener('change', handleFileUpload);
});