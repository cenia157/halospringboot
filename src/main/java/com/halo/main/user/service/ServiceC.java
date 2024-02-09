package com.halo.main.user.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/service")
@Controller
public class ServiceC {
	
	@GetMapping("/info")
	public String service (Model model) {
		model.addAttribute("serviceStep", "svcselect.jsp");
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceInformation/serviceInformation.jsp");
		return "index";
	}
	
	@GetMapping("/apply/step1")
	public String applyStep1(Model model) {
		model.addAttribute("serviceStep", "svcselect.jsp");
		model.addAttribute("menu", "user/menu-index.jsp");
		model.addAttribute("subMenu", "service/serviceApply/serviceApply.jsp");
		return "index";
	}
	
	
	
	
}
