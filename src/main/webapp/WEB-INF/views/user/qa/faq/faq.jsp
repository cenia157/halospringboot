<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<!-- @media 쓰려면 이거 넣어야함 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- @media 쓰려면 이거 넣어야함 -->
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/qa/faq/_css/faq.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/qa/faq/_css/faqDetail.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/qa/faq/_css/index-banner.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/0.css/index-menu.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/0.css/index-footer.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/qa/faq/_css/faqMobile.css">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="user/qa/faq/_js/user_faq.js"></script>
	
</head>
<body>



	<!-- 본문 -->
	<div class="faq-content-tbl">
	
		<!-- 자주묻는 질문 -->
		<div class="faq-content-box-tr1">
			<div class="faq-content-box-td1-0"><a href="QuestionC">お問い合わせに＞＞</a></div>
		    <div class="faq-content-box-td1-1">よくある質問</div>
		    <div class="faq-content-box-td1-2">
		    	<c:forEach items="${FAQs}" var="qa">
			        <button class="faq-content-box-td1-2-content loadButton" id="showModalBtn" onclick="loadFAQDetailContent('${qa.qa_seq}')">● ${qa.qa_title }</button>
			        <input name="qa_seq" hidden="1">
		    	</c:forEach>
		    </div>
		</div>
		
	    <!-- 로드된 파일이 나타날 컨테이너 -->
		<div class="faqDetailContainer" id="FAQModal">
			<jsp:include page="/user/qa/faq/faqDetail.jsp"></jsp:include>
		</div>
    

	</div>
	

</body>

    <script>
    document.getElementById("FAQModal").style.display = "none";

    var faqButtons = document.querySelectorAll(".faq-content-box-td1-2-content");
    faqButtons.forEach(function(button) {
      button.addEventListener("click", function() {
        document.getElementById("FAQModal").style.display = "flex";

        let modal = document.getElementById("FAQModal");

        function scrollToModal() {
          let start = window.pageYOffset;
          let end = modal.offsetTop;
          let duration = 500; // 0.5sec

          let startTime;
          function scrollStep(timestamp) {
            if (!startTime) startTime = timestamp;
            let progress = timestamp - startTime;
            let percentage = Math.min(progress / duration, 1);

            window.scrollTo(0, start + percentage * (end - start));

            if (progress < duration) {
              window.requestAnimationFrame(scrollStep);
            }
          }

          window.requestAnimationFrame(scrollStep);
        }

        setTimeout(scrollToModal, 100);
      });
    });



        
    </script>
    
</html>