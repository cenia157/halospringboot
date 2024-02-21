//
//document.addEventListener('DOMContentLoaded', function() {
//	openPopup();
//
//});
//
//function openPopup() {
//	let url = "user/popup/popup.jsp";
//	let name = "";
//	window.open(url, name, "width=590, height=780, top=100, left=1000");
//}

//// 쿠키 관련 함수
//var handleCookie = {
//    // 쿠키 쓰기 (이름, 값, 만료일)
//    setCookie: function (popup1, val, exp) {
//      var date = new Date();
//
//      // 만료 시간 구하기(만료일을 ms단위로 변경)
//      date.setTime(date.getTime() + exp * 24 * 60 * 60 * 1000);
//      console.log(name + "=" + val + ";expires=" + date.toUTCString() + ";path=/");
//
//      // 실제로 쿠키 작성하기
//      document.cookie = name + "=" + val + ";expires=" + date.toUTCString() + ";";
//    },
//    // 쿠키 읽어오기(쿠키 이름을 기준으로 정규식 이용해서 가져오기)
//    getCookie: function (name) {
//      var value = document.cookie.match("(^|;) ?" + name + "=([^;]*)(;|$)");
//      return value ? value[2] : null;
//    }
//};

// 	today = new Date()
// 	var todayDate = new Date(today.toLocaleDateString()); 
// 	console.log("todayDate : "+todayDate);  : Wed Feb 07 2024 00:00:00 GMT+0900 (한국 표준시)
// 	console.log(todayDate.toLocaleDateString());	yyyy.mm.dd
// 	todayDate.setDate(todayDate.getDate() + 1);		+ 24h
// 	console.log("+1 :" + todayDate);				+ 24h된 hu Feb 08 2024 00:00:00 GMT+0900 (한국 표준시)
// 	console.log(todayDate.toLocaleDateString());	+ 24h된 yyyy.mm.dd


    // Your code here
    console.log('Document is fully loaded and parsed');
    // You can now safely manipulate the DOM or perform other actions.
    const modalBackground = document.getElementById('modalContainer');
    const modalCloseButton = document.getElementById('modalCloseButton');
    const modal = document.getElementById('modalContainer');
    const checked = document.getElementById('pop-checkbox');

    var modalCookie = document.cookie.replace(/(?:(?:^|.*;\s*)modalClose\s*=\s*([^;]*).*$)|^.*$/, "$1");
    if (modalCookie === "close") {
     modal.classList.add('hidden');
   }

    modalCloseButton.addEventListener('click', () => {
    	if(checked.checked){
    		today = new Date()
    		var todayDate = new Date(today.toLocaleDateString());
    		todayDate.setDate(todayDate.getDate() + 1);
    		
    	    // 쿠키 생성
    	    document.cookie = "modalClose=close; path=/; expires="+ todayDate.toGMTString()+";";
    		
    	}
    	
        modal.classList.add('hidden');
    	
    });