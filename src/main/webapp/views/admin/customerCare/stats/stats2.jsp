<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="${pageContext.request.contextPath}/admin/0.js/ckeditor.js"></script>
<title>Frequenthyask</title>





<link rel="stylesheet" href="admin/0.css/test copy.css" />
<link rel="stylesheet"
	href="admin/boardmanagement/frequenthyask/0.css/frequenthyask.css" />

<script src="admin/0.js/test2.js"></script>
<script src="admin/0.js/test.js"></script>





<link
	href="https://db.onlinewebfonts.com/c/18039781048bd528f6304c029f5d0f99?family=SF+Pro+JP+Regular"
	rel="stylesheet" />
</head>




















</head>

<body>
	<h1>로컬스토리지</h1>




	<script type="text/javascript">
		const visitCount = localStorage.getItem('visitCount');

		const asd = new Date();
		const qqq = asd.toLocaleString();

		const visitTime = localStorage.getItem('visitTime');

		if (visitCount) {
			localStorage.setItem('visitCount', Number(visitCount) + 1);
		} else {
			localStorage.setItem('visitCount', 1);
		}

		localStorage.setItem('visitTime', qqq);

		console.log(visitCount);
		console.log(visitTime);
	</script>



	<h1>이 웹사이트에 님이 지금까지 <span id="visitorCount"></span>번 방문하셨네요!</h1>


<script type="text/javascript">


//방문자 수를 증가시키는 함수
function increaseVisitorCount() {
	// 이전에 저장된 방문자 수를 불러와서 1을 더합니다.
	let count = localStorage.getItem('visitorCount');
	count = count ? parseInt(count) + 1 : 1;
	localStorage.setItem('visitorCount', count); // 새로운 방문자 수를 저장합니다.
	return count;
}

console.log(visitorCount);
console.log(localStorage);
console.log();
console.log();
console.log();
console.log();
console.log();
console.log();
console.log();
console.log();
console.log();
console.log(1);


// 페이지가 로드될 때마다 방문자 수를 표시하는 함수
function displayVisitorCount() {
	const visitorCount = document.getElementById('visitorCount');
	visitorCount.textContent = increaseVisitorCount(); // 방문자 수를 증가시키고, 표시합니다.
}


console.log(visitorCount);
console.log();
console.log();
console.log();
console.log();
console.log();






// 페이지가 로드될 때마다 방문자 수를 표시합니다.
window.onload = displayVisitorCount;


</script>








</body>
</html>