  $(document).ready(function () {
	
	let modal = document.querySelector("#myModal");

    //모달 조회
    $(".ancTitleDiv").on("click", function () {
      let aidx = $(this).data("anseq");
		
		$.ajax({
   		  type: "post",
   		  url: "/info/notice/getNotice",
    	  data: { an_seq: aidx },
   		  dataType: "json", // JSON 형식으로 데이터를 받음
    	  success: function (result) {
		  console.log('데이터확인')
		  console.log(result);
          // 모달에 받은 데이터를 적용
          $("#modalWriter").text(result.an_writer);
          $("#modalTitle").text(result.an_title);
          $("#modalContent").html(result.an_content);
          $("#modalregDate").text(result.an_reg_date);
          
		// 클래스가 d-content-box-td2-1-content인 요소를 찾음
		let targetDivs = document.querySelectorAll('.qd-content-box-td2-1-content');
		console.log(targetDivs);
		
		// 모든 요소에 대해 반복
		targetDivs.forEach(function(targetDiv) {
		    console.log("현재 처리 중인 targetDiv:", targetDiv);
		    
		    // 해당 요소 안에 있는 모든 span 요소를 선택
		    let spans = targetDiv.getElementsByTagName('span');
		    
		    // 각 span 요소에 대해 반복
		    for (let i = 0; i < spans.length; i++) {
		        let span = spans[i];
		        console.log("현재 처리 중인 span:", span);
		        
		        // span 요소의 현재 font-family 스타일을 가져옴
		        let currentFontFamily = window.getComputedStyle(span).fontFamily;
		        console.log("현재 span의 font-family:", currentFontFamily);
		        
		        // font-family가 설정되어 있는지 확인
		        if (currentFontFamily) {
		            // span 요소의 font-family 스타일을 변경 (인라인 스타일에 !important 추가)
		            span.style.cssText = "font-family: " + currentFontFamily + " !important;";
		            console.log("span의 font-family 변경 완료:", currentFontFamily);
		        }
		    }
		    // for 루프 종료 후 추가적인 로그를 출력할 수 있습니다.
		    console.log("현재 처리 중인 targetDiv의 작업이 완료되었습니다.");
		});

          
         

          //DB조회 -> 화면 그려주고 -> 모달 노출 및 헤더 가리기 
		  $(".header-tbl").css("visibility", "hidden");
		  $(".header-tr-2").hide();
		  $(".header-br-call").css("visibility", "hidden");

          modal.style.display = "flex";
		  $(".qd-content-box-td2-1").scrollTop(0);
		  $(".remote-control-tbl").hide();
		  $('body').css('overflow', 'hidden');
		  // 모바일 버전에서 모달창 뜰시, 제목 타이블 부분 스크롤 초기화처리 
		  if ($(window).width() <= 500 && $("#myModal .qd-content-box-td1-2-2").length) {
    	  	 $("#myModal .qd-content-box-td1-2-2").scrollLeft(0);
		  }
		  
        },
        error: function () {
          alert("error!!!");
        },
      });
    });

    //모달 닫기
    $("#closeModalBtn").on("click", function () {
      modal.style.display = "none";
      $(".header-tbl").css("visibility", "visible");
	  $(".header-br-call").css("visibility", "visible");
	  $(".header-tr-2").show();
	  $(".remote-control-tbl").show();
	  $('body').css('overflow', 'visible');
    });
  });