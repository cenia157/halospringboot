
document.addEventListener('DOMContentLoaded', function() {
	
		fetch('/admin/loginCheck',{
		method : 'Post'
	})
	.then(response => response.text())
	.then(data =>{
		console.log(data);
		if(data == 'Login_required'){
			window.location.href='/admin/logout'
		}
	})

	// 세션 유효 시간 (초)
	let sessionTimeout = parseInt(document.getElementById('sessionTimeoutVal').value);
	// 초기 설정
	let timerElement = document.getElementById('timer');
	let countdown = sessionTimeout;
	let asd = sessionStorage.getItem('login_session');
	console.log('session = ' + asd);
	
	
	// 카운트다운 함수
	function updateTimer() {
		let hours = Math.floor(countdown / 3600);
		let minutes = Math.floor((countdown % 3600) / 60);
		let seconds = countdown % 60;

		// 1자리 수일 경우 앞에 0을 붙이기
		hours = hours < 10 ? '0' + hours : hours;
		minutes = minutes < 10 ? '0' + minutes : minutes;
		seconds = seconds < 10 ? '0' + seconds : seconds;

		timerElement.textContent = hours + ':' + minutes + ':' + seconds;

		countdown--;

		// 세션이 만료되었을 때의 동작 (예: 리디렉션 등)
		// 카운트다운 종료 시 타이머 멈추기
		if (countdown < 0) {
			clearInterval(countdownInterval);
			window.location.href = 'LoginPageC'; // 세션이 만료되면 로그아웃 페이지로 이동하도록 설정
		}

	}

	// 초기 카운트다운 설정
	updateTimer();

	// 1초마다 카운트다운 업데이트
	let countdownInterval = setInterval(function() {
		updateTimer();
	}, 1000);

	const extendTime = document.querySelector("#extendTime");
	extendTime.addEventListener('click', function(event) {
		fetch('/admin/loginExtendTime') // ExtendSessionServlet은 세션을 연장하는 서블릿입니다.
			.then(response => response.text())
			.then(data => {
				// 성공적으로 세션이 연장되면 서버에서 받은 데이터를 처리합니다.
				console.log(data);
				// 연장 성공 시 타이머를 다시 설정
				countdown = sessionTimeout;
			})
			.catch(error => {
				console.error('Error:', error);
			});
	});
});
