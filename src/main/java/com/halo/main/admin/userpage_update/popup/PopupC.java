package com.halo.main.admin.userpage_update.popup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/homepage-update")
public class PopupC {
	
	@GetMapping("/popup")
	public String goPopup(Model model) {
		
		model.addAttribute("menuname","ポップアップの設定");
		model.addAttribute("menu", "/WEB-INF/views/admin/popup/popupContent.jsp");
		
		return "/admin/index";
	}
	
	
}
