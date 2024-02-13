package com.halo.main.user.information;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/introduce")
@Controller
public class InformationC {
	
	@GetMapping("/company")
	private String infoCompany(Model model) {
		
		model.addAttribute("menu","/WEB-INF/views/user/menu-index.jsp");
		model.addAttribute("subMenu","/WEB-INF/views/user/information/company/inform.jsp");
		
		return "index";
		
	}
	
	@GetMapping("/map")
	private String infoMap(Model model) {
		
		model.addAttribute("menu","/WEB-INF/views/user/menu-index.jsp");
		model.addAttribute("subMenu","/WEB-INF/views/user/information/map/map.jsp");
		
		return "index";
		
	}
	
	
}
