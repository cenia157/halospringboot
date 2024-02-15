<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Ask</title>
</head>
<body>
	<div class="ontent-m-td-2-content">
		<!-- 아마 여기서 for Each문을 써서 DB에서 값을 가져와 게시판을 표현해야 할 것 같다 -->
		<div class="ontent-m-td-2-content-container">
			<div class="ontent-m-td-2-content-txt">
				<div class="ontent-m-td-2-content-txt-no">No</div>
				<div class="ontent-m-td-2-content-txt-kategorie">カテゴリー</div>
				<div class="ontent-m-td-2-content-txt-title">タイトル</div>
				<div class="ontent-m-td-2-content-txt-writer">投稿者</div>
				<div class="ontent-m-td-2-content-txt-date">投稿日</div>
				<div class="ontent-m-td-2-content-txt-delete"></div>
				<input id="regBtnHiddeninput" type="hidden" value="${sessionScope.login_session.a_name }"/>
			</div>
		</div>
		<div class="ontent-m-td-2-mid" id="FOREACH_ASK">
<!-- 			foreach문 추가 -->

			<c:forEach items="${QnCs}" var="item" varStatus="loop">
			    <div class="ontent-m-td-2-content-txt-in">
			    	<input hidden="1" name="q_seq" value="${item.q_seq}">
				        <div class="ontent-m-td-2-content-txt-no-in">
				        	${(loop.index + 1) + (curPageNo - 1) * 8}
				        </div>
			        <div class="ontent-m-td-2-content-txt-kategorie-in">
						<c:choose>
			                <c:when test="${item.c_answer eq '1'}">
			                    完
			                </c:when>
			                <c:otherwise>
			                    未
			                </c:otherwise>
			            </c:choose>
			        </div>
				        <div class="ontent-m-td-2-content-txt-title-in">
			            <a onclick="getData('${item.q_seq}');">${item.q_title}</a>
				        </div>
			        <div class="ontent-m-td-2-content-txt-writer-in">${item.q_name}</div>
			        <div class="ontent-m-td-2-content-txt-date-in">${item.q_reg_date}</div>
			        <div class="ontent-m-td-2-content-txt-delete-in">
			            <button id="deleteBtn" onclick="deleteQuestion(${item.q_seq}, this)">削除</button>
			        </div>
			    </div>
			</c:forEach>
		</div>
	<div class="ontent-m-td-2-bottom">
		<div class="ontent-m-td-2-page-side"></div>
		<div class="ontent-m-td-2-page-center" id="PAGING_ASK">
			<!-- 					페이징처리 해야할 부분 -->
					                <!--페이징시작 -->
                <div class="paging-div">
                  <!-- 처음으로 가는 버튼 -->
                  <c:choose>
                    <c:when test="${curPageNo > 5}">
                      <a href="/admin/boardManagement/question/${curPageNo - 5}">
                        <button id="MostPrevious"><<</button>
                      </a>
                    </c:when>
                    <c:when test="${curPageNo <= 5 && curPageNo > 1}">
                      <a href="/admin/boardManagement/question/1">
                        <button id="MostPrevious"><<</button>
                      </a>
                    </c:when>
                    <c:otherwise>
                      <button disabled id="MostPrevious"><<</button>
                    </c:otherwise>
                  </c:choose>

                  <!-- 이전 페이지로 가는 버튼 -->
                  <c:choose>
                    <c:when test="${curPageNo > 1}">
                      <a href="/admin/boardManagement/question/${curPageNo - 1}">
                        <button id="Previous">前の</button>
                      </a>
                    </c:when>
                    <c:otherwise>
                      <button disabled id="Previous">前の</button>
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
                      href="/admin/boardManagement/question/${pageNumber}"
                      class="page-number ${currentPageClass}"
                      >
                      [ ${pageNumber} ]
                      </a>
                  </c:forEach>
                  <!-- 페이지 번호 생성 끝 -->

                  <!-- 다음 페이지로 가는 버튼 -->
                  <c:choose>
                    <c:when test="${curPageNo < pageCount}">
                      <a href="/admin/boardManagement/question/${curPageNo + 1}">
                        <button id="Next">次の</button>
                      </a>
                    </c:when>
                    <c:otherwise>
                      <button disabled id="Next">次の</button>
                    </c:otherwise>
                  </c:choose>

                  <!-- 마지막으로 가는 버튼 -->
                  <c:choose>
                    <c:when test="${curPageNo + 5 <= pageCount}">
                      <a href="/admin/boardManagement/question/${curPageNo + 5}">
                        <button id="MostNext">>></button>
                      </a>
                    </c:when>
                    <c:when
                      test="${curPageNo + 5 > pageCount && curPageNo < pageCount}"
                    >
                      <a href="/admin/boardManagement/question/${pageCount}">
                        <button id="MostNext">>></button>
                      </a>
                    </c:when>
                    <c:otherwise>
                      <button disabled id="MostNext">>></button>
                    </c:otherwise>
                  </c:choose>
                </div>
                <!-- 페이징끝 -->
			</div>
		<div class="ontent-m-td-2-page-side"></div>
		</div>
	</div>
</body>

<script src="/admin/boardmanagement/ask/_js/ask.js"></script>
<script src="/admin/_js/test.js"></script>

</html>