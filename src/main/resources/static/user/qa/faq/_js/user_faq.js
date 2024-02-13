function loadFAQDetailContent(qa_seq, qa_title, qa_content, qa_reg_date){
    $.ajax({
        url: "/loadFAQDetailContent",
        dataType: "json",
        type: "post",
        contentType: "application/json", // 데이터 형식 지정
        data: JSON.stringify({ // 데이터를 JSON 형식으로 변환하여 전송
            qa_seq: qa_seq,
            qa_title: qa_title,
            qa_content: qa_content,
            qa_reg_date: qa_reg_date
        }),
        success: function(data){
			console.log(data)
            let qa_seq = data[0].qa_seq;
            let qa_title = data[0].qa_title;
            let qa_content = data[0].qa_content;
            let qa_reg_date = data[0].qa_reg_date;

            $('#FAQ_QUESTION').html("Q. " + qa_title);
            $('#FAQ_ANSWER').html("A. " + qa_content);
        },
        error: function(xhr, status, error){
            console.error("FAQ 상세 내용 로드 오류: ", status, error);
        }
    });
}




//function openModal(ModalId){
//		document.getElementById(ModalId).style.display = 'flex';
//}
//
//function openFAQModal(qa_seq, qa_title, qa_content, qa_reg_date){
//	loadFAQDetailContent(qa_seq, qa_title, qa_content, qa_reg_date);
//	openFAQModal('FAQModal');
//}