package com.halo.main.admin.userpage_update.quick_menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/hompage-update")
public class QuickMenuC {
	
	@GetMapping("/quick-menu")
	public String goQuickMenu(Model model) {
		
		model.addAttribute("menuname","クイックメニュー設定");
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/mainpage/mainpageContent.jsp");
		
		return "/admin/index";
	}
	
}
