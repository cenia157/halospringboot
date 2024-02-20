<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="content-tbl">
		<div class="content-space"></div>
		<div class="content-sec">
			<jsp:include page="${subMenu }"></jsp:include>
		</div>
		<!-- 하단베너 -->
		<div class="bottom-venner-tr">
			<c:forEach var="bannerInform" items="${hdto.bottomBanners}" >
				<c:if test="${bannerInform.b_type == 1 }">
					<div class="bottom-venner-td menu-box"
						onclick="location.href='${bannerInform.b_url}'">${bannerInform.b_m_text }</div>
				</c:if>
				<c:if test="${bannerInform.b_type == 2 }">
					<div class="bottom-venner-td sales-box"
						style="background-image: url('${pageContext.request.contextPath}/user/upload_imgs/banner/${bannerInform.b_img_url}');"
						onclick="openNewWindow('${bannerInform.b_url}');">商品名:
						${bannerInform.b_m_text}</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
<!-- 상품판매 클릭시, 해당url 새 창으로 이동js -->
<script type="text/javascript">
	function openNewWindow(url) {
		window.open(url, '_blank');
	}
</script>
</html>