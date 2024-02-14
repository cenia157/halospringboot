package com.halo.main.admin.userpage_update.banner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BannerC {
	
	@GetMapping("/banner")
	public String goBanner(Model model) {
		
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/banner/bannerContent.jsp");
		
		return "/admin/index";
	}
}
