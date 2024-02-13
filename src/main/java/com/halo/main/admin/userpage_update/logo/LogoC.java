package com.halo.main.admin.userpage_update.logo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoC {
	
	@GetMapping("/logo")
	public String goLogo(Model model) {
		
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/logo/logoContent.jsp");
		
		return "/admin/index";
	}
	
}
