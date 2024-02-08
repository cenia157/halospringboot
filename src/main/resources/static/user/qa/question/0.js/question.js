    // 페이지 로드가 완료된 후 실행
    document.addEventListener('DOMContentLoaded', function() {
        // 페이징 버튼에 대한 클릭 이벤트 리스너 등록
        document.querySelectorAll('.page-link').forEach(function(button) {
            button.addEventListener('click', function(event) {
                // 기본 동작인 페이지 이동을 막음
                event.preventDefault();
                
                // 여기에 페이징 버튼을 클릭했을 때 수행할 동작을 추가
                // 예: 페이지 내용 로드, 페이지 이동 등
                // 클릭된 버튼의 href 속성에서 페이지 URL을 가져옴
                var targetPage = this.getAttribute('href');
            });
        });
    });
    
    function submitForm() {
        document.getElementById('QuestionDetailC').submit();
    }
    


