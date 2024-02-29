<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ page import="java.util.Collections" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>




<!DOCTYPE html>
<html>
<head>
<!-- @media 쓰려면 이거 넣어야함 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- @media 쓰려면 이거 넣어야함 -->
<meta charset="UTF-8">
<title>Question</title>
<link
      rel="stylesheet"
      href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
    />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/qa/question/0.css/question.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/qa/question/0.css/questionMobile.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/qa/faq/0.css/index-banner.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/0.css/index-menu.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/0.css/index-footer.css">


<script>
    function submitForm() {
        document.getElementById('QuestionDetailC').submit();
    }
    
</script>

</head>
<body>

		<!-- 문의작성란 -->
	<div class="q-content-tbl">
		<form action="/QuestionSubmit" method="post">
		<div class="q-content-box-tr1">
			<div class="q-content-box-td0">
				<a href="/qna/faq">＜＜よくある質問に</a>
			</div>
			<div class="q-content-box-td1">
				<span class="q-content-box-td-content1">お問い合わせフォーム</span>
			</div>
			
			<div class="q-content-box-td2">
				<span class="q-content-box-td-content2-1">投稿者* </span>
				<input class="q-content-box-td-content2-2" type="text" name="q_name"/>
			</div>

<!-- tel -->
			<div class="q-content-box-td2">
				<span class="q-content-box-td-content3-1">電話番号*</span>
				<input class="q-content-box-td-content3-2" type="text" name="q_contact_number"/>
			</div>
<!-- category -->
			<div class="q-content-box-td2">
				<span class="q-content-box-td-content4-1">カテゴリー*</span>
					<select class="q-content-box-td-content4-2" id="questioncategory" name="q_category">
			            <option value="訪問介護サービス">訪問介護サービス</option>
			            <option value="タクシーサービス">タクシーサービス</option>
			            <option value="ホームページ関連">ホームページ関連</option>
			            <option value="その他">その他</option>
			        </select>
			</div>
<!-- title -->
			<div class="q-content-box-td2">
				<span class="q-content-box-td-content5-1">タイトル*</span>
				<input class="q-content-box-td-content5-2" type="text" name="q_title"/>
			</div>
<!-- e-mail -->
			<div class="q-content-box-td2">
				<span class="q-content-box-td-content6-1">E-mail </span>
				<input class="q-content-box-td-content6-2" type="text" name="q_email"/>
			</div>
<!-- pw -->
			<div class="q-content-box-td2">
				<span class="q-content-box-td-content7-1">パスワード </span>
				<input class="q-content-box-td-content7-2" type="text" name="q_password"/>
			</div>
<!-- txt -->
			<div class="q-content-box-td2 content-box-td-content8">
				<span class="q-content-box-td-content8-1">お問い<br>合わせ<br>内容*</span>
				<textarea class="q-content-box-td-content8-2" type="text" name="q_content"></textarea>
			</div>
			<div class="q-content-box-td3">
				<span class="q-content-box-td-content9">*は必ずお書きください。</span>
			</div>
			
<!-- submit -->
			
				<div class="q-content-box-td4">
					<button class="q-content-box-td-content10">提出</button>
				</div>
			
<!-- img -->
			<div>
				<img class="img1" alt="" src="${pageContext.request.contextPath}/user/qa/question/0.img/clover3.png">
				<img class="img2" alt="" src="${pageContext.request.contextPath}/user/qa/question/0.img/clover4.png">
			</div>
		</div>
			</form>

		<!-- 문의글 게시판 -->


		<!-- content-box-tr1-td3 ::: display: flex wrap용 -->
          <div class="q_content-box-tr1-td3">
            <!-- 뒷 배경용 #FFEDAF -->
            <div class="q_content-box-tr1-td3-1">
              <div class="q_content-box-tr1-td3-1-1">
                <div class="q_content-box-tr1-td3-1-1-1">
                	
                	<div class="q_content-box-tr1-td3-1-1-1-txt">
                		<span>掲示板</span>
                	</div>
                	
                  <!-- 타이블 첫 행 -->
                  <div class="q_content-box-tr1-td3-1-1-1-1">
                    <div class="q_content-box-tr1-td3-1-1-1-1-1 No-width">
                      <span>No</span>
                    </div>
                    <div class="q_content-box-tr1-td3-1-1-1-1-2 writer-width">
                      <span>投稿者</span>
                    </div>
                    <div class="q_content-box-tr1-td3-1-1-1-1-3 title-width">
                      <span>タイトル</span>
                    </div>
                    <div class="q_content-box-tr1-td3-1-1-1-1-4 answer-width">
                      <span>応答</span>
                    </div>
                    <div class="q_content-box-tr1-td3-1-1-1-1-5 reg-width">
                      <span>投稿日</span>
                    </div>
                  </div>
                  
                  
             <form id="QuestionDetailC" action="QuestionDetailC" method="post">     
                  <!-- 2번째 행 여기는 forEach문이겠죠?-->
					<c:forEach items="${QnCs}" var="question" varStatus="loop">
					    <div class="q_content-box-tr1-td3-1-1-1-2">
					    		<input hidden="1" name="q_seq" val="${question.q_seq }"/>
			                    <div class="q_content-box-tr1-td3-1-1-1-2-1 No-width">
			                      <span>${(loop.index + 1) + (curPageNo - 1) * 5}</span>
			                    </div>
			                    <div class="q_content-box-tr1-td3-1-1-1-2-2 writer-width">
			                      <span>${question.q_name}</span>
			                    </div>
			                    <div class="q_content-box-tr1-td3-1-1-1-2-3 title-width">
			                      <a href="/qna/question/detail/${question.q_seq}">${question.q_title}</a>
			                    </div>
			                    <div class="q_content-box-tr1-td3-1-1-1-2-4 answer-width">
			                    	<c:choose>
						                <c:when test="${question.c_answer eq '1'}">
						                    完
						                </c:when>
						                <c:otherwise>
						                    未
						                </c:otherwise>
						            </c:choose>
			                    </div>
			                    <div class="q_content-box-tr1-td3-1-1-1-2-5 reg-width">
			                      <span><fmt:formatDate value="${question.q_reg_date}" pattern="yyyy-MM-dd"/></span>
			                    </div>
					    </div>
					</c:forEach>
				</form>	
