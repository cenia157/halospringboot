//	window.onload = function () {
//  
//    let modal = document.querySelector("#myModal");
//    let closeModalButton = document.querySelector(".qd-content-box-td2-2-button");
//
//    let modalContent = document.querySelector(".modal-content"); 
//    let ancTitleDiv = document.querySelector(".ancTitleDiv"); 
//    let headerTbl = document.querySelector(".header-tbl");
//    let contentBox = document.querySelector(".qd-content-box-td2-1-content"); 
//
//	// "Escape" 키를 누를 때 모달을 닫는 버튼에 대한 클릭 이벤트를 가상으로 발생시켜 모달을 닫는 것을 구현
//	$(document).keydown(function (e) {
//	  if (e.key === "Escape") {
//	    let event = new Event("click");
//	    if (closeModalButton) { 
//	      closeModalButton.dispatchEvent(event);
//	    }
//	  }
//    });
//     
//    // 모달 외부 부분 닫기 처리 
//	document.addEventListener("click", function (e) {
//	  if (e.target === modal && !modalContent.contains(e.target)) {
//	    modal.style.display = "none";
//	    if (headerTbl) {
//	      headerTbl.style.display = "block";
//	    }
//	  }
//	});
//  };

document.addEventListener("DOMContentLoaded", function() {
  let modal = document.querySelector("#myModal");
  let closeModalButton = document.querySelector(".qd-content-box-td2-2-button");
  let modalContent = document.querySelector(".modal-content"); 
  let ancTitleDiv = document.querySelector(".ancTitleDiv"); 
  let headerTbl = document.querySelector(".header-tbl");
  let contentBox = document.querySelector(".qd-content-box-td2-1-content");


  // "Escape" 키를 누를 때 모달을 닫는 버튼에 대한 클릭 이벤트를 가상으로 발생시켜 모달을 닫는 것을 구현
  document.addEventListener("keydown", function(e) {
    if (e.key === "Escape") {
      let event = new Event("click");
      if (closeModalButton) { 
        closeModalButton.dispatchEvent(event);
      }
    }
  });

  // 모달 외부 부분 닫기 처리 
  document.addEventListener("click", function(e) {
    if (e.target === modal && !modalContent.contains(e.target)) {
      modal.style.display = "none";
	  $(".header-tbl").css("visibility", "visible");	
	  $(".header-br-call").css("visibility", "visible");
	  $(".header-tr-2").show();
	  $(".remote-control-tbl").show();
	  $('body').css('overflow', 'visible');
      if (headerTbl) {
        headerTbl.style.display = "block";
      }
    }
  });
});