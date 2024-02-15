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