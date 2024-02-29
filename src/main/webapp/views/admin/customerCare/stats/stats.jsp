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

<body>
	<h1>쿠키 생성</h1>

	<button id="saveTimeBtn">현재 시간 저장</button>

	<script>
		document
				.getElementById('saveTimeBtn')
				.addEventListener(
						'click',
						function() {
							// 현재 시간을 yyyy-mm-dd hh-mm-ss 형식으로 가져오기
							const currentTime = new Date().toISOString()
									.replace(/T/, ' ').replace(/\..+/, '');

							// 로컬 스토리지에 현재 시간 저장
							localStorage.setItem('koreanCurrentTime',
									currentTime);

							// 저장한 값을 콘솔에 출력
							console.log('로컬 스토리지에 저장된 현재 시간:', currentTime);

							// URLSearchParams를 사용하여 쿼리 문자열 생성
							const queryParams = new URLSearchParams();
							queryParams.set('koreanTime', currentTime);

							// 생성된 쿼리 문자열을 콘솔에 출력
							console.log('URL에 추가될 쿼리 문자열:', queryParams
									.toString());

							let CkeditorC123 = fetch(
									'VisitorC',
									{
										method : 'GET',
										body : queryParams,
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded', // 헤더 설정
										}
									})
							console.log('aaa');
							console.log(CkeditorC123);
							console.log('aaa');
							// TODO: 서버로 쿼리 문자열을 전송하는 로직 추가 (예: AJAX 또는 폼 전송)
						});
	</script>

	<h1>쿠키 생성</h1>

	<p></p>
	<button onclick="onPageLoad()">지우기</button>
	<input type="text" name="" id="">

	<form class="www" method="post">
		<button type="submit">보내기</button>

	</form>
	<script type="text/javascript">
		let www = document.querySelector('.www');

		
		
		
		www.addEventListener("submit", function(event){
		     event.preventDefault(); // 기본 submit 동작 방지
//
		
		
		

		
		
		
		
		
		const visitCount = localStorage.getItem('visitCount');

		const asd = new Date();
		const qqq = asd.toLocaleString();

		
		
		
		
		
		
		
		
		
		//
		const visitTime = localStorage.getItem('visitTime');

		if (visitCount) {
			localStorage.setItem('visitCount', Number(visitCount) + 1);
		} else {
			localStorage.setItem('visitCount', 1);
		}
		console.log('111');		
		console.log(visitTime);		
		console.log('111');		
		localStorage.setItem('visitTime', qqq);
		window.localStorage.getItem(visitTime)
		console.log('AAAAAAAAAAAAA');		
		console.log(window.localStorage.getItem('visitTime'));		
		console.log('AAAAAAAAAAAAA');		
		//여기부터


		
		const timeValue = document.querySelector('visitTime');
		console.log('222');		
		console.log(www);
		console.log('222');				
		
		
		
		
		


		
		
	 	const content = localStorage.getItem('visitTime');
	 	const visitTimeA = content;

/* 		 const content = localStorage.getItem('visitTime');
	 	 const visitTimeA = localStorage.getItem('visitTime'); */

		
 		 const url = `VisitorC?visitCount='visitCount'&visitTime=${visitCountA}&qqq=${qqq}`;
/* 		 const url = 'VisitorC?visitCount=' +visitCount; */




alert(visitCount); //html input에 담아둔 값 사용


		 console.log('0000000000000');		 
		 console.log(visitCount);
		 console.log(visitTime);
		 console.log('0000000000000');		 
		 console.log('111111111111111111111111');
		 console.log(url);
		 console.log('111111111111111111111111');
		 const formData = new FormData(event.target);
		 const payload = new URLSearchParams(url);
		 
		console.log('333');
		console.log(formData);
		
		console.log('333');		
		 
		 
		 
		 
		 for (var pair of formData.entries()) {
		        console.log(pair[0] + ': ' + pair[1] + ': ' + pair[2]);
		    }
		 
		let CkeditorC123 = fetch('VisitorC',  {
		        method: 'POST',
		        body: payload,
		        headers: {
		            'Content-Type': 'application/x-www-form-urlencoded', // 헤더 설정
		        }
		    })
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 여기까지

		console.log(visitCount);
		console.log(visitTime);
		
		});
	</script>
</body>
</html>