<!-- 					페이징처리 해야할 부분 -->
					                <!--페이징시작 -->
                <div class="paging-div">
                  <!-- 처음으로 가는 버튼 -->
                  <c:choose>
                    <c:when test="${curPageNo > 5}">
                      <a href="/qna/question/${curPageNo - 5}">
                        <button><<</button>
                      </a>
                    </c:when>
                    <c:when test="${curPageNo <= 5 && curPageNo > 1}">
                      <a href="/qna/question/1">
                        <button><<</button>
                      </a>
                    </c:when>
                    <c:otherwise>
                      <button disabled style="cursor: default; background:white; visibility: hidden;"><<</button>
                    </c:otherwise>
                  </c:choose>

                  <!-- 이전 페이지로 가는 버튼 -->
                  <c:choose>
                    <c:when test="${curPageNo > 1}">
                      <a href="/qna/question/${curPageNo - 1}">
                        <button>前の</button>
                      </a>
                    </c:when>
                    <c:otherwise>
                      <button disabled style="cursor: default; background:white; visibility: hidden;">前の</button>
                    </c:otherwise>
                  </c:choose>

                  <!-- 페이지 번호 생성 시작 -->
                  <c:set var="pageSize" value="5" />
                  <c:set var="startPage" value="${curPageNo - 2}" />
                  <c:set var="endPage" value="${curPageNo + 2}" />
                  <!-- 시작 페이지와 끝 페이지 계산 -->

					<c:if test="${startPage < 1}">
					    <c:set var="startPage" value="1" />
					    <c:set var="endPage" value="${startPage + 4}" />
					    <!-- 시작 페이지가 1보다 작으면 1로 설정하고 끝 페이지를 조정 -->
					</c:if>

<!-- 이부분 문제 -->
                  <c:if test="${endPage > pageCount}">
                    <c:set var="endPage" value="${pageCount}" />
                    <c:choose>
                    	<c:when test="${endPage - 4}>0">
                    		<c:set var="startPage" value="${endPage - 4}" />
                    	</c:when>
                    	<c:when test="${endPage - 4}<=0">
                    		<c:set var="startPage" value="1" />
                    	</c:when>
                    </c:choose>
                    <!-- 끝 페이지가 페이지 수를 넘으면 끝 페이지를 페이지 수로 설정하고 시작 페이지를 조정 -->
                  </c:if>
<!-- 경고 -->

                  <c:forEach
                    var="pageNumber"
                    begin="${startPage}"
                    end="${endPage}"
                  >
                  
                    <c:set
                      var="currentPageClass"
                      value="${pageNumber == curPageNo ? 'current-page' : ''}"
                    />
					<!-- 버튼 모양 결정 -->
                    <a
                      href="/qna/question/${pageNumber}"
                      class="page-number ${currentPageClass}"
                      >
                      [ ${pageNumber} ]
                      </a>
                  </c:forEach>
                  <!-- 페이지 번호 생성 끝 -->

                  <!-- 다음 페이지로 가는 버튼 -->
                  <c:choose>
                    <c:when test="${curPageNo < pageCount}">
                      <a href="/qna/question/${curPageNo + 1}">
                        <button>次の</button>
                      </a>
                    </c:when>
                    <c:otherwise>
                      <button disabled style="cursor: default; background:white; visibility: hidden;">次の</button>
                    </c:otherwise>
                  </c:choose>

                  <!-- 마지막으로 가는 버튼 -->
                  <c:choose>
                    <c:when test="${curPageNo + 5 <= pageCount}">
                      <a href="/qna/question/${curPageNo + 5}">
                        <button>>></button>
                      </a>
                    </c:when>
                    <c:when
                      test="${curPageNo + 5 > pageCount && curPageNo < pageCount}"
                    >
                      <a href="/qna/question/${pageCount}">
                        <button>>></button>
                      </a>
                    </c:when>
                    <c:otherwise>
                      <button disabled style="cursor: default; background:white; visibility: hidden;">>></button>
                    </c:otherwise>
                  </c:choose>
                </div>
                <!-- 페이징끝 -->



<!-- Bootstrap JS (required for pagination) -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


                  
                  </div>

                </div>
              </div>
            </div>
          </div>
		
	
</body>
</html>