function loadFAQDetailContent(qa_seq, qa_title, qa_content, qa_reg_date){
    $.ajax({
        url: "LoadFAQDetailContentC",
        dataType: "json",
        type: "post",
        data:{
            qa_seq: qa_seq,
            qa_title: qa_title,
            qa_content: qa_content,
            qa_reg_date: qa_reg_date
        },
        success: function(data){
            let qa_seq = data[0].qa_seq;
            let qa_title = data[0].qa_title;
            let qa_content = data[0].qa_content;
            let qa_reg_date = data[0].qa_reg_date;

            $('#FAQ_QUESTION').html("Q. " + qa_title);
            $('#FAQ_ANSWER').html("A. " + qa_content);
        },
        error: function(xhr, status, error){
            console.error("faqDetail.jsp 로드오류: ", status, error);
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