window.onload = function() {

  let contextPath = document.getElementById('contextPath_val').value;

  let resume_div = document.querySelector('.e_content-box-tr1-td3-1-1-1-5-1-1-1-1');

  resume_div.addEventListener('click', function() {
    let resume_link = contextPath + '/user/introduce/employment/0.file/resume.docx'; 
    location.href = resume_link;
  });
};

// a테그 상위범위로 확대 
document.addEventListener('DOMContentLoaded', function() {

    let divs = document.querySelectorAll('.e_content-box-tr1-td1-1, .e_content-box-tr1-td1-2, .e_content-box-tr1-td1-3');

    divs.forEach(function(div) {
        div.addEventListener('click', function() {
            let href = this.querySelector('a').getAttribute('href');
            if (href) window.location.href = href; 
        });

        div.style.cursor = 'pointer';
    });
});

