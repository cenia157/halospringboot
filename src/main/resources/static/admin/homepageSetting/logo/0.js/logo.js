function handleFileUpload(event) {
	event.preventDefault();
	const fileInput = event.target;
	const files = fileInput.files;

	if (files.length > 0) {
		const selectedFile = files[0];
		console.log('선택된 파일:', selectedFile);

		var formData = new FormData(document.getElementById('fileUploadForm'));
		formData.append('logo_img', files[0]);
		
		fetch("/admin/homepage-update/logo/upload-file",{
			method: "post",
			body: formData

		})
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
			var fileName = data.uploadedImg;
			//미리보기 이미지 띄우기
				$('#logo_preview').attr('src', '/user/upload_imgs/' + fileName);
				//버튼 누를때 파라미터 (수정할 이미지 이름) 넘기기
				$('#logo_btn_submit').attr('onclick', "location.href='LogoUpdateC?newFileName=" + fileName +"'")
				console.log();
			
		});
		
		
	}
}

document.addEventListener('DOMContentLoaded', function() {
	
	document.getElementById('logo_img').addEventListener('change', handleFileUpload);
});