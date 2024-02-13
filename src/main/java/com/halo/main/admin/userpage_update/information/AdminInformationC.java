package com.halo.main.admin.userpage_update.information;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminInformationC {
	
	@GetMapping("/infoUpdate")
	public String goInfo(Model model) {
		
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/information/informationContent.jsp");
		
		return "/admin/index";
	}
}
