<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- @media 쓰려면 이거 넣어야함 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- @media 쓰려면 이거 넣어야함 -->
<meta charset="UTF-8">
<title>Question Detail</title>
<link rel="stylesheet"
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/qa/question/0.css/questionDetail.css">	
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/qa/question/0.css/questionDetailMobile.css">	
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/0.css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/0.css/index-menu.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/0.css/index-footer.css">

<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/user/qa/question/0.js/questionDetails.js"></script> --%>
<script type="text/javascript">
function deleteQuestion(n) {
	let password = prompt("削除しますか?\n パスワードを入力してください。");
	if (password === "${QnC.q_password}") {
		location.href= "/QuestionDelete/" + n;
	} else {
		alert("パスワードをご確認ください");
	}
}

function checkPW(){
	let enteredPassword = document.getElementById("password").value;
    let correctPassword = "${QnC.q_password}"; // 서버에서 가져온 올바른 패스워드

    if (enteredPassword === correctPassword) {
        // 패스워드가 올바르면 password_input을 숨기고 password_content를 보이게 설정
        document.getElementById("password_input").style.display = "none";
        document.getElementById("password_content").style.display = "block";
    } else {
        // 패스워드가 틀렸을 때의 처리
        alert("パスワードをご確認ください。");
        document.getElementById("password_input").style.display = "block";
        document.getElementById("password_content").style.display = "none";
        document.getElementById("password").value = null;
    }
}
</script>

</head>
<body>


	<div class="qd-content-tbl">

	<div class="qd-content-tbl">
		<div class="qd-content-box-tr1">
			<div class="qd-content-box-tr2">
				<div class="qd-content-box-tr2-1">
				<div class="qd-content-box-td1-1">
					<span>お問い合わせ</span>
				</div>
				<div class="qd-content-box-td1-2">
					<div class="qd-content-box-td1-2-1">タイトル</div>
					<div class="qd-content-box-td1-2-2"> ${QnC.q_title} </div>
				</div>

				<div class="qd-content-box-td1-3">
					<div class="qd-content-box-td1-3-1">作成者</div>
					<div class="qd-content-box-td1-3-2"> ${QnC.q_name} </div>
				</div>

				<div class="qd-content-box-td1-4">
					<div class="qd-content-box-td1-4-content">
						<span class="qd-content-box-td1-4-1">作成日時</span>
						<span class="qd-content-box-td1-4-2"> <fmt:formatDate value="${QnC.q_reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/>  
						</span>
					</div>
					<div class="qd-content-box-td-button">
						<button class="qd-content-box-td-button-2" onclick="deleteQuestion(${QnC.q_seq})">削除 X</button>
					</div>
				</div>

				<div class="qd-content-box-td2-1">
					<div class="qd-content-box-td2-1-content">
						${QnC.q_content}
					</div>
				</div>

				<div class="qd-content-box-td2-2">
					<button class="qd-content-box-td2-2-button" id="listButton">リスト</button>
				</div>
				<div class="qd-content-box-td3">
				<div class="qd-content-box-td3-1">
					<c:choose>
						<c:when test="${not empty QnC.c_comment_content}">
							<div class="qd-content-box-td3-1-1">${QnC.c_commenter_name}</div>
							<div class="qd-content-box-td3-1-2">${QnC.c_reg_date }</div>
						</c:when>
						<c:otherwise>
							<div class="qd-content-box-td3-1-1">まだコメントがありません</div>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="qd-content-box-td3-2">
						<div class="qd-content-box-td3-2-1">
							<img id="lockImg" alt=""
								src="${pageContext.request.contextPath}/user/qa/question/0.img/lock.png">
						</div>
						
						<c:choose>
							<c:when test="${not empty QnC.c_comment_content}">
								<div id="password_input">
									<input name="password" id="password" type="password" placeholder="パスワードを入力してください" />
									<button id="password_submit_btn" onclick="checkPW()">確認</button>
								</div>
								<div class="password_submit">
								</div>
								<div class="qd-content-box-td3-2-2" id="password_content">
									${QnC.c_comment_content}
								</div>
							</c:when>
							<c:otherwise></c:otherwise>					
						</c:choose>
				</div>
				</div>
				
				
				<div class="qd-content-box-td4" >
<c:forEach var="question" items="${resultList}" varStatus="status">
    <c:if test="${question.q_seq eq questionId}">
        <c:set var="currentIndex" value="${status.index}" />
    </c:if>
</c:forEach>

					<div class="qd-content-box-td4-1">
						<div class="qd-content-box-td4-1-1">前のページ</div>
							<div class="qd-content-box-td4-1-2">
								<c:choose>
								    <c:when test="${currentIndex > 0}">
								        <c:set var="prevIndex" value="${currentIndex - 1}" />
								        <c:set var="prevQuestion" value="${resultList[prevIndex]}" />
								        <a href="/qna/question/detail/${prevQuestion.q_seq}">${prevQuestion.q_title}</a>
								    </c:when>
								    <c:otherwise>
								        <p id="disabledPost">前の投稿はありません</p>
								    </c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="qd-content-box-td4-2">
						<div class="qd-content-box-td4-2-1">後のページ</div>
							<div class="qd-content-box-td4-2-2">

								<c:choose>
								    <c:when test="${currentIndex < fn:length(resultList) - 1}">
								        <c:set var="nextIndex" value="${currentIndex + 1}" />
								        <c:set var="nextQuestion" value="${resultList[nextIndex]}" />
								        <a href="/qna/question/detail/${nextQuestion.q_seq}">${nextQuestion.q_title}</a>
								    </c:when>
								    <c:otherwise>
								        <p id="disabledPost">次の投稿はありません</p>
								    </c:otherwise>

								</c:choose>
							</div>
						</div>
					</div>
				</div>
				
				<div class="qd-content-box-td4-3">
					<div class="qd-content-box-td4-3-1">
						他のお問い合わせは <br> Tel.06-6997-6531 にご連絡お願い致します。
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>


</body>

<script type="text/javascript">
	document.getElementById("listButton").onclick = function() {
    window.location.href = "/qna/question";
  };	
</script>
</html>