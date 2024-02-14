package com.halo.main.admin.userpage_update.popup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopupC {
	
	@GetMapping("/popup")
	public String goPopup(Model model) {
		
		model.addAttribute("menu", "/WEB-INF/views/admin/popup/popupContent.jsp");
		
		return "/admin/index";
	}
	
	
}
