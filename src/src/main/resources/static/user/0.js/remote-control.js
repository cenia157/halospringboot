document.addEventListener('DOMContentLoaded', function() {
    // 리모컨 상단 박스 클릭했을때
    document.querySelector('#goTop').addEventListener('click', function() {
        scrollToTop();
    });

    // scrollToTop 함수 선언
    function scrollToTop() {
        window.scrollTo({ top: 0, behavior: 'instant' });
    }
});



