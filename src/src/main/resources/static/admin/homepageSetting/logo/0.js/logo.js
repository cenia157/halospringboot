function handleFileUpload(event) {
	event.preventDefault();
	const fileInput = event.target;
	const files = fileInput.files;

	if (files.length > 0) {
		const selectedFile = files[0];
		console.log('선택된 파일:', selectedFile);

		var formData = new FormData(document.getElementById('fileUploadForm'));
		// 여기에서 파일을 서버로 업로드하거나 다른 작업을 수행할 수 있습니다.
		// 예: AJAX를 사용하여 서버에 파일 업로드 요청을 보내기

		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',	// 필수
			url: 'LogoUploadC',
			data: formData,		// 필수
			processData: false,	// 필수
			contentType: false,	// 필수
			cache: false,
			success: function(fileName) {
				//미리보기 이미지 띄우기
				$('#logo_preview').attr('src', 'user/upload_imgs/' + fileName);
				//버튼 누를때 파라미터 (수정할 이미지 이름) 넘기기
				$('#logo_btn_submit').attr('onclick', "location.href='LogoUpdateC?newFileName=" + fileName +"'")
			},
			error: function(e) {
				console.log('에러 : ' + e);
			}
		});
	}
}

document.addEventListener('DOMContentLoaded', function() {
	document.getElementById('logo_img').addEventListener('change', handleFileUpload);
});