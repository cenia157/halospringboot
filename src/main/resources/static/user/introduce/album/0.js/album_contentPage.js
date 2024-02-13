
  let page = 0;
  let totalPage;
  let items;
  let scroll_index = 0;
  let scroll_per_val;

  //인스타 api 요청
  let requestInstagram = function(){
      $.ajax({
      	url:"/Album_insta_api_C",
      	method: "POST",
      	dataType: "json",
		success: function (response) {
		  console.log("response :::" + response);
		  console.log(" response.data :::" +  response.data);
		  console.log("API Response:", response);
		  items = response.data;
		  console.log("items :::" + items);
		  makeView();
		},
		error: function (xhr, status, error) {
		  console.log(xhr.responseText);
		},
	});
  };
  
  function makeView() {
      let mediaTag;
      totalPage = Math.ceil(items.length / 9);
      console.log("토탈페이지: " + totalPage);

      $(".item-row").empty(); 

      console.log("items.length: " + items.length);
      console.log("page: " + page);

      let container = $(".a_content-box-tr1-td3-1");
      let rowDiv;

      if (page > totalPage) {
        return;
//        console.log("page > totalPage");
      }

      for (let i = page * 9; i < (1 + page) * 9; i++) {
        if (i == 24) {
          break;
        }

        if (items[i] == null) {
          break;
        }

        if (i % 3 == 0) {
          rowDiv = $("<div></div>").addClass("rowDiv");
          container.append(rowDiv);
        }

        let columnDiv = $("<div></div>").addClass("insta" + i);
        rowDiv.append(columnDiv);

        if (items[i].media_type === "VIDEO") {
          mediaTag = $("<video class='video' loop controls></video>").attr(
            "src",
            items[i].media_url
          );
        } else {
          mediaTag = $("<img class='img'>").attr("src", items[i].media_url);
        }

        // a 태그로 mediaTag를 감싸서 각 insta div 엘리먼트에 추가
        let aTag = $("<a></a>")
          .attr("href", items[i].permalink)
          .attr("target", "_blank")
          .append(mediaTag);

        // 이미지 또는 비디오를 추가할 대상 div 엘리먼트를 찾아서 추가
        $(".insta" + i)
          .empty()
          .append(aTag);
      } // for (let i = page*perPage_divNum; i < (1 + page) * 9; i++)

      page++;

      console.log("page++ :::" + page);
    } // makeView(res)
    
    function makeInstaIcon() {
	    let container = $(".a_content-box-tr1-td3-1");
	    let under_icon_div = $("<div></div>").addClass("under_icon_div");
	
	    under_icon_div.css({
	        height: "auto",
	    });
	
	    // 새로운 div 요소 생성
	    let innerDiv = $("<div></div>")
	        .addClass("inner_div")
	        .css({
	            cursor: "pointer",
	        })
	        .click(function () {

	            window.location.href = "https://www.instagram.com/ody_1004/", "_blank";
	        });
	
	    // 첫 번째 내부 div 생성 및 클래스 추가
	    let innerDivIcon = $("<div></div>").addClass("innerDiv_icon");
	
	    let img = $("<img />")
	        .addClass("insta_img")
	        .attr("src", "user/introduce/album/0.img/insta_logo2.png")
	        .css({
	            width: "100%",
	            height: "100%",
	        });
	
	    innerDivIcon.append(img);
	
	    let innerDivWord = $("<div></div>").addClass("innerDiv_word");
	
	    innerDivWord.html("Instagramでフォロー");
	
	    innerDiv.append(innerDivIcon);
	    innerDiv.append(innerDivWord);
	
	    innerDivIcon.css({
	        width: "20%",
	        height: "20%",
	    });
	
	    innerDivWord.css({
	        color: "#006400",
	        "font-weight": "700",
	        "margin-left": "1.5%",
	        "font-size": "1.5rem",
	        "white-space": "nowrap",
	    });
	
	    under_icon_div.append(innerDiv);
	    container.append(under_icon_div);

		if ($(window).width() < 500) {
        	$(".under_icon_div .innerDiv_word").remove(); 
       	    $(".under_icon_div .innerDiv_icon").css("width", "60%"); 
		    $(".innerDiv_icon").css({"display": "flex", "justify-content": "center"});    
		}
	
	} // makeInstaIcon()
	
  $(document).ready(function () {
	 requestInstagram();
	  
    window.addEventListener("scroll", function () {
      console.log("window.scrollY ::: " + window.scrollY);
      let scrollValue_px = window.scrollY;
      let scrollPercentage =
        (scrollValue_px /
          (document.body.scrollHeight - window.innerHeight)) *
        100;
      console.log("scrollPercentage :::" + scrollPercentage);

      switch (scroll_index) {
        case 0:
          scroll_per_val = 73;
          break;
        case 1:
          scroll_per_val = 84;
          break;
        case 2:
          scroll_per_val = 90;
          break;
        default:
          scroll_per_val = 101; // 예외 처리 101 도달 불가능함
          break;
      }

      if (scrollPercentage >= scroll_per_val) {
        if (scroll_index <= 2) {
          makeView(); // *makeView 함수 호출*
          if (scroll_index == 2) {
            makeInstaIcon();
            console.log("makeInstaIcon()실행");
          }
        }

        scroll_index++;
        console.log("scroll_index ::" + scroll_index);
      } // if (scrollPercentage >= scroll_per_val)
    }); // window.addEventListener('scroll', function()
  }); //  $(document).ready(function () {
	
	function checkAndAdjustLayout() {
	
	    let windowWidth = $(window).width();
	
	    if (windowWidth <= 1550) {
	
	        let innerDivWordExists = $(".under_icon_div .innerDiv_word").length > 0;
	
	        // innerDiv_word 클래스가 존재하는 경우
	        if (innerDivWordExists) {
	            $(".under_icon_div .innerDiv_word").remove();
	            $(".under_icon_div .innerDiv_icon").css("width", "60%");
	            $(".innerDiv_icon").css({"display": "flex", "justify-content": "center"});
	        }
	    }
	}
	
	
	$(document).ready(function() {
	
	    checkAndAdjustLayout();
	
	    $(window).resize(function() {
	        checkAndAdjustLayout();
	    });
	});