document.addEventListener("DOMContentLoaded", function() {
	let yScrollLocation = window.scrollY;
	let scrollCnt = '';
	let currentScroll = 1;

	window.addEventListener("scroll", function() {
		const scrollValue = window.scrollY;

		let rightImg = document.querySelector(".img-rightCloud");
		let leftImg = document.querySelector(".img-leftCloud");
		let rightPink = document.querySelector(".img-rightPink");
		let lefttPink = document.querySelector(".img-leftPink");
		let sunSet = document.querySelector(".img-sunset");
		let scrollPercentage =
			(scrollValue / (document.body.scrollHeight - window.innerHeight)) * 100;
		if (scrollPercentage >= 60) {
			rightImg.style.transform = "translateX(20%)";
			leftImg.style.transform = "translateX(-20%)";
			rightPink.style.transform = "translateX(30%)";
			lefttPink.style.transform = "translateX(-30%)";
			sunSet.style.transform = "translateY(-30%)";
		} else if (scrollPercentage >= 45) {
			rightImg.style.transform = "translateX(15%)";
			leftImg.style.transform = "translateX(-15%)";
			rightPink.style.transform = "translateX(20%)";
			lefttPink.style.transform = "translateX(-20%)";
			sunSet.style.transform = "translateY(-15%)";
		} else if (scrollPercentage >= 30) {
			rightImg.style.transform = "translateX(10%)";
			leftImg.style.transform = "translateX(-10%)";
			rightPink.style.transform = "translateX(17%)";
			lefttPink.style.transform = "translateX(-17%)";
			sunSet.style.transform = "translateY(-8%)";
		} else if (scrollPercentage >= 15) {
			rightImg.style.transform = "translateX(5%)";
			leftImg.style.transform = "translateX(-5%)";
			rightPink.style.transform = "translateX(13%)";
			lefttPink.style.transform = "translateX(-13%)";
			sunSet.style.transform = "translateY(-5%)";
		} else if (scrollPercentage >= 5) {
			rightImg.style.transform = "translateX(1%)";
			leftImg.style.transform = "translateX(-1%)";
			rightPink.style.transform = "translateX(8%)";
			lefttPink.style.transform = "translateX(-8%)";
			lefttPink.style.transition = "transform 1.2s ease-in-out";
			rightPink.style.transition = "transform 1.2s ease-in-out";
			sunSet.style.transform = "translateY(-2%)";
		} else {
			rightImg.style.transform = "translateX(0%)";
			leftImg.style.transform = "translateX(-0%)";
			rightPink.style.transform = "translateX(0%)";
			lefttPink.style.transform = "translateX(-0%)";
			sunSet.style.transform = "translateY(-0%)";
		}

		if (window.innerWidth > 500) {
			if (yScrollLocation < window.scrollY) {

				if (scrollCnt > 3) {
					scrollCnt = '';
				}

				console.log(scrollCnt)

				scrollCnt++;
				if (scrollCnt > 1) {
					setTimeout(() => {
						if (currentScroll == 1) {
							window.scrollTo(0, 1300);
							scrollCnt = '';
							setTimeout(function() {
								currentScroll = 2;
							}, 300);
						} else if (currentScroll == 2) {
							window.scrollTo(0, 2300);
							scrollCnt = '';
							setTimeout(function() {
								currentScroll = 3;
							}, 300);
						}
					}, 150);
				}
			} else {

				if (scrollCnt > 3) {
					scrollCnt = '';
				}

				console.log(scrollCnt)

				scrollCnt++;
				if (scrollCnt > 1) {
					setTimeout(() => {
						if (currentScroll == 3) {
							window.scrollTo(0, 2300);
							scrollCnt = '';
							setTimeout(function() {
								currentScroll = 2;
							}, 300);
						} else if (currentScroll == 2) {
							window.scrollTo(0, 1300);
							scrollCnt = '';
							setTimeout(function() {
								currentScroll = 1;
							}, 300);
						} else if (currentScroll == 1) {
							window.scrollTo(0, 0);
							scrollCnt = '';
							setTimeout(function() {
							}, 300);
						}
					}, 150);
				}
			}
			yScrollLocation = window.scrollY;
		}

	});
});
