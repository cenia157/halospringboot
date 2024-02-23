let isScrolling = null;
let scrollCnt = '';
let lastScrollTop = 0;
let scrollStatus = '';
let scrollLocation = 1;

document.addEventListener("DOMContentLoaded", function() {
	window.addEventListener('wheel', function(event) {
		if (event.deltaY < 0) { // 휠을 위로 움직였을 때
			if (!isScrolling) {
				isScrolling = setTimeout(() => {
					if (window.innerWidth > 500) {
						if (scrollLocation == 3) {
							smoothScrollTo(1000);
							setTimeout(function() {
								scrollLocation = 2;
							}, 300);
						} else if (scrollLocation == 2) {
							smoothScrollTo(0);
							setTimeout(function() {
								scrollLocation = 1;
							}, 300);
						}
					}
					isScrolling = null;
				}, 150);
			}
		} else if (event.deltaY > 0) {
			if (!isScrolling) {
				isScrolling = setTimeout(() => {
					if (window.innerWidth > 500) {
						if (scrollLocation == 1) {
							smoothScrollTo(1000);
							setTimeout(function() {
								scrollLocation = 2;
							}, 300);
						} else if (scrollLocation == 2) {
							smoothScrollTo(2000);
							setTimeout(function() {
								scrollLocation = 3;
							}, 300);
						}
					}
					isScrolling = null;
				}, 150);
			}
		}
	});
})

// smoothScrollTo 함수 수정
function smoothScrollTo(targetPosition) {
	const startPosition = window.scrollY;
	const distance = targetPosition - startPosition;
	const duration = 250; // 원하는 지속 시간(ms)으로 조정

	let startTime = null;

	function scrollAnimation(currentTime) {
		if (startTime === null) startTime = currentTime;
		const elapsedTime = currentTime - startTime;
		const scrollProgress = Math.min(elapsedTime / duration, 1);
		const easedProgress = easeOutQuad(scrollProgress);
		window.scrollTo(0, startPosition + distance * easedProgress);

		if (elapsedTime < duration) {
			requestAnimationFrame(scrollAnimation);
		} else {
			setTimeout(function() {
				isScrolling = false;// 스크롤이 끝났음을 표시
			}, 750);
		}
	}
	requestAnimationFrame(scrollAnimation);
}

// easeOutQuad 함수 유지
function easeOutQuad(t) {
	return t * (2 - t);
}