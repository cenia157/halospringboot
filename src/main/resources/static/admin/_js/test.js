$(function() {
	let menutitle = $('.menu-td-3-td-open-td-1 > a, .menu-td-3-td-open-td-2-td-1 > span');
	let menutitleclick = true;
	let openedmenu = null;
	let menuhover = true;
	let menufolding = false;



	menutitle.click(function() {
		let menulength = $(this).closest(".menu-td-3-td-open-td-2-con").find(".menu-td-3-td-open-td-2-con-td-2").children().length;
		console.log(menulength)
		if (openedmenu != null) {
			openedmenu.parent().css("background-color", "");
			openedmenu.closest(".menu-td-3-td-open-td-2").css("height", "7%");
			openedmenu.closest(".menu-td-3-td-open-td-2").find(".menu-td-3-td-open-td-2-con-td-2").css("visibility", "hidden");
			openedmenu.closest(".menu-td-3-td-open-td-2").find(".menu-td-3-td-open-td-2-con-td-2-select").css("transition", "all 0s ease-in-out");

			menutitleclick = !menutitleclick;
		}

		if (menutitleclick) {
			$(this).parent().css("background-color", "#384123");
			$(this).closest(".menu-td-3-td-open-td-2").css("height", "auto");
			$(this).closest(".menu-td-3-td-open-td-2").find(".menu-td-3-td-open-td-2-con-td-2").css("visibility", "visible");
			$(this).closest(".menu-td-3-td-open-td-2").find(".menu-td-3-td-open-td-2-con-td-2-select").css("transition", "all 0.1s ease-in-out");
			openedmenu = $(this);
		} else {
			$(this).parent().css("background-color", "");
			$(this).closest(".menu-td-3-td-open-td-2").css("height", "7%");
			$(this).closest(".menu-td-3-td-open-td-2").find(".menu-td-3-td-open-td-2-con-td-2").css("visibility", "hidden");
			$(this).closest(".menu-td-3-td-open-td-2").find(".menu-td-3-td-open-td-2-con-td-2-select").css("transition", "all 0s ease-in-out");

		}
		menutitleclick = !menutitleclick;

	});

	$(".menu-td-3-td-open-td-2-con-td-2-select > a").hover(function() {
		if (menuhover) {
			$(this).parent().css("margin-left", "10%");
			$(this).parent().children(".menu-td-3-td-open-td-2-con-td-2-select > img").css("visibility", "visible");
		} else {
			$(this).parent().css("margin-left", "0%");
			$(this).parent().children(".menu-td-3-td-open-td-2-con-td-2-select > img").css("visibility", "hidden");
		}
		menuhover = !menuhover;
	});

	document.querySelector('.admin-menu-folding').addEventListener("click", function() {
		if (!menufolding) {
			document.querySelector('.menu-tr').style.right = '83vw';
			document.querySelector('.menu-tr').style.position = 'absolute';
			document.querySelector('.header-tr').style.right = '0';
			document.querySelector('.header-tr').style.position = 'absolute';
			document.querySelector('.content-tr').style.right = '0';
			document.querySelector('.content-tr').style.position = 'absolute';

			document.querySelector('.menu-tr').style.right = '100vw';
			document.querySelector('.header-tr').style.width = '100vw';
			document.querySelector('.content-tr').style.width = '100vw';
			document.querySelector('.admin-menu-folding').style.left = '0';

			setTimeout(function() {
				document.querySelector('.header-tr').style.position = '';
				document.querySelector('.content-tr').style.position = '';
			}, 300)

			menufolding = !menufolding;
		} else {
			document.querySelector('.menu-tr').style.position = 'absolute';
			document.querySelector('.header-tr').style.position = 'absolute';
			document.querySelector('.content-tr').style.position = 'absolute';

			document.querySelector('.menu-tr').style.right = '83vw';
			document.querySelector('.admin-menu-folding').style.left = '';
			document.querySelector('.header-tr').style.width = '83vw';
			document.querySelector('.content-tr').style.width = '83vw';
			
			setTimeout(function() {
				document.querySelector('.menu-tr').style.position = '';
				document.querySelector('.menu-tr').style.left = '';
				document.querySelector('.header-tr').style.position = '';
				document.querySelector('.header-tr').style.right = '';
				document.querySelector('.content-tr').style.position = '';
				document.querySelector('.content-tr').style.right = '';
			}, 300)

			menufolding = !menufolding;
		}
	})
});

