<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>お知らせ</title>
  	<link href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular" rel="stylesheet" />
  	<link rel="stylesheet" href="user/introduce/announcement/0.css/announcement_contentPage.css"/>
    <script src="admin/_js/ckeditor/ckeditor.js"></script>
    <script src="user/introduce/announcement/0.js/announcement_contentPage_modal.js"></script>
    <script src="user/introduce/announcement/0.js/announcement_contentPage_ajax.js"></script>  
  </head>
  <body>
    <!--     <div class="a_container"> -->
    <div class="a_content-tbl">
      <!--ody 구분선 1 시작-->
      <div class="a_content-box-tr1">
        <div class="a_content-box-tr1-td1">
          <div class="a_content-box-tr1-td1-1">
            <span><a href="AnnouncedC">お知らせ</a></span>
          </div>
          <div class="a_content-box-tr1-td1-2">
            <span><a href="AlbumC">アルバム</a></span>
          </div>
          <div class="a_content-box-tr1-td1-3">
            <span><a href="EmploymentC">スタッフ募集</a></span>
          </div>
        </div>

        <div class="a_content-box-tr1-td2">
          <div class="a_content-box-tr1-td2-1">
            <img
              src="user/0.img/home.png"
              width="1.7%"
              alt=""
            />
            > 情報 > お知らせ
          </div>
        </div>

        <!-- content-box-tr1-td3 ::: display: flex wrap용 -->
        <div class="a_content-box-tr1-td3">
          <!-- 뒷 배경용 #FFEDAF -->
          <div class="a_content-box-tr1-td3-1">
            <div class="a_content-box-tr1-td3-1-1">
              <div class="a_content-box-tr1-td3-1-1-1">
                <!-- 타이블 첫 행 -->
                <div class="a_content-box-tr1-td3-1-1-1-1">
                  <div class="a_content-box-tr1-td3-1-1-1-1-1 No-width">
                    <span>No</span>
                  </div>
                  <div class="a_content-box-tr1-td3-1-1-1-1-2 writer-width">
                    <span>投稿者</span>
                  </div>
                  <div class="a_content-box-tr1-td3-1-1-1-1-3 title-width">
                    <span>タイトル</span>
                  </div>
                  <div class="a_content-box-tr1-td3-1-1-1-1-4 category-width">
                    <span>カテゴリー</span>
                  </div>
                  <div class="a_content-box-tr1-td3-1-1-1-1-5 reg-width">
                    <span>投稿日</span>
                  </div>
                </div>
                <!-- 2번째 행 여기는 forEach문이겠죠?-->
                <c:forEach var="announcement" items="${announcements}" varStatus="loop">
                  <div class="a_content-box-tr1-td3-1-1-1-2">
                    <div class="a_content-box-tr1-td3-1-1-1-2-1 No-width">
                      <span>${(loop.index + 1) + (curPageNo - 1) * 5}</span>
                    </div>
                    <div class="a_content-box-tr1-td3-1-1-1-2-2 writer-width">
                      <span>${announcement.an_writer}</span>
                    </div>
                    <div
                      class="a_content-box-tr1-td3-1-1-1-2-3 title-width ancTitleDiv"
                      data-anseq="${announcement.an_seq }"
                    >
                      <span>${announcement.an_title}</span>
                    </div>
                    <div class="a_content-box-tr1-td3-1-1-1-2-4 category-width">
                      <span>${announcement.an_category}</span>
                    </div>
                    <div class="a_content-box-tr1-td3-1-1-1-2-5 reg-width">
                      <span
                        ><fmt:formatDate
                          value="${announcement.an_reg_date}"
                          pattern="yyyy-MM-dd"
                      /></span>
                    </div>
                  </div>
	                <!--페이징시작 -->
	                </c:forEach>
	                <div class="paging-div">
	                  <!-- 처음으로 가는 버튼 -->
	                  <c:choose>
	                    <c:when test="${curPageNo > 5}">
	                      <a href="Announced_paging_C?p=${curPageNo - 5}">
	                        <button><<</button>
	                      </a>
	                    </c:when>
	                    <c:when test="${curPageNo <= 5 && curPageNo > 1}">
	                      <a href="Announced_paging_C?p=1">
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
	                      <a href="Announced_paging_C?p=${curPageNo - 1}">
	                        <button>前の</button>
	                      </a>
	                    </c:when>
	                    <c:otherwise>
	                      <button disabled style="cursor: default; background:white; visibility: hidden;">前の</button>
	                      
	                    </c:otherwise>
	                  </c:choose>
	
	                  <!-- 페이지 번호 생성 시작 -->
	                  <c:set var="pageSize" value="10" />
	                  <c:set var="startPage" value="${curPageNo - 2}" />
	                  <c:set var="endPage" value="${curPageNo + 2}" />
	                  <!-- 시작 페이지와 끝 페이지 계산 -->
	
	                  <c:if test="${startPage < 1}">
	                    <c:set var="startPage" value="1" />
	                    <c:set var="endPage" value="${startPage + 4}" />
	                    <!-- 시작 페이지가 1보다 작으면 1로 설정하고 끝 페이지를 조정 -->
	                  </c:if>
	
	                  <c:if test="${endPage > pageCount}">
	                    <c:set var="endPage" value="${pageCount}" />
	                    <c:set var="startPage" value="${endPage - 4}" />
	                    <!-- 끝 페이지가 페이지 수를 넘으면 끝 페이지를 페이지 수로 설정하고 시작 페이지를 조정 -->
	                  </c:if>
	
	                  <c:forEach
	                    var="pageNumber"
	                    begin="${startPage}"
	                    end="${endPage}"
	                  >
	                    <c:set
	                      var="currentPageClass"
	                      value="${pageNumber == curPageNo ? 'current-page' : ''}"
	                    />
	                    <a
	                      href="Announced_paging_C?p=${pageNumber}"
	                      class="page-number ${currentPageClass}"
	                      >[${pageNumber}]</a
	                    >
	                  </c:forEach>
	                  <!-- 페이지 번호 생성 끝 -->
	
	                  <!-- 다음 페이지로 가는 버튼 -->
	                  <c:choose>
	                    <c:when test="${curPageNo < pageCount}">
	                      <a href="Announced_paging_C?p=${curPageNo + 1}">
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
	                      <a href="Announced_paging_C?p=${curPageNo + 5}">
	                        <button>>></button>
	                      </a>
	                    </c:when>
	                    <c:when
	                      test="${curPageNo + 5 > pageCount && curPageNo < pageCount}"
	                    >
	                      <a href="Announced_paging_C?p=${pageCount}">
	                        <button>>></button>
	                      </a>
	                    </c:when>
	                    <c:otherwise>
	                      <button disabled style="cursor: default; background:white; visibility: hidden;">>></button>
	                    </c:otherwise>
	                  </c:choose>
	                </div>
	                <!-- 페이징끝 -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--ody 구분선 1 끝-->
    <!--     </div> -->
    <!-- 모달시작 -->
    <div id="myModal" class="modal">
      <div class="modal-content">
        <!-- 여기서 소스 활용 시작 -->
        <!-- 문의글 게시판 (디테일) -->
        <div class="qd-content-box-td1-1">
          <span> お知らせ</span>
        </div>
        <div class="qd-content-box-td1-2">
          <div class="qd-content-box-td1-2-1"><span>タイトル</span></div>
          <div class="qd-content-box-td1-2-2" id="modalTitle">일정공지</div>
        </div>

        <div class="qd-content-box-td1-3">
          <div class="qd-content-box-td1-3-1"><span>投稿者<span></div>
          <div class="qd-content-box-td1-3-2" id="modalWriter">
            오오데아키코
          </div>
        </div>
        <div class="qd-content-box-td1-4">
          <div class="qd-content-box-td1-4-content">
            <span class="qd-content-box-td1-4-1">投稿日&nbsp:&nbsp</span>
            <span class="qd-content-box-td1-4-2" id="modalregDate"
              >23-12-15</span
            >
          </div>
        </div>

        <!-- 본문 예시 -->
        <div class="qd-content-box-td2-1">
          <div class="qd-content-box-td2-1-content ck ck-content" id="modalContent">
            안녕하세요, 운영자입니다. <br />
            일정관리를 다음과 같이 알려드립니다. 시세확장때문에 하는데요. <br />
            평일 중 2일과 주말 1일을 정기적으로 한 달 동안 이용하는 것이
            가능한지 궁금합니다. <br />
            안녕하세요, 운영자입니다. <br />
            일정관리를 다음과 같이 알려드립니다. 시세확장때문에 하는데요. <br />
            평일 중 2일과 주말 1일을 정기적으로 한 달 동안 이용하는 것이
            가능한지 궁금합니다. <br />
            안녕하세요, 운영자입니다. <br />
            일정관리를 다음과 같이 알려드립니다. 시세확장때문에 하는데요. <br />
            평일 중 2일과 주말 1일을 정기적으로 한 달 동안 이용하는 것이
            가능한지 궁금합니다. <br />
            안녕하세요, 운영자입니다. <br />
            일정관리를 다음과 같이 알려드립니다. 시세확장때문에 하는데요. <br />
            평일 중 2일과 주말 1일을 정기적으로 한 달 동안 이용하는 것이
            가능한지 궁금합니다. <br />
            안녕하세요, 운영자입니다. <br />
            일정관리를 다음과 같이 알려드립니다. 시세확장때문에 하는데요. <br />
            평일 중 2일과 주말 1일을 정기적으로 한 달 동안 이용하는 것이
            가능한지 궁금합니다. <br />
            부모님의 편의를 생각해서 가능한 빠른 답변 부탁드립니다. 다음 주에도
            가능하다면 좋겠어요. <br />
            <br />
            부모님을 위한 편리한 이동이라는 목적으로 서비스를 검토 중이니,
            <br />
            어떤 혜택이나 특별한 안내사항이 있는지도 함께 알려주시면
            감사하겠습니다 오버플로우 오토로 줬어요. <br />
          </div>
        </div>

        <div class="qd-content-box-td2-2">
          <button class="qd-content-box-td2-2-button" id="closeModalBtn">
            閉じる
          </button>
        </div>
      </div>
    </div>
    <!--모달끝-->

    <script>

    </script>
  </body>
</html>