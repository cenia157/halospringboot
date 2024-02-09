
document.addEventListener('DOMContentLoaded', function() {
	openPopup();

});

function openPopup() {
	let url = "user/popup/popup.jsp";
	let name = "";
	window.open(url, name, "width=590, height=780, top=100, left=1000");
}




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

