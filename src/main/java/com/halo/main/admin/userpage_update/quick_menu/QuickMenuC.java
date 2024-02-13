package com.halo.main.admin.userpage_update.quick_menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuickMenuC {
	
	@GetMapping("/quick_menu")
	public String goQuickMenu(Model model) {
		
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/mainpage/mainpageContent.jsp");
		
		return "/admin/index";
	}
	
}
