function handleFileUpload(event) {
	event.preventDefault();
	const fileInput = event.target;
	const files = fileInput.files;

	if (files.length > 0) {
		const selectedFile = files[0];
		console.log('선택된 파일:', selectedFile);

		var formData = new FormData(document.getElementById('fileUploadForm'));
		formData.append('logo_img', files.current);
		
		fetch("/admin/homepage-update/logo/upload-file",{
			method: "post",
			body: formData

		})
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
//			$('#logo_preview').attr('src', 'user/upload_imgs/' + fileName);
		});
		
		
	}
}

document.addEventListener('DOMContentLoaded', function() {
	
	document.getElementById('logo_img').addEventListener('change', handleFileUpload);
});