<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

%>

<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Ask</title>
</head>
<body>
	<div onclick="closeModalN()" id="myModalN" class="modal-background"></div>
	<div id="myModal-tblN" class="modal-tbl">
	
	
	
	
	
	
	
		<div class="modal-title-set">
			<div class="modal-title-tr">
				<div class="modal-title-td-1">

					<div class="real-title">
						<div class="real-title-up"> <span id="N_QUESTION_TITLE"></span> </div>
						<div class="real-title-down">
							<div class="real-title-down-L">

								<div class="real-title-down-contain" id="N_QUESTION_DATE"></div>
								<div class="real-title-down-contain">未回答</div>
							</div>
							<div class="real-title-down-2">
								<div class="real-title-down-contain">
									<span id="N_QUESTION_PHONE"></span>
								</div>
								<div class="real-title-down-contain">
									<span id="N_QUESTION_EMAIL"></span>
								</div>
							</div>
<!-- 							<div class="real-title-down-2"> -->
<!-- 								<div class="real-title-down-contain"> -->
<!-- 									<span id="N_QUESTION_CATEGORY"></span> -->
<!-- 								</div> -->
<!-- 							</div> -->
							
						</div>
					</div>


				</div>
				<div class="modal-title-td-2">
					<span class="close" id="closeModalBtn" onclick="closeModalN()">&times;</span>
				</div>
			</div>
			<div class="modal-content">
				<div class="modal-content-txt">
					<div class="modal-content-txt-question">
						<!-- 여기는 고객의 문의를 띄우는 곳 -->
						<div id="N_QUESTION_CONTENT"></div>
<%-- 						<jsp:include page="askEditPageCustomerQuestion.jsp"></jsp:include> --%>
					</div>
<!-- 					확인용 -->
					<span id="N_QUESTION_SEQ"></span>
					<textarea id="c_comment_content" name="c_comment_content" class="modal-content-txt-response-textarea" rows=""
						cols="" placeholder="回答を入力してください"></textarea>
				</div>
				<div class="modal-content-button">
				
					<!-- 					q_seq값 넘기기 -->
					<input hidden="1" id="q_seq" name="q_seq"/>
					<input id="regBtnHiddeninput" type="hidden" value="${sessionScope.login_session.a_name }"/>
					<button class="SubmitButton" onclick="submitComments(); closeModalN();">回答する</button>
				</div>
				
			</div>
		</div>
		
	</div>
</body>
</html>