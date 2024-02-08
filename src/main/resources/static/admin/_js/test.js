$(function () {
    let menutitle = $('.menu-td-3-td-open-td-1 > a, .menu-td-3-td-open-td-2-td-1 > span');
    let menutitleclick = true;
    let openedmenu = null;
    let menuhover = true;

    

    menutitle.click(function () {
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

    $(".menu-td-3-td-open-td-2-con-td-2-select > a").hover(function () {
        if (menuhover) {
            $(this).parent().css("margin-left", "10%");
            $(this).parent().children(".menu-td-3-td-open-td-2-con-td-2-select > img").css("visibility", "visible");
        } else {
            $(this).parent().css("margin-left", "0%");
            $(this).parent().children(".menu-td-3-td-open-td-2-con-td-2-select > img").css("visibility", "hidden");
        }
        menuhover = !menuhover;
    });
});

