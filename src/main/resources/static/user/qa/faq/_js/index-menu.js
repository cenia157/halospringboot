$(function () {
    let menuhover = true;
    let submenuhover = true;

    $(".header-td a, img").hover(function () {
        if (menuhover) {
            $(".header-br-logo > a").css("color", "#ffffff");
            $(".header-td-menu-title > a").css("font-size", "350%").css("color", "#ffffff");
            $(".header-opmenu-back").css("top", "0");
            $(".header-opmenu-td").css("visibility", "visible");
            $(".header-td-menu-img > img").css("filter", "brightness(0) invert(1)")
            $(this).css("color", "#FFDF6C");
            $(this).find(".header-td-menu-under").css("visibility", "visible").css("transform", "scaleX(1)");
            // 마우스 벗어날때 판정
            $(".header-td").hover(function () {
                $(".header-br-logo > a").css("color", "#546137");
                $(".header-td-menu-title > a").css("font-size", "250%").css("color", "rgb(83, 97, 56)");
                $(".header-opmenu-back").css("top", "-50vh");
                $(".header-opmenu-td").css("visibility", "hidden");
                $(".header-td-menu-img > img").css("filter", "brightness(1) invert(0)")
                $(this).css("color", "#white");
                
            });
        } else {
            $(this).find(".header-td-menu-under").css("visibility", "hidden").css("transform", "scaleX(0)");
            $(this).css("color", "#FFFFFF");
        }
        menuhover = !menuhover;

    });

    $(".header-opmenu-a").hover(function () {
        if (submenuhover) {
            $(this).css("color", "#FFDF6C");
            $(this).closest(".header-td-menu").find(".header-td-menu-title").find(".header-td-menu-under").css("visibility", "visible").css("transform", "scaleX(1)");
        } else {
            $(this).css("color", "white");
            $(this).closest(".header-td-menu").find(".header-td-menu-title").find(".header-td-menu-under").css("visibility", "hidden").css("transform", "scaleX(0)");
        }
        submenuhover = !submenuhover;
    });

});
