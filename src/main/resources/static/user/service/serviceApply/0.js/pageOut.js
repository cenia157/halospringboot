// 페이지를 벗어났을 때 실행되는 이벤트 처리
window.onbeforeunload = function() {
  // 'selectedService' 키에 해당하는 세션 스토리지 데이터 제거
  sessionStorage.removeItem('selectedService');
}