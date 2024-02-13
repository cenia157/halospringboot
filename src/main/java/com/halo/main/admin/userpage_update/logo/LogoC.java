package com.halo.main.admin.userpage_update.logo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/hompage-update")
public class LogoC {
	
	@GetMapping("/logo")
	public String goLogo(Model model) {
		
		model.addAttribute("menuname","ロゴ変更");
		model.addAttribute("menu", "/WEB-INF/views/admin/homepageSetting/logo/logoContent.jsp");
		
		return "/admin/index";
	}
	
}
