package com.halo.main.admin.userpage_update.banner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/hompage-update")
public class BannerC {
	
	@GetMapping("/banner")
	public String goBanner(Model model) {
		
		model.addAttribute("menuname","下のバナー設定");
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/banner/bannerContent.jsp");
		
		return "/admin/index";
	}
}
