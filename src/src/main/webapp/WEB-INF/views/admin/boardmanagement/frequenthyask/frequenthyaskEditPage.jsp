<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Frequenthyask</title>
<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
</head>
<body>

	<div onclick="closeModalF()" id="myModalF" class="modal-background"></div>
	<div id="myModal-tblF" class="modal-tbl">
		<div class="modal-title-set">
			<div class="modal-title-tr">
				<div class="modal-title-td-1">
					<div class="real-title">

						<input class="real-title-editor"
							placeholder="● 제공되는 서비스를 이용하려면 어떻게 해야되나요?"
							name="qa_title">

					</div>
				</div>
				<div class="modal-title-td-2">
					<span class="close" id="closeModalBtn" onclick="closeModalF()">&times;</span>
				</div>

			</div>
			<div class="modal-content">
				<form style="height: 100%" id="textbox" action="" method="post">
				<div class="modal-content-txt">
					<!-- 아래의 코드는 CK Editor를 넣는 부분이다-->
					<div id="classicNR" name="qa_content" contenteditable="true"></div>
					<!-- 아래의 스크립트 코드는 CK Editor를 불러오는 부분이다-->





				
				
				
				<script>
        ClassicEditor
            .create(document.querySelector('#classicNR'), {
                ckfinder: {
                    uploadUrl: '/upload.php'
                }
            })
            .then(editor => {
                console.log('이미지 업로드 성공', editor);
            })
            .catch(error => {
                console.error('이미지 업로드 실패', error);
            });
    </script>
				
				
				
				
				
				
				
				
				
				
				
				
				
				</div>
				<div class="modal-content-button">
					<button class="SubmitButton" onclick="closeModalF()">수정완료</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>