window.onload = function() {

  let contextPath = document.getElementById('contextPath_val').value;

  let resume_div = document.querySelector('.e_content-box-tr1-td3-1-1-1-5-1-1-1-1');

  resume_div.addEventListener('click', function() {
    let resume_link = contextPath + '/user/introduce/employment/0.file/resume.docx'; 
    location.href = resume_link;
  });
};