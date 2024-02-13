package com.halo.main.admin.userpage_update;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageUpdateC {
	
	@GetMapping("/logo")
	public String goLogo(Model model) {
		
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/logo/logoContent.jsp");
		
		return "/admin/index";
	}
	
	@GetMapping("/quick_menu")
	public String goQuickMenu(Model model) {
		
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/mainpage/mainpageContent.jsp");
		
		return "/admin/index";
	}
	
	@GetMapping("/banner")
	public String goBanner(Model model) {
		
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/banner/bannerContent.jsp");
		
		return "/admin/index";
	}
	
	@GetMapping("/infoUpdate")
	public String goInfo(Model model) {
		
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/information/informationContent.jsp");
		
		return "/admin/index";
	}
	
	
}
